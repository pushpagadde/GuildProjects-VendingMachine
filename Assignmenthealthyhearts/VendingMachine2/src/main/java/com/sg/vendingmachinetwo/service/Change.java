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
public class Change {
    private int totalDollar  = 0;
    private int totalQuarter = 0;
    private int totalDime    = 0;
    private int totalNickel  = 0;
    private int totalPenny   = 0;
    
    public Change() {
    }

    public int getTotalDollar() {
        return totalDollar;
    }

    public int getTotalQuarter() {
        return totalQuarter;
    }

    public int getTotalDime() {
        return totalDime;
    }

    public int getTotalNickel() {
        return totalNickel;
    }

    public int getTotalPenny() {
        return totalPenny;
    }

    public void setTotalDollar(double totalDollarDouble) {
        this.totalDollar = (int)totalDollarDouble;
    }

    public void setTotalQuarter(double totalQuarterDouble) {
        this.totalQuarter = (int)totalQuarterDouble;
    }

    public void setTotalDime(double totalDimeDouble) {
        this.totalDime = (int) totalDimeDouble;
    }

    public void setTotalNickel(double totalNickelDouble) {
        this.totalNickel = (int) totalNickelDouble;
    }

    public void setTotalPenny(double totalPennyDouble) {
        this.totalPenny = (int) totalPennyDouble;
    }
}