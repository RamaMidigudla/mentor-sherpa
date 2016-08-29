/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.entity.Student;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.entity.QuestionResponse;
import com.snapit.solutions.mentor.sherpa.model.ProgramSignupForm;
import com.snapit.solutions.mentor.sherpa.model.QuestionOptionsAndResponses;
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
import com.snapit.solutions.mentor.sherpa.validator.QuestionResponseValidator;
import com.snapit.solutions.web.security.AuthUser;
import java.util.ArrayList;
import java.util.HashSet;
import org.bson.types.ObjectId;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/mentor")
public class MentorController {

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

    /**
     * Show Mentor by mentor id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showMentor(@PathVariable String id, Model model) {
        Mentor mentor = mentorService.findById(id);
        if (mentor != null) {
            model.addAttribute(mentor);
        } else {
            model.addAttribute(new Mentor()); // We should be throwing Exception.
        }
        return "mentorProfile";
    }

    /**
     * Show Programs for an Organization.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/signup/{id}", method = RequestMethod.GET)
    public ModelAndView showPrograms(@PathVariable String id, Model model) {
        Organization organization = organizationService.findOrganziationById(id);
        model.addAttribute(organization);
        ProgramSignupForm programSignupForm = new ProgramSignupForm();
        programSignupForm.setOrganizationId(id);
        model.addAttribute(programSignupForm);
        return new ModelAndView("selectProgram");
    }

    /**
     * Show Questions for a Program.
     *
     * @param id
     * @param programSignupForm
     * @param model
     * @return
     */
//    @RequestMapping(value = "/signup/{id}", method = RequestMethod.POST)
//    public ModelAndView showQuestions(@PathVariable String id, @ModelAttribute ProgramSignupForm programSignupForm, Model model) {
//        Organization organization = organizationService.findOrganziationById(programSignupForm.getOrganizationId());
//        if (organization != null && organization.getPrograms() != null) { //this should never happen. throw exception
//            List<ObjectId> questionIdList = new ArrayList<>();
//            List<Program> programList = organization.getPrograms();
//            for (Program program : programList) {
//                if (program.getProgramName().trim().equalsIgnoreCase(programSignupForm.getSelectedProgramName()) && program.getQuestionsIdList() != null) {
//                    questionIdList.addAll(program.getQuestionsIdList());
//                }
//            }
//            programSignupForm.setQuestionsList(questionOptionsService.findQuestionOptionsByQuestionFor(CommonServiceUtils.createSetOfStringIds(questionIdList), "mentor"));
//            model.addAttribute(organization);
//            model.addAttribute(programSignupForm);
//        programSignupForm.setQuestionsList(questionOptionsService.findQuestionOptionsByQuestionFor(CommonServiceUtils.createSetOfStringIds(questionIdList), "mentor"));
//        model.addAttribute(organization);
//        model.addAttribute(programSignupForm);
//        }
//        return new ModelAndView("answerQuestions");
//    }
//    @RequestMapping(value = "/signup/{id}", method = RequestMethod.POST)
//    public ModelAndView showQuestions(@PathVariable String id, @ModelAttribute ProgramSignupForm programSignupForm, Model model) {
//        ProgramSignupForm newProgramSignupForm = new ProgramSignupForm();
//        newProgramSignupForm.setOrganizationId(programSignupForm.getOrganizationId());
//        newProgramSignupForm.setSelectedProgramName(programSignupForm.getSelectedProgramName());
//         Organization organization = organizationService.findOrganziationById(programSignupForm.getOrganizationId());
//        List<QuestionOptions> questionsList = new ArrayList<>();
//        questionsList.addAll(questionOptionsService.getMentorQuestions(programSignupForm.getOrganizationId(), programSignupForm.getSelectedProgramName()));
//        newProgramSignupForm.setQuestionsList(questionsList);
//        for (QuestionOptions question : newProgramSignupForm.getQuestionsList()) {
//            if (null == newProgramSignupForm.getUserSelection().get(question.getQuestionCategory())) {
//                List<QuestionOptions> tempQuestionsList = new ArrayList<>();
//                tempQuestionsList.add(question);
//                newProgramSignupForm.getUserSelection().put(question.getQuestionCategory(), tempQuestionsList);
//                // for JSTL
//                List<QuestionResponse> qr = new ArrayList<>();
//                newProgramSignupForm.getQuestionResponseMap().put(question.getQuestionCategory(), qr);
//            } else {
//                List<QuestionOptions> tempQuestionsList = newProgramSignupForm.getUserSelection().get(question.getQuestionCategory());
//                tempQuestionsList.add(question);
//                //for JSTL
//                List<QuestionResponse> qr = newProgramSignupForm.getQuestionResponseMap().get(question.getQuestionCategory());
//                qr.add(new QuestionResponse());
//            }
//        }
//        model.addAttribute(organization);
//        model.addAttribute("programSignupForm", newProgramSignupForm);
//        return new ModelAndView("answerQuestions");
//    }
    @RequestMapping(value = "/signup/{id}", method = RequestMethod.POST)
    public ModelAndView showQuestions(@PathVariable String id, @ModelAttribute ProgramSignupForm programSignupForm, Model model) {
        Organization organization = organizationService.findOrganziationById(programSignupForm.getOrganizationId());
        List<QuestionOptions> questionsList = new ArrayList<>();
        questionsList.addAll(questionOptionsService.getMentorQuestions(programSignupForm.getOrganizationId(), programSignupForm.getSelectedProgramName()));
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
        return new ModelAndView("answerQuestions");
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
        MentorAndStudentResponse mentorResponse = new MentorAndStudentResponse();
        mentorResponse.setOrgId(new ObjectId(programSignupForm.getOrganizationId()));
        mentorResponse.setProgramName(programSignupForm.getSelectedProgramName());
        AuthUser activeUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mentorResponse.setMentorOrStudentId(new ObjectId(activeUser.getUserId()));

        List<QuestionResponse> questionResponseList = new ArrayList<>();
        for (String questionCategory : programSignupForm.getQuestionResponseMap().keySet()) {
            List<QuestionOptionsAndResponses> questionOptionsAndResponses = programSignupForm.getQuestionResponseMap().get(questionCategory);
            if (null != questionOptionsAndResponses && !questionOptionsAndResponses.isEmpty()) {
                for (QuestionOptionsAndResponses questionOptionsAndResponse : questionOptionsAndResponses) {
                    questionResponseList.add(questionOptionsAndResponse.getQuestionResponse());
                }
            }
        }

        mentorResponse.setQuestionAndResponses(questionResponseList);
        mentorAndStudentResponseService.saveResponses(mentorResponse);
        redirectAttr.addFlashAttribute("infoMessage", "Your response was successfully saved.");
        return "redirect:/";
    }

    @RequestMapping(value = "/signup/save", method = RequestMethod.GET)
    public ModelMap list(@RequestParam(required = false) boolean success) {
        ModelMap modelMap = new ModelMap();
        if (success) {
            modelMap.put("infoMessage", "Your response was successfully saved.");
        }
        return modelMap;
    }

    /**
     * Show list of Organizations.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/programs/list", method = RequestMethod.GET)
    public ModelAndView showCurrentPrograms(Model model) {
        List<Organization> mentorList = organizationService.listAllOrganizations();
        model.addAttribute(mentorList);
        return new ModelAndView("organizationList");
    }

//    @RequestMapping(value = "/programs/{org}", method = RequestMethod.GET)
//    public ModelAndView showCurrentPrograms(@PathVariable String orgName, Model model) {
//        Organization org = organizationService.findByOrganizationName(orgName);
//        if (null != org) {
//            List<Organization> mentorList = questionOptionsService.getMentorQuestions(org.getId(), "Mentor Makers"); // TODO
//            model.addAttribute(mentorList);
//            return new ModelAndView("organizationList");
//        }
//    }
    @RequestMapping(value = "/programs/new", method = RequestMethod.GET)
    public ModelAndView showNewPrograms(Model model) {
        List<Organization> mentorList = organizationService.listAllOrganizations();
        model.addAttribute(mentorList);
        return new ModelAndView("newPrograms");
    }

    /**
     * Show list of Mentors.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public ModelAndView showStudentList(Model model) {
        List<Student> studentList = studentService.findall();
        model.addAttribute(studentList);
        return new ModelAndView("studentList");
    }

}
