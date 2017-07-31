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
public class Capital {

    private int scoreMath, scoreScience, scoreLA;
    
    public Capital(){
        
    }
    
    public Capital(int pscoreMath, int pscoreScience, int pscoreLA) {
        this.scoreMath = pscoreMath;
        this.scoreScience = pscoreScience;
        this.scoreLA = pscoreLA;
    }
    
    public String displayAll() {
        String state;
        state = this.nameOfCapital + " | " + this.population + " | " + this.squareMileage;
        return state;
    }
    
    
    public String getNameOfCapital() {
        return nameOfCapital;
    }

    public void setNameOfCapital(String nameOfCapital) {
        this.nameOfCapital = nameOfCapital;
    }
    
    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }
    
    public double getSquareMileage() {
        return squareMileage;
    }

    public void setSquareMileage(double squareMileage) {
        this.squareMileage = squareMileage;
    }
    
}
