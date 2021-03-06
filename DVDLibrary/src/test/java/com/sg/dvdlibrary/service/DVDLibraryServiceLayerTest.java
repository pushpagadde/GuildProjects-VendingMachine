/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DVDLibraryServiceLayerTest {
    private DVDLibraryServiceLayer service;
    
    public DVDLibraryServiceLayerTest() {
/*        DVDLibraryDao dao = new DVDLibraryDaoStubImpl();
        DVDLibraryAuditDao auditDao = new DVDLibraryAuditDaoStubImpl();
        service = new DVDLibraryServiceLayerImpl(dao, auditDao);*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", DVDLibraryServiceLayer.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testCreateDVD() throws Exception {
        DVDLibrary dvd = new DVDLibrary("Title2");
        dvd.setDirectorName("Director name 2");
        dvd.setMPAARating("Rating 2");
        LocalDate releaseDate = LocalDate.parse("2015-01-01");
        dvd.setReleaseDate(releaseDate);
        dvd.setStudio("Studio 2");
        dvd.setUserNotes("Notes 2");
        service.createDVD(dvd);
    }

    @Test
    public void testCreateDuplicateDVDTitle() throws Exception {
        DVDLibrary dvd = new DVDLibrary("Title1");
        dvd.setDirectorName("Director name 1");
        dvd.setMPAARating("Rating 1");
        LocalDate releaseDate = LocalDate.parse("2018-01-01");
        dvd.setReleaseDate(releaseDate);
        dvd.setStudio("Studio 1");
        dvd.setUserNotes("Notes 1");
        try {
            service.createDVD(dvd);
            fail("Expected: Duplicate title exception was not thrown.");
        } catch (DVDLibraryDuplicateNameException e) {
            return;
        }
    }
    
    @Test
    public void testInvalidData() throws Exception {
        DVDLibrary dvd = new DVDLibrary("Title2");
        dvd.setDirectorName("");
        dvd.setMPAARating("Rating 2");
        LocalDate releaseDate = LocalDate.parse("2015-01-01");
        dvd.setReleaseDate(releaseDate);
        dvd.setStudio("Studio 2");
        dvd.setUserNotes("Notes 2");
        try {
            service.createDVD(dvd);
            fail("Expected: Invalid data exception was not thrown.");
        } catch (DVDLibraryDataValidationException e) {
            return;
        }
    }
    
    /**
     * Test of removeDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVDLibrary dvd = service.removeDVD("Title1");
        assertNotNull(dvd);
        dvd = service.removeDVD("Title2");
        assertNull(dvd);
    }

    /**
     * Test of editDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testEditDVD() throws Exception {
        assertEquals(service.getDVDInfo("Title1").getReleaseDate(), LocalDate.parse("2015-01-01"));
        DVDLibrary dvd = service.editDVD("Title1",1,"2015-01-01");
        assertEquals(dvd.getReleaseDate(),LocalDate.parse("2015-01-01"));
        
        assertEquals(service.getDVDInfo("Title1").getMPAARating(), "Rating");
        dvd = service.editDVD("Title1",2,"Rating 2");
        assertEquals(dvd.getMPAARating(),"Rating 2");
        
        assertEquals(service.getDVDInfo("Title1").getDirectorName(), "Director name");
        dvd = service.editDVD("Title1",3,"Director name 2");
        assertEquals(dvd.getDirectorName(),"Director name 2");
        
        assertEquals(service.getDVDInfo("Title1").getStudio(), "Studio");
        dvd = service.editDVD("Title1",4,"Studio 2");
        assertEquals(dvd.getStudio(),"Studio 2");

    }

    /**
     * Test of getAllDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetAllDVD() throws Exception {
        assertEquals(1, service.getAllDVD().size());
    }

    /**
     * Test of getDVDInfo method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetDVDInfo() throws Exception {
        DVDLibrary dvd = service.getDVDInfo("Title1");
        assertNotNull(dvd);
    }

    /**
     * Test of getAllTitles method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetAllTitles() throws Exception {
        assertEquals(1, service.getAllTitles().size());
    }
}
