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
public class Circle extends Shape {
    
    private double radius;

    public double area () {
        return this.radius * this.radius * 3.14;
    }
    
    public double perimeter() {
        return 2* 3.14 * this.radius;
    }
    
    public double area(double pRadius) {
        return pRadius * pRadius * 3.14;
    }
    
    public double perimeter(double pRadius) {
        return 2*pRadius * 3.14;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double pRadius) {
        this.radius = pRadius;
    }

    
}