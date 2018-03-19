/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.util.List;
import com.sg.superherosighting.model.Member;
import com.sg.superherosighting.model.Organization;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PG
 */
public class MemberDaoImplTest {
    public MemberDao dao;
    public OrganizationDao orgDao;
    
    public MemberDaoImplTest() {
    }
    /*
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("memberDao", MemberDao.class);
        
       List<Member> members = dao.getAllMembers();
        for (Member currentMember : members) {
            dao.deleteMember(currentMember.getMemberID());
        }

        orgDao = ctx.getBean("organizationDao", OrganizationDao.class);
        
       List<Organization> organizations = orgDao.getAllOrganizations();
        for (Organization currentOrg : organizations) {
            orgDao.deleteOrganization(currentOrg.getOrganizationID());
        }
    }
     
    @Test
    public void addGetOperations() {  
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        orgDao.addOrganization(organization);
        Organization orgFromDao = orgDao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);        
        
        Member member = new Member();
        member.setFirstName("member 1");
        member.setLastName("lname 1");
        member.setAddress("address 1");
        member.setZipCode("44256");
        dao.addMember(member, organization.getOrganizationID());
        Member memberFromDao = dao.getMemberByID(member.getMemberID());
        assertEquals(memberFromDao, member);               
    }

    @Test
    public void updateOperations() {    
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        orgDao.addOrganization(organization);
        Organization orgFromDao = orgDao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);        
        
        Member member = new Member();
        member.setFirstName("member 1");
        member.setLastName("lname 1");
        member.setAddress("address 1");
        member.setZipCode("44256");
        dao.addMember(member, organization.getOrganizationID());

        Organization organization2 = new Organization();
        organization2.setOrganizationName("organization1");
        organization2.setAddress("address1");
        organization2.setZipCode("44256");
        organization2.setPhone("123456789");
        orgDao.addOrganization(organization2);
        Organization orgFromDao2 = orgDao.getOrganizationByID(organization2.getOrganizationID());
        assertEquals(orgFromDao2, organization2);        
        
        Member memberFromDao = dao.getMemberByID(member.getMemberID());
        memberFromDao.setFirstName("member 12");
        memberFromDao.setLastName("lname 12");
        memberFromDao.setAddress("address 12");
        memberFromDao.setZipCode("44256");
        dao.updateMember(memberFromDao, orgFromDao2.getOrganizationID());
        
        Member memberAfterUpdate = dao.getMemberByID(memberFromDao.getMemberID());
     
        assertEquals(memberAfterUpdate.getFirstName(), "member 12");
        assertEquals(memberAfterUpdate.getLastName(), "lname 12");
        assertEquals(memberAfterUpdate.getAddress(), "address 12");
        assertEquals(memberAfterUpdate.getZipCode(), "44256");
    }
    
    @Test
    public void deleteMember() {
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        orgDao.addOrganization(organization);
        Organization orgFromDao = orgDao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);        
        
        Member member = new Member();
        member.setFirstName("member 2");
        member.setLastName("lname 2");
        member.setAddress("address 2");
        member.setZipCode("44256");
        dao.addMember(member, organization.getOrganizationID());
        
        Member fromDao = dao.getMemberByID(member.getMemberID());
        assertEquals(fromDao, member);
        dao.deleteMember(member.getMemberID());
        assertNull(dao.getMemberByID(member.getMemberID()));        
    }
    
    @Test
    public void getAllMembers() {
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        orgDao.addOrganization(organization);
        Organization orgFromDao = orgDao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);        
        
        Member member1 = new Member();
        member1.setFirstName("member 2");
        member1.setLastName("lname 2");
        member1.setAddress("address 2");
        member1.setZipCode("44256");
        dao.addMember(member1, organization.getOrganizationID());
                
        Member member2 = new Member();
        member2.setFirstName("member 3");
        member2.setLastName("lname 3");
        member2.setAddress("address 3");
        member2.setZipCode("44256");
        dao.addMember(member2, organization.getOrganizationID());
        
        assertEquals(2,dao.getAllMembers().size());   
    }*/
}