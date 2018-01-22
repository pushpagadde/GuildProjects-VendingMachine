/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ItemServiceImpl;

/**
 *
 * @author PG
 */
@Controller
public class ItemController {
    private ItemServiceImpl service;
    
    @Inject
    public ItemController(ItemServiceImpl service){
        System.out.println("controller constructor");
        this.service = service;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET ) 
    public String index(Model model){
        System.out.println("controller indexpage"+service.getAllItems());
        model.addAttribute("items",service.getAllItems());
        return "index";
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String itemSelection(HttpServletRequest request, Model model) {
        
        /*List<Item> items = dao.getAllItems();
        for (int index = 0; index < items.size(); index++){
            model.addAttribute("item"+items.get(index).getItemId(), items.get(index));
        }
        model.addAttribute("itemPurchasedText", itemPurchasedText);
        model.addAttribute("moneyAdded", moneyAdded);
        model.addAttribute("messageToSend", messageToSend);
        model.addAttribute("changeDue", changeDue);*/
        return "index";
    }
    
}
