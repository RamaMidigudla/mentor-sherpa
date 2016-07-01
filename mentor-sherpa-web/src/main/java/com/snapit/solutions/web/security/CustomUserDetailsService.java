/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.web.security;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
import com.snapit.solutions.securtiy.entity.User;
import com.snapit.solutions.securtiy.service.UserService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

//    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String userId)
            throws UsernameNotFoundException {
        User myUser = userService.findByUserId(userId);
//        CustomUser myUser = new CustomUser();
//        myUser.setEmail("admin@hello.com");
//        myUser.setPassword("password");    
        System.out.println("User : " + myUser);
        //get the encoded password
        if (myUser == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        
//        UserDetails details = new CustomUser(myUser.getEmail(), myUser.getPassword(), getGrantedAuthorities(myUser));
//        return new org.springframework.security.core.userdetails.CustomUser(myUser.getEmail(), myUser.getPassword(),
//                myUser.getState().equals(UserStatus.ACTIVE), true, true, true, getGrantedAuthorities(myUser));
         return new org.springframework.security.core.userdetails.User(myUser.getEmail(), myUser.getPassword(), getGrantedAuthorities(myUser));   
//         return new org.springframework.security.core.userdetails.CustomUser(myUser.getEmail(), myUser.getPassword(), getGrantedAuthorities(myUser));   
//        UserDetails details = myUser;
//        return details;
   }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


        for (String userProfile : user.getUserRole()) {
            System.out.println("UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile));
        }
        System.out.println("authorities :" + authorities);
        return authorities;
    }
//    private List<GrantedAuthority> getGrantedAuthorities(CustomUser user) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//
//        for (String userProfile : user.getUserRole()) {
//            System.out.println("UserProfile : " + userProfile);
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile));
//        }
//        System.out.println("authorities :" + authorities);
//        return authorities;
//    }

}
