/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.FileNames;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Taxes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

    //0 orderNumber;String 1 customerName;String 2 state;double 3 taxRate;
    //String 4 productType;double 5 area;double 6 costPerSquareFoot; double 7 laborCostPerSquareFoot;
    //double 8 materialCost;double 9 laborCost;double 10 tax;double 11 total;
public class FlooringMasteryDaoFileImpl implements FlooringMasteryDao {
    private List<Product> flooringMasteryProducts;
    private List<Taxes> flooringMasteryTaxes;
    private List<FileNames> fileNames;// = new ArrayList<>();
    private Map<String, Order> flooringMasteryOrdersMap;
    private Map<String, Order> flooringMasteryOtherOrdersMap;
    private String ordersFileName;// = "Orders.txt";
    public static final String DELIMITER = "::";
      
    public FlooringMasteryDaoFileImpl() {
        flooringMasteryOrdersMap = new HashMap<>();
        flooringMasteryOtherOrdersMap = new HashMap<>();
        try{
            loadProductsFromFile();
            loadTaxesFromFile();
        }catch(Exception e){
            //ignore
        }
    }
    
    @Override
    public Order addOrder( Order order, String fileName) {
        int count=0;
        for (String flName : displayExistingFiles()){
            if (flName.equals(fileName)){
                try {
                    loadOrdersFromFile(fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (Order ord : flooringMasteryOrdersMap.values()){
            if(count < ord.getOrderNumber()){
                count = ord.getOrderNumber();
            }
        }
        count = count + 1;
        order.setOrderNumber(count);
        flooringMasteryOrdersMap.put(count+"", order);
        return order;
    }

    @Override
    public Order removeOrder(int orderNumber) {
        Order removedOrder = flooringMasteryOrdersMap.remove(orderNumber+"");
        return removedOrder;
    }
    
    @Override
    public Order editOrder(int orderNumber, List<Double> newEntries, String productType, 
            String state, String fileName, String customerName) {
        Order editOrder = flooringMasteryOrdersMap.get(orderNumber+"");
        removeOrder(orderNumber);
        try {
            saveWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
        editOrder.setState(state);
        editOrder.setArea(newEntries.get(0));
        editOrder.setProductType(productType);
        editOrder.setMaterialCost(newEntries.get(1));
        editOrder.setLaborCost(newEntries.get(2));
        editOrder.setTax(newEntries.get(3));
        editOrder.setTotal(newEntries.get(4));
        editOrder.setCustomerName(customerName);
        addOrder(editOrder, fileName);
        return editOrder;
    }
    
    @Override
    public void saveWork() throws FlooringMasteryFileNotFoundException {
        writeToFile(ordersFileName);
    }
    
    @Override
    public void saveWork(String fileName) throws FlooringMasteryFileNotFoundException {
        writeToFile(fileName);
        ordersFileName = fileName;
    }
      
    @Override
    public List<String> displayExistingFiles() {
        List<String> fileNames = new ArrayList<>();
        File curDir = new File(".");
        File[] filesList = curDir.listFiles();
        for(File orderFile : filesList){
            if(orderFile.getName().contains("Orders_")){
                if (orderFile.length() != 0 ) {
                    fileNames.add(orderFile.getName());
                }
            }
        }
        return fileNames;
    }
    
    private List<Order> listCurrentOrders() throws FlooringMasteryFileNotFoundException {
        List<Order> orderList = new ArrayList<Order>();
        for (String key : flooringMasteryOrdersMap.keySet()){
            Order ord = flooringMasteryOrdersMap.get(key);
            orderList.add(ord);
        }
        return orderList;
    }
    
    @Override
    public boolean validateOrderToEdit(int orderToEdit) {
        if (flooringMasteryOrdersMap.size() == 0){
            try{             
                listCurrentOrders();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(flooringMasteryOrdersMap.get(orderToEdit + "") != null){
            return true;
        }else {
            return false;
        }
    }
    
    public List<Double> getProductCostLabor(String productType){
        List<Double> productCostLabor = null;
        if (flooringMasteryProducts != null){
            for (Product productFromList : flooringMasteryProducts){
                if (productFromList.getProduct().equalsIgnoreCase(productType)){
                    productCostLabor = new ArrayList<Double>();
                    productCostLabor.add(new Double(productFromList.getCost()));
                    productCostLabor.add(new Double(productFromList.getLabor()));
                }
            }
        }
        return productCostLabor;
    }
    
    public double getStateTax(String state){
        Taxes taxes = null;
        double tax = 0.0;
        boolean found = false;
        if (flooringMasteryTaxes != null){
            List<Taxes> statesList = new ArrayList<Taxes>();
            for (Taxes stateTaxesFromList : flooringMasteryTaxes){
                if (stateTaxesFromList.getState().equalsIgnoreCase(state)){
                    taxes = stateTaxesFromList;
                    tax = taxes.getTax();
                } 
            }
        }
        return tax;
    }

    @Override
    public List<String> loadOrdersFromFile(String orderFileName) throws FlooringMasteryFileNotFoundException {
        List<String> orderRecords = new ArrayList<String>();
        ordersFileName = orderFileName;
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(orderFileName)));
        }catch (FileNotFoundException e){
            throw new FlooringMasteryFileNotFoundException(e.getMessage());
        }
        String currentLine = null;
        String[] currentTokens;
        flooringMasteryOrdersMap = new HashMap<String, Order>();
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Order currentItem = new Order(Integer.parseInt(currentTokens[0]) );
            //orderRecords[i] = Integer.parseInt(currentTokens[0]);
            currentItem.setCustomerName(currentTokens[1] );
            currentItem.setState(currentTokens[2]);
            currentItem.setTaxRate(Double.parseDouble(currentTokens[3]) );
            currentItem.setProductType(currentTokens[4]);
            currentItem.setArea(Double.parseDouble(currentTokens[5]));
            currentItem.setCostPerSquareFoot(Double.parseDouble(currentTokens[6]));
            currentItem.setLaborCostPerSquareFoot(Double.parseDouble(currentTokens[7]));
            currentItem.setMaterialCost(Double.parseDouble(currentTokens[8]));
            currentItem.setLaborCost(Double.parseDouble(currentTokens[9]));
            currentItem.setTax(Double.parseDouble(currentTokens[10]));
            currentItem.setTotal(Double.parseDouble(currentTokens[11]));
            flooringMasteryOrdersMap.put(currentItem.getOrderNumber()+"", currentItem);
            String modifiedLine = String.format("%-10s", currentTokens[0]) 
                                 + String.format("%-20s", currentTokens[1])
                                 + String.format("%-10s", currentTokens[2])
                    + String.format("%-10s", currentTokens[3])
                    + String.format("%-10s", currentTokens[4])
                    + String.format("%-10s", currentTokens[5])
                    + String.format("%-10s", currentTokens[6])
                    + String.format("%-10s", currentTokens[7])
                    + String.format("%-10s", currentTokens[8])
                    + String.format("%-10s", currentTokens[9])
                    + String.format("%-10s", currentTokens[10])
                    + String.format("%-10s", currentTokens[11]);
            orderRecords.add(modifiedLine);
        }
        scanner.close();
        return orderRecords;
    }
    
    private void writeToFile(String fileName) throws FlooringMasteryFileNotFoundException {
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(fileName));
        } catch(IOException e){
          throw new FlooringMasteryFileNotFoundException(e.getMessage());  
        }
       List<Order> ordersList = this.listCurrentOrders();
        for (Order currentItem : ordersList) {
                String completeRecord;
                completeRecord = currentItem.getOrderNumber()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getCustomerName()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getState()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getTaxRate()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getProductType()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getArea()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getCostPerSquareFoot()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getLaborCostPerSquareFoot()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getMaterialCost()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getLaborCost()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getTax()+ DELIMITER;
                completeRecord = completeRecord + currentItem.getTotal()+ DELIMITER;
                out.println(completeRecord);
                out.flush();
        }
        out.close();
    }
    
    
    public String getProductType(int orderToEdit){
        Order editOrder = flooringMasteryOrdersMap.get(orderToEdit+"");
        return editOrder.getProductType();
    }
    
    public String getState(int orderToEdit){
        Order editOrder = flooringMasteryOrdersMap.get(orderToEdit+"");
        return editOrder.getState();
    }
    
    public double getArea(int orderToEdit) {
        Order editOrder = flooringMasteryOrdersMap.get(orderToEdit+"");
        return editOrder.getArea() ;
    }
    
    public String getCustomerName(int orderToEdit) {
        Order editOrder = flooringMasteryOrdersMap.get(orderToEdit+"");
        return editOrder.getCustomerName();
    }
    
    @Override
    public double getProductCost(int orderNumber){
        Order ord = flooringMasteryOrdersMap.get(orderNumber+"");
        return ord.getCostPerSquareFoot();
    }
    
    @Override
    public double getLaborCostPerSquareFoot(int orderNumber){
        Order ord = flooringMasteryOrdersMap.get(orderNumber+"");
        return ord.getLaborCostPerSquareFoot();
    }
    
    @Override
    public double getStateTax(int orderNumber){
        Order ord = flooringMasteryOrdersMap.get(orderNumber+"");
        return ord.getTax();
    }
    
    private void loadProductsFromFile() throws FlooringMasteryFileNotFoundException {
        Scanner scanner;
        flooringMasteryProducts = new ArrayList();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("Products.txt")));
        }catch (FileNotFoundException e){
            throw new FlooringMasteryFileNotFoundException(e.getMessage());
        }
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Product currentItem = new Product();
            currentItem.setProduct(currentTokens[0]);
            currentItem.setCost(Double.parseDouble(currentTokens[1] ));
            currentItem.setLabor( Double.parseDouble(currentTokens[2]));
            flooringMasteryProducts.add(currentItem);
        }
        scanner.close();
    }

    private void loadTaxesFromFile() throws FlooringMasteryFileNotFoundException {
        Scanner scanner;
        flooringMasteryTaxes = new ArrayList<Taxes>();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("Taxes.txt")));
        }catch (FileNotFoundException e){
            throw new FlooringMasteryFileNotFoundException(e.getMessage());
        }
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Taxes currentItem = new Taxes();
            currentItem.setState(currentTokens[0]);
            currentItem.setTax(Double.parseDouble(currentTokens[1])); 
            flooringMasteryTaxes.add(currentItem);
        }
        scanner.close();
    }
}