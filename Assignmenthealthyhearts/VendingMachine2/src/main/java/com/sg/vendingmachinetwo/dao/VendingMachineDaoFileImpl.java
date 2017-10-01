/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.dao;

import com.sg.vendingmachinetwo.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {    
    private Map<String, Item> vendingMachineItemsMap;
    private String vendingMachineFileName = "VendingMachine2.txt";
    public static final String DELIMITER = "::";
    
    public VendingMachineDaoFileImpl(String fileName){
        vendingMachineFileName = fileName;
        vendingMachineItemsMap = new HashMap<>();
    }
    
    @Override
    public Item addItem(int itemNumber, Item item) throws VendingMachineFileNotFoundException {
        vendingMachineItemsMap.put(itemNumber+"", item);
        writeToFile();
        return item;
    }

    @Override
    public Item removeItem(int itemNumber) throws  VendingMachineFileNotFoundException {
        Item removedItem = vendingMachineItemsMap.remove(itemNumber+"");
        writeToFile();
        return removedItem;
    }
    @Override//mothod to auto assin the item number when adding new item to inventory
    public List<Integer> getKeySet()throws VendingMachineFileNotFoundException{
        List<Integer> keySet = new ArrayList<Integer>();
        List<Item> itemList = this.getAllItems();
        for(Item currentItem : itemList) {
            keySet.add(currentItem.getItemNumber());
        }
        return keySet;
        
    }
    //edit the inventory for any item 
    @Override
    public Item editItem(int itemNumber, int newInventoryValue) throws VendingMachineFileNotFoundException {
        Item editItem = vendingMachineItemsMap.get(itemNumber+"");
        editItem.setInventory(newInventoryValue);
        writeToFile();
        return editItem;
    }
    //auto reduction of inventory when an item is purchased
    @Override
    public Item editItemInventory(int itemNumber)throws VendingMachineFileNotFoundException{
        Item editItem = vendingMachineItemsMap.get(itemNumber + "");
        System.out.println("editItem.."+editItem.getItemName()+"..");
        editItem.setInventory(editItem.getInventory() - 1);
        vendingMachineItemsMap.put(itemNumber+"", editItem);
        writeToFile();
        return editItem;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachineFileNotFoundException {
        loadItemsFromFile();
        //return new ArrayList<Item>(vendingMachineItemsMap.values());
        return vendingMachineItemsMap.values().stream()
                                     .collect(Collectors.toList());
    }

    @Override
    public Item getItemInfo(String itemName) throws VendingMachineFileNotFoundException{
        loadItemsFromFile();
        List<Item> itemList = this.getAllItems();
        for(Item currentItem : itemList) {
            if (currentItem.getItemName().equalsIgnoreCase(itemName)){
                return currentItem;
            }
        }
        return null;
    }
    
    @Override
    public Item getItem(int itemNumber)throws VendingMachineFileNotFoundException{
        loadItemsFromFile();
        List<Item> itemList = this.getAllItems();
        for(Item currentItem : itemList) {
            if (currentItem.getItemNumber() == itemNumber){
                return currentItem;
            }
        }
        return null;
    }
    
    private void loadItemsFromFile() throws VendingMachineFileNotFoundException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(vendingMachineFileName)));
        } catch(FileNotFoundException  e) {
            throw new VendingMachineFileNotFoundException ("Could not load data into memory", e);
        }
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Item currentItem = new Item(Integer.parseInt(currentTokens[0]));
            currentItem.setItemName(currentTokens[1]);
            currentItem.setPrice(new BigDecimal(currentTokens[2]));
            currentItem.setInventory(Integer.parseInt(currentTokens[3]));
            vendingMachineItemsMap.put(currentItem.getItemNumber()+"", currentItem);
        }
        scanner.close();
    }
        
    private void writeToFile() throws VendingMachineFileNotFoundException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(vendingMachineFileName));
        } catch (IOException e) {
            throw new VendingMachineFileNotFoundException("Could not save data", e);
        }
        List<Item> itemList = this.getAllItems();
        for(Item currentItem : itemList) {
                String completeRecord;
                completeRecord = currentItem.getItemNumber() + DELIMITER;
                completeRecord = completeRecord + currentItem.getItemName() + DELIMITER;
                completeRecord = completeRecord + currentItem.getPrice() + DELIMITER;
                completeRecord = completeRecord + currentItem.getInventory() + DELIMITER;
                out.println(completeRecord);
                out.flush();
        }
        out.close();
    }
}