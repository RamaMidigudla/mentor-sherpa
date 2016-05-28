/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.dao.impl;

import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Repository("organizationDAO")
public class OrganizationDAOImpl extends BasicDAO<Organization, ObjectId> implements OrganizationDAO {
    
    @Autowired
    public OrganizationDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Organization> findAll() {
        return getDatastore().find( Organization.class ).asList();
    }
}
