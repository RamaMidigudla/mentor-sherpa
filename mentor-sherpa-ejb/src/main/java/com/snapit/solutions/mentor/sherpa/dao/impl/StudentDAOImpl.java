/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao.impl;

import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.dao.utils.DaoUtils;

/**
 *
 * @author Ram
 */
@Repository("studentDAO")
public class StudentDAOImpl extends BasicDAO<Student, ObjectId> implements StudentDAO {

    @Autowired
    public StudentDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))

    }

    @Override
    public Student findById(String studentId) {
        return getDatastore().find(Student.class).field("_id").equal(DaoUtils.createObjectId(studentId)).get();
    }

    @Override
    public List<Student> findAll() {
        return getDatastore().find(Student.class).asList();
    }
}
