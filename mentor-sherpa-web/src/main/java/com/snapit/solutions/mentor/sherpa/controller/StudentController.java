/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.controller;

import com.snapit.solutions.mentor.sherpa.entity.Student;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.service.MentorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.snapit.solutions.mentor.sherpa.service.StudentService;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    MentorService mentorService;
    
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String showMentor(@PathVariable String name, Model model) {
        Mentor mentor = mentorService.findByMentorName(name);
        model.addAttribute(mentor);
        return "studentProfile";
    }   
        
    @RequestMapping(value = "/mentor/list", method = RequestMethod.GET)
    public ModelAndView showMentorList(Model model) {
//        List<Mentor> mentorList = new ArrayList<Mentor>();
        List<Mentor> mentorList = mentorService.findall();
//        Mentor mentor = new Mentor();
//        mentor.setAge(32);
//        mentor.setName("John Doe");
//        mentor.setGender("Male");
//        mentor.setEducation("Masters");
//        mentorList.add(mentor);
//        mentor = new Mentor();
//        mentor.setAge(32);
//        mentor.setName("John Doe");
//        mentor.setGender("Male");
//        mentor.setEducation("Masters");
//        mentorList.add(mentor);
//        mentor = new Mentor();
//        mentor.setAge(32);
//        mentor.setName("John Doe");
//        mentor.setGender("Male");
//        mentor.setEducation("Masters");
//        mentorList.add(mentor);
//        mentor = new Mentor();
//        mentor.setAge(32);
//        mentor.setName("John Doe");
//        mentor.setGender("Male");
//        mentor.setEducation("Masters");
//        mentorList.add(mentor);
//        mentor = new Mentor();
//        mentor.setAge(32);
//        mentor.setName("John Doe");
//        mentor.setGender("Male");
//        mentor.setEducation("Masters");
//        mentorList.add(mentor);
//        mentor = new Mentor();
//        mentor.setAge(32);
//        mentor.setName("John Doe");
//        mentor.setGender("Male");
//        mentor.setEducation("Masters");
//        mentorList.add(mentor);
//        mentor = new Mentor();
//        mentor.setAge(32);
//        mentor.setName("John Doe");
//        mentor.setGender("Male");
//        mentor.setEducation("Masters");
//        mentorList.add(mentor);
//        mentor = new Mentor();
//        mentor.setAge(32);
//        mentor.setName("John Doe");
//        mentor.setGender("Male");
//        mentor.setEducation("Masters");
//        mentorList.add(mentor);
//        
        model.addAttribute(mentorList);
        return new ModelAndView("mentorList");
    }
    
    @RequestMapping(value = "/organization/list", method = RequestMethod.GET)
    public ModelAndView showOrganizationList(Model model) {
        List<Student> childList = studentService.findall();
        
//        interestsList.add("Baking");
//        Student child = new Student();
//        child.setAge(10);
//        child.setName("John Doe");
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//        childList.add(child);
//
//        child = new Student();
//        child.setAge(8);
//        child.setName("John Doe");
//        child.setGender("Male");
//        childList.add(child);
//        child.setIntrests(interestsList);
//
//        child = new Student();
//        child.setAge(12);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Student();
//        child.setAge(16);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Student();
//        child.setAge(13);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Student();
//        child.setAge(14);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Student();
//        child.setAge(11);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Student();
//        child.setAge(12);
//        child.setName("John Doe");
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//        childList.add(child);
        
        model.addAttribute(childList);
        return new ModelAndView("organziationList");
    }

    
}
