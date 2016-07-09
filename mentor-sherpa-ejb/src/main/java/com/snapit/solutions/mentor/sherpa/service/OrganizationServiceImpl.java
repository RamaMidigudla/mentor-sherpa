/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDAO organizationDao;

    @Override
    public List<Organization> listAllOrganizations() {
        return organizationDao.findAll();
    }

    @Override
    public Organization findOrganziationById(ObjectId orgId) {
        return organizationDao.retrieveOrganizationById(orgId);
    }

}
