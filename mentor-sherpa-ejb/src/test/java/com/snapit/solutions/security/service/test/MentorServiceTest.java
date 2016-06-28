/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.security.service.test;

import com.snapit.solutions.mentor.sherpa.service.MentorService;
import com.snapit.solutions.securtiy.service.UserService;
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
 * @author Ram
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-applicationContext.xml", "classpath:MongoDBTestConnection.xml" } )
public class MentorServiceTest {
    
    @Autowired
    private MentorService mentorService;
    
    public MentorServiceTest() {
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
    public void serviceInitTest() {      
     
   Assert.assertNotNull(mentorService);
   
    }
    
    @Test
    public void find() {  
        
        
     
   //Assert.assertNotNull(mentorService.findMentorById(userId));
   
    }
}
