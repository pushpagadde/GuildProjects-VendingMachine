/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.Member;
import model.Organizations;
import model.SuperHero;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
/**
 *
 * @author PG
 */
public class DaoTest {
    public LocationDao dao;
    
    public DaoTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("locationDao", LocationDao.class);
        
        List<Member> members = dao.getAllMembers();
        for (Member currentMember : members) {
            dao.deleteMember(currentMember.getMemberID());
        }
        List<SuperHero> heros = dao.getAllHeros();
        for (SuperHero currentHero : heros) {
            dao.deleteHero(currentHero.getHeroID());
        }
        List<Organizations> organizations = dao.getAllOrganizations();
        for (Organizations currentOrganization : organizations) {
            dao.deleteOrganization(currentOrganization.getOrganizationID());
        }
    }
     
    @Test
    public void addGetOperations() {
        Organizations organization = new Organizations();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);
        Organizations orgFromDao = dao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);        
        
        SuperHero hero = new SuperHero();
        hero.setHeroName("hero1");
        hero.setHeroPower("power1");
        dao.addHero(hero, organization.getOrganizationID());
        SuperHero superHeroFromDao = dao.getHeroById(hero.getHeroID());
        assertEquals(superHeroFromDao, hero);
        
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
    public void deleteOrganization() {
        Organizations organization = new Organizations();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);
        Organizations orgFromDao = dao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);        
        
        dao.deleteOrganization(organization.getOrganizationID());
        assertNull(dao.getMemberByID(organization.getOrganizationID()));        
    }
    
    @Test
    public void deleteSuperHero() {
        Organizations organization = new Organizations();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);

        SuperHero hero = new SuperHero();
        hero.setHeroName("hero1");
        hero.setHeroPower("power1");
        dao.addHero(hero, organization.getOrganizationID());
        
        SuperHero fromDao = dao.getHeroById(hero.getHeroID());
        assertEquals(fromDao, hero);
        dao.deleteHero(hero.getHeroID());
        assertNull(dao.getHeroById(hero.getHeroID()));        
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
    public void getAllOrganizations() {        
        Organizations organization = new Organizations();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);

        Organizations organizationTwo = new Organizations();
        organizationTwo.setOrganizationName("organization2");
        organizationTwo.setAddress("address2");
        organizationTwo.setZipCode("44256");
        organizationTwo.setPhone("123456780");
        dao.addOrganization(organizationTwo);
        
        assertEquals(2,dao.getAllOrganizations().size());   
    }

    @Test
    public void getAllSuperHeros() {        
        Organizations organization = new Organizations();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        dao.addOrganization(organization);
        
        SuperHero hero = new SuperHero();
        hero.setHeroName("hero1");
        hero.setHeroPower("power1");
        dao.addHero(hero, organization.getOrganizationID());
        
        SuperHero heroTwo = new SuperHero();
        heroTwo.setHeroName("hero2");
        heroTwo.setHeroPower("power2");
        dao.addHero(heroTwo, organization.getOrganizationID());        
        assertEquals(2,dao.getAllHeros().size());   
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
        member2.setFirstName("member 2");
        member2.setLastName("lname 2");
        member2.setAddress("address 2");
        member2.setZipCode("44281");
        dao.addMember(member2);
        
        assertEquals(2,dao.getAllMembers().size());   
    }
    /*
    @Test
    public void addGetMember() {
        Member member = new Member();
        member.setFirstName("member 1");
        member.setLastName("lname 1");
        member.setAddress("address 1");
        member.setZipCode("44281");
        dao.addMember(member);
        Member fromDao = dao.getMemberByID(member.getMemberID());
        assertEquals(fromDao, member);               
    }*/
}