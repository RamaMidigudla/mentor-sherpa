/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.MentorAndStudentResponseDAO;
import com.snapit.solutions.mentor.sherpa.dao.MentorDAO;
import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
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
                                                                retrieveMentorsResponsebyOrgAndProgram(orgId, programName, orgId);
         
         Map<ObjectId, Integer> mentorToMatchPercentageMap = MatchingServiceImpl.match(studentResponse, mentorResponseList);
         
         Set<ObjectId> mentorIds = mentorToMatchPercentageMap.keySet();
         
         List<Mentor> mentorList = mentorDAO.findMentorsByIds(CommonServiceUtils.createSetOfStringIds(mentorIds));
         
         Map<Mentor, Integer> mentorMatchPercentageForStudent = new HashMap();
         
         for(Mentor mentor : mentorList){
            mentorMatchPercentageForStudent.put(mentor, mentorToMatchPercentageMap.get(mentor.getId()));
         }
        
      return mentorMatchPercentageForStudent;  
    }

    @Override
    public void assignNewMentorToStudent(String studentID, String orgId, String mentorId, String programName) {
        studentDAO.assignNewMentorToStudent(studentID, orgId, mentorId, programName);
    }
    
    
}
