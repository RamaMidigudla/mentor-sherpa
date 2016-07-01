/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.ChildDAO;
import com.snapit.solutions.mentor.sherpa.entity.Child;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ram
 */
@Service("childService")
public class ChildServiceImpl implements ChildService {
    
    @Autowired
    ChildDAO childDAO;
   
    
    @Override
    public List<Child> findall() {
        return childDAO.findAll();
    }
    
    
    
    
    
}
