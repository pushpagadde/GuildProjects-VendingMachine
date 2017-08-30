/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVDLibrary;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryServiceLayer {
    public void createDVD(DVDLibrary dvd) throws DVDLibraryDuplicateNameException, 
                DVDLibraryDataValidationException, DVDLibraryPersistenceException, DVDLibraryDaoException;
    DVDLibrary removeDVD(String title) throws DVDLibraryDaoException, DVDLibraryPersistenceException, DVDLibraryDVDNotFoundException;
    DVDLibrary editDVD (String title, int editKey, String newValue) throws DVDLibraryPersistenceException, DVDLibraryDataValidationException, DVDLibraryDaoException;
    List<DVDLibrary> getAllDVD () throws DVDLibraryPersistenceException, DVDLibraryDVDNotFoundException,DVDLibraryDaoException;
    DVDLibrary getDVDInfo(String title) throws DVDLibraryPersistenceException, DVDLibraryDVDNotFoundException,DVDLibraryDaoException;
    List<String> getAllTitles() throws DVDLibraryPersistenceException, DVDLibraryDVDNotFoundException,DVDLibraryDaoException;
}
