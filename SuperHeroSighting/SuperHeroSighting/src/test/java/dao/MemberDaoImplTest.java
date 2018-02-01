/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Member;
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
    
    public MemberDaoImplTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("memberDao", MemberDao.class);
        
       List<Member> members = dao.getAllMembers();
        for (Member currentMember : members) {
            dao.deleteMember(currentMember.getMemberID());
        }
    /*     List<SuperHero> heros = dao.getAllHeros();
        for (SuperHero currentHero : heros) {
            dao.deleteHero(currentHero.getHeroID());
        }
        List<Organizations> organizations = dao.getAllOrganizations();
        for (Organizations currentOrganization : organizations) {
            dao.deleteOrganization(currentOrganization.getOrganizationID());
        }*/
    }
     
    @Test
    public void addGetOperations() {    
        Member member = new Member();
        member.setFirstName("member 1");
        member.setLastName("lname 1");
        member.setAddress("address 1");
        member.setZipCode("44281");
        dao.addMember(member);
        Member memberFromDao = dao.getMemberByID(member.getMemberID());
        assertEquals(memberFromDao, member);               
    }

    @Test
    public void updateOperations() {    
        Member member = new Member();
        member.setFirstName("member 1");
        member.setLastName("lname 1");
        member.setAddress("address 1");
        member.setZipCode("44281");
        dao.addMember(member);
        
        Member memberFromDao = dao.getMemberByID(member.getMemberID());
        memberFromDao.setFirstName("member 12");
        memberFromDao.setLastName("lname 12");
        memberFromDao.setAddress("address 12");
        memberFromDao.setZipCode("44256");
        dao.updateMember(memberFromDao);
        
        Member memberAfterUpdate = dao.getMemberByID(memberFromDao.getMemberID());
     
        assertEquals(memberAfterUpdate.getFirstName(), "member 12");
        assertEquals(memberAfterUpdate.getLastName(), "lname 12");
        assertEquals(memberAfterUpdate.getAddress(), "address 12");
        assertEquals(memberAfterUpdate.getZipCode(), "44256");
    }
    
    @Test
    public void deleteMember() {
        Member member = new Member();
        member.setFirstName("member 2");
        member.setLastName("lname 2");
        member.setAddress("address 2");
        member.setZipCode("44281");
        dao.addMember(member);
        Member fromDao = dao.getMemberByID(member.getMemberID());
        assertEquals(fromDao, member);
        dao.deleteMember(member.getMemberID());
        assertNull(dao.getMemberByID(member.getMemberID()));        
    }

    
    @Test
    public void getAllMembers() {
        Member member1 = new Member();
        member1.setFirstName("member 2");
        member1.setLastName("lname 2");
        member1.setAddress("address 2");
        member1.setZipCode("44281");
        dao.addMember(member1);
                
        Member member2 = new Member();
        member2.setFirstName("member 3");
        member2.setLastName("lname 3");
        member2.setAddress("address 3");
        member2.setZipCode("44256");
        dao.addMember(member2);
        
        assertEquals(2,dao.getAllMembers().size());   
    }
}
