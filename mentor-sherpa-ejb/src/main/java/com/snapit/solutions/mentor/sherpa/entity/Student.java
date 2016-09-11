/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Ram
 */
@Entity("student")
public class Student implements Serializable {
    
    @Id
    private ObjectId id;
    
    @Embedded("userObjectId")
    private ObjectId userObjectId;
    
    private List<AssignedMentor> assignedMentors;
    
    private String name = "";
    
    private int age;
    
    private String gender = "";
    
    private String education = "";
    
    private String address = "";
    
    private List<SignedupOrganization>  interestedOrganizations = new ArrayList<>();
    
    private List<String>  interests = new ArrayList<>();
    
    private String imageName = "";

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getUserObjectId() {
        return userObjectId;
    }

    public void setUserObjectId(ObjectId userObjectId) {
        this.userObjectId = userObjectId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<SignedupOrganization> getInterestedOrganizations() {
        return interestedOrganizations;
    }

    public void setInterestedOrganizations(List<SignedupOrganization> interestedOrganizations) {
        this.interestedOrganizations = interestedOrganizations;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    public List<AssignedMentor> getAssignedMentors() {
        return assignedMentors;
    }

    public void setAssignedMentors(List<AssignedMentor> assignedMentors) {
        this.assignedMentors = assignedMentors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }  
}
