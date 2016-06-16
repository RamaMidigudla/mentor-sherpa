/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.entity;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public enum UserStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");
     
    String state;
     
    private UserStatus(final String state){
        this.state = state;
    }
     
    public String getState(){
        return this.state;
    }
 
    @Override
    public String toString(){
        return this.state;
    }
 
 
    public String getName(){
        return this.name();
    }
 
}
