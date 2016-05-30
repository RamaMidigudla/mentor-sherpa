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
@RequestMapping("/organization")
public class OrganizationController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView register(Model model) {
        return new ModelAndView("organization.registration");
    }
}
