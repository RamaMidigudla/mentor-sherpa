/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.model;

/**
 *
 * @author Ram
 */
public class AssignMentorForm {
    //TODO use this for assigning and matching mentors.
    private String organizationId;
    private String selectedProgramName;
    private String mentorId;
    private String studentId;
    
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

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }  
}
