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
@Entity("organizations")
@XmlRootElement
public class Organization implements Serializable {

    @Id
    private ObjectId id;
    
    private String organizationName;
   
    @Embedded("superUser")
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    
    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
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
