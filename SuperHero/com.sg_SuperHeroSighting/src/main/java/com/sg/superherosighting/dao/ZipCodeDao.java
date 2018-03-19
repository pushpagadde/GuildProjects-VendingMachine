/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.util.List;
import com.sg.superherosighting.model.ZipCodeInfo;

/**
 *
 * @author PG
 */
public interface ZipCodeDao {

    //methods for zipcode Table
    //public void updateZipCode(ZipCodeInfo zipCode);//3
    public void addZipCode(ZipCodeInfo zipCode);//1
    public void deleteZipCode(String zipCode);//2    
    public ZipCodeInfo getZipCodeByID(String zipCode);//4
    public List<ZipCodeInfo> getAllZipCodes();    //5
}
