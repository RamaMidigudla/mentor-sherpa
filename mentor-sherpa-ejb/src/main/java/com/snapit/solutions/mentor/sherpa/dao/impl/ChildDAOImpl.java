/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao.impl;

import com.snapit.solutions.mentor.sherpa.dao.ChildDAO;
import com.snapit.solutions.mentor.sherpa.entity.Child;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ram
 */
@Repository("childDAO")
public class ChildDAOImpl extends BasicDAO<Child, ObjectId> implements ChildDAO {
    
     @Autowired
    public ChildDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
  
    }

    @Override
    public List<Child> findAll() {
        return getDatastore().find( Child.class ).asList();
    }
    
}
