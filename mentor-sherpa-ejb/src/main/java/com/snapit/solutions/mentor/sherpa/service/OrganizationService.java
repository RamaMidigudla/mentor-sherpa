/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface OrganizationService {

    public List<Organization> listAllOrganizations();

    public Organization findOrganziationById(ObjectId orgId);
    
    public Organization findOrganziationById(String orgId);
    
    public Map<Mentor, Integer> getMatchedMentors(ObjectId studentId, ObjectId orgId, String programName);

}
