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
public class DVDLibraryDataValidationException extends Exception{

    public DVDLibraryDataValidationException(String message) {
        super(message);
    }

    public DVDLibraryDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
