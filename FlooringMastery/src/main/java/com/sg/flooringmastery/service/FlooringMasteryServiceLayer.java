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
    void loadOrders() throws FlooringMasteryFileNotFoundException;
    void saveOrders() throws FlooringMasteryFileNotFoundException;
    List<Order> getAllOrders() throws FlooringMasteryFileNotFoundException;
    Order addOrder( List orderDetails, String state, double stateTax, String productType, 
                double productCost,double laborCost) throws FlooringMasteryDuplicateOrderException;
    Order removeOrder(int orderNumber) throws FlooringMasteryOrderNotFoundException;
    Order editOrder(int orderNumber, double newTotal) throws FlooringMasteryOrderNotFoundException;
    Order getOrderInfo(int orderNumber) throws FlooringMasteryOrderNotFoundException;
    List<Double> getProductCostLabor(String productType);
    double getStateTax(String state);
    List<String> getOrderDates();
    List<Order> getAllOrders(String orderDate) throws FlooringMasteryFileNotFoundException;
    //void validateOrderSelection(int orderNumber) throws FlooringMasteryFileNotFoundException;
}