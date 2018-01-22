/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;
import com.sg.vendingmachinespringmvc.dao.ItemListDao;
import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author PG
 */
public class ItemListServiceImpl {
    private ItemListDao dao;
    int selection;
    double enteredAmount;
    String message = "Message", returnChange="Return Change";

    public ItemListServiceImpl(){
    }
    
    public void setDao(ItemListDao dao){
        this.dao = dao;
    }
    
    @Inject
    public ItemListServiceImpl(ItemListDao dao) {
        returnChange = "Return Change";
        this.dao = dao;
    }
    public void setSelection(int id){
        this.selection = id;
    }
    
    public int getSelection(){
        return selection;
    }
    
    public String getMessage(){
        return message;
    }
    
    public String getReturnChange(){
        return returnChange;
    }
    
    public void addMoney(double add){
        enteredAmount = enteredAmount + add;
        enteredAmount = Math.round(enteredAmount * 100);
        enteredAmount = enteredAmount/100;            
    }
    
    public void resetReturnChange(){
        returnChange = "Return Change";
    }
    
    private double addMoreMoney(){
        double more;
        more = dao.getPrice(selection) - enteredAmount;
        more = Math.round(more * 100);
        more = more/100;               
        return more;
    }
    
    public void returnMoney(){
        if(enteredAmount != 0) {
            calculateChange(enteredAmount);
        }else {
            message = "No amount entered.";
        }        
    }
    
    public void calculateChange(double returnAmount){
        returnChange = "";
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
            returnChange = returnChange + dollars + " Dollars ";
        }       
        double totalQuarter = (returnAmount / quarter);
        quarters = (int)totalQuarter;
        returnAmount %= quarter;
        if (quarters != 0) {
            returnChange = returnChange + quarters + " Quarters ";
        }        
        double totalDime = (returnAmount / dime);
        dimes = (int)totalDime;
        returnAmount %= dime;        
        if (dimes != 0) {
            returnChange = returnChange + dimes + " Dimes ";
        }
        
        double totalNickel = (returnAmount / nickel);
        nickels = (int)totalNickel;
        returnAmount %= nickel;
        if (nickels != 0 ) {
            returnChange = returnChange + nickels + " Nickles ";
        }
        
        double totalPenny = (returnAmount / penny);
        pennies = (int)totalPenny;
        returnAmount %= penny;
        if (pennies != 0 ) {
            returnChange = returnChange + pennies + " Pennies ";
        }            
        if (returnChange == ""){
            returnChange = "No return change!";
        }                
    }
    
    public void validateAndCompletePurchase(){        
        if (selection == 0 ){
            message = "Pick and item!";
        } else if(!dao.verifyQuantity(selection)) {
            message = "SOLD OUT!";            
        } else if(dao.getPrice(selection) > enteredAmount) {            
            message = "Enter more $ " + addMoreMoney();
        } else {            
            dao.updateQuantity(selection);
            calculateChange(enteredAmount - dao.getPrice(selection));
            selection = 0;
            message = "Thank you!";
            enteredAmount = 0.00;            
        }                
    }        
    public double sendEnteredMoney(){
        return enteredAmount;
    }    
    public List<Item> getAllItems(){
        return dao.getAllItems();
    }        
    public Item getItemById(int itemNumber){        
        return dao.getItemById(itemNumber);
    }    
}
