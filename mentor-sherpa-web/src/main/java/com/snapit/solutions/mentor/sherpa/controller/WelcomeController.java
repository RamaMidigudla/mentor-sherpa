/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(Model model) {
        return new ModelAndView("home");
    }

}
