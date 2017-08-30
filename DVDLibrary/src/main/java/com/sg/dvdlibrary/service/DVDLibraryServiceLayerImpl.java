/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVDLibrary;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer {
    private DVDLibraryDao dao;
    private DVDLibraryAuditDao auditDao;

    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public void createDVD(DVDLibrary dvd) throws DVDLibraryDuplicateNameException,
                DVDLibraryDataValidationException, DVDLibraryPersistenceException, DVDLibraryDaoException{
                if(dao.getDVDInfo(dvd.getTitle()) != null) {
                    throw new DVDLibraryDuplicateNameException(dvd.getTitle() + " already exists. Key new title.");
                }
                validateDVDInfo(dvd);
                dao.addDVD(dvd.getTitle(), dvd);
                
    }
    
    
    @Override
    public DVDLibrary removeDVD(String title) throws DVDLibraryDaoException, DVDLibraryPersistenceException {
    /*    if(dao.getDVDInfo(title) == null) {
            throw new DVDLibraryDVDNotFoundException("DVD not found. Enter a valid DVD title.");
        }*/
        DVDLibrary removeDVD = dao.removeDVD(title);
        return removeDVD;
    }

    @Override
    public DVDLibrary editDVD(String title, int editKey, String newValue) throws DVDLibraryPersistenceException, DVDLibraryDataValidationException,DVDLibraryDaoException {
        if(editKey< 1 || editKey > 5 || newValue == null) {
            throw new DVDLibraryDataValidationException("Error: Field and Value must be keyed");
        }
        DVDLibrary editDVD = dao.editDVD(title, editKey, newValue);
        return editDVD;
    }

    @Override
    public List<DVDLibrary> getAllDVD() throws DVDLibraryPersistenceException, DVDLibraryDVDNotFoundException, DVDLibraryDaoException {
        return dao.getAllDVD();
    }

    @Override
    public DVDLibrary getDVDInfo(String title) throws DVDLibraryPersistenceException, DVDLibraryDVDNotFoundException, DVDLibraryDaoException {
        return dao.getDVDInfo(title);
    }

    @Override
    public List<String> getAllTitles() throws DVDLibraryPersistenceException, DVDLibraryDVDNotFoundException,DVDLibraryDaoException {
        return dao.getAllTitles();
    }
    
    private void validateDVDInfo(DVDLibrary dvd) throws DVDLibraryDataValidationException {
        if(dvd.getDirectorName() == null        || dvd.getDirectorName().trim().length() == 0 
                || dvd.getMPAARating() == null  || dvd.getMPAARating().trim().length() == 0 
                || dvd.getReleaseDate() == null || dvd.getReleaseDate().trim().length() == 0 
                || dvd.getStudio() == null      || dvd.getStudio().trim().length() == 0 
                || dvd.getTitle() == null       || dvd.getTitle().trim().length() == 0 
                || dvd.getUserNotes() == null   || dvd.getUserNotes().trim().length() == 0 ){
            throw new DVDLibraryDataValidationException ( "Error: Key all fields.");
        }
    }
}
