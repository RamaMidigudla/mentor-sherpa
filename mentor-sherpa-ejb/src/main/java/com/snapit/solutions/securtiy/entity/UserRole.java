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
    ORG_ADMIN("ADMIN"),
    ORG_USER("USER");
     
    String userProfileType;
     
    private UserRole(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
}
