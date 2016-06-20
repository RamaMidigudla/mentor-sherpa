/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.model.LoginForm;
import com.snapit.solutions.securtiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/site/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showLogin(Model model) {
        return new ModelAndView("login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        userService.findByUserId(loginForm.getEmailId());
        return new ModelAndView("login");
    }

}
