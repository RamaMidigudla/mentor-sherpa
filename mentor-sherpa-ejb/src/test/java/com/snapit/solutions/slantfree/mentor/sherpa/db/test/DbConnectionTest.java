/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.slantfree.mentor.sherpa.db.test;

import com.mongodb.client.MongoDatabase;
import com.snapit.solutions.slantfree.mentor.sherpa.db.DatabaseConnector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sudheerparasker
 */
public class DbConnectionTest {
    
    public DbConnectionTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void testConnection() {
        MongoDatabase db = DatabaseConnector.getDbConnection();
         Assert.assertNotNull(db);
    }
}
