/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.security.dao;

import com.snapit.solutions.securtiy.entity.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface UserDAO extends DAO<User, ObjectId> {
    
}
