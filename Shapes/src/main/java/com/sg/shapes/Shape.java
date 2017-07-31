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
abstract class Shape {
    private String color;
    //private double length;
    //private double width;
    //private double radius;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
  
       
    abstract public double area();
    abstract public double perimeter();
    //abstract public void circumference();        
    
}
