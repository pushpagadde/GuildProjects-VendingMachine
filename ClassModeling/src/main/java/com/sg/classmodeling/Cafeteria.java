/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classmodeling;

/**
 *
 * @author apprentice
 */
class Cafeteria {
    private int numberOfStoves, seatingCapacity, numberOfServingLines, mealsPerHour;
    private double squareFootage;

    public Cafeteria(int numberOfStoves, int seatingCapacity, int numberOfServingLines, int mealsPerHour, double squareFootage) {
        this.numberOfStoves = numberOfStoves;
        this.seatingCapacity = seatingCapacity;
        this.numberOfServingLines = numberOfServingLines;
        this.mealsPerHour = mealsPerHour;
        this.squareFootage = squareFootage;
    }

    public int getNumberOfStoves() {
        return numberOfStoves;
    }

    public void setNumberOfStoves(int numberOfStoves) {
        this.numberOfStoves = numberOfStoves;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getNumberOfServingLines() {
        return numberOfServingLines;
    }

    public void setNumberOfServingLines(int numberOfServingLines) {
        this.numberOfServingLines = numberOfServingLines;
    }

    public int getMealsPerHour() {
        return mealsPerHour;
    }

    public void setMealsPerHour(int mealsPerHour) {
        this.mealsPerHour = mealsPerHour;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }
    
    
    
}
