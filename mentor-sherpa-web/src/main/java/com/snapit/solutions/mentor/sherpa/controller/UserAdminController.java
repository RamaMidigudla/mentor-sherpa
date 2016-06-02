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
@RequestMapping("/user")
public class UserAdminController {
    
    @RequestMapping(value = "/organization/admin", method = RequestMethod.GET)
    public ModelAndView organizationAdminUser(Model model) {
        return new ModelAndView("");
    }
    
    @RequestMapping(value = "/organization/user", method = RequestMethod.GET)
    public ModelAndView organizationUser(Model model) {
        return new ModelAndView("");
    }
    
    @RequestMapping(value = "/mentor", method = RequestMethod.GET)
    public ModelAndView mentor(Model model) {
        return new ModelAndView("");
    }

    @RequestMapping(value = "/parent", method = RequestMethod.GET)
    public ModelAndView parent(Model model) {
        return new ModelAndView("");
    }
 
    @RequestMapping(value = "/child", method = RequestMethod.GET)
    public ModelAndView child(Model model) {
        return new ModelAndView("");
    }

}
