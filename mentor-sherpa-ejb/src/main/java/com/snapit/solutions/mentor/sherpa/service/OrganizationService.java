/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Organization;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface OrganizationService {

    public List<Organization> listAllOrganizations();

    public Organization findOrganziationById(ObjectId orgId);
    public Organization findOrganziationById(String orgId);
    public Organization findOrganziationByUserId(String orgId);

}
