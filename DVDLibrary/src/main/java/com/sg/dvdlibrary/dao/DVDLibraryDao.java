/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryDao {
    DVDLibrary addDVD(String title, DVDLibrary dvd) throws DVDLibraryDaoException;
    DVDLibrary removeDVD(String title)throws DVDLibraryDaoException;
    DVDLibrary editDVD(String title, int newKey, String newValue) throws DVDLibraryDaoException;
    List<DVDLibrary> getAllDVD() throws DVDLibraryDaoException;
    DVDLibrary getDVDInfo(String title) throws DVDLibraryDaoException;
    List<String> getAllTitles() throws DVDLibraryDaoException;
}
