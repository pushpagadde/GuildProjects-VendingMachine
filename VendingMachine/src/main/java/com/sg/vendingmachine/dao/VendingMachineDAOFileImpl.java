/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachineItem;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineDAOFileImpl implements VendingMachineItemDao {
    private Map< Integer , VendingMachineItem> vendingMachine = new HashMap<>() ;
    VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
    String VENDINGMACHINE_FILE = "VendingMachine.txt";
    String DELIMITER = "::";
    
    public VendingMachineDAOFileImpl() {
        this.auditDao = auditDao;
    }
    
    @Override
    public List<Integer> updateInventory(int menuSelection, BigDecimal enteredMoney) throws VendingMachineDaoException{
        VendingMachineItem updateItemInventory = vendingMachine.get(menuSelection);
        updateItemInventory.setInventory(updateItemInventory.getInventory() - 1);
        writeToFile(); 
        auditDao.writeAuditEntry("Item " + updateItemInventory.getItemName() + " removed.");
        List<Integer> changeList = returnChange(updateItemInventory.getPrice(), enteredMoney);
        return changeList;
    }
    //method to find the change for each coin denomination
    private List<Integer> returnChange(BigDecimal costOfItem, BigDecimal enteredMoney){
        if (costOfItem.compareTo(enteredMoney) < 0) {
            BigDecimal change = enteredMoney.subtract(costOfItem);
            double dChange = change.doubleValue();
            dChange = dChange * 100.00;
            double quarter = 25;
            double dime = 10;
            double nickel = 5;
            double penny = 1;
            double dollar = 100;
            List<Integer> changeList = new ArrayList<Integer>(5);
            double totalDollar = (dChange/dollar);
            dChange %= dollar;
            changeList.add((int) totalDollar);
            double totalQuarter = (dChange / quarter);
            dChange %= quarter;
            changeList.add((int) totalQuarter);
            double totalDime = (dChange / dime);
            dChange %= dime;
            changeList.add((int) totalDime);
            double totalNickel = (dChange / nickel);
            dChange %= nickel;
            changeList.add((int) totalNickel);
            double totalPenny = (dChange / penny);
            dChange %= penny;
            changeList.add((int) totalPenny);
            return changeList;
        } else{
            return null;
        }
    }
    
    
    public List<VendingMachineItem> getAllItems() throws VendingMachineDaoException{
        loadFile();
        return new ArrayList<>(vendingMachine.values());
    }
    
    private void loadFile() throws VendingMachineDaoException {
        UserIO userIO = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineView(userIO);
        int counter=1;
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(VENDINGMACHINE_FILE)));
            String currentLine;
            String[] currentTokens;
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                if (currentLine != null && currentLine.length() > 0){
                    currentTokens = currentLine.split(DELIMITER);
                    VendingMachineItem itemList = new VendingMachineItem(Integer.parseInt(currentTokens[0]));
                    itemList.setItemName(currentTokens[1]);
                    BigDecimal price = new BigDecimal(currentTokens[2]);
                    itemList.setPrice(price);
                    itemList.setInventory(Integer.parseInt(currentTokens[3]));
                    vendingMachine.put(itemList.getItemNumber(), itemList);
                }
            }
            scanner.close();
         } catch(FileNotFoundException | NumberFormatException e) {
            throw new VendingMachineDaoException (e.getMessage());
        }
    }
    
    private void writeToFile() throws VendingMachineDaoException{
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(VENDINGMACHINE_FILE));
        } catch (Exception e) {
            throw new VendingMachineDaoException("could not write to file", e);
        }
        List<VendingMachineItem> itemsList = this.getAllItems();
        for(VendingMachineItem currentItem : itemsList) {
            String completeRecord;
            completeRecord = currentItem.getItemNumber() + DELIMITER;
            completeRecord = completeRecord + currentItem.getItemName() + DELIMITER;
            completeRecord = completeRecord + currentItem.getPrice() + DELIMITER;
            completeRecord = completeRecord + currentItem.getInventory() + DELIMITER;
            out.println(completeRecord);
            out.flush();
        }
    }
    
}
