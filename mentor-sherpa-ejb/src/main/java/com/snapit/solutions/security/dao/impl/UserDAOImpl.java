/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.security.dao.impl;

import com.snapit.solutions.security.dao.UserDAO;
import com.snapit.solutions.securtiy.entity.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public class UserDAOImpl extends BasicDAO<User, ObjectId>implements UserDAO {
    @Autowired
    public UserDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }
}
