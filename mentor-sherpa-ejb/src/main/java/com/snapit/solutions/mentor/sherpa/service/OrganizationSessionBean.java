/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.service;

import com.snapit.solutions.mentor.sherpa.dao.OrganizationDAO;
import com.snapit.solutions.mentor.sherpa.entity.Organization;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
@Path("/organization/")
public class OrganizationSessionBean implements OrganizationSessionBeanLocal {

   private static final Logger LOG = LogManager.getLogger(OrganizationSessionBean.class);
   @Autowired
    private OrganizationDAO organizationDao;
   // 
    /**
     *
     * @return
     */
    @GET
    @Path("all/")
    @Produces({"application/json"})
    @Override
    public List<Organization> listAllOrganizations() {
        LOG.info("Findall");
        return organizationDao.findAll();
    }
}
