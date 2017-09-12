/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dao.VendingMachineDAOFileImpl;
import com.sg.vendingmachine.dto.VendingMachineItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineView {
    private UserIO userio;
    VendingMachineDAOFileImpl dao = new VendingMachineDAOFileImpl();
    
    public VendingMachineView(UserIO io) {
        this.userio = io;
    }
    public int GetItemSelection() {
        return userio.readInt("Please select from the above listed items.");
    }
    public void displayTopBanner() {
        userio.print("===========================================");
        userio.print("                Main Menu                  ");
        userio.print("===========================================");
        userio.print("No." + " " + "Items" + "      " + "Price" + "   " + "Inventory");
        userio.print("===========================================");
    }
    public List<Integer> displayList(List<VendingMachineItem> itemsList){
        List<Integer> availableItems = new ArrayList<>();
        for(VendingMachineItem currentItem : itemsList) {
            String allDetails;
            if (currentItem.getInventory() > 0) {
                allDetails = currentItem.getItemNumber() + ". ";
                allDetails = allDetails + currentItem.getItemName()+ " ";
                allDetails = allDetails + "$" + currentItem.getPrice() + " ";
                allDetails = allDetails + Integer.toString(currentItem.getInventory());
                availableItems.add(currentItem.getItemNumber());
                userio.print(allDetails);
            }
        }
        return availableItems;
    }
    public void displayBottomBanner() {
        userio.print("===========================================");
    }
    public void displayUserSelection() {
        userio.print("You selected:");
    }
}
