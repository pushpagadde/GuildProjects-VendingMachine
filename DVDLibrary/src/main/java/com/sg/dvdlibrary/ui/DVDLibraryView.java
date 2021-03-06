/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVDLibrary;
import com.sg.dvdlibrary.exception.DVDNotFoundException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryView {
    private DVDLibraryUserIO io = new DVDLibraryUserIOConsoleImpl();
    
    public DVDLibraryView (DVDLibraryUserIO io) {
        this.io = io;
        ///touching to submit back
    }
    public int printMenuAndGetSelection() {
            io.print("======Main Menu:======");
            io.print("1. Add DVD to Library");
            io.print("2. Remove DVD from Library");
            io.print("3. Edit DVD in Library");
            io.print("4. List all DVD in Library");
            io.print("5. Search by Title");
            io.print("6. List all Titles");
            io.print("7. Exit");
            return io.readInt("Enter selection", 1, 7);
    }
    public void unknownCommand(){
        io.print("Unknown Command");
    }
    public DVDLibrary getDVDInfo() {
        io.print("Enter new DVD Details");
        String title = io.readString("Enter title of DVD");
        
        boolean invalidDate = true;
        LocalDate releaseDateField = null;
        String releaseDate = null;
        do {
            releaseDate = io.readString("Enter Release Date");
            try{
                releaseDateField = LocalDate.parse(releaseDate);
            }catch (java.lang.Exception e){
                System.out.println("print"+e);
                continue;
            }
            invalidDate = validateDate(releaseDateField);
            if(invalidDate) {
                System.out.println("Entered date should not be after today's date.");
            }
        }while(invalidDate);
        
        String rating = io.readString("Enter MPAA rating");
        String directorName = io.readString("Enter Directors name");
        String studio = io.readString("Enter name of Studio");
        String userNotes = io.readString("Enter user notes");
        DVDLibrary currentDVD = new DVDLibrary(title);
        currentDVD.setReleaseDate(releaseDateField);
        currentDVD.setMPAARating(rating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserNotes(userNotes);
        io.print("New DVD added to Library");
        return currentDVD;
    }
    
    private boolean validateDate(LocalDate releaseDate) {
        if(releaseDate.isBefore(LocalDate.now())) {
            return false;
        } else {
            return true;
        }
    }
    
    public String getTitleChoice(String action) {
        return io.readString("Enter title " + action);
    }
    public int getNewDVDEditInfo() {
        int editChoice = getWhatToEdit();
        return editChoice;
    }
    private int getWhatToEdit(){
        io.print("=======Menu for Edit=======");
        io.print("1. Release Date");
        io.print("2. MPAA Rating");
        io.print("3. Directors name");
        io.print("4. Studio");
        io.print("5. User Notes");
        return io.readInt("Enter selection 1 to 5", 1, 5);
    }
    public String changeFieldInfo() {
        return io.readString("Enter the new value");
    }
    public void displayDVDList(List<DVDLibrary> DVDList) {
        for(DVDLibrary currentDVD : DVDList) {
            String allDetails;
            allDetails = currentDVD.getTitle() ;
            allDetails = allDetails + " " +  currentDVD.getReleaseDate();
            allDetails = allDetails + " " +  currentDVD.getMPAARating();
            allDetails = allDetails + " " +  currentDVD.getDirectorName();
            allDetails = allDetails + " " +  currentDVD.getStudio();
            allDetails = allDetails + " " +  currentDVD.getUserNotes();
            io.print(allDetails);
        }
        io.readString("Please hit enter to continue");
    }
    public void displayDVDInfo(DVDLibrary DVDInfo) throws DVDNotFoundException{
        if(DVDInfo == null) {
            throw new DVDNotFoundException("DVD Not Found");
        } else {
            String allDetails;
            allDetails = DVDInfo.getTitle();
            allDetails = allDetails + " " + DVDInfo.getReleaseDate();
            allDetails = allDetails + " " +  DVDInfo.getMPAARating();
            allDetails = allDetails + " " +  DVDInfo.getDirectorName();
            allDetails = allDetails + " " +  DVDInfo.getStudio();
            allDetails = allDetails + " " +  DVDInfo.getUserNotes();
            io.print(allDetails);
        }
        io.readString("Please hit enter to continue");
    }
    public void displayAllTitles(List<String> DVDTitleList) {
        for(int i=0; i<DVDTitleList.size(); i++) {
            io.print(DVDTitleList.get(i));
        }
        io.print("All titles printed");
        io.readString("Please hit enter to continue");
    }
    public int getCount(String operation) {
        int count = io.readInt("Enter how many records would you like to "+ operation + " ?", 0, 10);
        return count;
    }
    public void displayErrorMessage(String errorMsg) {
        io.print("=====ERROR=====");
        io.print(errorMsg);
    }
}
