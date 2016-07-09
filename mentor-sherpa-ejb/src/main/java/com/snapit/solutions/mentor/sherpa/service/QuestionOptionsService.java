/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ram
 */
public interface QuestionOptionsService {

    public List<QuestionOptions> findQuestionOptionsForOrganization(List<ObjectId> questionIdList);
    
    public List<QuestionOptions> findQuestionOptionsByQuestionFor(List<ObjectId> questionIdList,String questionFor);

}
