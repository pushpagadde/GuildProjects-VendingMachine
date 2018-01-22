/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Item;

/**
 *
 * @author PG
 */
public class ItemListDao {
    HashMap<Integer,Item> items;
    
    public ItemListDao() {
        items = new HashMap<>();
        items.put(1, new Item(1,"Snickers",new BigDecimal("1.85"),1));
        items.put(2, new Item(2,"M & Ms",new BigDecimal("1.50"),9));
        items.put(3, new Item(3,"Pringles",new BigDecimal("2.10"),2));
        items.put(4, new Item(4,"Reese's",new BigDecimal("1.85"),5));
        items.put(5, new Item(5,"Pretzels",new BigDecimal("1.25"),4));
        items.put(6, new Item(6,"Twinkies",new BigDecimal("1.95"),0));
        items.put(7, new Item(7,"Doritos",new BigDecimal("1.75"),3));
        items.put(8, new Item(8,"Almond Joy",new BigDecimal("1.85"),11));
        items.put(9, new Item(9,"Trident",new BigDecimal("1.95"),1));    
        
    }
    
    public List<Item> getAllItems(){
        List<Item> itemList = (ArrayList<Item>) items.values();
        System.out.println("dao ");
        return itemList;
    }
    
}
