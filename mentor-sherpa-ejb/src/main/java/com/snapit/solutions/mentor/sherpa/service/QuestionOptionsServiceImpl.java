/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.QuestionOptionsDAO;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ram
 */
@Service("questionOptionsService")
public class QuestionOptionsServiceImpl implements QuestionOptionsService {

    @Autowired
    private QuestionOptionsDAO questionOptionsDAO;

    @Override
    public List<QuestionOptions> findQuestionOptionsForOrganization(List<ObjectId> questionIdList) {
        return questionOptionsDAO.retrievebyObjectIds(questionIdList);
    }

    @Override
    public List<QuestionOptions> findQuestionOptionsByQuestionFor(List<ObjectId> questionIdList, String questionFor) {
        Set<String> questionForSet = new HashSet<>();
        questionForSet.add(questionFor);
        questionForSet.add("common");
         
        List<QuestionOptions> questionOptions = questionOptionsDAO.retrievebyQuestionFor(questionIdList,questionForSet);
        List<QuestionOptions> commonQuestionOptions = questionOptionsDAO.retrieveCommonQuestions();
        questionOptions.addAll(commonQuestionOptions);
        return questionOptions;
        
    }
    
    

}
