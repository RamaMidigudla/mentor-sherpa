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
    
    private com.snapit.solutions.securtiy.entity.User authorizedUser;

    private String fullName;
    private String userId;
    private String gender;
    private boolean male;
    private boolean female;
    private boolean couple;

    public String getUserId() {
        return authorizedUser.getId().toString();
    }

    public String getFullName() {
        return authorizedUser.getFirstName() + " " + authorizedUser.getLastName();
    }
    
    public String getGender() {
        return authorizedUser.getGender();
    }

    public String getImageName() {
        return authorizedUser.getImageName();
    }

    public boolean getMale() {
        return getGender() != null ? getGender().equalsIgnoreCase("male"): false; // TODO - BAD
    }
    public boolean getFemale() {
        return getGender() != null ? getGender().equalsIgnoreCase("female"): false; // TODO - BAD
    }
    public boolean getCouple() {
        return getGender() != null ? getGender().equalsIgnoreCase("couple"): false; // TODO - BAD
    }
    public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    public com.snapit.solutions.securtiy.entity.User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(com.snapit.solutions.securtiy.entity.User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }
}
