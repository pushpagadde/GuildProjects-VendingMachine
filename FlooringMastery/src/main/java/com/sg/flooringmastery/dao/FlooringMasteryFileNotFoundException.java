/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryFileNotFoundException extends Exception {
    
    public FlooringMasteryFileNotFoundException(String message) {
        super(message);
    }
    public FlooringMasteryFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
