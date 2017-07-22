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
public class AirTrafficControlSystem {
    
    double neCoordinate, swCoordinate;
    
    //constructor to initialize the coordinates
    public AirTrafficControlSystem(double[] coordinates) {
        this.neCoordinate = coordinates[0];
        this.swCoordinate = coordinates[1];
    }
    
    //get and set methods to detect position of aircraft
    public void setNECoordinate(double nedirection) {
        this.neCoordinate = nedirection;
    }
    
    public void setSWCoordinate(double swdirection) {
        this.swCoordinate = swdirection;
    }
    public double getNECoordinate() {
        return neCoordinate;
    }
    public double getSWCoordinate() {
        return swCoordinate;
    }
    
    //method to check collision
    public void collision(double[] aircraft2coordinates ) {
        if (aircraft2coordinates[0]<=this.neCoordinate + 5 || aircraft2coordinates[1] >=this.neCoordinate ) {
            System.out.println("Another craft too close to this craft");
        }
    }
}
