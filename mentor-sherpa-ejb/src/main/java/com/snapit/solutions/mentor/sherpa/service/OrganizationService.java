/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Organization;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Remote
public interface OrganizationService {
    public List<Organization> listAllOrganizations();
}
