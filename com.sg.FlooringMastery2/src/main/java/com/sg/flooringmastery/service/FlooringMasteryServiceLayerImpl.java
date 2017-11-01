/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.sg.flooringmastery.dao.FlooringMasteryFileNotFoundException;
import com.sg.flooringmastery.dto.Order;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {
    FlooringMasteryDao dao;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public FlooringMasteryServiceLayerImpl(FlooringMasteryDao dao) {
        this.dao = dao;
    }
    
    @Override
    public List<String> getAllOrders(String fileName) throws FlooringMasteryFileNotFoundException{
        return dao.loadOrdersFromFile(fileName);
    }
    
    @Override
    public void saveOrders() throws FlooringMasteryFileNotFoundException{
        String newFile = makeOrderFileName();
        if(dao.displayExistingFiles().contains(newFile)){
            dao.saveWork();
        }else {
            dao.saveWork(newFile);
        }
    }
    
    private String makeOrderFileName() {
        String fileName;
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
        String folderDate = formatter.format(today);
        fileName = "Orders_" + folderDate+".txt";
        //ordersFileName = fileName;
        return fileName;
    }
        
    @Override
    public Order addOrder( List orderDetails, String state, double stateTax, String productType, 
                double productCost,double laborCost) throws FlooringMasteryDuplicateOrderException, 
                                                            FlooringMasteryFileNotFoundException{
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
        materialCost = Double.parseDouble(df2.format(materialCost));
        order.setMaterialCost(materialCost);
        double labourCost = laborCost * area;
        labourCost = Double.parseDouble(df2.format(labourCost));
        order.setLaborCost(labourCost);
        double totalTax = stateTax * 0.01 * (materialCost + laborCost);
        totalTax = Double.parseDouble(df2.format(totalTax));
        order.setTax(totalTax);
        double totalAmount = materialCost + laborCost + totalTax;
        totalAmount = Double.parseDouble(df2.format(totalAmount));
        order.setTotal(totalAmount);
        dao.loadOrdersFromFile(makeOrderFileName());
        dao.addOrder(order);
        return order;
    }
    @Override
    public Order editOrder(int orderNumber, double newArea) throws FlooringMasteryOrderNotFoundException{
        Order editOrder = null;
        List<Double> newEntries = new ArrayList<Double>();
        double productCost = dao.getProductCost(orderNumber);
        double laborCostPerSft = dao.getLaborCostPerSquareFoot(orderNumber);
        double stateTax = dao.getStateTax(orderNumber);
        double materialCost = newArea * productCost;
        materialCost = Double.parseDouble(df2.format(materialCost));
        double laborCost = newArea * laborCostPerSft;
        laborCost = Double.parseDouble(df2.format(laborCost));
        double totalTax = stateTax * 0.01 * (materialCost + laborCost);
        totalTax = Double.parseDouble(df2.format(totalTax));
        double total = materialCost + laborCost + totalTax;
        total = Double.parseDouble(df2.format(total));
        newEntries.add(0, new Double(newArea));
        newEntries.add(1, new Double(materialCost));
        newEntries.add(2, new Double(laborCost));
        newEntries.add(3, new Double(totalTax));
        newEntries.add(4, new Double(total));
        editOrder = dao.editOrder(orderNumber, newEntries);
        return editOrder;
    }
    
    public List<Double> getProductCostLabor(String productType) {
        return dao.getProductCostLabor(productType);
    }
    
    public double getStateTax(String state){
        return dao.getStateTax(state);
    }
    
    @Override
    public Order removeOrder(int orderNumber) throws FlooringMasteryOrderNotFoundException{
        return dao.removeOrder(orderNumber);
    }
    
    @Override
    public boolean validateOrderToEdit(int orderToEdit){
        if (dao.validateOrderToEdit(orderToEdit)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> displayExistingFiles() {
        return dao.displayExistingFiles();
    }
}