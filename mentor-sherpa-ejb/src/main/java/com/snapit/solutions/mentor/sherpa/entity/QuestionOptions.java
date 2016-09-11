/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Ram
 */
@Entity("questionAndOptions")
@XmlRootElement
public class QuestionOptions implements Serializable {
    
    @Id
    private ObjectId id;
    
    private String questionType;
    
    private String questionFor;

    private String question;
    
    private List<String> options;
    
    @Embedded("orgId")
    private ObjectId orgId;

    private String questionCategory;
    
    private boolean exculdeInMatch;
    
    private int categoryOrder;
    
    private String programName;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionFor() {
        return questionFor;
    }

    public void setQuestionFor(String questionFor) {
        this.questionFor = questionFor;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
    public ObjectId getOrgId() {
        return orgId;
    }

    public void setOrgId(ObjectId orgId) {
        this.orgId = orgId;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String QuestionCategory) {
        this.questionCategory = QuestionCategory;
    }

    public int getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(int categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public boolean isExculdeInMatch() {
        return exculdeInMatch;
    }

    public void setExculdeInMatch(boolean exculdeInMatch) {
        this.exculdeInMatch = exculdeInMatch;
    } 
}
