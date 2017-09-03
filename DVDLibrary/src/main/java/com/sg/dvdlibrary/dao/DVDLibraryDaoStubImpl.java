/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoStubImpl implements DVDLibraryDao{
    DVDLibrary onlyDVD;
    List<DVDLibrary> DVDList = new ArrayList<>();

    public DVDLibraryDaoStubImpl() {
        onlyDVD = new DVDLibrary("Title1");
        LocalDate releaseDate = LocalDate.parse("2015-01-01");
        onlyDVD.setReleaseDate(releaseDate);
        onlyDVD.setMPAARating("Rating");
        onlyDVD.setDirectorName("Director name");
        onlyDVD.setStudio("Studio");
        onlyDVD.setUserNotes("Notes");
        DVDList.add(onlyDVD);
    }
    
    @Override
    public DVDLibrary addDVD(String title, DVDLibrary dvd) throws DVDLibraryDaoException {
        if(title.equalsIgnoreCase(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public DVDLibrary removeDVD(String title) throws DVDLibraryDaoException {
        if(title.equalsIgnoreCase(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public DVDLibrary editDVD(String title, int newKey, String newValue) throws DVDLibraryDaoException {
        if(title.equalsIgnoreCase(onlyDVD.getTitle())) {
            switch(newKey) {
                case 1:
                    LocalDate newDate = LocalDate.parse(newValue);
                    onlyDVD.setReleaseDate(newDate);
                    break;
                case 2:
                    onlyDVD.setMPAARating(newValue);
                    break;
                case 3:
                    onlyDVD.setDirectorName(newValue);
                    break;
                case 4:
                    onlyDVD.setStudio(newValue);
                    break;
                case 5:
                    onlyDVD.setUserNotes(newValue);
                    break;
                default:    
                    System.out.println("Unknown command");
            }
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public List<DVDLibrary> getAllDVD() throws DVDLibraryDaoException {
        return DVDList;
    }

    @Override
    public DVDLibrary getDVDInfo(String title) throws DVDLibraryDaoException {
        if(title.equalsIgnoreCase(onlyDVD.getTitle())) {
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public List<String> getAllTitles() throws DVDLibraryDaoException {
        List<String> titlesList= new ArrayList<>();
        titlesList.add(onlyDVD.getTitle());
        return titlesList;
    }
}
