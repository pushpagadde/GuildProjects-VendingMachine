/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.exception;

/**
 *
 * @author apprentice
 */
public class DVDNotFoundException extends Exception{
    public DVDNotFoundException(String message) {
        super(message);
    }
}
