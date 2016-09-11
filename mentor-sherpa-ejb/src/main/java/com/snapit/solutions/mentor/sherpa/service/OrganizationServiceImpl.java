/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.MentorAndStudentResponseDAO;
import com.snapit.solutions.mentor.sherpa.dao.MentorDAO;
import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.entity.AssignedMentor;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import com.snapit.solutions.mentor.sherpa.service.utils.CommonServiceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDAO organizationDao;
    
    @Autowired
    MentorAndStudentResponseDAO mentorAndStudentResponseDAO;
    
    @Autowired
    MentorDAO mentorDAO;
    
    @Autowired
    StudentDAO studentDAO;
    

    @Override
    public List<Organization> listAllOrganizations() {
        return organizationDao.findAll();
    }

    @Override
    public Organization findOrganziationById(String orgId) {
        return organizationDao.findById(orgId);
    }
    @Override
    public Organization findOrganziationByUserId(String userId) {
        return organizationDao.findByUserId(userId);
}
    
    @Override
    public Map<Mentor, Integer> getMatchedMentors(String studentId, String orgId, String programName) {
       
         MentorAndStudentResponse studentResponse = mentorAndStudentResponseDAO.retrieveByMentorStudentId(studentId);
         
         List<MentorAndStudentResponse> mentorResponseList = mentorAndStudentResponseDAO.
                                                                retrieveMentorsResponsebyOrgAndProgram(orgId, programName, studentId);
         
         Map<ObjectId, Integer> mentorToMatchPercentageMap = MatchingServiceImpl.match(studentResponse, mentorResponseList);
         
         Set<ObjectId> mentorIds = mentorToMatchPercentageMap.keySet();
         
         List<Mentor> mentorList = mentorDAO.findMentorsByUserObjectIds(CommonServiceUtils.createSetOfStringIds(mentorIds));
         
         Map<Mentor, Integer> mentorMatchPercentageForStudent = new HashMap();
         
         for(Mentor mentor : mentorList){
            mentorMatchPercentageForStudent.put(mentor, mentorToMatchPercentageMap.get(mentor.getUserObjectId()));
         }
        
      return mentorMatchPercentageForStudent;  
    }

    @Override
    public void assignNewMentorToStudent(String studentUserObjectID, String orgId, String mentorUserObjectID, String programName) {
        studentDAO.assignNewMentorToStudent(studentUserObjectID, orgId, mentorUserObjectID, programName);
    }

    @Override
    public Organization findByOrganizationName(String name) {
        return organizationDao.findByOrgName(name);
    }
    
    @Override
    public Map<Student, Mentor> findSignedUpStudentsAndAssignedMentors(List<Student> fullStudentList)
    {
       Map<Student, Mentor> studentMentorMap = new HashMap();
       
       List<Student> unSignedUpStudents = findUnSignedUpStudents(fullStudentList);
       
       List<Student> signedUpStudents = getSignedUpStudents(fullStudentList, unSignedUpStudents);
       
       for(Student student : signedUpStudents){
           if(!student.getAssignedMentors().isEmpty()){
               for(AssignedMentor assignedMentor : student.getAssignedMentors()){
                   List<Mentor> mentors = mentorDAO.findMentorsByUserObjectIds(
                           CommonServiceUtils.createHashSet(assignedMentor.getMentorUserObjectId().toString()));
                   for(Mentor mentor : mentors){
                      studentMentorMap.put(student, mentor);
                   }
               }
           }
           else{
             studentMentorMap.put(student, new Mentor());
           }    
       }  
        return studentMentorMap;   
    }
    
    @Override
    public List<Student> findUnSignedUpStudents(List<Student> fullStudentList){    
        List<Student> unSignedUpStudents = new ArrayList();
        for(Student student : fullStudentList){
           MentorAndStudentResponse studentResponse = mentorAndStudentResponseDAO.
                   retrieveByMentorStudentId(student.getUserObjectId().toString()); 
           if(studentResponse == null){
              unSignedUpStudents.add(student);
           }
        }
        return unSignedUpStudents;
    }

    private List<Student> getSignedUpStudents(List<Student> fullStudentList,List<Student> unSignedUpStudents)
    {  
        List<Student> signedUpStudents = new ArrayList();     
        for(Student student : fullStudentList){
           if(!unSignedUpStudents.contains(student)){
               signedUpStudents.add(student);
           } 
       }
         return signedUpStudents;
    }   
}

    
