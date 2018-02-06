/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.util.List;
import com.sg.superherosighting.model.Organization;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PG
 */
public class OrganizationDaoImplTest {
    public OrganizationDao dao;
    
    public OrganizationDaoImplTest() {
    }
        
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("organizationDao", OrganizationDao.class);
        
        List<Organization> organizations = dao.getAllOrganizations();
        for (Organization currentOrganization : organizations) {
            dao.deleteOrganization(currentOrganization.getOrganizationID());
        }
    }
     
    @Test
    public void addGetOperations() {
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);
        Organization orgFromDao = dao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);           
     }

        @Test
    public void updateOrganization() {
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);
        
        Organization orgFromDao = dao.getOrganizationByID(organization.getOrganizationID());
        orgFromDao.setOrganizationName("organization12");
        orgFromDao.setAddress("address12");
        orgFromDao.setZipCode("44256");
        orgFromDao.setPhone("123456780");
        dao.updateOrganization(orgFromDao);
        
        Organization orgAfterUpdate = dao.getOrganizationByID(orgFromDao.getOrganizationID());
        assertEquals(orgAfterUpdate.getOrganizationID(), orgFromDao.getOrganizationID());
        assertEquals(orgAfterUpdate.getOrganizationName(), "organization12");
        assertEquals(orgAfterUpdate.getAddress(), "address12");
        assertEquals(orgAfterUpdate.getZipCode(), "44256");
        assertEquals(orgAfterUpdate.getPhone(), "123456780");
     }
    
    @Test
    public void deleteOrganization() {
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);
        Organization orgFromDao = dao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);        
        
        dao.deleteOrganization(organization.getOrganizationID());
        assertNull(dao.getOrganizationByID(organization.getOrganizationID()));        
    }

    @Test
    public void getAllOrganizations() {        
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);

        Organization organizationTwo = new Organization();
        organizationTwo.setOrganizationName("organization2");
        organizationTwo.setAddress("address2");
        organizationTwo.setZipCode("44256");
        organizationTwo.setPhone("123456780");
        dao.addOrganization(organizationTwo);
        
        assertEquals(2,dao.getAllOrganizations().size());   
    }
}
