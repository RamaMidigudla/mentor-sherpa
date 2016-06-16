/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import com.snapit.solutions.securtiy.entity.User;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Entity
@XmlRootElement
public class Organization implements Serializable {

    @Id
    private ObjectId id;
    private String name;
    private String address1;
    private String address2;
    private String state;
    private String city;
    private String zip;

    @Embedded
    private User superUser;

    @Embedded("subUser")
    private List<User> subUsers;

    @Embedded("program")
    private List<Program> programs;

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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public User getSuperUser() {
        return superUser;
    }

    public void setSuperUser(User superUser) {
        this.superUser = superUser;
    }

    public List<User> getSubUsers() {
        return subUsers;
    }

    public void setSubUsers(List<User> subUsers) {
        this.subUsers = subUsers;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.snapit.solutions.slantfree.mentor.sherpa.entity.Organization[ id=" + id + " ]";
    }

}
