/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.dao;

import com.snapit.solutions.mentor.sherpa.entity.Parent;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Ram
 */
public interface ParentDAO extends DAO<Parent, ObjectId> {
    
    public List<Parent> findAll();
    
     /**
     * Retrieves  parent doc in parent/child collection by username.
     * @param parent 
     * @return Parent doc 
     */
    public Parent findParentByUserName(Parent parent);
    
    /**
     * Updates existing parent doc in parent/child collection.
     * @param parent 
     */
    public void updateParentById(Parent parent);
    
    /**
     * persists new parent object into parent/child collection
     * @param parent 
     */
    public void saveParent(Parent parent);
    
    /**
     * deletes parent doc in parent/child collection.
     * @param parent 
     */
    public void deleteParentById(Parent parent);
    
    
    
}
