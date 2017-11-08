/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface FlooringMasteryDao {
    Order addOrder(Order order, String fileName) ;
    void saveWork() throws FlooringMasteryFileNotFoundException;
    void saveWork(String fileName) throws FlooringMasteryFileNotFoundException;
    double getStateTax(String state);
    List<Double> getProductCostLabor(String productType);
    boolean validateOrderToEdit(int orderToEdit);
    Order editOrder(int orderNumber, List<Double> newEntries, String productType, String state, String fileName) 
            throws FlooringMasteryFileNotFoundException;
    Order removeOrder(int orderNumber);
    String getProductType(int orderToEdit);
    String getState(int orderToEdit);
    double getProductCost(int orderNumber);
    double getLaborCostPerSquareFoot(int orderNumber);
    double getStateTax(int orderNumber);
    double getArea(int orderToEdit);
    List<String> displayExistingFiles();
    List<String> loadOrdersFromFile(String orderFileName) throws FlooringMasteryFileNotFoundException;
}
