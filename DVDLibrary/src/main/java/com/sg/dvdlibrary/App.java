/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.exception.DVDNotFoundException;
import com.sg.dvdlibrary.ui.DVDLibraryUserIO;
import com.sg.dvdlibrary.ui.DVDLibraryUserIOConsoleImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;


/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) { 
        DVDLibraryUserIO myIO = new DVDLibraryUserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIO);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        try {
            controller.run();
        } catch( Exception e) {
            System.out.println("Error");
        }
                

    }
}
