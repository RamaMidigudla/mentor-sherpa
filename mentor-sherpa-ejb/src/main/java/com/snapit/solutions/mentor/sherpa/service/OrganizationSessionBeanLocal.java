/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Organization;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Local
public interface OrganizationSessionBeanLocal {
    public List<Organization> listAllOrganizations();
}
