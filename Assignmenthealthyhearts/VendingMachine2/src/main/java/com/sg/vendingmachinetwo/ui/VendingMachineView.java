/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.ui;

import com.sg.vendingmachinetwo.dto.Item;
import com.sg.vendingmachinetwo.service.Change;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineView {
    UserIO io = new UserIOImpl();
    
    public VendingMachineView() {
    }
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    public void displayTopBanner() {
        io.print("===========================================");
        io.print("                Main Menu                  ");
        io.print("===========================================");
        io.print("No." + " " + "Items" + "      " + "Price" + "   " + "Inventory");
        io.print("===========================================");
    }

    public int printMenuAndGetSelection() {
        io.print("======Main Menu:======");
        io.print("1. Add Item to Vending Machine");
        io.print("2. Remove Item from Vending Machine");
        io.print("3. Edit Item Inventory");
        io.print("4. List all Items in Inventory");
        io.print("5. Buy Item");
        io.print("6. Exit");
        return io.readInt("Key in a number to make your selection.", 1, 6);
    }

    public void displayBottomBanner() {
        io.print("===========================================");
    }

    public void displayUserSelection() {
        io.print("You selected:");
    }
    
    public double getUserMoney() {
        return io.readDouble("Enter money");
    }
    
    public Item getItemInfo(int totalItems){
        io.print("Enter New Item details:");
        int itemNumber = totalItems;
        String itemName = io.readString("Enter Name of Item");
        BigDecimal price = BigDecimal.valueOf(io.readDouble("Enter Price of item:"));
        int inventory = io.readInt("Enter Quantity of the Item");
        Item currentItem = new Item(itemNumber);
        currentItem.setItemNumber(itemNumber);
        currentItem.setItemName(itemName);
        currentItem.setPrice(price);
        currentItem.setInventory(inventory);
        return currentItem;
    }

    public void displayItem(String itemInfo){
        io.print(itemInfo);
    }
    
    public void displayAllItems(List<Item> itemList ){
        displayTopBanner();
        for(Item currentItem : itemList) {
            if (currentItem.getInventory() != 0){
                io.print(currentItem.getItemNumber()+"  "+currentItem.getItemName()+"        "+currentItem.getPrice()+"    "+currentItem.getInventory());
            }
        }
        displayBottomBanner();
    }
    
    public void displayAllItemsForNewInventory(List<Item> itemList) {
        displayTopBanner();
        for(Item currentItem : itemList) {
            io.print(currentItem.getItemNumber()+"  "+currentItem.getItemName()+"        "+currentItem.getPrice()+"    "+currentItem.getInventory());
        }
        displayBottomBanner();
    }
    
    public int getItemInventory(){
        return io.readInt("Enter new Inventory for selected item");
    }
    
    public int getItemNumber(String prompt){
        return io.readInt(prompt);
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void printChange(Change changeInCoins) {
        io.print("Return change is:");
        io.print("Dollars:" + changeInCoins.getTotalDollar());
        io.print("Quarters:" + changeInCoins.getTotalQuarter());
        io.print("Dimes:" + changeInCoins.getTotalDime());
        io.print("Nickel:" + changeInCoins.getTotalNickel());
        io.print("Penny:" + changeInCoins.getTotalPenny());
    }
    public void displayUnknownCommandBanner(){
        io.print("Unknown command");
    }
    
    public void exitMessage(){
        io.print("Good Bye!!");
    }
}
