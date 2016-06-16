/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.dao;

import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.User;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface OrganizationDAO extends DAO<Organization, ObjectId> {
    
    /**
     * persists new organization object into organizations collection
     * @param organization 
     */
    public void saveOrganization(Organization organization);
    
    /**
     * retrieves organization object by username
     * @param superUser
     * @return 
     */
    public Organization findOrganizationByUserName(User superUser);
     
    /**
     * Updates existing organization doc in organizations collection.
     * @param organization 
     */
    public void updateOrganizationById(Organization organization);
    
    /**
     * deletes organization doc in organizations collection.
     * @param organization 
     */
    public void deleteOrganizationById(Organization organization);
    
    public List<Organization> findAll();
    
}

