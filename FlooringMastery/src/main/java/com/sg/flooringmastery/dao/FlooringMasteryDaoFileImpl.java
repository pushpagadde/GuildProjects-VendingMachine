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

/**
 *
 * @author apprentice
 */
public class FlooringMasteryDaoFileImpl implements FlooringMasteryDao {
    private List<Product> flooringMasteryProducts;
    private List<Taxes> flooringMasteryTaxes;
    private Map<String, Map> orderFiles;// = new ArrayList<>();
    private Map<String, Order> flooringMasteryOrdersMap;
    private String ordersFileName;// = "Orders.txt";
    public static final String DELIMITER = "::";
    private boolean dataSaved = true;
    private boolean forEdit = false;
    
    public FlooringMasteryDaoFileImpl() throws FlooringMasteryFileNotFoundException{
        orderFiles = new HashMap<String, Map>();
        try{
            loadOrdersFromFile();
            loadProductsFromFile();
            loadTaxesFromFile();
        }catch(Exception e){
            throw new FlooringMasteryFileNotFoundException("Exception FlooringMasteryDaoFileImpl"+e.getMessage());
        }
    }

    public List<String> listAllFiles() {
        List<String> fileNames = new ArrayList<String>();
        for (String key : orderFiles.keySet()) {
            fileNames.add(key);
        }
        return fileNames;
    }
    
    @Override
    public List<Order> listAllOrders() throws FlooringMasteryFileNotFoundException {
        forEdit = false;
        List<Order> orderList = new ArrayList<Order>();
        for (String key : flooringMasteryOrdersMap.keySet()){
            Order ord = flooringMasteryOrdersMap.get(key);
            orderList.add(ord);
        }
        return orderList;
    }

    public void loadOrderFileByDate(Date orderDate) throws FlooringMasteryFileNotFoundException {
        //makeOrderFileName(orderDate);
        loadOrdersFromFile();
    }
    
    @Override
    public Order findOrder(int orderNumber) {
        Order order = flooringMasteryOrdersMap.get(orderNumber+"");
        return order;
    }
    
    @Override
    public Order addOrder( Order order) {
        int count=0;
        List<Order> orderList = new ArrayList<Order>();
        for (Order ord : flooringMasteryOrdersMap.values()){
            orderList.add(ord);
            if(count < ord.getOrderNumber()){
                count = ord.getOrderNumber() + 1;
            }
        }
        order.setOrderNumber(count);
        flooringMasteryOrdersMap.put(count+"", order);
        dataSaved = false;
        return order;
    }

    @Override
    public Order editOrder(int orderNumber, double newArea) {
        forEdit = true;
        
        Order editOrder = flooringMasteryOrdersMap.get(orderNumber+"");
        editOrder.setTotal(newArea);
        dataSaved = false;
        return editOrder;
    }
    
    @Override
    public Order removeOrder(int orderNumber) {
        Order removedOrder = flooringMasteryOrdersMap.remove(orderNumber+"");
        dataSaved = false;
        return removedOrder;
    }

    @Override
    public void saveWork() throws FlooringMasteryFileNotFoundException {
        String fileName = makeOrderFileName();
        writeToFile(fileName);
        dataSaved = true;
    }
    
    private String makeOrderFileName() throws FlooringMasteryFileNotFoundException {
        Date date = new Date();
        String fileName;
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
        String folderDate = formatter.format(today);
        fileName = "Orders_" + folderDate+".txt";
        saveFileNames(fileName);
        return fileName;
    }
    
    private void saveFileNames(String fileName) throws FlooringMasteryFileNotFoundException {
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter("FileNames.txt"), true);
        } catch(IOException e){
            throw new FlooringMasteryFileNotFoundException(e.getMessage());  
        }
        out.println(fileName + DELIMITER);
        out.flush();
        out.close();
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
    
    public List<String> getOrderDates(){
        List<String> listOfOrderDates = new ArrayList<>();
        File curDir = new File(".");
        File[] filesList = curDir.listFiles();
        for(File orderFile : filesList){
            if(orderFile.isFile()){
                if (orderFile.getName().startsWith("Orders")){
                    listOfOrderDates.add(orderFile.getName());
                }
            }
        }
        return listOfOrderDates;
    }
    
    public List<Order> getAllOrders(String orderDate) throws FlooringMasteryFileNotFoundException {
        List<Order> ordersList = new ArrayList<>();
        File curDir = new File(".");
        File[] filesList = curDir.listFiles();
        for(File orderFile : filesList){
            if(orderFile.isFile()){
                if (orderFile.getName().contains(orderDate)){
                    Scanner scanner;
                    try {
                        scanner = new Scanner(new BufferedReader(new FileReader("Orders_" + orderDate + ".txt")));
                    }catch (FileNotFoundException e){
                        throw new FlooringMasteryFileNotFoundException(e.getMessage());
                    }
                    String currentLine;
                    String[] currentTokens;
                    while(scanner.hasNextLine()) {
                        currentLine = scanner.nextLine();
                        currentTokens = currentLine.split(DELIMITER);
                        Order currentItem = new Order(Integer.parseInt(currentTokens[0]));
                        currentItem.setCustomerName(currentTokens[1]);
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
                        ordersList.add(currentItem) ;
                    }
                    scanner.close();
                }else {
                    return null;
                }
            }
        }
        return ordersList;
    }
    
    private void loadOrdersFromFile() throws FlooringMasteryFileNotFoundException {
        File curDir = new File(".");
        File[] filesList = curDir.listFiles();
        for(File orderFile : filesList){
            if(orderFile.isFile()){
                if (orderFile.getName().startsWith("Orders")){
                    String orderFileName = orderFile.getName();
                    Scanner scanner;
                    flooringMasteryOrdersMap = new HashMap<String, Order>();
                    try {
                        scanner = new Scanner(new BufferedReader(new FileReader(orderFileName)));
                    }catch (FileNotFoundException e){
                        throw new FlooringMasteryFileNotFoundException(e.getMessage());
                    }
                    String currentLine;
                    String[] currentTokens;
                    while(scanner.hasNextLine()) {
                        currentLine = scanner.nextLine();
                        currentTokens = currentLine.split(DELIMITER);
                        Order currentItem = new Order(Integer.parseInt(currentTokens[0]));
                        currentItem.setCustomerName(currentTokens[1]);
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
                        flooringMasteryOrdersMap.put(orderFileName + " " +  currentItem.getOrderNumber()+"", currentItem);
                    }
                    scanner.close();
                    orderFiles.put(orderFileName, flooringMasteryOrdersMap);
                }
            }
        }
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
    
    private void loadFileNamesFromFile() throws FlooringMasteryFileNotFoundException {
        Scanner scanner;
        //fileNames = new ArrayList<FileNames>();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("FileNames.txt")));
        }catch (FileNotFoundException e){
            throw new FlooringMasteryFileNotFoundException(e.getMessage());
        }
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            FileNames currentItem = new FileNames();
            currentItem.setFileNames( currentTokens[0]);
            //fileNames.add(currentItem);
        }
        scanner.close();
    }

    //0 orderNumber;String 1 customerName;String 2 state;double 3 taxRate;
    //String 4 productType;double 5 area;double 6 costPerSquareFoot; double 7 laborCostPerSquareFoot;
    //double 8 materialCost;double 9 laborCost;double 10 tax;double 11 total;
    private void writeToFile(String fileName) throws FlooringMasteryFileNotFoundException {
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(fileName));
        } catch(IOException e){
          throw new FlooringMasteryFileNotFoundException(e.getMessage());  
        }
        List<Order> ordersList = this.listAllOrders();
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
}