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
        onlyOrder.setMaterialCost();//Double.parseDouble("921.3")
        onlyOrder.setLaborCost();//Double.parseDouble("777.0")
        onlyOrder.setTax();//Double.parseDouble("13.50")
        onlyOrder.setTotal();//Double.parseDouble("2650.03")
        orderList.add(onlyOrder);
    }
    
    @Override
    public Order addOrder(Order order, String fileName) {
        if (order.getOrderNumber() == onlyOrder.getOrderNumber()) {
            return order;
        }else {
            return null;
        }
    }
    
    public List<String> getProductTypes( ) {
        List<String> products = new ArrayList<>();
        products.add("Carpet");
        products.add("Wood");
        products.add("Tile");
        products.add("Vynal");
        
        return products;
    }
    
    public List<String> getStatesList() {
        List<String> states = new ArrayList<>();
        states.add("OH");
        states.add("VA");
        states.add("WV");
        states.add("PA");
        return states;
    }
    
    public double getArea(int orderToEdit) {
        return onlyOrder.getArea();
    }
    
    public String getProductType(int orderToEdit) {
        return onlyOrder.getProductType();
    }
    
    public String getState(int orderToEdit){
        
        return onlyOrder.getState();
    }
    
    public String getCustomerName(int orderToEdit) {
        return onlyOrder.getCustomerName();
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
    public Order editOrder(int orderNumber, List<Double> newEntries,String productType, 
            String state, String fileName, String customerName, String fileToAddTo) {
        //1::CustomerName::OH::6.25::Carpet::100.0::2.1::2.25::210.0::225.0::13.27::225.52::
        onlyOrder.setState(state);
        onlyOrder.setProductType(productType);
        onlyOrder.setArea(newEntries.get(0));
        onlyOrder.setMaterialCost();//newEntries.get(1)
        onlyOrder.setLaborCost();//newEntries.get(2)
        onlyOrder.setTax();//newEntries.get(3)
        onlyOrder.setCustomerName(customerName);
        onlyOrder.setTotal();//newEntries.get(4)
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
    public double getStateTax(String state) {
        return onlyOrder.getTaxRate();
    }

    @Override
    public List<Double> getProductCostLabor(String productType) {
        List<Double> costLabor = new ArrayList<>();
        costLabor.add(onlyOrder.getLaborCostPerSquareFoot());
        costLabor.add(onlyOrder.getCostPerSquareFoot());
        return costLabor;
    }

    @Override
    public double getProductCost(int orderNumber) {
        return onlyOrder.getCostPerSquareFoot();
    }

    @Override
    public double getLaborCostPerSquareFoot(int orderNumber) {
        return onlyOrder.getLaborCostPerSquareFoot();
    }

    @Override
    public double getStateTax(int orderNumber) {
        return onlyOrder.getTax();
    }
}
