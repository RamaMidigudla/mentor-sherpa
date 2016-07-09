/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.facade;

import com.snapit.solutions.mentor.sherpa.model.RegisterForm;
import com.snapit.solutions.securtiy.entity.User;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface MentorSherpaUserService {
    public User findUser(String emailId);
    public void registerUser(RegisterForm registerForm, String role);
}
