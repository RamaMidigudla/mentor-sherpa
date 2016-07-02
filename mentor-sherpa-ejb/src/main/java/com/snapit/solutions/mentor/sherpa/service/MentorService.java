/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import java.util.List;

/**
 *
 * @author Ram
 */
public interface MentorService {
   
    public void createMentor(Mentor mentor);
    
    public List<Mentor> findall();
    
    public Mentor findByMentorName(String mentorName);
}
