/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;

/**
 *
 * @author Ram
 */
public interface MentorAndStudentResponseService {
    public void saveResponses(MentorAndStudentResponse mentorAndStudentResponse);
    public boolean isResponseCaptured(String orgId, String resourceId, String programName);
    
}
