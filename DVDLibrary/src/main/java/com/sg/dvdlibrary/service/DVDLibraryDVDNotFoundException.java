/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDVDNotFoundException extends Exception{

    public DVDLibraryDVDNotFoundException(String message) {
        super(message);
    }

    public DVDLibraryDVDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
