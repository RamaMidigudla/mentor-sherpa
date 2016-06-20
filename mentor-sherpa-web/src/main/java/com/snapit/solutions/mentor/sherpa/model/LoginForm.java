/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.model;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public class LoginForm {
    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String password;
}
