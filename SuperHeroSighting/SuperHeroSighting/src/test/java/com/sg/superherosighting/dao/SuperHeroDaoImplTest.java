/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.util.List;
import com.sg.superherosighting.model.Organization;
import com.sg.superherosighting.model.SuperHero;
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
    public SuperHeroDao heroDao;
    public OrganizationDao orgDao;
    
    public SuperHeroDaoImplTest() {
    }
    /*
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        heroDao = ctx.getBean("superHeroDao", SuperHeroDao.class);
        
        List<SuperHero> heros = heroDao.getAllHeros();
        for (SuperHero currentHero : heros) {
            heroDao.deleteHero(currentHero.getHeroID());
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
        heroDao.addHero(hero, organization.getOrganizationID());
        SuperHero superHeroFromDao = heroDao.getHeroById(hero.getHeroID());
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

        Organization organization2 = new Organization();
        organization2.setOrganizationName("organization2");
        organization2.setAddress("address2");
        organization2.setZipCode("44256");
        organization2.setPhone("123456788");
        orgDao.addOrganization(organization2);
        Organization orgFromDao2 = orgDao.getOrganizationByID(organization2.getOrganizationID());
        assertEquals(orgFromDao2, organization2);        
                
        SuperHero hero = new SuperHero();
        hero.setHeroName("hero1");
        hero.setHeroPower("power1");
        heroDao.addHero(hero, organization.getOrganizationID());
        SuperHero superHeroFromDao = heroDao.getHeroById(hero.getHeroID());
        superHeroFromDao.setHeroName("hero12");
        superHeroFromDao.setHeroPower("power12");
        heroDao.updateHero(superHeroFromDao, orgFromDao2.getOrganizationID());
        SuperHero superHeroAfterUpdate = heroDao.getHeroById(superHeroFromDao.getHeroID());
        
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
        heroDao.addHero(hero, organization.getOrganizationID());
        
        SuperHero fromDao = heroDao.getHeroById(hero.getHeroID());
        assertEquals(fromDao, hero);
        heroDao.deleteHero(hero.getHeroID());
        assertNull(heroDao.getHeroById(hero.getHeroID()));        
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
        heroDao.addHero(hero, organization.getOrganizationID());
        
        SuperHero heroTwo = new SuperHero();
        heroTwo.setHeroName("hero2");
        heroTwo.setHeroPower("power2");
        heroDao.addHero(heroTwo, organization.getOrganizationID());        
        assertEquals(2,heroDao.getAllHeros().size());   
    }
*/
}