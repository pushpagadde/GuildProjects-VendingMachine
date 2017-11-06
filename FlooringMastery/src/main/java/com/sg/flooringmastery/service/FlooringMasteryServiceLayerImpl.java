/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.sg.flooringmastery.dao.FlooringMasteryFileNotFoundException;
import com.sg.flooringmastery.dto.Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {
    FlooringMasteryDao dao;
//    FlooringMasteryAuditDao auditDao;
    public FlooringMasteryServiceLayerImpl(FlooringMasteryDao dao) {
        this.dao = dao;
        //this.auditDao = auditDao;
    }
    
    @Override
    public void loadOrders() throws FlooringMasteryFileNotFoundException{
        dao.loadOrderFileByDate(new Date());
    }
    
    @Override
    public void saveOrders() throws FlooringMasteryFileNotFoundException{
        dao.saveWork();
    }
    
    @Override
    public Order addOrder( List orderDetails, String state, double stateTax, String productType, 
                double productCost,double laborCost) throws FlooringMasteryDuplicateOrderException{
        Order order = new Order();
        order.setCustomerName(orderDetails.get(0).toString());
        order.setState(state);
        order.setTaxRate(stateTax);
        order.setProductType(productType);
        double area = ((Double)orderDetails.get(1)).doubleValue();
        order.setArea(area);
        order.setCostPerSquareFoot(productCost);
        order.setLaborCostPerSquareFoot(laborCost);
        double materialCost = area * productCost;
        order.setMaterialCost(materialCost);
        double labourCost = laborCost * area;
        order.setLaborCost(labourCost);
        double totalTax = stateTax * 0.01 * (materialCost + laborCost);
        order.setTax(totalTax);
        double totalAmount = materialCost + laborCost + totalTax;
        order.setTotal(totalTax);
        dao.addOrder(order);
        return order;
    }
    
    @Override
    public List<Order> getAllOrders(String orderDate) throws FlooringMasteryFileNotFoundException{
        return dao.getAllOrders(orderDate);
        //return dao.getAllOrders(String orderdate);
    }
    
    @Override
    public List<String> getOrderDates() {
        return dao.getOrderDates();
    }
    
    
    @Override
    public Order removeOrder(int orderNumber) throws FlooringMasteryOrderNotFoundException{
        return dao.removeOrder(orderNumber);
    }
    
    @Override
    public Order editOrder(int orderNumber, double newArea) throws FlooringMasteryOrderNotFoundException{
        Order editOrder = dao.findOrder(orderNumber);
        if (editOrder == null) {
            throw new FlooringMasteryOrderNotFoundException("Order Not Found to edit");
        }
        editOrder = dao.editOrder(orderNumber, newArea);
        return editOrder;
    }
    
    @Override
    public Order getOrderInfo(int orderNumber) throws FlooringMasteryOrderNotFoundException{
        Order findOrder = dao.findOrder(orderNumber);
        if (findOrder == null) {
            throw new FlooringMasteryOrderNotFoundException("Order Not Found.");
        }
        return findOrder;
    }
    
    public List<Double> getProductCostLabor(String productType) {
        return dao.getProductCostLabor(productType);
    }
    
    public double getStateTax(String state){
        
        return dao.getStateTax(state);
    }

    @Override
    public List<Order> getAllOrders() throws FlooringMasteryFileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}