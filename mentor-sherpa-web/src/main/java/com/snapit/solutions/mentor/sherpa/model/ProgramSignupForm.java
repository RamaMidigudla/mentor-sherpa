/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.model;

import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public class ProgramSignupForm {
    private String organizationId;
    private String selectedProgramName;
    private List<String> questions;
    private Set<String> questionResponses;
    private List<QuestionOptions> questionsList;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getSelectedProgramName() {
        return selectedProgramName;
    }

    public void setSelectedProgramName(String selectedProgramName) {
        this.selectedProgramName = selectedProgramName;
    }

    public Set<String> getQuestionResponses() {
        return questionResponses;
    }

    public void setQuestionResponses(Set<String> questionResponses) {
        this.questionResponses = questionResponses;
    }
    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }
    public List<QuestionOptions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<QuestionOptions> questionsList) {
        this.questionsList = questionsList;
    }

    
}
