/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao;

import com.snapit.solutions.mentor.sherpa.entity.Mentor;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Ram
 */
public interface StudentDAO extends DAO<Student, ObjectId> {

    public List<Student> findAll();

    public Student findById(String studentId);
    
    public void assignNewMentorToStudent(String studentiD, String orgId, String mentorId, String programName);
    
    public List<Mentor> findMentorsByUserObjectIds(Set<String> studentUserObjectIds);

}
