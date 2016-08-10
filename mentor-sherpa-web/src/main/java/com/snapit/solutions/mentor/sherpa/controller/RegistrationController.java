/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.facade.MentorSherpaUserService;
import com.snapit.solutions.mentor.sherpa.model.RegisterForm;
import com.snapit.solutions.mentor.sherpa.model.StudentRegisterForm;
import com.snapit.solutions.mentor.sherpa.model.MentorRegisterForm;
import com.snapit.solutions.mentor.sherpa.validator.MentorRegisterValidator;
import com.snapit.solutions.mentor.sherpa.validator.StudentRegisterValidator;
import com.snapit.solutions.securtiy.entity.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/register")
@SessionAttributes({"mentorRegisterForm", "studentRegisterForm"})
public class RegistrationController {
    @Autowired
    MentorSherpaUserService mentorSherpaUserService;
    @Autowired
    StudentRegisterValidator studentRegisterValidator;
    @Autowired
    MentorRegisterValidator mentorRegisterValidator;
    
    @InitBinder("mentorRegisterForm")
    public void initMentorBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(mentorRegisterValidator);
        dateValidator(webDataBinder);
    }

    private void dateValidator(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @InitBinder("studentRegisterForm")
    public void initStudentBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(studentRegisterValidator);
        dateValidator(webDataBinder);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView register(Model model) {
        initialize(model);
        return new ModelAndView("register");
    }

    private void initialize(Model model) {
        MentorRegisterForm mentorRegisterForm = new MentorRegisterForm();
        StudentRegisterForm studentRegisterForm = new StudentRegisterForm();
        model.addAttribute(mentorRegisterForm);
        model.addAttribute(studentRegisterForm);
    }
    
    @RequestMapping(value = "/mentor", method = RequestMethod.POST)
    public String mentorRegistration(@Validated @ModelAttribute("mentorRegisterForm") MentorRegisterForm mentorRegisterForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        return register(mentorRegisterForm, result, model, "MENTOR", redirectAttributes);
    }
    
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String studentRegistration(@Validated @ModelAttribute("studentRegisterForm") StudentRegisterForm studentRegisterForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        return register(studentRegisterForm, result, model, "STUDENT", redirectAttributes);
    }
    
    private String register(RegisterForm registerForm, BindingResult result, Model model, String role, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
//            if (registerForm instanceof MentorRegisterForm) {
//                model.addAttribute("mentorRegisterForm", registerForm);
//            } else if (registerForm instanceof StudentRegisterForm) {
//                model.addAttribute("studentRegisterForm", registerForm);
//            }
            return "register";            
        }
        User user;
        user = mentorSherpaUserService.findUser(registerForm.getEmailId());
        
        if (user == null) {
            mentorSherpaUserService.registerUser(registerForm, role);
            redirectAttributes.addFlashAttribute("successMessage", "You have successfully registered. Please Login! ");
            return "redirect:/login";
        } else {
            result.reject("Oops! that email already exists. Try logging in!");
        }
        return "register";
    }
}
