/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.web.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public class AuthUser extends User {
    
    private String fullName;
    private String userId;
    private String gender;
    private boolean male;
    private boolean female;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getMale() {
        return getGender() != null ? getGender().equalsIgnoreCase("male"): false; // TODO - BAD
    }
    public boolean getFemale() {
        return getGender() != null ? getGender().equalsIgnoreCase("female"): false; // TODO - BAD
    }
    public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
