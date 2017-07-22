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
public class carInventoryDealership {
    String brand, modelName, type;
    
    //constructor
    public carInventoryDealership(String[] carDetails) {
        this.brand = carDetails[0];
        this.modelName = carDetails[1];
        this.type = carDetails[2];
    }
    
    //get and set methods 
    public String getBrand() {
        return brand;
    }
    public String getModelName () {
        return modelName;
    }
    public String getType() {
        return type;
    }
    public void setBrand(String carBrand) {
        this.brand = carBrand;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    
}
