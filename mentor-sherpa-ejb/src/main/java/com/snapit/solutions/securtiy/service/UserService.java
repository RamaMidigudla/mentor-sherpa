/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.securtiy.service;

import com.snapit.solutions.securtiy.entity.User;
import javax.ejb.Remote;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Remote
public interface UserService {
    public User findByUserId(String userId);
}
