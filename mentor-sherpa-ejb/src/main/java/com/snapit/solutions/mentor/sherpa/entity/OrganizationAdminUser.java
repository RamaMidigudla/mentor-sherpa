/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.entity;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
import java.io.Serializable;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Ram
 */
@Embedded
public class OrganizationAdminUser implements Serializable {
    
     private String userName;
     
     private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    
}