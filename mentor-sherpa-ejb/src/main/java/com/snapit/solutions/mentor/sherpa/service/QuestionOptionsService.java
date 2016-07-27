/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Ram
 */
public interface QuestionOptionsService {

    public List<QuestionOptions> findQuestionOptionsForOrganization(Set<String> questionIdList);
    
    public List<QuestionOptions> findQuestionOptionsByQuestionFor(Set<String> questionIdList,String questionFor);

}
