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
public class House {
    double[] coordinates = new double[2]; //array for length, width and height
    
    //constructor defined to set the length, width and height
    public House(double[] point) {
        this.coordinates[0]=point[0];
        this.coordinates[1]=point[1];
    }
    
    //method set
    public void setCoordinates(double[] point) {
        this.coordinates[0] = point[0];
        this.coordinates[1] = point[1];
    }
    
    //method get
    public double[] getCoordinates() {
        return coordinates;
    }
    
    
    //method to return area of the house
    public double area() {
        return this.coordinates[0]*this.coordinates[1];
    }
        
    
}
