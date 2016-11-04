/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    
    @Embedded("userObjectId")
    private ObjectId userObjectId;
    
    private String name = "";
    
    private String title = "";

    private int age;
    
    private String gender = "";
    
    private String education = "";
    
    private String address = "";
    
    private List<SignedupOrganization>  signedupOrganizations = new ArrayList<>();
    
    private List<String>  interests = new ArrayList<>();
    
    private String imageName = "";
    
    @Embedded("assignedUsersInfo")
    private List<AssignedUserInfo> assignedUsersInfo;
    
    @Embedded("questionAndResponses")
    private QuestionResponse mentorQuestionAndResponses;
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public List<SignedupOrganization> getSignedupOrganizations() {
        return signedupOrganizations;
    }

    public void setSignedupOrganizations(List<SignedupOrganization> signedupOrganizations) {
        this.signedupOrganizations = signedupOrganizations;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public QuestionResponse getMentorQuestionAndResponses() {
        return mentorQuestionAndResponses;
    }

    public void setMentorQuestionAndResponses(QuestionResponse mentorQuestionAndResponses) {
        this.mentorQuestionAndResponses = mentorQuestionAndResponses;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<AssignedUserInfo> getAssignedUsersInfo() {
        return assignedUsersInfo;
    }

    public void setAssignedUsersInfo(List<AssignedUserInfo> assignedUsersInfo) {
        this.assignedUsersInfo = assignedUsersInfo;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.userObjectId);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + this.age;
        hash = 59 * hash + Objects.hashCode(this.gender);
        hash = 59 * hash + Objects.hashCode(this.education);
        hash = 59 * hash + Objects.hashCode(this.address);
        hash = 59 * hash + Objects.hashCode(this.signedupOrganizations);
        hash = 59 * hash + Objects.hashCode(this.interests);
        hash = 59 * hash + Objects.hashCode(this.imageName);
        hash = 59 * hash + Objects.hashCode(this.mentorQuestionAndResponses);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mentor other = (Mentor) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.education, other.education)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.imageName, other.imageName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.userObjectId, other.userObjectId)) {
            return false;
        }
        if (!Objects.equals(this.signedupOrganizations, other.signedupOrganizations)) {
            return false;
        }
        if (!Objects.equals(this.interests, other.interests)) {
            return false;
        }
        if (!Objects.equals(this.mentorQuestionAndResponses, other.mentorQuestionAndResponses)) {
            return false;
        }
        return true;
    }
    
    
}
