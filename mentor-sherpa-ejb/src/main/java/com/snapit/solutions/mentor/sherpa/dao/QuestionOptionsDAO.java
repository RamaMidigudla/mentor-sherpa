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

    public List<QuestionOptions> retrievebyObjectIds(Set<String> questionIdList);

    public List<QuestionOptions> retrievebyQuestionFor(Set<String> questionIdList, Set<String> questionFor);
    
    public List<QuestionOptions> retrieveCommonQuestions();
    
    public List<QuestionOptions> retrieveMentorQuestions(String id, String programName);
    
    public List<QuestionOptions> retrieveStudentQuestions(String id, String programName);
    
    //TODO use this to retrevie questions for each category to display
    public List<QuestionOptions> retrieveRequiredQuestions(String orgId, String programName,String questionFor,String questionCategory);
    
    public List<QuestionOptions> retrieveQuestionsBasedOnExclusion(boolean isExcluded, String questionFor);
    
}
