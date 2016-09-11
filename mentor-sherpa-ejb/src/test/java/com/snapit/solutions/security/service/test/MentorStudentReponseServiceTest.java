/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.security.service.test;

import com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import com.snapit.solutions.mentor.sherpa.service.MentorAndStudentResponseService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-applicationContext.xml", "classpath:MongoDBTestConnection.xml" } )
public class MentorStudentReponseServiceTest {
    
    @Autowired
    private MentorAndStudentResponseService mentorAndStudentResponseService;
    
    public MentorStudentReponseServiceTest() {
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
    public void find() {      
//      "_id" : ObjectId("57c268e369e71e0ecc5bdc30"),
//    "className" : "com.snapit.solutions.mentor.sherpa.entity.MentorAndStudentResponse",
//    "orgId" : ObjectId("57b783d4253a0c9c03f9cc0e"),
//    "mentorOrStudentId" : ObjectId("577f110769e71e78d842bf26"),
//    "programName" : "Mentor Makers",
        boolean responseAvailable = mentorAndStudentResponseService.isResponseCaptured("57b783d4253a0c9c03f9cc0e", "577f110769e71e78d842bf26", "Mentor Makers");
        assertTrue(responseAvailable);    
    }
}
