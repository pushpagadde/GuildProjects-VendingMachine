/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.service;

import com.sg.vendingmachinetwo.dao.VendingMachineFileNotFoundException;
import com.sg.vendingmachinetwo.dto.Item;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingMachineServiceLayer {
    Item addItem(int itemNumber, Item item) throws VendingMachineDuplicateItemException, 
                                                   VendingMachineFileNotFoundException;
    int getLastItemNumber() throws VendingMachineFileNotFoundException;
    List<Item> getAllItems() throws VendingMachineFileNotFoundException;
    Item removeItem(int itemNumber) throws VendingMachineFileNotFoundException,
                                           VendingMachineItemNotFoundException;
    Item editItem(int itemNumber, int newInventoryValue) throws VendingMachineFileNotFoundException,
                                                                VendingMachineItemNotFoundException;
    Item getItemInfo(String title) throws VendingMachineFileNotFoundException, 
                                          VendingMachineItemNotFoundException;
    Change editItemInventoryGetChange(int itemNumber, double userMoney)
            throws VendingMachineFileNotFoundException, 
                   VendingMachineItemNotFoundException,
                   VendingMachineInsufficientFundsException;

}
