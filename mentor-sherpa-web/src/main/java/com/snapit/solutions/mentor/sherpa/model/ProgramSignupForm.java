/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.model;

import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.list.LazyList;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public class ProgramSignupForm {
    private String organizationId;
    private String selectedProgramName;
    private List<String> questions;
//    private Set<String> questionResponses;
    private Map<String, List<QuestionOptions>> userSelection = new HashMap<>();
    private Map<String, List<QuestionOptionsAndResponses>> questionResponseMap = new HashMap<>();
    private List<Set<String>> questionResponses;
    private List<QuestionOptions> questionsList;
//    private Map<String, List<QuestionResponse>> questionResponseMap;

    public ProgramSignupForm() {
      this.questionResponseMap = MapUtils.lazyMap(new HashMap<String,List<Object>>(), new Factory() {

          @Override
          public Object create() {
              return LazyList.decorate(new ArrayList<QuestionOptionsAndResponses>(), 
                             FactoryUtils.instantiateFactory(QuestionOptionsAndResponses.class));
          }
      });
    }
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

    public List<Set<String>> getQuestionResponses() {
        return questionResponses;
    }

    public void setQuestionResponses(List<Set<String>> questionResponses) {
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

    public Map<String, List<QuestionOptions>> getUserSelection() {
        return userSelection;
    }

    public void setUserSelection(Map<String, List<QuestionOptions>> userSelection) {
        this.userSelection = userSelection;
    }
    public Map<String, List<QuestionOptionsAndResponses>> getQuestionResponseMap() {
        return questionResponseMap;
    }

    public void setQuestionResponseMap(Map<String, List<QuestionOptionsAndResponses>> questionResponseMap) {
        this.questionResponseMap = questionResponseMap;
    }
}
