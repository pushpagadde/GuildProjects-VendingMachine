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
public class Triangle extends Shape{

    private double base, height, side1, side2, side3;

    public double area () {
        return (this.base * this.height)/2;
    }
    
    public double perimeter() {
        return side1+side2+side3;
    }
    
    public double area(double pBase, double pHeight) {
        return pBase*pHeight;
    }
    
    public double perimeter(double pSide1, double pSide2, double pSide3) {
        return pSide1+pSide2+pSide3;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    
}
