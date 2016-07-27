/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface OrganizationService {

    public List<Organization> listAllOrganizations();
    
    public Organization findOrganziationById(String orgId);
    
    public Map<Mentor, Integer> getMatchedMentors(String studentId, String orgId, String programName);

}
