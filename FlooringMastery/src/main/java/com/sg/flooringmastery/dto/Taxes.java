/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class Taxes {
    String state;
    double tax;

    public Taxes() {
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    
}
