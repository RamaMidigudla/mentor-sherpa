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
//    @Override
//    public List<String> getPrograms(String organizationId) {
//        List<String> programNames = new ArrayList<>();
//        Organization organization = organizationDao.findByUserId(organizationId);
//        if (organizationId != null) {
//            List<Program> programs = organization.getPrograms();
//            if (programs != null && !programs.isEmpty()) {
//                for (Program program : programs) {
//                    programNames.add(program.getProgramName());
//                }
//            }
//        }
//        return programNames;
//    }
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
    public void assignNewMentorToStudent(String studentID, String orgId, String mentorId, String programName) {
        studentDAO.assignNewMentorToStudent(studentID, orgId, mentorId, programName);
    }

    @Override
    public Organization findByOrganizationName(String name) {
        return organizationDao.findByOrgName(name);
    }
    
    @Override
    public Map<ObjectId, Mentor> findAssignedMentorForStudents(List<Student> studentList)
    {
        Map<ObjectId ,List<AssignedMentor>> studentToAssignedMentorMap = new HashMap();
        for(Student student : studentList){
           if(!student.getAssignedMentors().isEmpty()){
           studentToAssignedMentorMap.put(student.getId(), student.getAssignedMentors());
           }
        }
        Map<ObjectId, Mentor> studentToMentorMap = new HashMap();
        for (Map.Entry<ObjectId ,List<AssignedMentor>> entry : studentToAssignedMentorMap.entrySet()) {
          for(AssignedMentor assignedMentor : entry.getValue()){
             studentToMentorMap.put(entry.getKey(), mentorDAO.findById(assignedMentor.getMentorId().toString()));
          }
        }
        return studentToMentorMap;
    }
    
    
}
