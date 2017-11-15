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
    private List<FileNames> fileNames;
    private Map<String, List> flooringMasteryOrdersMap;
    private String ordersFileName;
    public static final String DELIMITER = "::";
      
    public FlooringMasteryDaoFileImpl() {
        flooringMasteryOrdersMap = new HashMap<String, List>();
        try{
            loadProductsFromFile();
            loadTaxesFromFile();
            loadAllOrdersToMap();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Order addOrder( Order order, String fileName) {
        int count=0;
        List<Order> ordersListFromMap = flooringMasteryOrdersMap.get(fileName);
        if (ordersListFromMap == null){
            ordersListFromMap = new ArrayList<Order>();
        }
        for (Order orderFromList : ordersListFromMap){
            if (count < orderFromList.getOrderNumber()){
                count = orderFromList.getOrderNumber();
            }
        }
        ordersFileName = fileName;
        count = count + 1;
        order.setOrderNumber(count);
        ordersListFromMap.add(order);
        flooringMasteryOrdersMap.put(fileName, ordersListFromMap);
        return order;
    }

    @Override
    public Order removeOrder(int orderNumber) {
        List<Order> ordersListFromMap = flooringMasteryOrdersMap.get(ordersFileName);
        if (ordersListFromMap == null){
            ordersListFromMap = new ArrayList<Order>();
        }
        Order removeOrder = null;
        for (Order orderFromList : ordersListFromMap){
            if (orderNumber == orderFromList.getOrderNumber()){
                removeOrder = orderFromList;
            }
        }
        if (removeOrder != null){
            ordersListFromMap.remove(removeOrder);
            flooringMasteryOrdersMap.put(ordersFileName, ordersListFromMap);
        }      
        return removeOrder;
    }
    
    @Override
    public boolean validateOrderToEdit(int orderToEdit) {
        boolean validOrder = false;
        List<Order> ordersListFromMap = flooringMasteryOrdersMap.get(ordersFileName);
        //System.out.println("order to edit: "+ orderToEdit + " file name: " + ordersFileName);
        if (flooringMasteryOrdersMap.size() == 0){
            try{             
                listCurrentOrders();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        for (Order orderFromList : ordersListFromMap){
            if (orderToEdit == orderFromList.getOrderNumber()){
                validOrder = true;
            }
        }
        /*if(flooringMasteryOrdersMap.get(orderToEdit + "") != null){
            return true;
        }else {
            return false;
        }*/
        return validOrder;
    }
    
    @Override
    public Order editOrder(int orderNumber, List<Double> newEntries, String productType, 
            String state, String fileName, String customerName, String fileToAddTo) {
        Order editOrder = getOrder(orderNumber);
        if(fileName != fileToAddTo) {
            editOrder = removeOrder(orderNumber);
        }
        editOrder.setState(state);
        editOrder.setArea(newEntries.get(0));
        editOrder.setProductType(productType);
        editOrder.setMaterialCost(newEntries.get(1));
        editOrder.setLaborCost(newEntries.get(2));
        editOrder.setTax(newEntries.get(3));
        editOrder.setTotal(newEntries.get(4));
        editOrder.setCustomerName(customerName);
        addOrder(editOrder, fileToAddTo);
        return editOrder;
    }
    
    @Override
    public void saveWork() throws FlooringMasteryFileNotFoundException {
        for (String keyFileName : flooringMasteryOrdersMap.keySet()){
            writeToFile(keyFileName);
        }
        loadAllOrdersToMap();
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
                }else {
                    //orderFile.delete(); - Not deleting for now but this command will delete the file
                }
            }
        }
        return fileNames;
    }
    
    private List<Order> listCurrentOrders() throws FlooringMasteryFileNotFoundException {
        //System.out.println("listCurrentOrders:DAOOrderFileName:"+ordersFileName+"  size"+flooringMasteryOrdersMap.size());
        List<Order> orderList = flooringMasteryOrdersMap.get(ordersFileName);
        return orderList;
    }

    public void loadAllOrdersToMap() {
        List<String> orderFiles = displayExistingFiles();
        for (String orderFileName : orderFiles){
            try{
                List<Order> orderRecordsToMap = new ArrayList<Order>();
                Scanner scanner;
                try {
                    scanner = new Scanner(new BufferedReader(new FileReader(orderFileName)));
                }catch (FileNotFoundException e){
                    throw new FlooringMasteryFileNotFoundException(e.getMessage());
                }
                String currentLine = null;
                String[] currentTokens;
                while(scanner.hasNextLine()) {
                    currentLine = scanner.nextLine();
                    currentTokens = currentLine.split(DELIMITER);

                    Order currentItem = new Order(Integer.parseInt(currentTokens[0]) );
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
                    
                    orderRecordsToMap.add(currentItem);
                }
                scanner.close();
                flooringMasteryOrdersMap.put(orderFileName, orderRecordsToMap);
            } catch(Exception e){
                //Ignoring as we are getting the order files names first 
                //so there won't be any file not found exception
            }
        }
    }
    
    @Override
    public List<String> loadOrdersFromFile(String orderFileName) throws FlooringMasteryFileNotFoundException {
        System.out.println("loadOrdersFromFile:"+orderFileName+" DAOOrderFileName:"+ordersFileName);
        ordersFileName = orderFileName; 
        List<String> orderRecords = new ArrayList<String>();
        List<Order> ordersListFromMap = flooringMasteryOrdersMap.get(orderFileName);
        if (ordersListFromMap != null){
            for (Order order : ordersListFromMap){
                String modifiedLine = String.format("%-10s", order.getOrderNumber()) 
                                 + String.format("%-20s", order.getCustomerName())
                                 + String.format("%-10s", order.getState())
                                 + String.format("%-10s", order.getTaxRate())
                                 + String.format("%-10s", order.getProductType())
                                 + String.format("%-10s", order.getArea())
                                 + String.format("%-10s", order.getCostPerSquareFoot())
                                 + String.format("%-10s", order.getLaborCostPerSquareFoot())
                                 + String.format("%-10s", order.getMaterialCost())
                                 + String.format("%-10s", order.getLaborCost())
                                 + String.format("%-10s", order.getTax())
                                 + String.format("%-10s", order.getTotal());

                orderRecords.add(modifiedLine);
            }
        }
        return orderRecords;
    }
    
    private void writeToFile(String fileName) throws FlooringMasteryFileNotFoundException {
        System.out.println("DAOwriteToFIle:"+fileName+"   ordrs:"+ordersFileName);
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(fileName));
        } catch(IOException e){
          throw new FlooringMasteryFileNotFoundException(e.getMessage());  
        }
        List<Order> ordersList = flooringMasteryOrdersMap.get(fileName);
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

    public Order getOrder(int orderNumber) {
        List<Order> ordersListFromMap = flooringMasteryOrdersMap.get(ordersFileName);
        if (ordersListFromMap == null){
            ordersListFromMap = new ArrayList<Order>();
        }
        Order order = null;
        for (Order orderFromList : ordersListFromMap){
            if (orderNumber == orderFromList.getOrderNumber()){
                order = orderFromList;
            }
        }        
        return order;
    }
    
    @Override
    public String getProductType(int orderNumber){
        Order order = getOrder(orderNumber);
        return order.getProductType();
    }
    @Override
    public String getState(int orderNumber){
        Order order = getOrder(orderNumber);
        return order.getState();
    }
    @Override
    public double getArea(int orderNumber) {
        Order order = getOrder(orderNumber);
        return order.getArea() ;
    }
    @Override
    public String getCustomerName(int orderNumber) {
        Order order = getOrder(orderNumber);
        return order.getCustomerName();
    }
    
    @Override
    public double getProductCost(int orderNumber){
        Order order = getOrder(orderNumber);
        return order.getCostPerSquareFoot();
    }
    
    @Override
    public double getLaborCostPerSquareFoot(int orderNumber){
        Order order = getOrder(orderNumber);
        return order.getLaborCostPerSquareFoot();
    }
    
    @Override
    public double getStateTax(int orderNumber){
        Order order = getOrder(orderNumber);
        return order.getTax();
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

    @Override
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

    @Override
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
}