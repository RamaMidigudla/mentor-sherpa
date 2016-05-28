/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.slantfree.mentor.sherpa;

import com.snapit.solutions.slantfree.mentor.sherpa.entity.Organization;
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
