/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao;

import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Ram
 */
public interface QuestionOptionsDAO extends DAO<QuestionOptions, ObjectId> {

    public List<QuestionOptions> retrievebyObjectIds(List<ObjectId> questionIdList);

    public List<QuestionOptions> retrievebyQuestionFor(List<ObjectId> questionIdList, Set<String> questionFor);
    
    public List<QuestionOptions> retrieveCommonQuestions();
}
