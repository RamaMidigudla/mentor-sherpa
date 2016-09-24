/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.service;

import com.snapit.solutions.mentor.sherpa.entity.PasswordResetToken;
import com.snapit.solutions.mentor.sherpa.service.OrganizationServiceImpl;
import com.snapit.solutions.security.dao.PasswordResetDAO;
import com.snapit.solutions.security.dao.UserDAO;
import com.snapit.solutions.securtiy.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
//@Stateless(name="UserService")//, mappedName = "com/snapit/solutions/security/service/userservice/ejb/UserService")
//@Interceptors(SpringBeanAutowiringInterceptor.class)
//@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LogManager.getLogger(OrganizationServiceImpl.class);
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordResetDAO passwordResetDAO;

    @Override
    public User findByUserId(String userId) {
        return userDAO.findUserByUserName(userId);
    }
    
    @Override
    public void registerUser(User user) {
        userDAO.save(user);
    }
    
    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetDAO.save(myToken);
    }  
    
    @Override
    public PasswordResetToken getPasswordResetToken(final String id, final String token) {
        return passwordResetDAO.findByIdToken(id, token);
    }
    
    @Override
    public void changePassword(User user, String password) {
        if (user != null) {
            user.setPassword(password);
            userDAO.save(user);
        }
    }

    @Override
    public User findById(String id) {
       return userDAO.findById(id);
    }   

}
