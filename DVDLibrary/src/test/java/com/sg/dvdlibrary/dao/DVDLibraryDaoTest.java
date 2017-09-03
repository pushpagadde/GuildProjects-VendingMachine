/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoTest {
    private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
    
    public DVDLibraryDaoTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<DVDLibrary> DVDList = dao.getAllDVD();
        for(DVDLibrary dvd : DVDList) {
            dao.removeDVD(dvd.getTitle());
        }
    }
    
    /**
     * Test of addDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testAddDVD() throws Exception {
        DVDLibrary dvd = new DVDLibrary("title1");
        dvd.setDirectorName("Director 1");
        dvd.setMPAARating("rating1");
        LocalDate releaseDate = LocalDate.parse("2015-01-01");
        dvd.setReleaseDate(releaseDate);
        dvd.setStudio("studio1");
        dvd.setTitle("title1 ");
        dvd.setUserNotes("notes1");
        dao.addDVD(dvd.getTitle(), dvd);
        DVDLibrary fromDao = dao.getDVDInfo(dvd.getTitle());
        assertEquals(dvd.getTitle(), fromDao.getTitle());
    }

    /**
     * Test of removeDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVDLibrary dvd1 = new DVDLibrary("title1");
        dvd1.setDirectorName("Director 1");
        dvd1.setMPAARating("rating1");
        LocalDate releaseDate = LocalDate.parse("2015-01-01");
        dvd1.setReleaseDate(releaseDate);
        dvd1.setStudio("studio1");
        dvd1.setTitle("title1 ");
        dvd1.setUserNotes("notes1");
        dao.addDVD(dvd1.getTitle(), dvd1);
        
        DVDLibrary dvd2 = new DVDLibrary("title2");
        dvd2.setDirectorName("Director 2");
        dvd2.setMPAARating("rating2");
        releaseDate = LocalDate.parse("2018-01-01");
        dvd2.setReleaseDate(releaseDate);
        dvd2.setStudio("studio2");
        dvd2.setTitle("title2 ");
        dvd2.setUserNotes("notes2");
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        assertEquals(2, dao.getAllDVD().size());
        dao.removeDVD(dvd1.getTitle());
        assertEquals(1, dao.getAllDVD().size());
        dao.removeDVD(dvd2.getTitle());
        assertEquals(0, dao.getAllDVD().size());
        assertNull(dao.getDVDInfo(dvd1.getTitle()));
        assertNull(dao.getDVDInfo(dvd2.getTitle()));
    }

    /**
     * Test of getAllDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllDVD() throws Exception {
        DVDLibrary dvd = new DVDLibrary("title1");
        dvd.setDirectorName("Director 1");
        dvd.setMPAARating("rating1");
        LocalDate releaseDate = LocalDate.parse("2015-01-01");
        dvd.setReleaseDate(releaseDate);
        dvd.setStudio("studio1");
        dvd.setTitle("title1 ");
        dvd.setUserNotes("notes1");
        dao.addDVD(dvd.getTitle(), dvd);
        assertEquals(1, dao.getAllDVD().size());
        
        DVDLibrary dvd2 = new DVDLibrary("title12");
        dvd2.setDirectorName("Director 2");
        dvd2.setMPAARating("rating2");
        releaseDate = LocalDate.parse("2018-01-01");
        dvd2.setReleaseDate(releaseDate);
        dvd2.setStudio("studio2");
        dvd2.setTitle("title2 ");
        dvd2.setUserNotes("notes2");
        dao.addDVD(dvd2.getTitle(), dvd2);
        assertEquals(2, dao.getAllDVD().size());
    }
}
