/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.MentorAndStudentResponseDAO;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.SignedupOrganization;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.service.utils.CommonServiceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
   
   @Autowired
   MentorAndStudentResponseDAO mentorAndStudentResponseServiceDao;
    
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
    public List<QuestionOptions> getQuestionsForStudentToAnswer(SignedupOrganization interestedOrganizations) {
        Organization organization = organizationService.findOrganziationById(CommonServiceUtils.createStringId(interestedOrganizations.getOrgId()));
        return questionOptionsService.findQuestionOptionsByQuestionFor(
                CommonServiceUtils.findrequiredQuestionIdList(
                        organization, interestedOrganizations), "student");
    }
    
    @Override
    public List<Student> findAllByProgramName(String orgId, String programName) {
        List<Student> studentList = new ArrayList<>();
            List<MentorAndStudentResponse> mentorStudentRespone = mentorAndStudentResponseServiceDao.retrieveByProgram(orgId, programName);
            if (mentorStudentRespone != null && !mentorStudentRespone.isEmpty()) {
                for(MentorAndStudentResponse mentorStudent : mentorStudentRespone) {
                    Student student = studentDAO.findById(mentorStudent.getMentorOrStudentId().toString());
                    if (student != null) {
                        studentList.add(student);
                    }
                }
            }
            return studentList;
    }
    
    @Override
    public Map<String, List<Student>> findAllByOrg(String orgId) {
        Map<String, List<Student>> studentMap = new HashMap<>();
            List<MentorAndStudentResponse> mentorStudentRespone = mentorAndStudentResponseServiceDao.retrieveByOrg(orgId);
            if (mentorStudentRespone != null && !mentorStudentRespone.isEmpty()) {
                for(MentorAndStudentResponse mentorStudent : mentorStudentRespone) {
                    Student student = null;
                    student = studentDAO.findStudentByUserObjectId(mentorStudent.getMentorOrStudentId().toString());
                    if (student != null) {
                        if (studentMap.get(mentorStudent.getProgramName()) != null) {
                            studentMap.get(mentorStudent.getProgramName()).add(student);
                        } else {
                         List<Student> studentList = new ArrayList<>();
                         studentList.add(student);
                        studentMap.put(mentorStudent.getProgramName(), studentList);
                        }
                    }
                }
            }
            return studentMap;
    }
}
