/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.util.List;
import com.sg.superherosighting.model.Location;
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
public class LocationDaoImplTest {
    public LocationDao dao;
    
    public LocationDaoImplTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("locationDao", LocationDao.class);                
        
        List<Location> locations = dao.getAllLocations();
        for (Location currentLocation : locations) {
            dao.deleteLocation(currentLocation.getLocationID());            
        }        
    }
    
    @Test
    public void addGetOperation(){
        Location location = new Location();        
        location.setDescription("hero");
        location.setAddress("address");
        location.setLatitude("1");
        location.setLongitude("1");
        location.setZipCode("44256");
        dao.addLocation(location);
        Location locationFromDao = dao.getLocationByID(location.getLocationID());
        assertEquals(locationFromDao, location);
    }
    
    @Test
    public void deleteLocation(){
        Location location = new Location();
        location.setAddress("address 1");
        location.setDescription("hero sighted 1");
        location.setLatitude("1.11");
        location.setLongitude("1.111");
        location.setZipCode("44256");
        dao.addLocation(location);        
        assertEquals(dao.getAllLocations().size(),1);
        dao.deleteLocation(location.getLocationID());
        assertEquals(dao.getAllLocations().size(),0);
        assertNull(dao.getLocationByID(location.getLocationID()));
    }
    
    
    @Test
    public void getAllLocations(){
        Location location = new Location();
        location.setAddress("address 1");
        location.setDescription("hero sighted 1");
        location.setLatitude("11.11");
        location.setLongitude("11.11");
        location.setZipCode("44256");
        dao.addLocation(location);        
        
        assertEquals(1, dao.getAllLocations().size());
        
        Location location1 = new Location();
        location1.setAddress("address 2");
        location1.setDescription("hero sighted 2");
        location1.setLatitude("22.22");
        location1.setLongitude("22.22");
        location1.setZipCode("44256");
        dao.addLocation(location1); 
        
        assertEquals(2, dao.getAllLocations().size());        
    }
     
}