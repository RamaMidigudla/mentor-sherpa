/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
/**
 *
 * @author Ram
 */
@Entity("parent/child")
@XmlRootElement
public class Parent implements Serializable {

    private String userName;

    private String password;

    @Embedded("child")
    private List<Child> childList;

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

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

}
