/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapes;

/**
 *
 * @author apprentice
 */
public class Square extends Shape{
    private double length;

    //code to find and return area of shape
    public double area () {
        return this.length * this.length;
    }
    //code to return perimeter of shape
    public double perimeter() {
        return 4*(this.length );
    }
    /*
    public double area(double pLength) {
        return pLength*pLength;
    }
    
    public double perimeter(double pLength) {
        return 4*(pLength);
    }*/
    
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
}