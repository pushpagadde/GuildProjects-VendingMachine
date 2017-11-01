/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryDuplicateOrderException extends Exception{
    public FlooringMasteryDuplicateOrderException(String message) {
        super(message);
    }
    public FlooringMasteryDuplicateOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
