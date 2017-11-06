/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dto.Order;
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
    
    public FlooringMasteryController(FlooringMasteryServiceLayer service,FlooringMasteryView view){
        this.service = service;
        this. view = view;
    }
    
    public void run() { //throws FlooringMasteryFileNotFoundException, FlooringMasteryDuplicateOrderException {
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
    private void saveWork() {
        System.out.println("save work");
        try {
            service.saveOrders();
        } catch(Exception e) {
            System.out.println("Save Work failed." + e.getMessage());
        }
        view.hitEnter();
    }
    private void removeOrder() {
        System.out.println("remove order");
        int orderNumber = view.removeOrder();
        try{
            service.removeOrder(orderNumber);
        }catch(Exception e){
            System.out.println("controller remove order :"+e.getMessage());
        }
        view.hitEnter();
    }
    private void editOrder() {
        double newArea; 
        int editOrder;
        Order returnOrder;
        boolean invalidItemNumber = true;
        do {
            try{
                List<String> orderDates = service.getOrderDates();
                String orderDate = view.displayOrderDatesGetDate(orderDates);
                List<Order> ordersList = service.getAllOrders(orderDate); 
                
            } catch(Exception e){
                System.out.println(""+e.getMessage());
            }
            List<Order> editOrders = null;//service.getAllOrders();
            editOrder = view.editOrder();
            newArea = view.getNewOrderArea();
            try {
                returnOrder = service.editOrder(editOrder, newArea);
            } catch (Exception ex) {
                returnOrder = null;
                invalidItemNumber = true;
                view.displayErrorMessage(ex.getMessage());
            }
            if (returnOrder == null) {
                invalidItemNumber = true;
            } else {
                invalidItemNumber = false;
            }    
        } while (invalidItemNumber);
        try{
            service.getAllOrders();
        }catch(Exception e){
            System.out.println("Exception thrown" + e.getMessage());
        }
        view.hitEnter();
    }
    private void addOrder() {
        System.out.println("add order");
        String state, productType;
        double stateTax=0.0, productCost=0.0, laborCost=0.0;
        boolean validState=false, validProduct=false;
        do{
            state = view.getState();
            stateTax = service.getStateTax(state);
            if(stateTax == 0.0) {
                view.displayErrorMessage("Not valid state");
                validState = false;
            }else {
                validState  = true;
            }
        }while(!validState);
        do{
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
            System.out.println("test"+service);
            service.addOrder(orderDetails, state, stateTax, productType, productCost, laborCost);
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.hitEnter();
    }
    private void listAllOrders(){
        System.out.println("list orders controller");
        try{
            service.getAllOrders();
        } catch(Exception e){
            System.out.println("controller list all orders");
            e.printStackTrace();
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