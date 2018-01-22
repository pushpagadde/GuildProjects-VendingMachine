/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.inject.Inject;
import model.Item;

/**
 *
 * @author PG
 */
public class ItemServiceImpl {
    private ItemListDao dao;

    @Inject
    public ItemServiceImpl(ItemListDao dao) {
        this.dao = dao;
    }
    
    public List<Item> getAllItems(){
        return dao.getAllItems();
    }
    
    public void updateCount(int itemNumber){
        dao.updateCount(itemNumber);
    }
    
    public getItemById(int itemNumber){
        return
    }
    
}
