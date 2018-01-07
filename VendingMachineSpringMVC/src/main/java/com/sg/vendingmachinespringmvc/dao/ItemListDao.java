/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PG
 */
public class ItemListDao {
    Item item = null;
    private Map<Integer, Item> itemMap = new HashMap<>();
    int ids[] = {1,2,3,4,5,6,7,8,9};
    String names[] = {"Snickers", "M&Ms", "Pringles",
                      "Reese's", "Pretzels", "Twinkies",
                      "Doritos", "Almond Joy", "Trident"};    
    
    double prices[] = {1.85, 1.50, 2.10, 
                       1.85, 1.25, 1.95, 
                       1.75, 1.85, 1.95};
    int quantity[] = {9,2,5, 4,9,3, 11,0,6};

    public ItemListDao() {
        for(int i = 0; i<9; i++) {
            item = new Item();
            item.addItems(ids[i], names[i], prices[i], quantity[i]);
            itemMap.put(i+1, item);
        }
    }

    public List<Item> getAllItems() {        
        Collection<Item> c = itemMap.values();        
        return new ArrayList(c);
    }        
    
    public void updateCount(int itemNumber){
        item = itemMap.get(itemNumber + 1);        
        item.setItemQuantity(item.getItemQuantity() - 1);        
    }   
}