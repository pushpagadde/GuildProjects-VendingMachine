/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.service;

/**
 *
 * @author apprentice
 */
public class VendingMachineItemNotFoundException extends Exception{
    public VendingMachineItemNotFoundException(String message) {
        super(message);
    }
    public VendingMachineItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
