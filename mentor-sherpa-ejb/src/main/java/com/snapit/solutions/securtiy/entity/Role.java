/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.entity;

import java.util.List;
import org.mongodb.morphia.annotations.Embedded;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Embedded
public class Role implements GrantedAuthority {
private static final long serialVersionUID = 1L;
    private String name;
 
    private List<Privileges> privileges;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String getAuthority() {
        return this.name;
    }
 
    public List<Privileges> getPrivileges() {
        return privileges;
    }
 
    public void setPrivileges(List<Privileges> privileges) {
        this.privileges = privileges;
    }
 
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Role [name=");
        builder.append(name);
        builder.append(", privileges=");
        builder.append(privileges);
        builder.append("]");
        return builder.toString();
    }
}
