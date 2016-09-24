/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.security.dao.impl;

import com.snapit.solutions.mentor.sherpa.dao.utils.DaoUtils;
import com.snapit.solutions.security.dao.UserDAO;
import com.snapit.solutions.securtiy.entity.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Repository("userDAO")
public class UserDAOImpl extends BasicDAO<User, ObjectId>implements UserDAO {
    
    @Autowired
    public UserDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }
    
    @Override
    public User findUserByUserName(String userId) {
        return getDatastore().find(User.class).field("email").equal(userId).get();
    }
    
    @Override
    public User findById(String id) {
        return getDatastore().find(User.class).field("_id").
                equal(DaoUtils.createObjectId(id)).get();
    } 
    
}
