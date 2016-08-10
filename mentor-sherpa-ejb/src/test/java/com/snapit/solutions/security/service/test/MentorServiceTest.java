/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.security.service.test;

import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.service.MentorService;
import com.snapit.solutions.mentor.sherpa.service.QuestionOptionsService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    
    @Autowired
    private QuestionOptionsService questionOptionsService;
    
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
     Set<String> questionIdList = new HashSet();  
     questionIdList.add("577da4703008228a61fdc33a");                            
     List<QuestionOptions> bb = questionOptionsService.findQuestionOptionsByQuestionFor(questionIdList,"mentor" );
     Assert.assertNotNull(mentorService);
     Assert.assertNotNull(bb);
   
    }
}
