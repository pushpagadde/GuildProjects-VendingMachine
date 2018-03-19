/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.model.Location;
import com.sg.superherosighting.model.Organization;
import com.sg.superherosighting.model.Sighting;
import com.sg.superherosighting.model.SuperHero;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PG
 */
public class SightingsDaoImplTest {
    public SightingDao dao;
    public OrganizationDao orgDao;
    public SuperHeroDao heroDao;
    public LocationDao locationDao;
    
    public SightingsDaoImplTest() {
    }
    /*
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("sightingDao", SightingDao.class);
        orgDao = ctx.getBean("organizationDao", OrganizationDao.class);
        heroDao = ctx.getBean("superHeroDao", SuperHeroDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);
        
        List<Sighting> sightings = dao.getAllSightings();
        for (Sighting currentSighting : sightings) {
            dao.deleteSighting(currentSighting.getSightingID());
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
        
        SuperHero hero = new SuperHero();
        hero.setHeroName("hero1");
        hero.setHeroPower("power1");
        heroDao.addHero(hero, organization.getOrganizationID());
        
        Location location = new Location();        
        location.setDescription("hero");
        location.setAddress("address");
        location.setLatitude("1");
        location.setLongitude("1");
        location.setZipCode("44256");
        locationDao.addLocation(location);
        
        Sighting sighting = new Sighting();
        sighting.setHeroID(hero.getHeroID());
        //sighting.setLocationID(1);
        sighting.setDateOfSighting(new Date(02/03/2017));
        dao.addSighting(sighting, location.getLocationID());
        
        Sighting fromDao = dao.getSightingByID(sighting.getSightingID());
        assertEquals(fromDao.getSightingID(), sighting.getSightingID());               
    }
    
    @Test
    public void deleteSighting() {
        Sighting sighting = new Sighting();
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
        
        Location location = new Location();        
        location.setDescription("hero");
        location.setAddress("address");
        location.setLatitude("1");
        location.setLongitude("1");
        location.setZipCode("44256");
        locationDao.addLocation(location);
        
        sighting.setHeroID(hero.getHeroID());
        //sighting.setLocationID(1);
        sighting.setDateOfSighting(new Date(02/03/2017));
        dao.addSighting(sighting, location.getLocationID());
        
        assertEquals(1, dao.getAllSightings().size());
        dao.deleteSighting(sighting.getSightingID());
        assertEquals(0, dao.getAllSightings().size());
        assertNull(dao.getSightingByID(sighting.getSightingID()));
                
    }
    
    @Test
    public void getAllSightings() {
        Sighting sighting1 = new Sighting();
        Organization organization1 = new Organization();
        organization1.setOrganizationName("organization1");
        organization1.setAddress("address1");
        organization1.setZipCode("44256");
        organization1.setPhone("123456789");
        orgDao.addOrganization(organization1);
        
        SuperHero hero1 = new SuperHero();
        hero1.setHeroName("hero1");
        hero1.setHeroPower("power1");
        heroDao.addHero(hero1, organization1.getOrganizationID());
        
        Location location1 = new Location();        
        location1.setDescription("hero");
        location1.setAddress("address");
        location1.setLatitude("1");
        location1.setLongitude("1");
        location1.setZipCode("44256");
        locationDao.addLocation(location1);
        
        sighting1.setHeroID(hero1.getHeroID());
        //sighting.setLocationID(1);
        sighting1.setDateOfSighting(new Date(02/03/2017));
        dao.addSighting(sighting1, location1.getLocationID());
        
        assertEquals(1, dao.getAllSightings().size());
        
        Sighting sighting2 = new Sighting();
        Organization organization2 = new Organization();
        organization2.setOrganizationName("organization1");
        organization2.setAddress("address1");
        organization2.setZipCode("44256");
        organization2.setPhone("123456789");
        orgDao.addOrganization(organization2);
        
        SuperHero hero2 = new SuperHero();
        hero2.setHeroName("hero1");
        hero2.setHeroPower("power1");
        heroDao.addHero(hero2, organization2.getOrganizationID());
        
        Location location2 = new Location();        
        location2.setDescription("hero");
        location2.setAddress("address");
        location2.setLatitude("1");
        location2.setLongitude("1");
        location2.setZipCode("44256");
        locationDao.addLocation(location2);
        
        sighting2.setHeroID(hero2.getHeroID());
        //sighting.setLocationID(1);
        sighting2.setDateOfSighting(new Date(02/03/2017));
        dao.addSighting(sighting2, location2.getLocationID());
        assertEquals(2, dao.getAllSightings().size());
                     
    }
    
    @Test
    public void updateSighting() {
        Sighting sighting1 = new Sighting();
        Organization organization1 = new Organization();
        organization1.setOrganizationName("organization1");
        organization1.setAddress("address1");
        organization1.setZipCode("44256");
        organization1.setPhone("123456789");
        orgDao.addOrganization(organization1);
        
        SuperHero hero1 = new SuperHero();
        hero1.setHeroName("hero1");
        hero1.setHeroPower("power1");
        heroDao.addHero(hero1, organization1.getOrganizationID());
        
        Location location1 = new Location();        
        location1.setDescription("hero");
        location1.setAddress("address");
        location1.setLatitude("1");
        location1.setLongitude("1");
        location1.setZipCode("44256");
        locationDao.addLocation(location1);
        
        sighting1.setHeroID(hero1.getHeroID());
        //sighting.setLocationID(1);
        sighting1.setDateOfSighting(new Date(02/03/2017));
        dao.addSighting(sighting1, location1.getLocationID());
        
        location1.setDescription("hero");
        location1.setAddress("address1");
        location1.setLatitude("2");
        location1.setLongitude("2");
        location1.setZipCode("44256");
        locationDao.updateLocation(location1);
        
        Location fromDao = locationDao.getLocationByID(location1.getLocationID());
        assertEquals(fromDao, location1);
        
        
    }
    
    */
}
