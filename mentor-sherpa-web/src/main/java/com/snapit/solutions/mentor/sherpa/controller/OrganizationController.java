/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import com.snapit.solutions.mentor.sherpa.model.ProgramSignupForm;
import com.snapit.solutions.mentor.sherpa.model.TestModel;
import com.snapit.solutions.mentor.sherpa.service.MentorService;
import com.snapit.solutions.mentor.sherpa.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import com.snapit.solutions.mentor.sherpa.service.StudentService;
import com.snapit.solutions.web.security.AuthUser;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    MentorService mentorService;
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    OrganizationService organizationService;

    @RequestMapping(value = "/programs/list", method = RequestMethod.GET)
    public ModelAndView programs(Model model) {
        Organization organization = organizationService.findOrganziationById(getOrganizationId());
        model.addAttribute(organization);
        ProgramSignupForm programSignupForm = new ProgramSignupForm();
        programSignupForm.setOrganizationId(getOrganizationId());
        model.addAttribute(programSignupForm);
        return new ModelAndView("selectProgram");
    }
    
    @RequestMapping(value = "/programs/list", method = RequestMethod.POST)
    public String showQuestions(@ModelAttribute ProgramSignupForm programSignupForm, Model model, RedirectAttributes redirectAttr) {
        redirectAttr.addFlashAttribute("selectedProgramName", programSignupForm.getSelectedProgramName());
        return "redirect:/organization/student/list";
    }
    @RequestMapping(value = "/programs/add", method = RequestMethod.GET)
    public ModelAndView addPrograms(Model model) {
        return new ModelAndView("");
    }
    @RequestMapping(value = "/mentor/{name}", method = RequestMethod.GET)
    public String showMentor(@PathVariable String name, Model model) {
        Mentor mentor = mentorService.findByMentorName(name);
        model.addAttribute(mentor);
        return "mentorProfile";
    }   
        
    @RequestMapping(value = "/mentor/list", method = RequestMethod.GET)
    public ModelAndView showMentorList(Model model) {
        List<Mentor> mentorList = mentorService.findall();
        model.addAttribute(mentorList);
        return new ModelAndView("mentorList");
    }
    
    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public ModelAndView showStudentList(@ModelAttribute String selectedProgramName, Model model) {
        List<Student> studentList = studentService.findall();
        model.addAttribute(selectedProgramName);
        model.addAttribute(studentList);
        return new ModelAndView("studentList");
    }
    
    @RequestMapping(value = "/{id}/select", method = RequestMethod.GET)
    public ModelAndView showPrograms(@PathVariable String id, Model model) {
        Organization organization = organizationService.findOrganziationById(getOrganizationId());
        model.addAttribute(organization);
        ProgramSignupForm programSignupForm = new ProgramSignupForm();
        programSignupForm.setOrganizationId(id);
        model.addAttribute(programSignupForm);
        return new ModelAndView("selectProgram");
    }
    
    @RequestMapping(value = "/{id}/assign", method = RequestMethod.GET)
    public ModelAndView findMentors(@PathVariable String id,@ModelAttribute String selectedProgramName,Model model) {
        Organization organization = organizationService.findOrganziationById(getOrganizationId());
        Student student = studentService.findById(id);
       Map<Mentor,Integer> matchResults = new HashMap<>();
               matchResults.putAll(organizationService.getMatchedMentors(student.getUserObjectId().toString(), 
                organization.getId().toString(),
                organization.getPrograms().get(0).getProgramName()));
               
        TestModel testModel = new TestModel();
        testModel.setMatch(matchResults);
        model.addAttribute(testModel);
        model.addAttribute(student);
        return new ModelAndView("matchedMentors");
    }
    
    @RequestMapping(value = "/{id}/save/{mid}", method = RequestMethod.GET)
    public ModelAndView assignMentor(@PathVariable String id,@PathVariable String mid, Model model, RedirectAttributes redirectAttr) {
        Organization organization = organizationService.findOrganziationById(getOrganizationId());
        organizationService.assignNewMentorToStudent(id, organization.getId().toString(), mid, 
                organization.getPrograms().get(0).getProgramName());
        redirectAttr.addFlashAttribute("infoMessage", "Your response was successfully saved.");
        return new ModelAndView("redirect:/");
    }
    
    private String getOrganizationId() {
        AuthUser authUser = (AuthUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Organization organization = organizationService.findOrganziationByUserId(authUser.getUserId());
        if (organization != null) {
            return organization.getId().toString();
        }
        return "";
    }
}
