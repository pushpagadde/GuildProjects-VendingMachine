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
    Order addOrder(Order order) ;
    //List<Order> getAllOrders(String orderDate) throws FlooringMasteryFileNotFoundException;
    void saveWork() throws FlooringMasteryFileNotFoundException;
    void saveWork(String fileName) throws FlooringMasteryFileNotFoundException;
    double getStateTax(String state);
    List<Double> getProductCostLabor(String productType);
    List<Order> listAllOrders() throws FlooringMasteryFileNotFoundException;
    //boolean checkFileExists(String fileName);
    boolean validateOrderToEdit(int orderToEdit);
    Order editOrder(int orderNumber, List<Double> newEntries);
    Order removeOrder(int orderNumber);
    double getProductCost(int orderNumber);
    double getLaborCostPerSquareFoot(int orderNumber);
    double getStateTax(int orderNumber);
    List<String> displayExistingFiles();
    List<String> loadOrdersFromFile(String orderFileName) throws FlooringMasteryFileNotFoundException;
    //void loadOrderFileByDate(Date orderDate) throws FlooringMasteryFileNotFoundException;
    //List<String> getOrderDates();
    
    //Order findOrder(int orderNumber) ;
    
}
