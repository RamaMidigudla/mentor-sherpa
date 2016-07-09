/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.dao.test;

import com.snapit.solutions.mentor.sherpa.dao.MentorDAO;
import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.dao.ParentDAO;
import com.snapit.solutions.mentor.sherpa.dao.QuestionOptionsDAO;
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
import com.snapit.solutions.mentor.sherpa.dao.StudentDAO;
import com.snapit.solutions.mentor.sherpa.entity.QuestionOptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;


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
    private ParentDAO parentDAO;
    
    @Autowired
    private MentorDAO mentorDAO;
    
    @Autowired
    private StudentDAO childDAO;
    
    @Autowired
    private QuestionOptionsDAO questionOptionsDAO;
    
    
    
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
     
   Assert.assertNotNull(organizationDAO);
   Assert.assertNotNull(parentDAO);
   Assert.assertNotNull(mentorDAO);
   Assert.assertNotNull(childDAO);
   
   List<ObjectId> olist = new ArrayList<>();
   
   
   olist.add(new ObjectId("577da4703008228a61fdc33a"));
   olist.add(new ObjectId("577da6033008228a61fdc33b"));
   olist.add(new ObjectId("577dbf663008228a61fdc340"));
   olist.add(new ObjectId("577dbdd13008228a61fdc33f"));
   olist.add(new ObjectId("577dad5e3008228a61fdc33c"));
   olist.add(new ObjectId("577dad5e3008228a61fdc33c"));
                   
           
Set<String> questionForSet = new HashSet<>();
        questionForSet.add("student");
        questionForSet.add("common");
   
   
   List<QuestionOptions> mentorList = questionOptionsDAO.retrievebyQuestionFor(olist, questionForSet);
  Assert.assertNotNull(mentorList);
    
//   List<Mentor> mentorList = mentorDAO.findAll();
//   Assert.assertNotNull(mentorList);
//   {
//    "_id" : ObjectId("574a265d0243e21a831d66e5"),
//    "userObjectId" : ObjectId("576850c33008228a61fdc339"),
//    "name" : "Rama",
//    "age" : "22",
//    "gender" : "F",
//    "education" : "cs",
//    "interestedOrganizations" : [ 
//        {
//            "orgId" : ObjectId("574b5a9c38bc199501921768"),
//            "programs" : [ 
//                "Learn to Code"
//            ]
//        }, 
//        {
//            "orgId" : ObjectId("574b5a9c38bc199501921769"),
//            "programs" : [ 
//                "Learn to bake"
//            ]
//        }
//    ],
//    "interests" : [ 
//        "coding", 
//        "soccer"
//    ]
//}
   
//  List<Child> childList = childDAO.findAll();
//  Assert.assertNotNull(childList); 
//  {
//    "_id" : ObjectId("574a265d0243e21a831d66e5"),
//    "userObjectId" : ObjectId("576850c33008228a61fdc339"),
//    "name" : "Jahnavi",
//    "age" : "10",
//    "gender" : "Female",
//    "interests" : [ 
//        "coding", 
//        "soccer"
//    ]
//}
  
    }
   
    
 }
