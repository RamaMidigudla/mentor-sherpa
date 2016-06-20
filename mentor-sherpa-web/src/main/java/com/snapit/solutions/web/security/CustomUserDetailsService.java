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
import com.snapit.solutions.securtiy.entity.UserStatus;
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

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String userId)
            throws UsernameNotFoundException {
        User myUser = userService.findByUserId(userId);
        System.out.println("User : " + myUser);
        if (myUser == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(myUser.getEmail(), myUser.getPassword(),
                myUser.getState().equals(UserStatus.ACTIVE), true, true, true, getGrantedAuthorities(myUser));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile : user.getUserProfiles()) {
            System.out.println("UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }

}
