/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.MentorAndStudentResponseDAO;
import com.snapit.solutions.mentor.sherpa.dao.MentorDAO;
import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.dao.QuestionOptionsDAO;
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.dao.utils.DaoUtils;
import com.snapit.solutions.mentor.sherpa.entity.AssignedUserInfo;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.Program;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import com.snapit.solutions.mentor.sherpa.service.utils.CommonServiceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    
    @Autowired
    QuestionOptionsDAO questionOptionsDAO;
    
    @Autowired
    MentorService mentorService;
    
    @Autowired
    StudentService studentService;
    

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
         
         List<Mentor> unAssignedMentorList = mentorService.getUnassignedMentorList();
         Map<Mentor, Integer> mentorMatchPercentageForStudent = new HashMap();
         Set<ObjectId> unAssignedMentorUOIds = new HashSet();
         if(unAssignedMentorList != null && !unAssignedMentorList.isEmpty())
         {     
            for(Mentor unAssignedMentor : unAssignedMentorList){
                unAssignedMentorUOIds.add(unAssignedMentor.getUserObjectId());
            }
 
         List<MentorAndStudentResponse> mentorResponseList = mentorAndStudentResponseDAO.retrieveByMentorStudentIds(CommonServiceUtils.createSetOfStringIds(unAssignedMentorUOIds));
         
         List<QuestionOptions> studentExecQuestions = questionOptionsDAO.retrieveQuestionsBasedOnExclusion(true, "student");
         
         List<QuestionOptions> mentorExecQuestions = questionOptionsDAO.retrieveQuestionsBasedOnExclusion(true, "mentor");
         
         
         Map<ObjectId, Integer> mentorToMatchPercentageMap = MatchingServiceImpl.match(studentResponse, 
                                                                                    mentorResponseList,
                                                                                    studentExecQuestions,
                                                                                    mentorExecQuestions);
         
         Set<ObjectId> mentorIds = mentorToMatchPercentageMap.keySet();
         
         List<Mentor> mentorList = mentorDAO.findMentorsByUserObjectIds(CommonServiceUtils.createSetOfStringIds(mentorIds));

         for(Mentor mentor : mentorList){
            mentorMatchPercentageForStudent.put(mentor, mentorToMatchPercentageMap.get(mentor.getUserObjectId()));
            }
       }
        
      return mentorMatchPercentageForStudent;  
    }
   

    @Override
    public void assignNewMentorToStudent(String mentorUserObjectID, String orgId, String studentUserObjectID, String programName) {
        mentorDAO.assignStudentToMentor(mentorUserObjectID, orgId, studentUserObjectID, programName);
        studentDAO.assignNewMentorToStudent(mentorUserObjectID, orgId, studentUserObjectID, programName);
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
           if(student.getAssignedUsersInfo() != null && !student.getAssignedUsersInfo().isEmpty()){
               for(AssignedUserInfo assignedMentor : student.getAssignedUsersInfo()){
                   Mentor mentor = mentorDAO.findMentorByUserObjectId(
                           assignedMentor.getUserObjectId().toString());
                      studentMentorMap.put(student, mentor);
               }
           }
           else{
             studentMentorMap.put(student, null);
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

    @Override
    public void removeAssignedMentor(String orgId, String programName, String mentorUserObjectId, String studentUserObjectId) {  
        AssignedUserInfo assignedUserInfo = new AssignedUserInfo();
        assignedUserInfo.setUserObjectId(DaoUtils.createObjectId(mentorUserObjectId));
        assignedUserInfo.setOrgId(DaoUtils.createObjectId(orgId));
        assignedUserInfo.setProgramName(programName);
        studentDAO.removeAssignedMentor(assignedUserInfo, studentUserObjectId);
    }
    
    @Override
    public void removeAssignedStudent(String orgId, String programName, String mentorUserObjectId, String studentUserObjectId){
        AssignedUserInfo assignedUserInfo = new AssignedUserInfo();
        assignedUserInfo.setUserObjectId(DaoUtils.createObjectId(studentUserObjectId));
        assignedUserInfo.setOrgId(DaoUtils.createObjectId(orgId));
        assignedUserInfo.setProgramName(programName);
        mentorDAO.removeAssignedStudent(assignedUserInfo, mentorUserObjectId);
        
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

    @Override
    public Map<Organization,String> findSignedUporganizationToProgramName(String userId) {
        return findorganizationToProgramName(userId, true);
    }
    
   @Override
    public Map<Organization,String> findUnSignedUporganizationToProgramName(String userId) {
        return findorganizationToProgramName(userId, false);
    } 
    
    
    private Map<Organization,String> findorganizationToProgramName(String userId, boolean signedUp) {
        Map<Organization, String> organizationToProgramName = new HashMap();
        List<Organization> orgList = listAllOrganizations();
        for (Organization organization : orgList) {
            List<Program> programList = organization.getPrograms();
            for (Program program : programList) {
              MentorAndStudentResponse mentorAndStudentResponse =  mentorAndStudentResponseDAO.retrieveUserResponse(
                        CommonServiceUtils.createStringId(organization.getId()),
                        userId,
                        program.getProgramName());
                if (signedUp && mentorAndStudentResponse != null) {
                    organizationToProgramName.put(organization, program.getProgramName());
                }
                else if(!signedUp && mentorAndStudentResponse == null) {
                organizationToProgramName.put(organization, program.getProgramName());
                }
            }
        }
        return organizationToProgramName;
    }
    
    @Override
    public void assignNewStudentToMentor(String studentUserObjectID, String orgId, String mentorUserObjectId, String programName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Student, Integer> getMatchedStudents(String mentorId,String mentorGender, String orgId, String programName) {
        MentorAndStudentResponse mentorResponse = mentorAndStudentResponseDAO.retrieveByMentorStudentId(mentorId);
         
         List<Student> unAssignedStudentList = studentService.getUnassignedStudentList(mentorGender);
         Map<Student, Integer> studentMatchPercentageForMentor = new HashMap();
         Set<ObjectId> unAssignedStudentIds = new HashSet();
         if(unAssignedStudentList != null && !unAssignedStudentList.isEmpty())
         {     
            for(Student unAssignedStudent : unAssignedStudentList){
                unAssignedStudentIds.add(unAssignedStudent.getUserObjectId());
            }
 
         List<MentorAndStudentResponse> studentResponseList = mentorAndStudentResponseDAO.retrieveByMentorStudentIds(CommonServiceUtils.createSetOfStringIds(unAssignedStudentIds));
         
         List<QuestionOptions> studentExecQuestions = questionOptionsDAO.retrieveQuestionsBasedOnExclusion(true, "student");
         
         List<QuestionOptions> mentorExecQuestions = questionOptionsDAO.retrieveQuestionsBasedOnExclusion(true, "mentor");
         
         
         Map<ObjectId, Integer> mentorToMatchPercentageMap = MatchingServiceImpl.match(mentorResponse, 
                                                                                    studentResponseList,
                                                                                    studentExecQuestions,
                                                                                    mentorExecQuestions);
         
         Set<ObjectId> studentIds = mentorToMatchPercentageMap.keySet();
         
         List<Student> studentList = studentDAO.findStudentByUserObjectIds(CommonServiceUtils.createSetOfStringIds(studentIds));

         for(Student student : studentList){
            studentMatchPercentageForMentor.put(student, mentorToMatchPercentageMap.get(student.getUserObjectId()));
            }
       }
        
      return studentMatchPercentageForMentor;  
    }

    @Override
    public List<Mentor> findUnSignedUpMentors(List<Student> fullStudentList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Mentor, Student> findSignedUpMentorsAndAssignedStudents(List<Mentor> fullMentorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAssignedStudents(String orgId, String programName, String mentorUserObjectId, String studentUserObjectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Mentor, List<Student>> findSignedUpMentorInfoByProgramName() {
        List<Mentor> signedUpMentorList = mentorService.getSignedUpMentorList(mentorService.findall());
        Map<Mentor, List<Student>> mentorToAssignedStudentsMap = new HashMap();
        for (Mentor mentor : signedUpMentorList) {
            Set<ObjectId> assignedStudentIds = new HashSet();
            if (mentor.getAssignedUsersInfo() != null && !mentor.getAssignedUsersInfo().isEmpty()) {
                for (AssignedUserInfo assignedUserInfo : mentor.getAssignedUsersInfo()) {
                    assignedStudentIds.add(assignedUserInfo.getUserObjectId());
                }

            }
            List<Student> studentList = new ArrayList();
            if(!assignedStudentIds.isEmpty()){
            studentList = studentDAO.findStudentByUserObjectIds(
                    CommonServiceUtils.createSetOfStringIds(assignedStudentIds));
            }
            mentorToAssignedStudentsMap.put(mentor, studentList);
        }
        return mentorToAssignedStudentsMap;
    }
    
}

    
