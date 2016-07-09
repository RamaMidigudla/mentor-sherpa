/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Ram
 */
@Embedded
public class InterestedOrganizations implements Serializable {
    
    private ObjectId orgId;
    
    private List<String> programs;

    public ObjectId getOrgId() {
        return orgId;
    }

    public void setOrgId(ObjectId orgId) {
        this.orgId = orgId;
    }

    public List<String> getPrograms() {
        return programs;
    }

    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }    
    
}
