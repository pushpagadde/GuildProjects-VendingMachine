/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.dao;

import com.sg.vendingmachinetwo.dto.Item;
import java.util.List;
/**
 *
 * @author apprentice
 */
public interface VendingMachineDao {
    
    Item addItem(int itemNumber, Item item) throws VendingMachineFileNotFoundException;
    Item removeItem(int itemNumber) throws VendingMachineFileNotFoundException;
    Item editItem(int itemNumber, int newInventoryValue) throws  VendingMachineFileNotFoundException;
    List<Item> getAllItems() throws VendingMachineFileNotFoundException;
    Item getItemInfo(String title) throws VendingMachineFileNotFoundException;
    Item editItemInventory(int itemNumber)throws VendingMachineFileNotFoundException;
    Item getItem(int itemNumber)throws VendingMachineFileNotFoundException;
    List<Integer> getKeySet()throws VendingMachineFileNotFoundException;
}