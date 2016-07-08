/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.model.RegisterForm;
import com.snapit.solutions.mentor.sherpa.model.StudentRegisterForm;
import com.snapit.solutions.mentor.sherpa.model.MentorRegisterForm;
import com.snapit.solutions.mentor.sherpa.validator.MentorRegisterValidator;
import com.snapit.solutions.mentor.sherpa.validator.StudentRegisterValidator;
import com.snapit.solutions.securtiy.entity.User;
import com.snapit.solutions.securtiy.service.UserService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/register")
@SessionAttributes({"mentorRegisterForm", "studentRegisterForm"})
public class RegistrationController {
    @Autowired
    private UserService userService;
    static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(11);
    
//    @Autowired
//    RegisterValidator registerValidator;
    @Autowired
    StudentRegisterValidator studentRegisterValidator;
    @Autowired
    MentorRegisterValidator mentorRegisterValidator;
    
//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder){
//        webDataBinder.setValidator(registerValidator);
//    }
    @InitBinder("mentorRegisterForm")
    public void initMentorBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(mentorRegisterValidator);
        dateValidator(webDataBinder);
    }

    private void dateValidator(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
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
    public String mentorRegistration(@Validated @ModelAttribute("mentorRegisterForm") MentorRegisterForm mentorRegisterForm, BindingResult result, Model model) {
        return register(mentorRegisterForm, result, model, "MENTOR");
    }
    
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String studentRegistration(@Validated @ModelAttribute("studentRegisterForm") StudentRegisterForm studentRegisterForm, BindingResult result, Model model) {
        return register(studentRegisterForm, result, model, "STUDENT");
    }
    
    private String register(RegisterForm registerForm, BindingResult result, Model model, String role) {
        if (result.hasErrors()) {
//            if (registerForm instanceof MentorRegisterForm) {
//                model.addAttribute("mentorRegisterForm", registerForm);
//            } else if (registerForm instanceof StudentRegisterForm) {
//                model.addAttribute("studentRegisterForm", registerForm);
//            }
            return "register";            
        }
        User user;
        user = userService.findByUserId(registerForm.getEmailId());
        
        if (user == null) {
            List<String> roles = new ArrayList<>();
            roles.add(role);
            user = new User();
            user.setEmail(registerForm.getEmailId());
            user.setPassword(PASSWORD_ENCODER.encode(registerForm.getPassword()));
            user.setFirstName(registerForm.getFirstName());
            user.setLastName(registerForm.getLastName());
            user.setUserRole(roles);
            user.setDateOfBirth(registerForm.getDateOfBirth());
            user.setPhoneNumber(registerForm.getPhoneNumber());
            userService.registerUser(user);
            return "redirect:login";
        } else {
            result.reject("Oops! that email already exists. Try logging in!");
        }
        return "register";
    }
}
