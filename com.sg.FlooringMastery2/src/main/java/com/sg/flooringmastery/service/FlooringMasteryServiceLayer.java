/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryFileNotFoundException;
import com.sg.flooringmastery.dto.Order;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface FlooringMasteryServiceLayer {
    Order addOrder( List orderDetails, String state, double stateTax, String productType, 
                double productCost,double laborCost) throws FlooringMasteryDuplicateOrderException,
                                                            FlooringMasteryFileNotFoundException;
    List<String> getAllOrders(String orderDate) throws FlooringMasteryFileNotFoundException;
    void saveOrders() throws FlooringMasteryFileNotFoundException;
    List<Double> getProductCostLabor(String productType);
    double getStateTax(String state);
    boolean validateOrderToEdit(int orderToEdit);
    List<String> displayExistingFiles();
    //List<Order> getAllOrders() throws FlooringMasteryFileNotFoundException;
    Order removeOrder(int orderNumber) throws FlooringMasteryOrderNotFoundException;
    Order editOrder(int orderNumber, double newArea) throws FlooringMasteryOrderNotFoundException;
    //Order getOrderInfo(int orderNumber) throws FlooringMasteryOrderNotFoundException;
    //List<String> getOrderDates();
    //void loadOrders() throws FlooringMasteryFileNotFoundException;
    //void validateOrderSelection(int orderNumber) throws FlooringMasteryFileNotFoundException;
}