/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDAOFileImpl;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.VendingMachineItem;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {
    VendingMachineView view;// = new ClassRosterView();
    private UserIO io = new UserIOConsoleImpl();
    VendingMachineDAOFileImpl dao = new VendingMachineDAOFileImpl();
    VendingMachineServiceLayer service;// = new VendingMachineServiceLayerImpl(dao);

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.view = view;
        this.service = service;
    }
    public void run() throws VendingMachineDaoException {
        boolean keepGoing = true;
        boolean repeat = false;
        int menuSelection = 0;
        BigDecimal moneyToBuy = new BigDecimal(0);
        String YorN="";
        do {
            if(!repeat){
                YorN = io.readString("Do you want to buy something (Enter Y or N)?","y", "n");
            }
            
            if (YorN.equalsIgnoreCase("y")) {
                try{
                menuSelection = getMenu();
                }catch(VendingMachineDaoException e){
                  io.print(e.getMessage());
                  break;
                }
                io.print("You entered: " + menuSelection);
                boolean invalidAmount = true;
                do {//code to print the change to be returned to user
                    moneyToBuy = BigDecimal.valueOf(io.readDouble("Please enter Money."));
                    io.print("You entered money: " + moneyToBuy);
                    List<Integer> returnChange = dao.updateInventory(menuSelection,  moneyToBuy);
                    if (returnChange != null) {
                        invalidAmount = false;
                        String totalChange = "Dollars:" + returnChange.get(0) + " Quarters:" + returnChange.get(1);
                               totalChange = totalChange + " Dimes:" + returnChange.get(2);
                               totalChange = totalChange + " Nickels:" + returnChange.get(3);
                               totalChange = totalChange + " Pennies:" + returnChange.get(4);
                        io.print("Return change is : " + totalChange);
                
                        YorN = io.readString("Do you want to buy more?", "y","n");
                        if(YorN.equalsIgnoreCase("y")) {
                            keepGoing = true;
                            repeat = true;
                        } else {
                            keepGoing = false;
                            repeat = false;
                        }
                    } else {
                        invalidAmount = true;
                        io.print("Not a valid amount. Enter amount greater than price of item picked.");
                    }
                } while(invalidAmount);
            } else {
                keepGoing = false;
                io.print("GOOD BYE");
                //exitMessage();
            }
        }while (keepGoing);
        exitMessage();
    }
    private void exitMessage() {
        io.print("Good BYE!");
    }
    private int getMenu() throws VendingMachineDaoException {//method to print menu
        List<VendingMachineItem> itemsList = dao.getAllItems();
        view.displayTopBanner();
        List<Integer> availableItems = view.displayList(itemsList);
        view.displayBottomBanner();
        int itemSelected = view.GetItemSelection();
        boolean invalidInput = true;
        do{// code to validate the item number entered is correct
            invalidInput = service.validItemSelection(itemSelected, availableItems);
            if (invalidInput) {
                System.out.println("Invalid item keyed. Key those available.");
                itemSelected = view.GetItemSelection();
                invalidInput = true;
            } else {
                invalidInput = false;
            }
        }while(invalidInput);
        return itemSelected;
    }
}