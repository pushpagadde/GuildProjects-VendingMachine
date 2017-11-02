/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryDaoStubImpl implements FlooringMasteryDao {
    Order onlyOrder;
    List<Order> orderList = new ArrayList<>();
//1::CustomerName::OH::6.25::Carpet::100.0::2.1::2.25::210.0::225.0::13.27::225.52::
    public FlooringMasteryDaoStubImpl() {
        onlyOrder = new Order();
        onlyOrder.setOrderNumber(1);
        onlyOrder.setCustomerName("Name 1");
        onlyOrder.setState("OH");
        onlyOrder.setTaxRate(Double.parseDouble("6.25") );
        onlyOrder.setProductType("Carpet");
        onlyOrder.setArea(Double.parseDouble("222.0"));
        onlyOrder.setCostPerSquareFoot(Double.parseDouble("2.1"));
        onlyOrder.setLaborCostPerSquareFoot(Double.parseDouble("2.25"));
        onlyOrder.setMaterialCost(Double.parseDouble("921.3"));
        onlyOrder.setLaborCost(Double.parseDouble("777.0"));
        onlyOrder.setTax(Double.parseDouble("13.50"));
        onlyOrder.setTotal(Double.parseDouble("2650.03"));
        orderList.add(onlyOrder);
    }
    
    @Override
    public Order addOrder(Order order) {
        if (order.getOrderNumber() == onlyOrder.getOrderNumber()) {
            return order;
        }else {
            return null;
        }
    }
    
    @Override
    public List<Order> listAllOrders() throws FlooringMasteryFileNotFoundException {
        return orderList;
    }

    @Override
    public boolean validateOrderToEdit(int orderToEdit) {
        if (onlyOrder.getOrderNumber() == orderToEdit){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Order editOrder(int orderNumber, List<Double> newEntries) {
        //1::CustomerName::OH::6.25::Carpet::100.0::2.1::2.25::210.0::225.0::13.27::225.52::
        onlyOrder.setArea(newEntries.get(0));
        onlyOrder.setMaterialCost(newEntries.get(1));
        onlyOrder.setLaborCost(newEntries.get(2));
        onlyOrder.setTax(newEntries.get(3));
        onlyOrder.setTotal(newEntries.get(4));
        return onlyOrder;
    }

    @Override
    public Order removeOrder(int orderNumber) {
        return onlyOrder;
    }

    @Override
    public List<String> displayExistingFiles() {
        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Orders_10282017.txt");
        listOfNames.add("Orders_10292017.txt");
        return listOfNames;
    }

    @Override
    public List<String> loadOrdersFromFile(String orderFileName) throws FlooringMasteryFileNotFoundException {
        List<String> listOfOrders = new ArrayList<>();
        listOfOrders.add("1::CustomerName::OH::6.25::Carpet::100.0::2.1::2.25::210.0::225.0::13.27::225.52::");
        return listOfOrders;
    }

    @Override
    public void saveWork() throws FlooringMasteryFileNotFoundException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //do nothing
    }

    @Override
    public void saveWork(String fileName) throws FlooringMasteryFileNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //do nothing
    }

    @Override
    public double getStateTax(String state) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return onlyOrder.getTaxRate();
    }

    @Override
    public List<Double> getProductCostLabor(String productType) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Double> costLabor = new ArrayList<>();
        costLabor.add(onlyOrder.getLaborCostPerSquareFoot());
        costLabor.add(onlyOrder.getCostPerSquareFoot());
        return costLabor;
    }

    @Override
    public double getProductCost(int orderNumber) {
        return onlyOrder.getCostPerSquareFoot();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getLaborCostPerSquareFoot(int orderNumber) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return onlyOrder.getLaborCostPerSquareFoot();
    }

    @Override
    public double getStateTax(int orderNumber) {
        return onlyOrder.getTax();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}