/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryView {
    UserIO io = new UserIOImpl();
    
    public FlooringMasteryView() {
    }
    
    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }
    
    public void displayName(String fileName) {
        io.print(fileName);
    }
    
    public void displayBanner(String message){
        io.print(message);
    }
    
    public int printMenuAndGetSelection() {
        io.print("======Main Menu:======");
        io.print("1. Display Orders");
        io.print("2. Add Order");
        io.print("3. Edit Order");
        io.print("4. Remove Order");
        io.print("5. Save Work");
        io.print("6. Quit");
        return io.readInt("Key in a number to make your selection.", 1, 6);
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void displayBottomBanner() {
        io.print("--------------------------------------------------------------------------------------------------------------------------------");
    }

    public void displayUserSelection() {
        io.print("You selected:");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("Unknown command");
    }
    
    public void exitMessage(){
        io.print("Good Bye!!");
    }
    
    public void hitEnter(){
        io.readString("Hit enter to continue");
    }

    public String getOrderDate(){
        return io.readString("Enter Order date of a file in MMDDYYYY format:");
    }
    
    
    public String getConfirmation() {
        io.print("Do you want to save the changes?");
        return io.readString("(Y/N):");
    }
    public List getOrderDetails() {
        List orderDetails = new ArrayList();
        String customerName = io.readString("Enter customer name:");
        Double area = io.readDouble("Enter area:");
        orderDetails.add(customerName);
        orderDetails.add(new Double(area));
        return orderDetails;
    }
    //order number, customer name, state, tax rate, product type, 
    //area, cost per square foot, labor cost per square foot, 
    //material cost, labor cost, tax, and total
    public void displayTopBanner(){
        String labels;
        labels = String.format("%-10s","S.No.") 
                + String.format("%-20s","Cust. Name")
                + String.format("%-10s","State") 
                + String.format("%-10s","Tax Rate")
                + String.format("%-10s", "Product") 
                + String.format("%-10s","Area")
                + String.format("%-10s","Cost/SqFt")  
                + String.format("%-10s","Lab/Sqft")
                + String.format("%-10s","Mat. Cost") 
                + String.format("%-10s","Lab. Cost")
                + String.format("%-10s","Tax") 
                + String.format("%-10s","Total");
        io.print("--------------------------------------------------------------------------------------------------------------------------------");
        io.print(labels);
        io.print("--------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public String displayOrderDatesGetDate(List<String> orderDates) {
        io.print("Orders with dates:");
        for(int i = 0 ; i < orderDates.size(); i++) {
            io.print(orderDates.get(i));;
        }
        return io.readString("Pick a date to list the orders for that date.");
    }
    
    public int removeOrder() {
        io.print("Enter Order Number to be removed:");
        int orderNumber = io.readInt("Enter order number");
        return orderNumber;
    }

    public int getOrderToEdit() {
        io.print("Enter Order Number to edit:");
        int orderNumber = io.readInt("Enter order number");
        return orderNumber;
    }    

    public double getNewOrderArea() {
        double newArea = io.readDouble("Enter new order area:");
        return newArea;
    }
    
    public String getState(){
        io.print("Enter state from below:");
        io.print("1. OH");
        io.print("2. PA");
        io.print("3. MI");
        io.print("4. IN");
        return io.readString("Enter State: ");
    }
    
    public String getProductType() {
        io.print("Enter product type from below:");
        io.print("1. Carpet");
        io.print("2. Laminate");
        io.print("3. Tile");
        io.print("4. Wood");
        return io.readString("Enter product type():");
    }

}