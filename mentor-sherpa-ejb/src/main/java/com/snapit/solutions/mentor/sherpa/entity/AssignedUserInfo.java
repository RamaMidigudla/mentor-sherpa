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
public class AssignedUserInfo implements Serializable {
    
    private ObjectId orgId;
    
    private String programName;
    
    private ObjectId userObjectId;

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

    public ObjectId getUserObjectId() {
        return userObjectId;
    }

    public void setUserObjectId(ObjectId userObjectId) {
        this.userObjectId = userObjectId;
    }
    
}
