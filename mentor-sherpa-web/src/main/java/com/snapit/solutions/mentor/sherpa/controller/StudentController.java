/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.entity.Student;
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
@RequestMapping("/student")
public class StudentController extends AbstractMentorStudentController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showStudent(@PathVariable String id, Model model) {
        Student student = studentService.findById(id);
        if (student != null) {
            model.addAttribute(student);
        } else {
            model.addAttribute(new Student());  // We should be throwing Exception
        }
        return "studentProfile";
    }   
        
    @RequestMapping(value = "/signup/{id}", method = RequestMethod.POST)
    public String showQuestions(@PathVariable String id, @ModelAttribute ProgramSignupForm programSignupForm, Model model, RedirectAttributes redirectAttributes) {
        return showQuestions(id, programSignupForm, model, true, redirectAttributes);
    }
}
