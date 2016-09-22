/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.entity.QuestionResponse;
import com.snapit.solutions.mentor.sherpa.messages.UIMessages;
import com.snapit.solutions.mentor.sherpa.model.ProgramSignupForm;
import com.snapit.solutions.mentor.sherpa.model.QuestionOptionsAndResponses;
import com.snapit.solutions.mentor.sherpa.service.MentorAndStudentResponseService;
import com.snapit.solutions.mentor.sherpa.service.MentorService;
import com.snapit.solutions.mentor.sherpa.service.OrganizationService;
import com.snapit.solutions.mentor.sherpa.service.QuestionOptionsService;
import com.snapit.solutions.mentor.sherpa.service.StudentService;
import com.snapit.solutions.mentor.sherpa.validator.QuestionResponseValidator;
import com.snapit.solutions.web.security.AuthUser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public abstract class AbstractMentorStudentController {
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
    @Autowired
    QuestionResponseValidator questionResponseValidator;

    @InitBinder("programSignupForm")
    public void initMentorBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(questionResponseValidator);
    }

    @RequestMapping(value = "/programs/list", method = RequestMethod.GET)
    public ModelAndView showCurrentPrograms( Model model) {
        AuthUser activeUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<Organization,String> signedUpOrgList = organizationService.
                findSignedUporganizationToProgramName(
                activeUser.getAuthorizedUser().getId().toString());
       Map<Organization,String> unsignedUpOrgList = organizationService.
               findUnSignedUporganizationToProgramName(
                activeUser.getAuthorizedUser().getId().toString());
        model.addAttribute("signedUpOrgList",signedUpOrgList);
        model.addAttribute("unsignedUpOrgList" ,unsignedUpOrgList);
        return new ModelAndView("organizationList");
    }    

    @RequestMapping(value = "/programs/new", method = RequestMethod.GET)
    public ModelAndView showNewPrograms(Model model) {
        List<Organization> mentorList = organizationService.listAllOrganizations();
        model.addAttribute(mentorList);
        return new ModelAndView("newPrograms");
    }    

    @RequestMapping(value = "/signup/{id}", method = RequestMethod.GET)
    public ModelAndView showPrograms(@PathVariable String id, Model model) {
        Organization organization = organizationService.findOrganziationById(id);
        model.addAttribute(organization);
        ProgramSignupForm programSignupForm = new ProgramSignupForm();
        programSignupForm.setOrganizationId(id);
        model.addAttribute(programSignupForm);
        return new ModelAndView("selectProgram");
    }
    
    public String showQuestions(@PathVariable String id, @ModelAttribute ProgramSignupForm programSignupForm, Model model, boolean student, RedirectAttributes redirectAttributes) {
        AuthUser activeUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean alreadySignedUp = mentorAndStudentResponseService.isResponseCaptured(programSignupForm.getOrganizationId(), activeUser.getUserId(), programSignupForm.getSelectedProgramName());
        if (alreadySignedUp) {
            redirectAttributes.addFlashAttribute("infoMessage", "You have already Signed up for the program - " + programSignupForm.getSelectedProgramName());
            return "redirect:/";
        }
        Organization organization = organizationService.findOrganziationById(programSignupForm.getOrganizationId());
        List<QuestionOptions> questionsList = new ArrayList<>();
        if (student) {
            questionsList.addAll(questionOptionsService.getStudentQuestions(programSignupForm.getOrganizationId(), programSignupForm.getSelectedProgramName()));
        } else {
            questionsList.addAll(questionOptionsService.getMentorQuestions(programSignupForm.getOrganizationId(), programSignupForm.getSelectedProgramName()));
        }
        programSignupForm.setQuestionsList(questionsList);

        for (QuestionOptions question : programSignupForm.getQuestionsList()) {
            if (null == programSignupForm.getQuestionResponseMap().get(question.getQuestionCategory())) {
                List<QuestionOptionsAndResponses> questionOptionsAndResponses = new ArrayList<>();
                getQuestionOptionResponse(question, questionOptionsAndResponses);
                programSignupForm.getQuestionResponseMap().put(question.getQuestionCategory(), questionOptionsAndResponses);
            } else {
                List<QuestionOptionsAndResponses> questionOptionsAndResponses = programSignupForm.getQuestionResponseMap().get(question.getQuestionCategory());
                getQuestionOptionResponse(question, questionOptionsAndResponses);
            }
        }
        model.addAttribute(organization);
        model.addAttribute("programSignupForm", programSignupForm);
        return "answerQuestions";
    }

    private void getQuestionOptionResponse(QuestionOptions question, List<QuestionOptionsAndResponses> questionOptionsAndResponses) {
        QuestionOptionsAndResponses questionOptionsAndResponse = new QuestionOptionsAndResponses();
        questionOptionsAndResponse.setQuestionOption(question);
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setQuestion(question.getQuestion());
        questionResponse.setResponse(new HashSet<String>());
        questionOptionsAndResponse.setQuestionResponse(questionResponse);

        questionOptionsAndResponses.add(questionOptionsAndResponse);
    }
    
    /**
     * Save User responses for Program's questions.
     * 
     * @param programSignupForm
     * @param model
     * @param redirectAttr
     * @return 
     */
    @RequestMapping(value = "/signup/save", method = RequestMethod.POST)
    public String saveQuestionResponses(@Validated @ModelAttribute ProgramSignupForm programSignupForm, BindingResult result, Model model, RedirectAttributes redirectAttr) {

        if (result.hasErrors()) {
            redirectAttr.addFlashAttribute("errorMessage", "Please answer all questions.");     
            model.addAttribute("errorMessage", "Please answer all questions.");
            model.addAttribute(programSignupForm);
            return "answerQuestions";
        }
        MentorAndStudentResponse studentResponse = new MentorAndStudentResponse();
        studentResponse.setOrgId(new ObjectId(programSignupForm.getOrganizationId()));
        studentResponse.setProgramName(programSignupForm.getSelectedProgramName());
        AuthUser activeUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        studentResponse.setMentorOrStudentId(new ObjectId(activeUser.getUserId()));

        List<QuestionResponse> questionResponseList = new ArrayList<>();
        for (String questionCategory : programSignupForm.getQuestionResponseMap().keySet()) {
            List<QuestionOptionsAndResponses> questionOptionsAndResponses = programSignupForm.getQuestionResponseMap().get(questionCategory);
            if (null != questionOptionsAndResponses && !questionOptionsAndResponses.isEmpty()) {
                for (QuestionOptionsAndResponses questionOptionsAndResponse : questionOptionsAndResponses) {
                    questionResponseList.add(questionOptionsAndResponse.getQuestionResponse());
                }
            }
        }

        studentResponse.setQuestionAndResponses(questionResponseList);
        mentorAndStudentResponseService.saveResponses(studentResponse);
        redirectAttr.addFlashAttribute("successMessage", UIMessages.SIGNUP_SUCCESS_INFO);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/viewResponse", method = RequestMethod.GET)
    public String showRespnses(Model model) {
      AuthUser activeUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      MentorAndStudentResponse mentorAndStudentResponse = mentorAndStudentResponseService.retrieveResponse(activeUser.getAuthorizedUser().getId().toString());
      model.addAttribute(mentorAndStudentResponse);
      return "responseList";
    }
    
    @RequestMapping(value = "/signup/save", method = RequestMethod.GET)
    public ModelMap list(@RequestParam(required = false) boolean success) {
        ModelMap modelMap = new ModelMap();
        if (success) {
            modelMap.put("successMessage", "Your response was successfully saved.");
        }
        return modelMap;
    }

    
}
