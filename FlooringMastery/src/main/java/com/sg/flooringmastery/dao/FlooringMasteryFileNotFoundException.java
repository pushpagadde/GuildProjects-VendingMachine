/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.dao;

/**
 *
 * @author apprentice
 */
public class VendingMachineFileNotFoundException extends Exception {
    
    public VendingMachineFileNotFoundException(String message) {
        super(message);
    }
    public VendingMachineFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
