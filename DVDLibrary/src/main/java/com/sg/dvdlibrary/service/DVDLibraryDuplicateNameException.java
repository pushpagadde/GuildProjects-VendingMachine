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
public class DVDLibraryDuplicateNameException extends Exception{

    public DVDLibraryDuplicateNameException(String message) {
        super(message);
    }

    public DVDLibraryDuplicateNameException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
