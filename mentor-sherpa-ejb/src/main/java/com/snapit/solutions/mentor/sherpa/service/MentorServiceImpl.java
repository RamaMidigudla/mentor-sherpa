/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.MentorAndStudentResponseDAO;
import com.snapit.solutions.mentor.sherpa.dao.MentorDAO;
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.entity.AssignedMentor;
import com.snapit.solutions.mentor.sherpa.entity.SignedupOrganization;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import com.snapit.solutions.mentor.sherpa.service.utils.CommonServiceUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ram
 */
@Service("mentorService")
public class MentorServiceImpl implements MentorService {

    @Autowired
    MentorDAO mentorDAO;
    
    @Autowired
    StudentDAO studentDAO;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    QuestionOptionsService questionOptionsService;

    @Autowired
    MentorAndStudentResponseDAO mentorAndStudentResponseDAO;

    @Override
    public void createMentor(Mentor mentor) {
        mentorDAO.save(mentor);
    }

    @Override
    public List<Mentor> findall() {
        return mentorDAO.findAll();
    }

    @Override
    public Mentor findByMentorName(String mentorName) {
        return mentorDAO.findByMentorName(mentorName);
    }

    @Override
    public Mentor findById(String id) {
        return mentorDAO.findById(id);
    }

    @Override
    public List<QuestionOptions> getQuestionsForMentorToAnswer(SignedupOrganization interestedOrganizations) {
        Organization organization = organizationService.findOrganziationById(CommonServiceUtils.createStringId(interestedOrganizations.getOrgId()));
        return questionOptionsService.findQuestionOptionsByQuestionFor(
                CommonServiceUtils.findrequiredQuestionIdList(
                        organization, interestedOrganizations), "mentor");
    }

    @Override
    public List<Mentor> getUnassignedMentorList() {   
        List<Mentor> signedUpMentorList = getSignedUpMentorList(findall()); 
         List<Mentor> unAssignedMentorList = new ArrayList();
        if(!signedUpMentorList.isEmpty()){
            List<Mentor> assignedMentorList = getAssignedMentorList(signedUpMentorList);  
            for(Mentor mentor : signedUpMentorList){
                if(!assignedMentorList.contains(mentor)){
                    unAssignedMentorList.add(mentor);     
                }
            } 
        }
        return unAssignedMentorList;   
    }
    
    @Override
    public List<Mentor> getAssignedMentorList(List<Mentor> signedUpMentorList) {
   
        Set<ObjectId> mentorObjectIdSet = new HashSet();
        for(Mentor mentor : signedUpMentorList){
            mentorObjectIdSet.add(mentor.getUserObjectId());
        }
        
        Set<String> mentorIdSet = CommonServiceUtils.createSetOfStringIds(mentorObjectIdSet);
        
        List<Student> studentList = new ArrayList();
        for(String mentorId : mentorIdSet){
            Student student = null;
            student = studentDAO.retrieveStudentsWithAssignedMentor(mentorId);
            if (student != null) {
                studentList.add(student);
            }
        }   
        List<Mentor> assignedMentorList = new ArrayList();
        Set<ObjectId> assignedMentorIdSet = new HashSet();
        if(!studentList.isEmpty()){
            for(Student student : studentList){
               if(student.getAssignedMentors() != null && !student.getAssignedMentors().isEmpty()){
                   for(AssignedMentor assignedMentor : student.getAssignedMentors()){
                   assignedMentorIdSet.add(assignedMentor.getMentorUserObjectId());
                  }
               } 
            }
          assignedMentorList.addAll(mentorDAO.findMentorsByUserObjectIds(CommonServiceUtils.createSetOfStringIds(assignedMentorIdSet)));
        }  
        return assignedMentorList;   
    }

    @Override
    public List<Mentor> getSignedUpMentorList(List<Mentor> fullMentorList) {
        List<Mentor> signedUpMentorList = new ArrayList();
        for(Mentor mentor : fullMentorList){
           MentorAndStudentResponse mentorResponse = mentorAndStudentResponseDAO.
                   retrieveByMentorStudentId(mentor.getUserObjectId().toString());
              if(mentorResponse != null){
              signedUpMentorList.add(mentor);
           }
        }
        return signedUpMentorList;
    }
    
    

}
