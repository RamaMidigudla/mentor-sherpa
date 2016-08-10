/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.security.dao.impl;

import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.PasswordResetToken;
import com.snapit.solutions.security.dao.PasswordResetDAO;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Repository("passwordResetDAO")
public class PasswordResetDAOImpl extends BasicDAO<PasswordResetToken, ObjectId> implements PasswordResetDAO {
    
    @Autowired
    public PasswordResetDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    } 
    
    @Override
    public PasswordResetToken findByIdToken(String id, String token) {
         Query<PasswordResetToken> query = getDatastore().createQuery(PasswordResetToken.class);
         query.field("user.id").equal(new ObjectId(id)).
                and(query.criteria("token").equal(token));
        return query.get();
    }
    
}
