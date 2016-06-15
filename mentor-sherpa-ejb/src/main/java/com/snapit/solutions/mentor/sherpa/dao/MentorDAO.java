/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Ram
 */
public interface MentorDAO extends DAO<Mentor, ObjectId> {
    
    public List<Mentor> findAll();
    
     /**
     * Retrieves  mentor doc in mentor collection by username.
     * @param mentor 
     * @return Mentor doc 
     */
    public Mentor findMentorByUserName(Mentor mentor);
    
    /**
     * Updates existing mentor doc in mentor collection.
     * @param mentor 
     */
    public void updateMentorById(Mentor mentor);
    
    /**
     * persists new mentor object into mentor collection
     * @param mentor 
     */
    public void saveMentor(Mentor mentor);
    
    /**
     * deletes mentor doc in mentor collection.
     * @param mentor 
     */
    public void deleteMentorById(Mentor mentor);
      
}
