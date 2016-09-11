/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.security.dao.test;

import com.snapit.solutions.security.dao.UserDAO;
import com.snapit.solutions.securtiy.entity.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-applicationContext.xml", "classpath:MongoDBTestConnection.xml"})
public class UserDaoTest {

    @Autowired
    private UserDAO userDAO;
    private static final String ORG_TEST_USERNAME = "org@hello.com";

    public UserDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void userDaoInitTest() {

        Assert.assertNotNull(userDAO);

    }

    @Test
    public void find() {

        Assert.assertNotNull(userDAO);
        User user = null;
//        try {
//         user = userDAO.findUserByUserName(ORG_TEST_USERNAME);
//        } catch (Exception e) {
//            e.printStackTrace();
//        System.out.println("###############################Exceprtion : " + e.getMessage());
//        }
//        Assert.assertNotNull(user);
//        System.out.println("###############################User : " + user);
//        Assert.assertEquals(ORG_TEST_USERNAME, user.getEmail());
//          user = userDAO.findUserByUserName(ORG_TEST_USERNAME);
//          Assert.assertNotNull(user);


    }
}
