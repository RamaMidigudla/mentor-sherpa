/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.entity.InterestedOrganizations;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.service.utils.CommonServiceUtils;

/**
 *
 * @author Ram
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    StudentDAO studentDAO;
    
   @Autowired
   OrganizationService organizationService;

   @Autowired
   QuestionOptionsService questionOptionsService;
   
    
    @Override
    public List<Student> findall() {
        return studentDAO.findAll();
    }

    @Override
    public void createMentor(Student student) {
        studentDAO.save(student);
    }

    @Override
    public Student findById(String id) {
        return studentDAO.findById(id);
    }
    
    @Override
    public List<QuestionOptions> getQuestionsForStudentToAnswer(InterestedOrganizations interestedOrganizations) {
        Organization organization = organizationService.findOrganziationById(interestedOrganizations.getOrgId());
        return questionOptionsService.findQuestionOptionsByQuestionFor(
                CommonServiceUtils.findrequiredQuestionIdList(
                        organization, interestedOrganizations), "student");
    }
    
}
