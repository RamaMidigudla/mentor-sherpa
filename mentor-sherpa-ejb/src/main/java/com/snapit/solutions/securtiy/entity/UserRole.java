/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.entity;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public enum UserRole {
    PARENT("PARENT"),
    CHILD("CHILD"),
    MENTOR("MENTOR"),
    ORG_ADMIN("ORG_ADMIN"),
    ORG_USER("ORG_USER");
     
    String userProfileType;
     
    private UserRole(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
}
