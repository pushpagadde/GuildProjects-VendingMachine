/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.ItemListServiceImpl;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PG
 */
@Controller
public class ItemController {
    ItemListServiceImpl service;// = new ItemListDao();
    private String itemPurchasedText = "Pick an item"; 
    private double moneyAdded = 0;
    private String messageToSend = "Welcome!";
    String changeDue = "";
    
    @Inject
    ItemController(ItemListServiceImpl service) {  
        this.service = service;
    }
        
    @RequestMapping(value="/displayItems", method=RequestMethod.GET)
    public String displayItemsPage(HttpServletRequest request, Model model) {
        List<Item> items = service.getAllItems();
        model.addAttribute("items", items);        
        model.addAttribute("id",String.valueOf(service.getSelection()));
        model.addAttribute("enteredMoney",service.sendEnteredMoney());
        model.addAttribute("message", service.getMessage());
        model.addAttribute("returnChange", service.getReturnChange());
        /*model.addAttribute("messageToSend", messageToSend);
        model.addAttribute("changeDue", changeDue);*/
        return "displayItems";
    }
    
    @RequestMapping(value="/itemSelection/{id}", method=RequestMethod.GET)
    public String itemSelection(@PathVariable("id") int id, Model model) {
        service.setSelection(id);        
        service.resetReturnChange();
        model.addAttribute("returnChange", service.getReturnChange());
        return "redirect:/";        
    }
        
    @RequestMapping(value="/addMoney", method=RequestMethod.GET)
    public String addMoney(HttpServletRequest request, Model model,
                           @RequestParam(required=false , value = "dollar") String dollarFlag,
                           @RequestParam(required=false , value = "dime") String dimeFlag,
                           @RequestParam(required=false , value = "quarter") String quarterFlag,
                           @RequestParam(required=false , value = "nickle") String nickleFlag) {
        if (dollarFlag != null){
            service.addMoney(1.00);
        } else if (dimeFlag != null){
            service.addMoney(0.10);
        } else if (quarterFlag != null){
            service.addMoney(0.25);
        } else if (nickleFlag != null){
            service.addMoney(0.05);
        }        
        return "redirect:displayItems";
    }
    
    @RequestMapping(value="/purchaseClick", method=RequestMethod.GET)
    public String purchaseClick(HttpServletRequest request, Model model) {
        service.validateAndCompletePurchase();
        return "redirect:displayItems";
    }
                
    @RequestMapping(value="/change", method=RequestMethod.GET)
    public String change(HttpServletRequest request, Model model) {
        service.returnMoney();
        return "redirect:displayItems";
    }
         
}
