/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
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
     * Show Questions for a Program.
     *
     * @param id
     * @param programSignupForm
     * @param model
     * @return
     */    
    @RequestMapping(value = "/signup/{id}", method = RequestMethod.POST)
    public String showQuestions(@PathVariable String id, @ModelAttribute ProgramSignupForm programSignupForm, Model model, RedirectAttributes redirectAttributes) {
        return showQuestions(id, programSignupForm, model, false, redirectAttributes);
    }
}
