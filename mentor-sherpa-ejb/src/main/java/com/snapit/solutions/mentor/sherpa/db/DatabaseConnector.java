/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author sudheerparasker
 */
public class DatabaseConnector {

    private static final Logger LOG = LogManager.getLogger(DatabaseConnector.class);
    private static final String DB_CONNECTION_URI = "mongodb://ms-admin:msPass@localhost:27017/mentor-sherpa-db";
    private static final String DB_NAME = "mentor-sherpa-db";

    /**
     * Simple Database Connector - Connects to MongoDB
     * @return 
     */
    public static MongoDatabase getDbConnection() {
        try {

            MongoClient mongoClient = getMongoClient();

            // Now connect to your databases
            MongoDatabase db;
            db = mongoClient.getDatabase(DB_NAME);
            LOG.info("Connect to database successfully");
            return db;
        } catch (Exception e) {
            LOG.error(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    private static MongoClient getMongoClient() {
        // To connect to mongodb server
        MongoClientURI connectionString = new MongoClientURI(DB_CONNECTION_URI);
        MongoClient mongoClient = new MongoClient(connectionString);
        return mongoClient;
    }

    /**
     * Morphia Connector for MongoDB
     * @return 
     */
    public static Datastore getDataStore() {
        final Morphia morphia = new Morphia();

        // tell Morphia where to find your classes
       // can be called multiple times with different packages or classes
        morphia.mapPackage("com.snapit.solutions.mentor.sherpa.entity");

        // create the Datastore connecting to the default port on the local host
        final Datastore datastore = morphia.createDatastore(getMongoClient(), DB_NAME);
        LOG.info("Connect to database successfully");
        datastore.ensureIndexes(); //creates all defined with @Indexed
        datastore.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
        return datastore;
    }
}
