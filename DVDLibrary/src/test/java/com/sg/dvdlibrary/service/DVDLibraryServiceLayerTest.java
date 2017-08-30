/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryAuditDaoStubImpl;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoStubImpl;
import com.sg.dvdlibrary.dto.DVDLibrary;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class DVDLibraryServiceLayerTest {
    private DVDLibraryServiceLayer service;
    
    public DVDLibraryServiceLayerTest() {
        DVDLibraryDao dao = new DVDLibraryDaoStubImpl();
        DVDLibraryAuditDao auditDao = new DVDLibraryAuditDaoStubImpl();
        service = new DVDLibraryServiceLayerImpl(dao, auditDao);
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
        dvd.setReleaseDate("Release Date 2");
        dvd.setStudio("Studio 2");
        dvd.setUserNotes("Notes 2");
        service.createDVD(dvd);
    }

    @Test
    public void testCreateDuplicateDVDTitle() throws Exception {
        DVDLibrary dvd = new DVDLibrary("Title1");
        dvd.setDirectorName("Director name 1");
        dvd.setMPAARating("Rating 1");
        dvd.setReleaseDate("Release Date 1");
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
        dvd.setReleaseDate("Release Date 2");
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
        assertEquals(service.getDVDInfo("Title1").getReleaseDate(), "Release Date");
        DVDLibrary dvd = service.editDVD("Title1",1,"Release Date 2");
        assertEquals(dvd.getReleaseDate(),"Release Date 2");
        
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
