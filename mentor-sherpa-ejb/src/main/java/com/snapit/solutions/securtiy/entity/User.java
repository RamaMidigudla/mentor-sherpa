/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
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

//    private String state = UserStatus.ACTIVE.getState();

//    @ManyToMany(fetch = FetchType.EAGER)
  //  @JoinTable(name = "APP_USER_USER_PROFILE",
//            joinColumns = {
//                @JoinColumn(name = "USER_ID")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "USER_PROFILE_ID")})
    
//    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
    @Embedded("userRole")
    private List<UserRole> userRole;

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }

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

//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }

//    public Set<UserProfile> getUserProfiles() {
//        return userProfiles;
//    }
//
//    public void setUserProfiles(Set<UserProfile> userProfiles) {
//        this.userProfiles = userProfiles;
//    }

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
