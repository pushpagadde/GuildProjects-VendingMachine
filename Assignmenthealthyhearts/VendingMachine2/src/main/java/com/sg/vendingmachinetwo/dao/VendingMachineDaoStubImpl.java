/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.dao;

import com.sg.vendingmachinetwo.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {
    Item item;
    List<Item> itemList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl() {
        item = new Item(1);
        item.setItemName("Item 1");
        item.setPrice(BigDecimal.valueOf(1.00));
        item.setInventory(10);
        itemList.add(item);
    }
    
    public Item addItem(int itemNumber, Item item) throws VendingMachineFileNotFoundException {
        if(itemNumber == item.getItemNumber()) {
            itemList.add(item);
            return item;
        } else {
            return null;
        }
    }
            
    public Item removeItem(int itemNumber) throws VendingMachineFileNotFoundException{
        if(itemNumber == item.getItemNumber()) {
            return item;
        } else {
            return null;
        }
    }
    
    public Item editItem(int itemNumber, int newInventoryValue) throws  VendingMachineFileNotFoundException{
        if(itemNumber == item.getItemNumber()) {
            item.setInventory(newInventoryValue);
            return item;
        } else {
            return null;
        }
    }
    
    public List<Item> getAllItems() throws VendingMachineFileNotFoundException{
        return itemList;
    }
    
    public Item getItemInfo(String title) throws VendingMachineFileNotFoundException{
        if(item.getItemName().equalsIgnoreCase(title)) {
            return item;
        } else {
            return null;
        }
    }
    
    public Item editItemInventory(int itemNumber)throws VendingMachineFileNotFoundException{
        if(itemNumber == item.getItemNumber()) {
            return item;
        } else {
            return null;
        }
    }
    
    public Item getItem(int itemNumber)throws VendingMachineFileNotFoundException{
        if(itemNumber == item.getItemNumber()) {
            return item;
        } else {
            return null;
        }
    }
    
    public List<Integer> getKeySet()throws VendingMachineFileNotFoundException{
        List<Integer> itemNumbers = new ArrayList<Integer>();
        itemNumbers.add(item.getItemNumber());
        return itemNumbers;
    }
}