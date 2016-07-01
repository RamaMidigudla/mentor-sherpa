/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Entity("user")
@XmlRootElement
public class User implements Serializable {

    @Id
    private ObjectId id;

    private String password;

    private String firstName;

    private String lastName;

    private String email;
    
    private List<String> userRole;
    
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<String> userRole) {
        this.userRole = userRole;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.email);
//        hash = 97 * hash + Objects.hashCode(this.userProfiles);
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
        final User other = (User) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
//        if (!Objects.equals(this.state, other.state)) {
//            return false;
//        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
//        if (!Objects.equals(this.userProfiles, other.userProfiles)) {
//            return false;
//        }
        return true;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", ssoId=" + email + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email +  "]";
    }

}