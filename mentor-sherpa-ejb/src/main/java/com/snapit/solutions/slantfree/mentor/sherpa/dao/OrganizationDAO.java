/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.slantfree.mentor.sherpa.dao;

import com.snapit.solutions.slantfree.mentor.sherpa.entity.Organization;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public interface OrganizationDAO extends DAO<Organization, ObjectId> {
    public List<Organization> findAll();
}
