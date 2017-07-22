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
public class House3DDesignSystem {
    
    double length, width, height;
    
    public House3DDesignSystem(double[] size) {
        this.length = size[0];
        this.width = size[1];
        this.height = size[2];
    }
    
    //get and set methods for length
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    
    //get and set methods for width
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    
    //get and set methods for height
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    
    //method to return area of the house
    public double getArea() {
        return length*width;
    }
    
}
