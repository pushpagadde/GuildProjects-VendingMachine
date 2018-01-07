/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;
import com.sg.vendingmachinespringmvc.dao.ItemListDao;
import com.sg.vendingmachinespringmvc.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PG
 */
@Controller
public class ItemController {
    ItemListDao dao;// = new ItemListDao();
    private String itemPurchasedText = "Pick an item"; 
    private double moneyAdded = 0;
    private String messageToSend = "Welcome!";
    String changeDue = "";
    
    ItemController(ItemListDao dao) {                
        this.dao = dao;
    }
        
    @RequestMapping(value="/displayItems", method=RequestMethod.GET)
    public String displayItemsPage(HttpServletRequest request, Model model) {
        List<Item> items = dao.getAllItems();
        for (int index = 0; index < items.size(); index++){
            model.addAttribute("item"+items.get(index).getItemId(), items.get(index));
        }
        model.addAttribute("itemPurchasedText", itemPurchasedText);
        model.addAttribute("moneyAdded", moneyAdded);
        model.addAttribute("messageToSend", messageToSend);
        model.addAttribute("changeDue", changeDue);
        return "displayItems";
    }
    
    @RequestMapping(value="/change", method=RequestMethod.GET)
    public String change(HttpServletRequest request, Model model) {
        changeDue = returnChange(moneyAdded);
        messageToSend = "Thank you!";
        itemPurchasedText = "Pick an item"; 
        moneyAdded = 0;        
        return "redirect:displayItems";
    }
    
    
    @RequestMapping(value="/purchaseClick", method=RequestMethod.GET)
    public String purchaseClick(HttpServletRequest request, Model model) {
        double needMoreMoney = 0;
        List<Item> items = dao.getAllItems();
        
        if (itemPurchasedText.isEmpty() || itemPurchasedText == "Pick an item") {
            messageToSend = "Select an item.";
        } else {
            int itemNumber = Integer.parseInt(itemPurchasedText) - 1;
            if ( items.get(itemNumber).getItemQuantity() != 0) {                
                if(moneyAdded >= items.get(itemNumber).getItemPrice() ) {
                    changeDue = returnChange(moneyAdded - items.get(itemNumber).getItemPrice() );
                    messageToSend = "Thank you!";
                    itemPurchasedText = "Pick an item"; 
                    moneyAdded = 0;
                    dao.updateCount(itemNumber);
                } else {
                    changeDue = "";
                    needMoreMoney = items.get(itemNumber).getItemPrice() - moneyAdded;
                    needMoreMoney = Math.round(needMoreMoney * 100);
                    needMoreMoney = needMoreMoney/100;       

                    messageToSend = "Add " + needMoreMoney + " more.";
                }
            } else {           
                itemPurchasedText = "Pick an item";
                messageToSend = "SOLD OUT";
            }
        }
        return "redirect:displayItems";
    }
    
    private String returnChange(double returnAmount) {
        String changeString = "";
        returnAmount = Math.round(returnAmount * 100);
        returnAmount = returnAmount/100;       
        returnAmount = returnAmount * 100.00;
        double quarter = 25;
        double dime = 10;
        double nickel = 5;
        double penny = 1;
        double dollar = 100;
        int quarters, dimes, nickels,pennies, dollars;
        double totalDollar = (returnAmount / dollar);
        dollars = (int)totalDollar;
        returnAmount %= dollar;
        if (dollars != 0) {
            changeString = changeString + dollars + " Dollars ";
        }       
        double totalQuarter = (returnAmount / quarter);
        quarters = (int)totalQuarter;
        returnAmount %= quarter;
        if (quarters != 0) {
            changeString = changeString + quarters + " Quarters ";
        }        
        double totalDime = (returnAmount / dime);
        dimes = (int)totalDime;
        returnAmount %= dime;        
        if (dimes != 0) {
            changeString = changeString + dimes + " Dimes ";
        }
        
        double totalNickel = (returnAmount / nickel);
        nickels = (int)totalNickel;
        returnAmount %= nickel;
        if (nickels != 0 ) {
            changeString = changeString + nickels + " Nickles ";
        }
        
        double totalPenny = (returnAmount / penny);
        pennies = (int)totalPenny;
        returnAmount %= penny;
        if (pennies != 0 ) {
            changeString = changeString + pennies + " Pennies ";
        }            
        
        return changeString;
    }
    
    @RequestMapping(value="/addMoney", method=RequestMethod.GET)
    public String addMoney(HttpServletRequest request, Model model,
                           @RequestParam(required=false , value = "dollar") String dollarFlag,
                           @RequestParam(required=false , value = "dime") String dimeFlag,
                           @RequestParam(required=false , value = "quarter") String quarterFlag,
                           @RequestParam(required=false , value = "nickle") String nickleFlag) {
        
        if (dollarFlag != null){
            moneyAdded = moneyAdded + 1.00;        
        } else if (dimeFlag != null){
            moneyAdded = moneyAdded + 0.10;            
        } else if (quarterFlag != null){
            moneyAdded = moneyAdded + 0.25;            
        } else if (nickleFlag != null){
            moneyAdded = moneyAdded + 0.05;            
        }        
        moneyAdded = Math.round(moneyAdded * 100);
        moneyAdded = moneyAdded/100;
        return "redirect:displayItems";
    }
        
    @RequestMapping(value="/itemSelect", method=RequestMethod.GET)
    public String itemSelect(HttpServletRequest request, Model model,
                            @RequestParam(required=false , value = "button1") String button1Flag,
                            @RequestParam(required=false , value = "button2") String button2Flag,
                            @RequestParam(required=false , value = "button3") String button3Flag,
                            @RequestParam(required=false , value = "button4") String button4Flag,
                            @RequestParam(required=false , value = "button5") String button5Flag,
                            @RequestParam(required=false , value = "button6") String button6Flag,
                            @RequestParam(required=false , value = "button7") String button7Flag,
                            @RequestParam(required=false , value = "button8") String button8Flag,
                            @RequestParam(required=false , value = "button9") String button9Flag) {
        if (button1Flag != null){
            itemPurchasedText = "1";
        } else if (button2Flag != null){
            itemPurchasedText = "2";
        } else if (button3Flag != null){
            itemPurchasedText = "3";
        } else if (button4Flag != null){
            itemPurchasedText = "4";
        } else if (button5Flag != null){
            itemPurchasedText = "5";
        } else if (button6Flag != null){
            itemPurchasedText = "6";
        } else if (button7Flag != null){
            itemPurchasedText = "7";
        } else if (button8Flag != null){
            itemPurchasedText = "8";
        } else if (button9Flag != null){
            itemPurchasedText = "9";
        }
        changeDue = "";
        return "redirect:displayItems";
    }
}
