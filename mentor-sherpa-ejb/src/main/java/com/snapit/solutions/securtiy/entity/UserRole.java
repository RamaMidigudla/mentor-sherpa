/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.entity;

import java.io.Serializable;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Embedded
public class UserRole implements Serializable {
//    PARENT("PARENT"),
//    CHILD("CHILD"),
//    MENTOR("MENTOR"),
//    ORG_ADMIN("ORG_ADMIN"),
//    ORG_USER("ORG_USER");
     
    private String role;

    public void setRole(String aRole) {
        this.role = aRole;
    }
     
//    private UserRole(String role){
//        this.role = role;
//    }
     
    public String getRole(){
        return role;
    }
}
