/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import com.sg.dvdlibrary.service.DVDLibraryDuplicateNameException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    private Map<String, DVDLibrary> DVDCollection = new HashMap<>();
    public static final String DVDLIBRARYFILENAME = "DVDLibrary.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public DVDLibrary addDVD(String title, DVDLibrary dvd) throws DVDLibraryDaoException {
        DVDLibrary newDVD = DVDCollection.put(title, dvd);
        writeDVDLibrary();
        return newDVD;
    }

    @Override
    public DVDLibrary removeDVD(String title) throws DVDLibraryDaoException {
        DVDLibrary removedDVD = DVDCollection.remove(title);
        writeDVDLibrary();
        return removedDVD;
    }

    @Override
    public DVDLibrary editDVD(String title, int changeFieldInt, String changeFieldValue) throws DVDLibraryDaoException {
        DVDLibrary editDVD = DVDCollection.get(title);
        String changeField = "";
        switch(changeFieldInt) {
            case 1:
                changeField = "releaseDate";
                LocalDate releaseDateChangeValue = LocalDate.parse(changeFieldValue);
                editDVD.setReleaseDate(releaseDateChangeValue);
                break;
            case 2:
                changeField = "MPAARating";
                //int rating = Integer.parseInt(changeFieldValue);
                editDVD.setMPAARating(changeFieldValue);
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

    @Override
    public List<DVDLibrary> getAllDVD()throws DVDLibraryDaoException{
        loadDVDLibraryFromFile();
        return new ArrayList<>(DVDCollection.values());
    }

    @Override
    public DVDLibrary getDVDInfo(String title) throws DVDLibraryDaoException{
        loadDVDLibraryFromFile();
        return DVDCollection.get(title);
    }

    @Override
    public List getAllTitles() throws DVDLibraryDaoException {
        loadDVDLibraryFromFile();
        return new ArrayList(DVDCollection.keySet());
    }
    private void loadDVDLibraryFromFile() throws DVDLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVDLIBRARYFILENAME)));
        } catch(FileNotFoundException  e) {
            throw new DVDLibraryDaoException ("Could not load data into memory", e);
        }
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVDLibrary currentDVD = new DVDLibrary(currentTokens[0]);
            LocalDate currentValue = LocalDate.parse(currentTokens[1]);
            currentDVD.setReleaseDate(currentValue);
            currentDVD.setMPAARating(currentTokens[2]);
            currentDVD.setDirectorName(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setUserNotes(currentTokens[4]);
            DVDCollection.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }
    private void writeDVDLibrary() throws DVDLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVDLIBRARYFILENAME));
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

    @Override
    public List<DVDLibrary> getAllDVDByDirector(String director) {
        return DVDCollection.values().stream()
                            .filter(dvd -> dvd.getDirectorName().equalsIgnoreCase(director))
                            .collect(Collectors.toList());
    }

    @Override
    public List<DVDLibrary> getAllDVDByStudio(String studio) {
        return DVDCollection.values().stream()
                            .filter(dvd -> dvd.getStudio().equalsIgnoreCase(studio))
                            .collect(Collectors.toList());
    }

    @Override
    public List<DVDLibrary> getAllDVDByRating(String rating) {
        return DVDCollection.values().stream()
                            .filter(dvd -> dvd.getMPAARating().equalsIgnoreCase(rating))
                            .collect(Collectors.toList());
    }

    @Override
    public List<DVDLibrary> getAllDVDReleasedIn(int numberOfYears) {
        return DVDCollection.values().stream()
                            .filter(dvd -> dvd.getDVDAge() < numberOfYears)
                            .collect(Collectors.toList());
    }
    
    @Override
    public DVDLibrary getOldestDVD() {
        return DVDCollection.values().stream()
                            .max(Comparator.comparing(dvd -> dvd.getDVDAge()))
                            .get();
    }

    @Override
    public DVDLibrary getNewestDVD() {
        return DVDCollection.values().stream()
                            .min(Comparator.comparing(dvd -> dvd.getDVDAge()))
                            .get();
    }
}
