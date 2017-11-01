/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.service.FlooringMasteryServiceLayer;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryController {
    
    FlooringMasteryServiceLayer service;
    FlooringMasteryView view = new FlooringMasteryView();
    String oldFileName = null;
    int executionMode = 2;
    public FlooringMasteryController(FlooringMasteryServiceLayer service,FlooringMasteryView view){
        this.service = service;
        this. view = view;
    }
    
    public void run() { //throws FlooringMasteryFileNotFoundException, FlooringMasteryDuplicateOrderException {
        executionMode = view.getMode();
        
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
    
    private void listAllOrders(){
        view.displayBanner("List of all files with orders:");
        List<String> fileNames = service.displayExistingFiles();
        java.util.Collections.sort(fileNames);
        int i=1;
        try{
            for (String names : fileNames) {
                view.displayName(i++ + ". " + names);
                List<String> recordsList =  service.getAllOrders(names);
                for(String record : recordsList) {
                    view.displayName("   "+record);
                }
                view.displayName("");
            }
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.hitEnter();
    }
    
    private void addOrder() {
        String state, productType;
        double stateTax=0.0, productCost=0.0, laborCost=0.0;
        boolean validState=false, validProduct=false;
        
        do{//check validity of state keyed by user
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
    
    private void editOrder() {
        int orderToEdit,i=1;
        List<String> fileNames = service.displayExistingFiles();
        java.util.Collections.sort(fileNames);
        try{
            for (String names : fileNames) {
                view.displayName(i++ + ". " + names);
            }
            int orderDate =  view.getOrderDate(i-1);
            List<String> recordsList =  service.getAllOrders(fileNames.get(orderDate-1));
            for(String record : recordsList) {
                view.displayName(record);
            }
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
        try{
            orderToEdit = view.getOrderToEdit();
            if(service.validateOrderToEdit(orderToEdit)) {
                service.editOrder(orderToEdit,view.getNewOrderArea());
            }else {
                view.displayErrorMessage("wrong order number");
            }
        }catch(Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.hitEnter();
    }
        
    private void removeOrder() {
        int orderToRemove,i=1;
        List<String> fileNames = service.displayExistingFiles();
        java.util.Collections.sort(fileNames);
        try{
            for (String names : fileNames) {
                view.displayName(i++ + ". " + names);
            }
            int orderDate =  view.getOrderDate(i-1);
            List<String> recordsList =  service.getAllOrders(fileNames.get(orderDate-1));
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
    
    private void saveWork() {
        if (executionMode == 2){
            view.displayName("Changes cann't be saved in Test Mode");
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