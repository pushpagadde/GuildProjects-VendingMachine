/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.controller;


import com.sg.vendingmachinetwo.dto.Item;
import com.sg.vendingmachinetwo.ui.VendingMachineView;
import com.sg.vendingmachinetwo.dao.VendingMachineFileNotFoundException;
import com.sg.vendingmachinetwo.service.Change;
import com.sg.vendingmachinetwo.service.VendingMachineDuplicateItemException;
import com.sg.vendingmachinetwo.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachinetwo.service.VendingMachineItemNotFoundException;
import com.sg.vendingmachinetwo.service.VendingMachineServiceLayer;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {
    VendingMachineServiceLayer service;
    VendingMachineView view = new VendingMachineView();

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() throws VendingMachineFileNotFoundException,
                             VendingMachineDuplicateItemException,
                             VendingMachineItemNotFoundException,
                             VendingMachineInsufficientFundsException {
        System.out.println("Test");
        boolean keepGoing = true;
        int menuSelection ;
        while (keepGoing) {
            menuSelection = printMenuAndGetSelection();
            switch(menuSelection) {
                case 1: 
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3: 
                    editItemInventory();
                    break;
                case 4:
                    listAllItems();
                    break;
                case 5:
                    buyItem();
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
    private void exitMessage(){
        view.exitMessage();
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private int printMenuAndGetSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void addItem() throws VendingMachineFileNotFoundException,
                                  VendingMachineDuplicateItemException {
        boolean duplicateItem = false;
        do {
            Item newItem = view.getItemInfo(service.getLastItemNumber()+1);
            try {
                service.addItem(newItem.getItemNumber(), newItem);
                duplicateItem = false;
            } catch (Exception ex) {
                duplicateItem = true;
                view.displayErrorMessage(ex.getMessage());
            }
        } while (duplicateItem);
        listAllItems();
    }
    
    private void removeItem() throws VendingMachineFileNotFoundException,
                                     VendingMachineItemNotFoundException {
        listAllItems();
        try {
            service.removeItem(view.getItemNumber());
        } catch (Exception ex) {
            view.displayErrorMessage(ex.getMessage());
        }
        listAllItems();
    }
    
    private void editItemInventory() throws VendingMachineFileNotFoundException,
                                            VendingMachineItemNotFoundException{
        int newInventory, editItem;
        Item returnItem;
        boolean invalidItemNumber = true;
        do {
            listAllItemsForNewInventory();
            editItem = view.getItemNumber();
            newInventory = view.getItemInventory();
            try {
                returnItem = service.editItem(editItem, newInventory);
            } catch (Exception ex) {
                returnItem = null;
                invalidItemNumber = true;
                view.displayErrorMessage(ex.getMessage());
            }
            if (returnItem == null) {
                invalidItemNumber = true;
            } else {
                invalidItemNumber = false;
            }    
        } while (invalidItemNumber);
        listAllItems();
    }
    
    private void buyItem() throws VendingMachineFileNotFoundException,
                                  VendingMachineItemNotFoundException,
                                  VendingMachineInsufficientFundsException {
        boolean wrongEntry = true, wrongItem = true;
        Change changeInCoins;
        List<Item> itemList = service.getAllItems();
        double userMoney = view.getUserMoney();
        do {
            view.displayAllItems(itemList);
            int itemNumber = view.getItemNumber();
            try{
                service.validateItemSelection(itemNumber);
                wrongItem = false;
                do {
                    try {
                        changeInCoins = service.editItemInventoryGetChange(itemNumber, userMoney);
                        view.printChange(changeInCoins);
                        wrongEntry = false;
                    } catch (Exception ex) {
                        wrongEntry = true;
                        view.displayErrorMessage(ex.getMessage());
                    }
                    if(wrongEntry) {
                        userMoney = view.getUserMoney();
                    }
                }while(wrongEntry);
            } catch (Exception ex) {
                wrongItem = true;
                view.displayErrorMessage(ex.getMessage());
            }
        } while (wrongItem);
    }
    
    private void listAllItems() throws VendingMachineFileNotFoundException{
        try {
            List<Item> itemList = service.getAllItems();
            view.displayAllItems(itemList);
        } catch (Exception ex) {
            view.displayErrorMessage(ex.getMessage());
        }
        view.displayItem("");
    }
    
    private void listAllItemsForNewInventory() throws VendingMachineFileNotFoundException {
        try {
            List<Item> itemList = service.getAllItems();
            view.displayAllItemsForNewInventory(itemList);
        } catch (Exception ex) {
            view.displayErrorMessage(ex.getMessage());
        }
        view.displayItem("");
    }
}