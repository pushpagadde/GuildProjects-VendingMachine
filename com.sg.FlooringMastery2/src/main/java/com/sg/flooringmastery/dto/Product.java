/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class Product {
    String product;
    double cost;
    double labor;

    public Product() {
        //this.product = product;
        
    }
     
    
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getLabor() {
        return labor;
    }

    public void setLabor(double labor) {
        this.labor = labor;
    }
   
    
}
