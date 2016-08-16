/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Ram
 */
@Embedded
public class AssignedMentor implements Serializable {
    
    private ObjectId orgId;
    
    private String programName;
    
    private ObjectId mentorId;

    public ObjectId getOrgId() {
        return orgId;
    }

    public void setOrgId(ObjectId orgId) {
        this.orgId = orgId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public ObjectId getMentorId() {
        return mentorId;
    }

    public void setMentorId(ObjectId mentorId) {
        this.mentorId = mentorId;
    }
    
}
