/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface OrganizationService {

    public List<Organization> listAllOrganizations();
    
    public Organization findOrganziationById(String orgId);
    
    public Map<Mentor, Integer> getMatchedMentors(String studentId, String orgId, String programName);
    
    public Organization findOrganziationByUserId(String orgId);
    
    public Organization findByOrganizationName(String name);

    public void assignNewMentorToStudent(String studentUserObjectID, String orgId, String mentorUserObjectId, String programName);
    
    public Map<Student, Mentor> findSignedUpStudentsAndAssignedMentors();

}
