/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.model.ProgramSignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/mentor")
public class MentorController extends AbstractMentorStudentController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showMentor(@PathVariable String id, Model model) {
        return showProfile(id,model);
    }   
    /**
     * Show Questions for a Program.
     * @param programSignupForm
     * @param model
     * @return
     */    
    @RequestMapping(value = "programs/list", method = RequestMethod.POST)
    public String showQuestions(@ModelAttribute ProgramSignupForm programSignupForm, Model model, RedirectAttributes redirectAttributes) {
        return showQuestions(programSignupForm, model, false, redirectAttributes);
    }
}
