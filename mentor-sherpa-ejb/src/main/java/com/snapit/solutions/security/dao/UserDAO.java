/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.security.dao;

import com.snapit.solutions.securtiy.entity.CustomUser;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface UserDAO extends DAO<CustomUser, ObjectId> {
    public CustomUser findUserByUserName(String userId);
    
    //public void save(CustomUser user);
    
}
