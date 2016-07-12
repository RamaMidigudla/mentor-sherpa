/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.MentorAndStudentResponseDAO;
import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ram
 */
@Service("mentorAndStudentResponseService")
public class MentorAndStudentResponseServiceImpl implements MentorAndStudentResponseService {

    @Autowired 
    public MentorAndStudentResponseDAO responseDao;
    @Override
    public void saveResponses(MentorAndStudentResponse mentorAndStudentResponse) {
        responseDao.saveMentor(mentorAndStudentResponse);
    }    
}
