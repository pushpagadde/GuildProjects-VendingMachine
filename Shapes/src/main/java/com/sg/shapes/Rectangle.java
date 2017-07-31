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
public class Rectangle extends Shape{
    
    private double length, width;

    public double area () {
        return this.length * this.width;
    }
    
    public double perimeter() {
        return 2*(this.length + this.width);
    }
    
    public double area(double pLength, double pWidth) {
        return pLength*pWidth;
    }
    
    public double perimeter(double pLength, double pWidth) {
        return 2*(pLength + pWidth);
    }
    
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }   
    
    
}
