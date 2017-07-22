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
public class IcecreamInventorySystem {
    String brand, flavor;
    double size, price;
    
    //constructor to initilize
    public IcecreamInventorySystem(String brand, String flavor, double size, double price) {
        this.brand = brand;
        this.flavor = flavor;
        this.price = price;
        this.size = size;
    }
    
    //get methods to return values
    public String getBrand() {
        return brand;
    }
    public String getFlavor() {
        return flavor;
    }
    public double getSize() {
        return size;
    }
    public double getPrice() {
        return price;
    }
    
    //set methods to initialize all variable
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setSize(double size) {
        this.size = size;
    }
    
    //method to see if count is enough or order more
    public void count() {
        
    }
}
