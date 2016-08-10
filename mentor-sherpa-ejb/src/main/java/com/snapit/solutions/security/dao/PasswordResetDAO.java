/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.security.dao;

import com.snapit.solutions.mentor.sherpa.entity.PasswordResetToken;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface PasswordResetDAO extends DAO<PasswordResetToken, ObjectId> {
    public PasswordResetToken findByIdToken(String id, String token);
}
