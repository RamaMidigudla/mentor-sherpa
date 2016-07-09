/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.MentorDAO;
import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ram
 */
@Service("mentorService")
public class MentorServiceImpl implements MentorService {
    
    @Autowired
    MentorDAO mentorDAO;
    
    @Override
    public void createMentor(Mentor mentor) {
        mentorDAO.save(mentor);
    }

    @Override
    public List<Mentor> findall() {
        return mentorDAO.findAll();
    }
    
    @Override
    public Mentor findByMentorName(String mentorName) {
        return mentorDAO.findByMentorName(mentorName);
    }

    @Override
    public Mentor findById(String id) {
        return mentorDAO.findById(id);
    }
}
