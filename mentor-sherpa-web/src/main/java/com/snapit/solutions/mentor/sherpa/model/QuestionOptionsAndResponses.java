/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.model;

import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.entity.QuestionResponse;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public class QuestionOptionsAndResponses {
    private QuestionOptions questionOption;
    private QuestionResponse questionResponse;

    public QuestionOptions getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(QuestionOptions questionOption) {
        this.questionOption = questionOption;
    }

    public QuestionResponse getQuestionResponse() {
        return questionResponse;
    }

    public void setQuestionResponse(QuestionResponse questionResponse) {
        this.questionResponse = questionResponse;
    }
    
}
