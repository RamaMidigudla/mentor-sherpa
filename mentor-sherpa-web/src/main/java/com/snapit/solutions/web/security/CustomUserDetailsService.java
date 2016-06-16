/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.web.security;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
import com.snapit.solutions.securtiy.entity.User;
import com.snapit.solutions.securtiy.entity.UserProfile;
import com.snapit.solutions.securtiy.service.UserService;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
  
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserService userService;
     
    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String userId)
            throws UsernameNotFoundException {
        User user = userService.findByUserId(userId);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), 
                 user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(UserProfile userProfile : user.getUserProfiles()){
            System.out.println("UserProfile : "+userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
     
}