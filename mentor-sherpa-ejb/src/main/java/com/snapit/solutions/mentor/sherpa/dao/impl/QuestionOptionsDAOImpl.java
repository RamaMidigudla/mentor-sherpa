/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao.impl;

import com.snapit.solutions.mentor.sherpa.dao.QuestionOptionsDAO;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ram
 */
@Repository("questionOptionsDAO")
public class QuestionOptionsDAOImpl extends BasicDAO<QuestionOptions, ObjectId> implements QuestionOptionsDAO {
    
    @Autowired
    public QuestionOptionsDAOImpl(Datastore datastore) {
        super(datastore);
        datastore.ensureIndexes(); //creates all defined with @Indexed
        datastore.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }

    @Override
    public List<QuestionOptions> retrievebyObjectIds(List<ObjectId> questionIdList) {
        Query<QuestionOptions> query = getDatastore().createQuery(QuestionOptions.class);
        query.field("id").hasAnyOf(questionIdList);
        return query.asList();
    }
    
    @Override
    public List<QuestionOptions> retrievebyQuestionFor(List<ObjectId> questionIdList, Set<String> questionFor) {        
        Query<QuestionOptions> query = getDatastore().createQuery(QuestionOptions.class);
        query.field("id").hasAnyOf(questionIdList).
                and(query.criteria("questionFor").hasAnyOf(questionFor));
        return query.asList();
    }
    
}
