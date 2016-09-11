/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao.impl;

import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;
import com.snapit.solutions.mentor.sherpa.dao.MentorAndStudentResponseDAO;
import com.snapit.solutions.mentor.sherpa.dao.utils.DaoUtils;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ram
 */
@Repository("mentorAndStudentResponseDAO")
public class MentorAndStudentResponseDAOImpl extends BasicDAO<MentorAndStudentResponse, ObjectId> implements MentorAndStudentResponseDAO {

    @Autowired
    public MentorAndStudentResponseDAOImpl(Datastore datastore) {
        super(datastore);
        datastore.ensureIndexes(); //creates all defined with @Indexed
        datastore.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }

    @Override
    public MentorAndStudentResponse retrieveByMentorStudentId(String mentorOrStudentId) {
        return getDatastore().find(MentorAndStudentResponse.class).field("mentorOrStudentId").equal(DaoUtils.createObjectId(mentorOrStudentId)).get();
    }

    @Override
    public List<MentorAndStudentResponse> retrieveMentorsResponsebyOrgAndProgram(String orgId, String programName, String childId) {
         Query<MentorAndStudentResponse> query = getDatastore().createQuery(MentorAndStudentResponse.class);
         query.field("orgId").equal(DaoUtils.createObjectId(orgId)).
                and(query.criteria("programName").hasThisOne(programName).
                and(query.criteria("mentorOrStudentId").notEqual(DaoUtils.createObjectId(childId))));
        return query.asList();
    }

    @Override
    public List<MentorAndStudentResponse> retrieveResponse(String orgId, String resourceId, String programName) {
         Query<MentorAndStudentResponse> query = getDatastore().createQuery(MentorAndStudentResponse.class);
         query.field("orgId").equal(new ObjectId(orgId)).
                and(query.criteria("programName").endsWithIgnoreCase(programName).
                and(query.criteria("mentorOrStudentId").equal(new ObjectId(resourceId))));
        return query.asList();
    }

    @Override
    public List<MentorAndStudentResponse> retrieveByProgram(String orgId, String programName) {
         Query<MentorAndStudentResponse> query = getDatastore().createQuery(MentorAndStudentResponse.class);
         query.field("orgId").equal(new ObjectId(orgId)).
                and(query.criteria("programName").endsWithIgnoreCase(programName));
        return query.asList();
    }

    @Override
    public List<MentorAndStudentResponse> retrieveByOrg(String orgId) {
         Query<MentorAndStudentResponse> query = getDatastore().createQuery(MentorAndStudentResponse.class);
         query.field("orgId").equal(new ObjectId(orgId));
        return query.asList();
    }

    @Override
    public List<MentorAndStudentResponse> findAll() {
        return getDatastore().find(MentorAndStudentResponse.class).asList();
    }

    @Override
    public void saveMentor(MentorAndStudentResponse mentorAndStudentResponse) {
        getDatastore().save(mentorAndStudentResponse);
    }
}
