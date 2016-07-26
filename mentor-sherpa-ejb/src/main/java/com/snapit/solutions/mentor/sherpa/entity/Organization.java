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
    
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
   
    @Embedded("superUser")
    private User superUser;
    
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

    @Override
    public String toString() {
        return "com.snapit.solutions.slantfree.mentor.sherpa.entity.Organization[ id=" + id + " ]";
    }
}
