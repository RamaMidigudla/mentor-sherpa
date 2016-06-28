/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.model.RegisterForm;
import com.snapit.solutions.mentor.sherpa.validator.RegisterValidator;
import com.snapit.solutions.securtiy.entity.User;
import com.snapit.solutions.securtiy.service.UserService;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    
    @Autowired
    RegisterValidator registerValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(registerValidator);
    }
    

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(Model model) {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Model model) {
        return new ModelAndView("accessDenied");
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(Model model) {
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute(registerForm);
        return new ModelAndView("register");
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("registerForm") RegisterForm registerForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(registerForm);
            return new ModelAndView("register");            
        }
        User user;
        user = userService.findByUserId(registerForm.getEmailId());
        
        if (user == null) {
            user = new User();
            List<String> role = Arrays.asList("ORG-ADMIN");
            user.setEmail(registerForm.getEmailId());
            user.setPassword(registerForm.getPassword());
            user.setFirstName(registerForm.getFirstName());
            user.setLastName(registerForm.getLastName());
            user.setUserRole(role);
            userService.registerUser(user);
            return new ModelAndView("login");
        } else {
            result.reject("Oops! that email already exists. Try logging in!");
        }
        return new ModelAndView("register");
    }

}
