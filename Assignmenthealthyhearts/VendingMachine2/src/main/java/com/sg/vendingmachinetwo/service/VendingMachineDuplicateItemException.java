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
public class VendingMachineDuplicateItemException extends Exception{
    public VendingMachineDuplicateItemException(String message) {
        super(message);
    }
    public VendingMachineDuplicateItemException(String message, Throwable cause) {
        super(message, cause);
    }
}
