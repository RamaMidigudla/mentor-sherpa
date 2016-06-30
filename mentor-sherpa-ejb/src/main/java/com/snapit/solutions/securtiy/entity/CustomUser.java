/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Entity("user")
@XmlRootElement
public class CustomUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId id; 
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private List<String> userRole;

    /* Spring Security fields*/
//    private List<Role> role;
//    private boolean accountNonExpired = true;
//    private boolean accountNonLocked = true;
//    private boolean credentialsNonExpired = true;
//    private boolean enabled = true;
 
//    public CustomUser () {
//        super(null, null, null);
//        this.id = null;
//        this.email = "";
//        this.firstName = "";
//        this.lastName = "";
//        this.userRole = null;
//    }
//    
//    public CustomUser(String userName, String password, List<GrantedAuthority> authorities) {
//        super(userName, password, authorities);
//    }
    
//    @Override
//    public String getUsername() {
//        return username;
//    }
// 
//    public void setUsername(String username) {
//        this.username = username;
//    }
//     
//    @Override
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
    
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
////
////        if (this.role != null && !this.role.isEmpty()) {
////        for (Role customRole : this.role) {
////            System.out.println("UserProfile : " + customRole.getAuthority());
////            authorities.add(new SimpleGrantedAuthority("ROLE_" + customRole.getAuthority()));
////        }
////        }
////        System.out.println("authorities :" + authorities);
////        return authorities;
//        return this.role;
//    }
//     
//    public void setAuthorities(List<Role> authorities) {
//        this.role = authorities;
//    }
// 
//    @Override
//    public boolean isAccountNonExpired() {
//        return this.accountNonExpired;
//    }
//     
//    public void setAccountNonExpired(boolean accountNonExpired) {
//        this.accountNonExpired = accountNonExpired;
//    }
// 
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.accountNonLocked;
//    }
//     
//    public void setAccountNonLocked(boolean accountNonLocked) {
//        this.accountNonLocked = accountNonLocked;
//    }
// 
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.credentialsNonExpired;
//    }
//     
//    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//        this.credentialsNonExpired = credentialsNonExpired;
//    }
// 
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
// 
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
// 
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("CustomUser [username=");
//        builder.append(username);
//        builder.append(", email=");
//        builder.append(email);
//        builder.append(", password=");
//        builder.append(password);
//        builder.append(", firstName=");
//        builder.append(firstName);
//        builder.append(", lastName=");
//        builder.append(lastName);
//        builder.append(", authorities=");
//        builder.append(role);
//        builder.append(", accountNonExpired=");
//        builder.append(accountNonExpired);
//        builder.append(", accountNonLocked=");
//        builder.append(accountNonLocked);
//        builder.append(", credentialsNonExpired=");
//        builder.append(credentialsNonExpired);
//        builder.append(", enabled=");
//        builder.append(enabled);
//        builder.append("]");
//        return builder.toString();
//    }
}
