/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.entity.Student;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.Program;
import com.snapit.solutions.mentor.sherpa.entity.QuestionResponse;
import com.snapit.solutions.mentor.sherpa.model.ProgramSignupForm;
import com.snapit.solutions.mentor.sherpa.service.MentorAndStudentResponseService;
import com.snapit.solutions.mentor.sherpa.service.MentorService;
import com.snapit.solutions.mentor.sherpa.service.OrganizationService;
import com.snapit.solutions.mentor.sherpa.service.QuestionOptionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.snapit.solutions.mentor.sherpa.service.StudentService;
import com.snapit.solutions.mentor.sherpa.service.utils.CommonServiceUtils;
import com.snapit.solutions.web.security.AuthUser;
import java.util.ArrayList;
import org.bson.types.ObjectId;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    MentorService mentorService;
    
    @Autowired
    StudentService studentService;
    @Autowired
    OrganizationService organizationService;
    @Autowired
    QuestionOptionsService questionOptionsService;
    @Autowired
    MentorAndStudentResponseService mentorAndStudentResponseService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showMentor(@PathVariable String id, Model model) {
        Student student = studentService.findById(id);
        if (student != null) {
            model.addAttribute(student);
        } else {
            model.addAttribute(new Student());  // We should be throwing Exception
        }
        return "studentProfile";
    }   
        
    @RequestMapping(value = "/mentor/list", method = RequestMethod.GET)
    public ModelAndView showMentorList(Model model) {
        List<Mentor> mentorList = mentorService.findall();
        model.addAttribute(mentorList);
        return new ModelAndView("mentorList");
    }
    
    @RequestMapping(value = "/organization/list", method = RequestMethod.GET)
    public ModelAndView showOrganizationList(Model model) {
        List<Organization> mentorList = organizationService.listAllOrganizations();
        model.addAttribute(mentorList);
        return new ModelAndView("organizationList");
    }    
    
    @RequestMapping(value = "/signup/{id}", method = RequestMethod.GET)
    public ModelAndView showPrograms(@PathVariable String id, Model model) {
        Organization organization = organizationService.findOrganziationById(id);
        model.addAttribute(organization);
        ProgramSignupForm programSignupForm = new ProgramSignupForm();
        programSignupForm.setOrganizationId(id);
        model.addAttribute(programSignupForm);
        return new ModelAndView("programSignup");
    }
    
    @RequestMapping(value = "/signup/{id}", method = RequestMethod.POST)
    public ModelAndView showQuestions(@PathVariable String id, @ModelAttribute ProgramSignupForm programSignupForm, Model model) {
        Organization organization = organizationService.findOrganziationById(programSignupForm.getOrganizationId());
        if (organization != null && organization.getPrograms() != null) { //this should never happen. throw exception
            List<ObjectId> questionIdList = new ArrayList<>();
            List<Program> programList = organization.getPrograms();
            for(Program program: programList) {
                if (program.getProgramName().trim().equalsIgnoreCase(programSignupForm.getSelectedProgramName()) && program.getQuestionsIdList() != null) {
                    questionIdList.addAll(program.getQuestionsIdList());
                }
            }
        programSignupForm.setQuestionsList(questionOptionsService.findQuestionOptionsByQuestionFor(CommonServiceUtils.createSetOfStringIds(questionIdList), "student"));
        model.addAttribute(organization);
//        model.addAttribute(questionsList);
        model.addAttribute(programSignupForm);
//        redirectAttr.addFlashAttribute(organization);
//        redirectAttr.addFlashAttribute(questionsList);
//        redirectAttr.addFlashAttribute(programSignupForm);
        }
        return new ModelAndView("answerQuestions");
    }
    
     @RequestMapping(value = "/signup/save", method = RequestMethod.POST)
    public ModelAndView saveQuestionResponses(@ModelAttribute ProgramSignupForm programSignupForm, Model model, RedirectAttributes redirectAttr) {
        List<QuestionResponse> questionResponseList = new ArrayList<>();

        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setQuestion(programSignupForm.getQuestions().get(0));
        questionResponse.setResponse(programSignupForm.getQuestionResponses());
        questionResponseList.add(questionResponse);
        
         MentorAndStudentResponse mentorResponse = new MentorAndStudentResponse();
         mentorResponse.setOrgId(new ObjectId(programSignupForm.getOrganizationId()));
         mentorResponse.setProgramName(programSignupForm.getSelectedProgramName());
         AuthUser activeUser = (AuthUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

         mentorResponse.setMentorOrStudentId(new ObjectId(activeUser.getUserId()));
         mentorResponse.setQuestionAndResponses(questionResponseList);
         
         mentorAndStudentResponseService.saveResponses(mentorResponse);
        redirectAttr.addFlashAttribute("infoMessage", "Your response was successfully saved.");
       return new ModelAndView("redirect:/");
    }
    
}
