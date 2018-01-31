/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarydbdao;

import com.sg.dvddb.dao.DVDDao;
import com.sg.dvddb.model.DVDInfo;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PG
 */
public class dvdlibraryDaoTest {
    DVDDao dao;
    public dvdlibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("dvdDao", DVDDao.class);
        // delete all dvds
        List<DVDInfo> dvds = dao.getAllDVDs();
        for (DVDInfo currentDVD : dvds){
            dao.removeDVD(currentDVD.getDvdID());
        }         
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addGetDVD(){
        DVDInfo dvd = new DVDInfo();
        dvd.setTitle("Title 1");
        dvd.setReleaseYear("2000");
        dvd.setDirector("Director 1");
        dvd.setRating("RG");
        dvd.setNotes("notes 1");
        dao.addDVD(dvd);
        
        DVDInfo fromDao = dao.getDVDById(dvd.getDvdID());
        assertEquals(fromDao, dvd);
        
        assertEquals(1, dao.getAllDVDs().size());
        
        DVDInfo dvd2 = new DVDInfo();
        dvd2.setTitle("Title 2");
        dvd2.setReleaseYear("2010");
        dvd2.setDirector("Director 2");
        dvd2.setRating("PG");
        dvd2.setNotes("notes 2");
        dao.addDVD(dvd2);
        
        assertEquals(2, dao.getAllDVDs().size());                
    }
    
    @Test
    public void deleteDVD(){
        DVDInfo dvd = new DVDInfo();
        dvd.setTitle("Title 1");
        dvd.setReleaseYear("2000");
        dvd.setDirector("Director 1");
        dvd.setRating("RG");
        dvd.setNotes("notes 1");
        dao.addDVD(dvd);
        DVDInfo fromDao = dao.getDVDById(dvd.getDvdID());
        assertEquals(fromDao, dvd);
        dao.removeDVD(dvd.getDvdID());
        assertEquals(0,dao.getAllDVDs().size());
        //assertNull(dao.getDVDById(dvd.getDvdID()));
        
    }
    
    @Test
    public void editDVD(){
        DVDInfo dvd = new DVDInfo();
        dvd.setTitle("Title 1");
        dvd.setReleaseYear("2000");
        dvd.setDirector("Director 1");
        dvd.setRating("RG");
        dvd.setNotes("notes 1");
        dao.addDVD(dvd);
        
        DVDInfo dvd2 = dao.getDVDById(dvd.getDvdID());
        
        dvd.setTitle("Title 2");
        dvd.setReleaseYear("2000");
        dvd.setDirector("Director 1");
        dvd.setRating("RG");
        dvd.setNotes("notes 1");                
        dao.updateDVD(dvd);
        
        assertFalse(dvd.equals(dvd2));
        
    }    
}
