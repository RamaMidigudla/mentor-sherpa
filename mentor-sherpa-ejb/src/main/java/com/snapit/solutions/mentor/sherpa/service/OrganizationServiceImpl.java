/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import com.snapit.solutions.mentor.sherpa.entity.Program;
import java.util.ArrayList;
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
    @Override
    public Organization findOrganziationById(String orgId) {
        return organizationDao.findById(orgId);
    }
    @Override
    public Organization findOrganziationByUserId(String userId) {
        return organizationDao.findByUserId(userId);
    }
//    @Override
//    public List<String> getPrograms(String organizationId) {
//        List<String> programNames = new ArrayList<>();
//        Organization organization = organizationDao.findByUserId(organizationId);
//        if (organizationId != null) {
//            List<Program> programs = organization.getPrograms();
//            if (programs != null && !programs.isEmpty()) {
//                for (Program program : programs) {
//                    programNames.add(program.getProgramName());
//                }
//            }
//        }
//        return programNames;
//    }
}
