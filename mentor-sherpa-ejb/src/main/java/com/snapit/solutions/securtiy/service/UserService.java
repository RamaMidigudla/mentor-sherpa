/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.service;

import com.snapit.solutions.mentor.sherpa.entity.PasswordResetToken;
import com.snapit.solutions.securtiy.entity.User;
import javax.ejb.Remote;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Remote
public interface UserService {
    public User findByUserId(String userId);
    public User findById(String id);
    public void registerUser(User user);
    public void createPasswordResetTokenForUser(final User user, final String token);
    public PasswordResetToken getPasswordResetToken(final String id, final String token);
    public void changePassword(User user, String password);
}
