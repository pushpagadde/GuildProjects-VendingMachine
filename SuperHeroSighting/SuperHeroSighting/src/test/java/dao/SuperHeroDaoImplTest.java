/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Organization;
import model.SuperHero;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PG
 */
public class SuperHeroDaoImplTest {
    public SuperHeroDao dao;
    public OrganizationDao orgDao;
    
    public SuperHeroDaoImplTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("superHeroDao", SuperHeroDao.class);
        
        List<SuperHero> heros = dao.getAllHeros();
        for (SuperHero currentHero : heros) {
            dao.deleteHero(currentHero.getHeroID());
        }

        orgDao = ctx.getBean("organizationDao", OrganizationDao.class);
        
        List<Organization> orgs = orgDao.getAllOrganizations();
        for (Organization currentOrg : orgs) {
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
        
        SuperHero hero = new SuperHero();
        hero.setHeroName("hero1");
        hero.setHeroPower("power1");
        dao.addHero(hero, organization.getOrganizationID());
        SuperHero superHeroFromDao = dao.getHeroById(hero.getHeroID());
        assertEquals(superHeroFromDao, hero);               
    }

    @Test
    public void updateSuperHero() {
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        orgDao.addOrganization(organization);
        Organization orgFromDao = orgDao.getOrganizationByID(organization.getOrganizationID());
        assertEquals(orgFromDao, organization);        
        
        SuperHero hero = new SuperHero();
        hero.setHeroName("hero1");
        hero.setHeroPower("power1");
        dao.addHero(hero, organization.getOrganizationID());
        SuperHero superHeroFromDao = dao.getHeroById(hero.getHeroID());
        superHeroFromDao.setHeroName("hero12");
        superHeroFromDao.setHeroPower("power12");
        dao.updateHero(superHeroFromDao);
        SuperHero superHeroAfterUpdate = dao.getHeroById(superHeroFromDao.getHeroID());
        
        assertEquals(superHeroAfterUpdate.getHeroName(), "hero12");
        assertEquals(superHeroAfterUpdate.getHeroID(), superHeroFromDao.getHeroID());
        assertEquals(superHeroAfterUpdate.getHeroPower(), "power12");
    }
    
    @Test
    public void deleteSuperHero() {
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        orgDao.addOrganization(organization);

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
    public void getAllSuperHeros() {        
        Organization organization = new Organization();
        organization.setOrganizationName("organization1");
        organization.setAddress("address1");
        organization.setZipCode("44256");
        organization.setPhone("123456789");
        orgDao.addOrganization(organization);
        
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
}
