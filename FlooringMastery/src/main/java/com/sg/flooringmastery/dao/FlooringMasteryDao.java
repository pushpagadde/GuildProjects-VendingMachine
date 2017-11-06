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
    List<Order> listAllOrders() throws FlooringMasteryFileNotFoundException;
    Order findOrder(int orderNumber) ;
    Order addOrder(Order order) ;
    Order editOrder(int orderNumber, double newTotal) ;
    Order removeOrder(int orderNumber);
    void loadOrderFileByDate(Date orderDate) throws FlooringMasteryFileNotFoundException;
    void saveWork() throws FlooringMasteryFileNotFoundException;
    double getStateTax(String state);
    List<Double> getProductCostLabor(String productType);
    List<String> getOrderDates();
    List<Order> getAllOrders(String orderDate) throws FlooringMasteryFileNotFoundException;
    
}
