/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdspringmvc2.dao;
import com.sg.dvdlibraryspringmvc2.dao.DVDListDao;
import com.sg.dvdlibraryspringmvc2.dao.SearchTerm;
import com.sg.dvdlibraryspringmvc2.model.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author PG
 */
public class DVDListDaoTest {
   private DVDListDao dao;

    public DVDListDaoTest() {
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
        dao = ctx.getBean("dvdListDao", DVDListDao.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteDVD() {        
        DVD nc = new DVD();
        nc.setTitle("Title1");
        nc.setReleaseYear("1111");
        nc.setDirector("Director1");
        nc.setRating("G");
        nc.setNotes("1234445678");
        dao.addDVD(nc);
        DVD fromDb = dao.getDVDById(nc.getDvdId());
        assertEquals(fromDb, nc);
        dao.removeDVD(nc.getDvdId());
        assertNull(dao.getDVDById(nc.getDvdId()));
    }

    @Test
    public void addUpdateDVD() {
        // Create new contact
        DVD nc = new DVD();
        nc.setTitle("Title1");
        nc.setReleaseYear("1111");
        nc.setDirector("Director1");
        nc.setRating("G");
        nc.setNotes("1234445678");
        dao.addDVD(nc);
        nc.setNotes("9999999999");
        dao.updateDVD(nc);
        DVD fromDb = dao.getDVDById(nc.getDvdId());
        assertEquals(fromDb, nc);
    }

    @Test
    public void getAllContacts() {
        // Create new contact
        DVD nc1 = new DVD();
        nc1.setTitle("Title1");
        nc1.setReleaseYear("1111");
        nc1.setDirector("Director1");
        nc1.setRating("G");
        nc1.setNotes("1234445678");
        dao.addDVD(nc1);
        // Create new contact
        DVD nc2 = new DVD();
        nc2.setTitle("Title2");
        nc2.setReleaseYear("2222");
        nc2.setDirector("Director2");
        nc2.setRating("PG-13");
        nc2.setNotes("1234555678");
        dao.addDVD(nc2);
        List<DVD> cList = dao.getAllDVDs();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void searchContacts() {
        // Create new contact
        DVD nc1 = new DVD();
        nc1.setTitle("Title1");
        nc1.setReleaseYear("1111");
        nc1.setDirector("Director1");
        nc1.setRating("G");
        nc1.setNotes("1234445678");
        dao.addDVD(nc1);
        // Create new contact
        DVD nc2 = new DVD();
        nc2.setTitle("Title2");
        nc2.setReleaseYear("2222");
        nc2.setDirector("Director2");
        nc2.setRating("PG-13");
        nc2.setNotes("1234555678");
        dao.addDVD(nc2);
        // Create new contact - same last name as first 
        // contact but different company
        DVD nc3 = new DVD();
        nc3.setTitle("Title3");
        nc3.setReleaseYear("3333");
        nc3.setDirector("Director3");
        nc3.setRating("u");
        nc3.setNotes("1234566678");
        dao.addDVD(nc3);
        // Create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        String searchCategory = "TITLE";
        String searchTerm = "Title1";
        
        List<DVD> cList = dao.getDVDByTitle(searchTerm);
        assertEquals(1, cList.size());      
        
    } 
}
