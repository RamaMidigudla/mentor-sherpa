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
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Ram
 */
@Entity("mentorStudentResponse")
@XmlRootElement
public class MentorAndStudentResponse implements Serializable {

    @Id
    private ObjectId id;

    private ObjectId orgId;

    private ObjectId mentorOrStudentId;

    private String programName;

    List<QuestionResponse> questionAndResponses;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getOrgId() {
        return orgId;
    }

    public void setOrgId(ObjectId orgId) {
        this.orgId = orgId;
    }

    public ObjectId getMentorOrStudentId() {
        return mentorOrStudentId;
    }

    public void setMentorOrStudentId(ObjectId mentorOrStudentId) {
        this.mentorOrStudentId = mentorOrStudentId;
    }

    public List<QuestionResponse> getQuestionAndResponses() {
        return questionAndResponses;
    }

    public void setQuestionAndResponses(List<QuestionResponse> questionAndResponses) {
        this.questionAndResponses = questionAndResponses;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

}
