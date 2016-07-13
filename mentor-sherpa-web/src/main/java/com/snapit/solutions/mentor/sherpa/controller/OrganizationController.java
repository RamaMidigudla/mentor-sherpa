/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import com.snapit.solutions.mentor.sherpa.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import com.snapit.solutions.mentor.sherpa.service.StudentService;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    MentorService mentorService;
    
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/programs", method = RequestMethod.GET)
    public ModelAndView programs(Model model) {
        return new ModelAndView("");
    }
    
    @RequestMapping(value = "/programs/add", method = RequestMethod.GET)
    public ModelAndView addPrograms(Model model) {
        return new ModelAndView("");
    }
    @RequestMapping(value = "/mentor/{name}", method = RequestMethod.GET)
    public String showMentor(@PathVariable String name, Model model) {
        Mentor mentor = mentorService.findByMentorName(name);
        model.addAttribute(mentor);
        return "mentorProfile";
    }   
        
    @RequestMapping(value = "/mentor/list", method = RequestMethod.GET)
    public ModelAndView showMentorList(Model model) {
        List<Mentor> mentorList = mentorService.findall();
        model.addAttribute(mentorList);
        return new ModelAndView("mentorList");
    }
    
    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public ModelAndView showStudentList(Model model) {
        List<Student> studentList = studentService.findall();
        model.addAttribute(studentList);
        return new ModelAndView("studentList");
    }
    
    @RequestMapping(value = "/{id}/assign", method = RequestMethod.GET)
    public String assignMentor(@PathVariable String id, Model model) {
        
        return "assignMentor";
    }   
}
