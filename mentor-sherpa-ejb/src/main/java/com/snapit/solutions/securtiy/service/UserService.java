/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.service;

import com.snapit.solutions.securtiy.entity.CustomUser;
import javax.ejb.Remote;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Remote
public interface UserService {
    public CustomUser findByUserId(String userId);
    public void registerUser(CustomUser user);
}
