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
    public MentorAndStudentResponse retrieveByMentorStudentId(ObjectId mentorOrStudentId) {
        return getDatastore().find(MentorAndStudentResponse.class).field("mentorOrStudentId").equal(mentorOrStudentId).get();
    }

    @Override
    public List<MentorAndStudentResponse> retrieveMentorsResponsebyOrgAndProgram(ObjectId orgId, String programName, ObjectId childId) {
         Query<MentorAndStudentResponse> query = getDatastore().createQuery(MentorAndStudentResponse.class);
         query.field("orgId").equal(orgId).
                and(query.criteria("programName").hasThisOne(programName).
                and(query.criteria("mentorOrStudentId").notEqual(childId)));
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
