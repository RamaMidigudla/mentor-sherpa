/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao.impl;

import com.snapit.solutions.mentor.sherpa.dao.ParentDAO;
import com.snapit.solutions.mentor.sherpa.entity.Parent;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ram
 */
@Repository("parentDAO")
public class ParentDAOImpl extends BasicDAO<Parent, ObjectId> implements ParentDAO  {
    
    @Autowired
    public ParentDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
  
    }
    
    @Override
    public List<Parent> findAll() {
        return getDatastore().find( Parent.class ).asList();      
    }

    @Override
    public Parent findParentByUserName(Parent parent) {
         return getDatastore().find(
                    Parent.class, 
                    "parentLogin.userName", 
                    parent.getParentLoginCredentials().getUserName()).get();  
    }

    @Override
    public void updateParentById(Parent parent) {
        Datastore dataStore = getDatastore();
        
        Query<Parent> updateQuery = 
                getDatastore().createQuery(Parent.class).field("_id").equal(parent.getId());
     
           UpdateOperations<Parent> ops = dataStore.createUpdateOperations(Parent.class).
            set("parentLogin.userName", parent.getParentLoginCredentials().getUserName()).
            set("parentLogin.password", parent.getParentLoginCredentials().getPassword()).
            set("child", parent.getChildList());
            dataStore.update(updateQuery, ops);
    }

    @Override
    public void saveParent(Parent parent) {
         getDatastore().save(parent);
    }

    @Override
    public void deleteParentById(Parent parent) {
         Datastore dataStore = getDatastore(); 
        Query<Parent> deleteQuery = 
                dataStore.createQuery(Parent.class).field("_id").equal(parent.getId());
            dataStore.delete(deleteQuery);
    }
    
  
    
}
