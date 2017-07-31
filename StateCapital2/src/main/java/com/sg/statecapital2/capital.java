/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapital2;

/**
 *
 * @author apprentice
 */
class capital {
    private String nameOfCapital;
    private double squareMileage;
    private double population;

    public capital(String pNameOfCapital, double pPopulation, double pSquareMileage) {
        this.nameOfCapital = pNameOfCapital;
        this.population = pPopulation;
        this.squareMileage = pSquareMileage;
    }
    
    
    
    public String getNameOfCapital() {
        return nameOfCapital;
    }

    public void setNameOfCapital(String nameOfCapital) {
        this.nameOfCapital = nameOfCapital;
    }

    public double getSquareMileage() {
        return squareMileage;
    }

    public void setSquareMileage(double squareMileage) {
        this.squareMileage = squareMileage;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }
    
    
}
