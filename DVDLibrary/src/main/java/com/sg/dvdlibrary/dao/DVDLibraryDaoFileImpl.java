/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    private Map<String, DVDLibrary> DVD = new HashMap<>();
    public static final String DVDLIBRARY = "DVDLibrary.txt";
    public static final String DELIMITER = "::";
    
    /**
     * 
     * @param title
     * @param dvd
     * @return DVDLibrary
     * @throws DVDLibraryDaoException
     */
    @Override
    public DVDLibrary addDVD(String title, DVDLibrary dvd) throws DVDLibraryDaoException {
        DVDLibrary newDVD = DVD.put(title, dvd);
        writeDVDLibrary();
        return newDVD;
    }

    /**
     *
     * @param title
     * @return
     * @throws DVDLibraryDaoException
     */
    @Override
    public DVDLibrary removeDVD(String title) throws DVDLibraryDaoException {
        DVDLibrary removedDVD = DVD.remove(title);
        writeDVDLibrary();
        return removedDVD;
    }

    /**
     *
     * @param title
     * @param changeFieldInt
     * @param changeFieldValue
     * @return
     * @throws DVDLibraryDaoException
     */
    @Override
    public DVDLibrary editDVD(String title, int changeFieldInt, String changeFieldValue) throws DVDLibraryDaoException {
        DVDLibrary editDVD = DVD.get(title);
        String changeField = "";
        switch(changeFieldInt) {
            case 1:
                changeField = "releaseDate";
                editDVD.setReleaseDate(changeFieldValue);
                break;
            case 2:
                changeField = "MPAARating";
                int rating = Integer.parseInt(changeFieldValue);
                editDVD.setMPAARating(rating);
                break;
            case 3:
                changeField = "directorName";
                editDVD.setDirectorName(changeFieldValue);
                break;
            case 4:
                changeField = "studio";
                editDVD.setStudio(changeFieldValue);
                break;
            case 5:
                changeField = "userNotes";
                editDVD.setUserNotes(changeFieldValue);
                break;
            default:    
                System.out.println("Unknown command");
        }
        System.out.println("Change complete");
        writeDVDLibrary();
        return editDVD;
    }

    /**
     *
     * @return
     * @throws DVDLibraryDaoException
     */
    @Override
    public List<DVDLibrary> getAllDVD()throws DVDLibraryDaoException{
        loadDVDLibraryFromFile();
        return new ArrayList<>(DVD.values());
    }

    /**
     *
     * @param title
     * @return
     * @throws DVDLibraryDaoException
     */
    @Override
    public DVDLibrary getDVDInfo(String title) throws DVDLibraryDaoException{
        loadDVDLibraryFromFile();
        return DVD.get(title);
    }

    /**
     *
     * @return
     * @throws DVDLibraryDaoException
     */
    @Override
    public List getAllTitles() throws DVDLibraryDaoException {
        loadDVDLibraryFromFile();
        return new ArrayList(DVD.keySet());
    }
    private void loadDVDLibraryFromFile() throws DVDLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY)));
        } catch(FileNotFoundException  e) {
            throw new DVDLibraryDaoException ("Could not load data into memory", e);
        }
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVDLibrary currentDVD = new DVDLibrary(currentTokens[0]);
            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setMPAARating(Integer.parseInt(currentTokens[2]));
            currentDVD.setDirectorName(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setUserNotes(currentTokens[4]);
            DVD.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }
    private void writeDVDLibrary() throws DVDLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVDLIBRARY));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save data", e);
        }
        
        List<DVDLibrary> DVDList = this.getAllDVD();
        for(DVDLibrary currentDVD : DVDList) {
            String completeRecord;
            completeRecord = currentDVD.getTitle() + DELIMITER;
            completeRecord = completeRecord + currentDVD.getReleaseDate() + DELIMITER;
            completeRecord = completeRecord + currentDVD.getMPAARating() + DELIMITER;
            completeRecord = completeRecord + currentDVD.getDirectorName() + DELIMITER;
            completeRecord = completeRecord + currentDVD.getStudio() + DELIMITER;
            completeRecord = completeRecord + currentDVD.getUserNotes();
            out.println(completeRecord);
            out.flush();
        }
        out.close();
    }
}
