/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Ram
 */
@Entity("mentor")
@XmlRootElement
public class Mentor implements Serializable {
    
    @Id
    private ObjectId id;
    
    private List<String> intrests;
    
    private String name;
    
    private Integer age;
    
    private String gender;
    
    @Embedded("mentorLogin")
    private User mentorLoginCredentials;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<String> getIntrests() {
        return intrests;
    }

    public void setIntrests(List<String> intrests) {
        this.intrests = intrests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getMentorLoginCredentials() {
        return mentorLoginCredentials;
    }

    public void setMentorLoginCredentials(User mentorLoginCredentials) {
        this.mentorLoginCredentials = mentorLoginCredentials;
    }
    
    
    
    
    
    
    
    
}
