 /*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.dao.impl;

import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.securtiy.entity.User;

import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Repository("organizationDAO")
public class OrganizationDAOImpl extends BasicDAO<Organization, ObjectId> implements OrganizationDAO {
    
    @Autowired
    public OrganizationDAOImpl(Datastore datastore) {
        super(datastore);
        datastore.ensureIndexes(); //creates all defined with @Indexed
        datastore.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }
    
    
    @Override
    public List<Organization> findAll() {
        return getDatastore().find( Organization.class ).asList();      
    }
    
    //can find orgs by any field of our choice
    @Override
    public Organization findOrganizationByUserName(User superUser) {
            return getDatastore().find(
                    Organization.class, 
                    "superUser.userName", 
                    superUser.getEmail()).get();      
        
    } 
    
    @Override
    public void saveOrganization(Organization organization) {    
       getDatastore().save(organization);       
    }

    @Override
    public void updateOrganizationById(Organization organization) {
        
        Datastore dataStore = getDatastore();
        
        Query<Organization> updateQuery = 
                getDatastore().createQuery(Organization.class).field("_id").equal(organization.getId());
     
           UpdateOperations<Organization> ops = dataStore.createUpdateOperations(Organization.class).
            set("organizationName", organization.getOrganizationName()).
            set("superUser", organization.getSuperUser()).
            set("programs", organization.getPrograms());
    
            dataStore.update(updateQuery, ops);
    } 
    
    @Override
    public void deleteOrganizationById(Organization organization) {     
        Datastore dataStore = getDatastore(); 
        Query<Organization> deleteQuery = 
                dataStore.createQuery(Organization.class).field("_id").equal(organization.getId());
            dataStore.delete(deleteQuery);
    } 

    @Override
    public Organization retrieveOrganizationById(ObjectId orgID) {
        return getDatastore().find(
                    Organization.class, 
                    "_id", 
                    orgID).get(); 
    }

    
    
    
        
}
