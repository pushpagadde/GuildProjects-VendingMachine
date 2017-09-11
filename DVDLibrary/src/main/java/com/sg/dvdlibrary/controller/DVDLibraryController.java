/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.dto.DVDLibrary;
import com.sg.dvdlibrary.exception.DVDNotFoundException;
import com.sg.dvdlibrary.ui.DVDLibraryUserIO;
import com.sg.dvdlibrary.ui.DVDLibraryUserIOConsoleImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {
    private DVDLibraryUserIO io = new DVDLibraryUserIOConsoleImpl();
    DVDLibraryView view;// = new DVDLibraryView();
    DVDLibraryDao dao = new DVDLibraryDaoFileImpl();

    public DVDLibraryController(DVDLibraryDao myDao, DVDLibraryView myView) {
        this.view = myView;
        this.dao = myDao;
    }
    public void run() throws DVDNotFoundException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch(menuSelection) {
                    case 1: 
                        io.print("Add"); 
                        addDVD();
                        break;
                    case 2:
                        io.print("Remove");
                        removeDVD();
                        break;
                    case 3: 
                        io.print("Edit");
                        editDVD();
                        break;
                    case 4:
                        io.print("List all");
                        listDVD();
                        break;
                    case 5:
                        io.print("Display info");
                        getDVDInfo();
                        break;
                    case 6:
                        io.print("Search by title");
                        searchByTitle();
                        break;
                    case 7:
                        io.print("Exit");
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            
            io.print("Good bye!");
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    } 
    //methods used above are defined here
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void unknownCommand(){
        view.unknownCommand();
    }
    private void addDVD() throws DVDLibraryDaoException{
        int count;
        count = view.getCount(" add");
        for(int c=0; c<count; c++) {
            DVDLibrary newDVD = view.getDVDInfo();
            dao.addDVD(newDVD.getTitle(), newDVD);
        }
    }
    private void removeDVD()throws DVDLibraryDaoException {
        int count;
        count = view.getCount(" remove");
        for(int c=0; c< count; c++) {
            String title = view.getTitleChoice(" to delete");
            dao.removeDVD(title);
        }
    }
    private void editDVD()throws DVDLibraryDaoException {
        int count;
        count = view.getCount(" edit");
        for(int c=0; c< count; c++) {
            String title = view.getTitleChoice(" to edit");
            dao.getDVDInfo(title);
            int changeFieldInt = view.getNewDVDEditInfo();
            String changeFieldInfo = view.changeFieldInfo();
            dao.editDVD(title, changeFieldInt, changeFieldInfo);
        }
    }
    private void listDVD() throws DVDLibraryDaoException {
        List<DVDLibrary> DVDList = dao.getAllDVD();
        view.displayDVDList(DVDList);
    }
    private void getDVDInfo() throws DVDLibraryDaoException {
        String title = view.getTitleChoice("to view");
        DVDLibrary DVDInfo = dao.getDVDInfo(title);
        try {
            view.displayDVDInfo(DVDInfo);
        } catch ( DVDNotFoundException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    private void searchByTitle() throws DVDLibraryDaoException, DVDNotFoundException {
        List<String> DVDTitleList = dao.getAllTitles();
        view.displayAllTitles(DVDTitleList);
    }
}
