/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Ram
 */
public interface MentorDAO extends DAO<Mentor, ObjectId> {

    public List<Mentor> findAll();

    public Mentor findById(String mentorId);

    /**
     * Retrieves mentor doc in mentor collection by username.
     *
     * @param userObjectId
     * @return Mentor doc
     */
    public Mentor findMentorByUserName(ObjectId userObjectId);

    /**
     * Updates existing mentor doc in mentor collection.
     *
     * @param mentor
     */
    public void updateMentorById(Mentor mentor);

    /**
     * persists new mentor object into mentor collection
     *
     * @param mentor
     */
    public void saveMentor(Mentor mentor);

    /**
     * deletes mentor doc in mentor collection.
     *
     * @param mentor
     */
    public void deleteMentorById(Mentor mentor);

    public Mentor findByMentorName(String mentorName);
    
    public List<Mentor> findMentorsByIds(Set<ObjectId> mentorIds);

}
