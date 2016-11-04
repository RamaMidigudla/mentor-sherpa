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
   MentorAndStudentResponseDAO mentorAndStudentResponseDao;
    
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
            List<MentorAndStudentResponse> mentorStudentRespone = mentorAndStudentResponseDao.retrieveByProgram(orgId, programName);
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
            List<MentorAndStudentResponse> mentorStudentRespone = mentorAndStudentResponseDao.retrieveByOrg(orgId);
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

    @Override
    public Student findByUserId(String userId) {
       return studentDAO.findStudentByUserObjectId(userId);
    }
    
    @Override
    public List<Student> getAssignedStudentList(List<Student> signedUpStudentList) {
         List<Student> assignedStudentList = new ArrayList(); 
         for(Student student : signedUpStudentList){
             if(student.getAssignedUsersInfo()!= null && !student.getAssignedUsersInfo().isEmpty())
            assignedStudentList.add(student);
        }
        return assignedStudentList; 
    }

    @Override
    public List<Student> getSignedUpStudentList(List<Student> fullStudentList) {
        List<Student> signedUpStudentList = new ArrayList();
        for(Student student : fullStudentList){
           MentorAndStudentResponse mentorResponse = mentorAndStudentResponseDao.
                   retrieveByMentorStudentId(student.getUserObjectId().toString());
              if(mentorResponse != null){
              signedUpStudentList.add(student);
           }
        }
        return signedUpStudentList;
    }
    
    @Override
    public List<Student> getUnassignedStudentList() {   
        List<Student> signedUpStudentList = getSignedUpStudentList(findall()); 
         List<Student> unAssignedSignedList = new ArrayList();
        if(!signedUpStudentList.isEmpty()){
            List<Student> assignedStudentList = getAssignedStudentList(signedUpStudentList);  
            for(Student student : signedUpStudentList){
                if(!assignedStudentList.contains(student)){
                    unAssignedSignedList.add(student);     
                }
            } 
        }
        return unAssignedSignedList; 
    }
    
}
