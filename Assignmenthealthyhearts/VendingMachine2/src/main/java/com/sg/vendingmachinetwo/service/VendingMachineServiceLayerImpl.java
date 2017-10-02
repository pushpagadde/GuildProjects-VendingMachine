/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.service;

import com.sg.vendingmachinetwo.dao.VendingMachineAuditDao;
import com.sg.vendingmachinetwo.dao.VendingMachineDao;
import com.sg.vendingmachinetwo.dao.VendingMachineFileNotFoundException;
import com.sg.vendingmachinetwo.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
    VendingMachineDao dao;
    VendingMachineAuditDao auditDao;
    double totalUserMoney = 0;
    int count = 0;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
       
    @Override
    public Item addItem(int itemNumber, Item item) throws VendingMachineDuplicateItemException,
                                                            VendingMachineFileNotFoundException {
        if( dao.getItemInfo(item.getItemName() ) != null ) {
            throw new VendingMachineDuplicateItemException("Item already exists in inventory.");
        }
        dao.addItem(itemNumber, item);
        //auditDao.writeAuditEntry("Item: " + item.getItemName() + " added.");
        return item;
    }   
    
    @Override
    public Item editItem(int itemNumber, int newInventoryValue) throws VendingMachineFileNotFoundException,
                                                                       VendingMachineItemNotFoundException{
        List<Integer> itemNumberList = dao.getKeySet();
        Item returnItem;
        if(itemNumberList.contains(itemNumber) ) {
            returnItem = dao.editItem(itemNumber, newInventoryValue);
        } else {
            throw new VendingMachineItemNotFoundException("Item number not found. Enter valid item number.");
        }
        return returnItem;
    }
    
    @Override
    public List<Item> getAllItems() throws VendingMachineFileNotFoundException{
        return dao.getAllItems();
    }   
    
    @Override
    public Item removeItem(int itemNumber) throws VendingMachineFileNotFoundException,
                                                  VendingMachineItemNotFoundException {
        
        //auditDao.writeAuditEntry("Item: " + itemNumber + " removed.");
        return dao.removeItem(itemNumber);
    }
    
    @Override
    public Item getItemInfo(String title) throws VendingMachineFileNotFoundException, 
                                                 VendingMachineItemNotFoundException{
        return dao.getItemInfo(title);
    }
    
    @Override
    public void validateItemSelection(int itemNumber) 
            throws VendingMachineItemNotFoundException,
                   VendingMachineFileNotFoundException {
        Item item = dao.getItem(itemNumber);
        if (item == null || item.getInventory() < 1) {
            throw new VendingMachineItemNotFoundException("Not valid item selection. Enter from list above.");
        }
    }
    
    @Override
    public Change editItemInventoryGetChange(int itemNumber, double userMoney)
            throws VendingMachineFileNotFoundException,
                   VendingMachineItemNotFoundException,
                   VendingMachineInsufficientFundsException {
        totalUserMoney = totalUserMoney + userMoney;
        List<Integer> keys = dao.getKeySet();
        Item item;
        item = dao.getItem(itemNumber);
        /*if(keys.contains(itemNumber)) {
            
        } else {
            throw new VendingMachineItemNotFoundException("Not valid item selection. Enter from list above.");
        }*/
        if( item.getPrice().compareTo(BigDecimal.valueOf(totalUserMoney)) > 0 ) {
            String message;
            double difference = item.getPrice().doubleValue() - totalUserMoney;
            message = "Not valid amount. Enter " + String.format( "%.2f",difference) + " more. The price of item is " + item.getPrice();
            count = count + 1;
            throw new VendingMachineInsufficientFundsException(message);
        }
        dao.editItemInventory(itemNumber );
        userMoney = totalUserMoney;
        totalUserMoney = 0;
        return returnchange(item.getPrice().subtract(BigDecimal.valueOf(userMoney)));
    }
    
    private Change returnchange(BigDecimal returnAmount) {
        double change = returnAmount.doubleValue();
        change = change * (-100.00);
        double quarter = 25;
        double dime = 10;
        double nickel = 5;
        double penny = 1;
        double dollar = 100;
        List<Integer> changeList = new ArrayList<Integer>(5);
        Change changeInCoins = new Change();
        
        double totalDollar = (change/dollar);
        change %= dollar;
        changeInCoins.setTotalDollar((int) totalDollar);
        double totalQuarter = (change / quarter);
        change %= quarter;
        changeInCoins.setTotalQuarter(totalQuarter);
        double totalDime = (change / dime);
        change %= dime;
        changeInCoins.setTotalDime(totalDime);
        double totalNickel = (change / nickel);
        change %= nickel;
        changeInCoins.setTotalNickel(totalNickel);
        double totalPenny = (change / penny);
        change %= penny;
        changeInCoins.setTotalPenny(totalPenny);
        return changeInCoins;
    }
    
    @Override
    public int getLastItemNumber() throws VendingMachineFileNotFoundException {
        List<Item> itemList = dao.getAllItems();
        int maxItemNumber = -1;
        for(Item currentItem : itemList) {        
            if (maxItemNumber < currentItem.getItemNumber()){
                maxItemNumber = currentItem.getItemNumber();
            }
        }
        return maxItemNumber;
    }
}