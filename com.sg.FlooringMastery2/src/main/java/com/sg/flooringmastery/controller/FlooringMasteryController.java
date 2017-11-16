/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringMasteryFileNotFoundException;
import com.sg.flooringmastery.service.FlooringMasteryServiceLayer;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryController {
    
    FlooringMasteryServiceLayer service;
    FlooringMasteryView view = new FlooringMasteryView();
    //String oldFileName = null;
    int executionMode = 2;
    //boolean dataSavePending = false;
    public FlooringMasteryController(FlooringMasteryServiceLayer service,FlooringMasteryView view){
        this.service = service;
        this. view = view;
    }
    
    public void run() { //throws FlooringMasteryFileNotFoundException, FlooringMasteryDuplicateOrderException {
       Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("executionmode.txt")));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String currentLine;
        if (scanner != null){
            while(scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
               if (currentLine.equals("1")){//Prod Mode
                   executionMode = Integer.parseInt(currentLine);
                } //Defualt mode is Production Mode
            }
        }
        boolean keepGoing = true;
        int menuSelection ;
        while (keepGoing) {
            menuSelection = printMenuAndGetSelection();
            switch(menuSelection) {
                case 1: 
                    listAllOrders();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3: 
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    saveWork();
                    break;
                case 6: 
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    } 
    
    private void addOrder() {
        String state, productType;
        double stateTax=0.0, productCost=0.0, laborCost=0.0;
        boolean validState=false, validProduct=false;
        do{//check validity of state keyed by user
            displayStates();
            state = view.getState();
            stateTax = service.getStateTax(state);
            if(stateTax == 0.0) {
                view.displayErrorMessage("Not valid state");
                validState = false;
            }else {
                validState  = true;
            }
        }while(!validState);
        do{//check validity of proudct keyed by user
            displayProductTypes();
            productType = view.getProductType();
            List prodList = service.getProductCostLabor(productType);
            if (prodList != null){
                productCost =  service.getProductCostLabor(productType).get(1).doubleValue();
                laborCost = service.getProductCostLabor(productType).get(0).doubleValue();
                validProduct = true;
            } else {
               validProduct = false;
               view.displayErrorMessage("Not valid product.");
            }
        }while(!validProduct);
        List orderDetails = view.getOrderDetails();
        try {
            service.addOrder(orderDetails, state, stateTax, productType, productCost, laborCost);
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.hitEnter();
    }
    
    private void listAllOrders(){
        //int i = 1;
        List<String> fileNames = service.displayExistingFiles();
        java.util.Collections.sort(fileNames);
        try{
            for (String names : fileNames) {
                view.displayName( names);
            }
            String choosenFileName = null;
            boolean validDateNotFound = true;
            do {
                String orderDate =  view.getOrderDate();

                for (String flName : fileNames){
                    if (flName.contains("Orders_"+orderDate+".txt")){                        
                        choosenFileName = flName;
                        validDateNotFound = false;
                    }
                }
            } while(validDateNotFound);
            
            List<String> recordsList =  service.getAllOrders(choosenFileName);
            if (recordsList.size() == 0){
                view.displayName("No Orders found!");
            } else {
                view.displayTopBanner();
                Collections.sort(recordsList);
                for(String record : recordsList) {
                    view.displayName(String.format("%-10s",record));
                }
                view.displayBottomBanner();
                
                view.displayName("");
            }
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.hitEnter();
    }
    
    private void editOrder() {
        int orderToEdit;
        String choosenFileName = null;
        String newFileNameToAdd;
        List<String> fileNames = service.displayExistingFiles();
        java.util.Collections.sort(fileNames);
        try{//list all files so user can pick a date and all orders for that date are displayed
            for (String names : fileNames) {
                view.displayName( names);
            }
            boolean validDateNotFound = true;
            do {
                String orderDate =  view.getOrderDate();
                for (String flName : fileNames){
                    if (flName.contains("Orders_"+orderDate+".txt")){                        
                        choosenFileName = flName;
                        validDateNotFound = false;
                    }
                }
            } while(validDateNotFound);
            List<String> recordsList =  service.getAllOrders(choosenFileName);
            view.displayTopBanner();
            for(String record : recordsList) {
                view.displayName(record);
            }
            view.displayBottomBanner();
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
        try{//get order to be edited from the displayed list of orders
            orderToEdit = view.getOrderToEdit();
            if(service.validateOrderToEdit(orderToEdit)) {
                String state, productType;
                double stateTax=0.0, productCost=0.0, laborCost=0.0;
                boolean validState=false, validProduct=false, validDate = false;
                String customerName = view.getCustomerName();//edit customer name
                if (customerName.equals("") || customerName == null){
                    customerName = service.getCustomerName(orderToEdit);
                }
                do{//check validity of state keyed by user
                    displayStates();
                    state = view.getNullState();
                    if(state == null || state.equals("")) {
                        state = service.getState(orderToEdit);
                        break;
                    }
                    stateTax = service.getStateTax(state);
                    if (stateTax == 0.0) {
                        view.displayErrorMessage("Not valid state");
                        validState = false;
                    } else {
                        validState  = true;
                    }
                }while(!validState);
              
                do{//check validity of proudct keyed by user
                    displayProductTypes();
                    productType = view.getNullProductType();
                    if(productType == null || productType.equals("")) {
                        //displayProductTypes();
                        productType = service.getProductType(orderToEdit);
                        break;
                    }
                    List prodList = service.getProductCostLabor(productType);
                    if (prodList != null){
                        productCost =  service.getProductCostLabor(productType).get(1).doubleValue();
                        laborCost = service.getProductCostLabor(productType).get(0).doubleValue();
                        validProduct = true;
                    } else {
                       validProduct = false;
                       view.displayErrorMessage("Not valid product.");
                    }
                }while(!validProduct);
                do {
                    newFileNameToAdd = view.getOrderDate();
                    if( newFileNameToAdd == null) {
                        newFileNameToAdd = choosenFileName;
                        validDate = true;
                        break;
                    } else {
                        for (String flName : fileNames){
                            if (flName.contains("Orders_"+newFileNameToAdd+".txt")){
                                newFileNameToAdd = "Orders_"+newFileNameToAdd+".txt";
                                validDate = true;
                                break;
                            }
                        }
                        if(validDate == true){break;}
                    }
                    validDate = false;
                }while(!validDate);
                Double newArea = view.getNewOrderArea();//get new area
                if (newArea == 0.0) {
                    newArea = service.getArea(orderToEdit);
                }                                
                service.editOrder(orderToEdit, newArea , stateTax, 
                                    productCost, laborCost, productType, state, choosenFileName, 
                                    customerName, newFileNameToAdd);
            }else {
                view.displayErrorMessage("wrong order number or no order to edit.");
            }
        }catch(Exception e) {
            view.displayErrorMessage(e.getMessage());
            e.printStackTrace();
        }
        view.hitEnter();
    }
        
    private void removeOrder() {
        int orderToRemove;
        List<String> fileNames = service.displayExistingFiles();
        java.util.Collections.sort(fileNames);
        try{
            for (String names : fileNames) {
                view.displayName( names);
            }
            String choosenFileName = null;
            boolean validDateNotFound = true;
            do {
                String orderDate =  view.getOrderDate();
                for (String flName : fileNames){
                    if (flName.contains("Orders_"+orderDate+".txt")){                        
                        choosenFileName = flName;
                        validDateNotFound = false;
                    }
                }
            } while(validDateNotFound);
            List<String> recordsList =  service.getAllOrders(choosenFileName);
            for(String record : recordsList) {
                view.displayName(record);
            }
        }catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
        int orderNumber = view.removeOrder();
        try{
            service.removeOrder(orderNumber);
        }catch(Exception e){
            view.displayErrorMessage("controller remove order :"+e.getMessage());
        }
        view.hitEnter();
    }
    private void displayProductTypes() {
        List<String> productsList = new ArrayList<>();
        productsList = service.getProductTypes();
        view.displayProducts(productsList);
        
    }
    private void displayStates() {
        List<String> statesList = new ArrayList<>();
        statesList = service.getStatesList();
        view.displayStates(statesList);
    }
    private void saveWork() {
        if (executionMode == 2){
            view.displayName("Changes can't be saved in Test Mode");
        } else {
            String confirmSave = "";
            do {
                confirmSave = view.getConfirmation();
            } while (!(confirmSave != null && (confirmSave.equalsIgnoreCase("Y") || confirmSave.equalsIgnoreCase("N"))));
            try {
                if (confirmSave.equalsIgnoreCase("Y")){
                    service.saveOrders();
                }
            } catch(Exception e) {
                view.displayErrorMessage("Save Work failed." + e.getMessage());
            }
        }
        view.hitEnter();
    }
    
    private int printMenuAndGetSelection() {
        return view.printMenuAndGetSelection();
    }
    private void exitMessage(){
        view.exitMessage();
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}                    