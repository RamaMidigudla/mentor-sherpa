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
import com.snapit.solutions.mentor.sherpa.entity.Child;
import com.snapit.solutions.mentor.sherpa.service.ChildService;
import com.snapit.solutions.mentor.sherpa.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

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
    ChildService childService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView organization(Model model) {
        return new ModelAndView("registration");
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(Model model) {
        return new ModelAndView("registration");
    }
    
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
    
    @RequestMapping(value = "/child/list", method = RequestMethod.GET)
    public ModelAndView showChildList(Model model) {
        List<Child> childList = childService.findall();
        
//        interestsList.add("Baking");
//        Child child = new Child();
//        child.setAge(10);
//        child.setName("John Doe");
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//        childList.add(child);
//
//        child = new Child();
//        child.setAge(8);
//        child.setName("John Doe");
//        child.setGender("Male");
//        childList.add(child);
//        child.setIntrests(interestsList);
//
//        child = new Child();
//        child.setAge(12);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Child();
//        child.setAge(16);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Child();
//        child.setAge(13);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Child();
//        child.setAge(14);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Child();
//        child.setAge(11);
//        child.setName("John Doe");
//        childList.add(child);
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//
//        child = new Child();
//        child.setAge(12);
//        child.setName("John Doe");
//        child.setGender("Male");
//        child.setIntrests(interestsList);
//        childList.add(child);
        
        model.addAttribute(childList);
        return new ModelAndView("childList");
    }

}
