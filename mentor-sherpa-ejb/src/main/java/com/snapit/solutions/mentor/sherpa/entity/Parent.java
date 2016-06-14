/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author Ram
 */
@Entity("parent/child")
@XmlRootElement
public class Parent implements Serializable  {
    
    @Embedded("parentLogin")
    private User parentLoginCredentials;
    
    @Embedded("child")
    private List<Child> childList;

    public User getParentLoginCredentials() {
        return parentLoginCredentials;
    }

    public void setParentLoginCredentials(User parentLoginCredentials) {
        this.parentLoginCredentials = parentLoginCredentials;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }   
    
}
