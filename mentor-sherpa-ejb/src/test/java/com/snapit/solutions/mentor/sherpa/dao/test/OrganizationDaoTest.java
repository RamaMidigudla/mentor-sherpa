/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.dao.test;

import com.snapit.solutions.mentor.sherpa.dao.MentorAndStudentResponseDAO;
import com.snapit.solutions.mentor.sherpa.dao.MentorDAO;
import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.dao.QuestionOptionsDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.entity.Student;
import java.util.HashSet;
import java.util.Set;
import org.bson.types.ObjectId;
import org.junit.Assert;


/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-applicationContext.xml", "classpath:MongoDBTestConnection.xml" } )
public class OrganizationDaoTest {
 
    @Autowired
    private OrganizationDAO organizationDAO;
        
    @Autowired
    private MentorDAO mentorDAO;
    
    @Autowired
    private StudentDAO childDAO;
    
    @Autowired
    private QuestionOptionsDAO questionOptionsDAO;
    
    @Autowired
    private MentorAndStudentResponseDAO mentorAndStudentResponseDAO;
    
    
    
    public OrganizationDaoTest() {
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
    public void hello() {      
       Set<ObjectId> mentorIds = new HashSet<>();
//        mentorIds.add(new ObjectId("574a265d0243e21a831d66e5"));
//        mentorIds.add(new ObjectId("5781d0253008228a61fdc345"));
        
//        Set<String> mentorIds = new HashSet<>();
//        mentorIds.add("574a265d0243e21a831d66e5");
//        mentorIds.add("5781d0253008228a61fdc345");
     
//        Mentor mentors = mentorDAO.findById(new ObjectId("574a265d0243e21a831d66e5").toHexString());
//        Assert.assertNotNull(mentors);

 Student student = childDAO.findStudentByUserObjectId("57b783d4253a0c9c03f9cc0e");
 Assert.assertNull(student);
 


        
        

    }
   
    
 }
