/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.ArrayList;
import java.util.List;
//import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
//import org.junit.BeforeClass;
//import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author PG
 */
public class VendingMachineDaoTest {
    private ItemListDao dao = null;
    
    public VendingMachineDaoTest() {
        
    }
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("itemListDao", ItemListDao.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPriceGetAllItems() {
        Item item = new Item();
        List<Item> itemMap = new ArrayList<>();
        itemMap = dao.getAllItems();
        item = itemMap.get(0);
        assertEquals("1.85", String.valueOf(item.getItemPrice()));
        item = itemMap.get(1);
        assertEquals("1.5", String.valueOf(item.getItemPrice()));
        item = itemMap.get(2);
        assertEquals("2.1", String.valueOf(item.getItemPrice()));
        item = itemMap.get(3);
        assertEquals("1.85", String.valueOf(item.getItemPrice()));
        item = itemMap.get(4);
        assertEquals("1.25", String.valueOf(item.getItemPrice()));
        item = itemMap.get(5);
        assertEquals("1.95", String.valueOf(item.getItemPrice()));
        item = itemMap.get(6);
        assertEquals("1.75", String.valueOf(item.getItemPrice()));
        item = itemMap.get(7);
        assertEquals("1.85", String.valueOf(item.getItemPrice()));
        item = itemMap.get(8);
        assertEquals("1.95", String.valueOf(item.getItemPrice()));
                          
    }
    
    @Test
    public void updateQuantity() {        
        Item item = dao.getItemById(1);
        assertEquals(9, item.getItemQuantity());
        dao.updateQuantity(1);
        assertEquals(8, item.getItemQuantity());
    }
    
    @Test
    public void getItemById(){
        Item item = dao.getItemById(1);     
        assertEquals(1, item.getItemId());
    }
    
    @Test
    public void verifyQuantity(){
        Item item = dao.getItemById(2);
        assertTrue(dao.verifyQuantity(2));
        assertEquals(2, item.getItemQuantity());
        dao.updateQuantity(2);
        dao.updateQuantity(2);
        assertFalse(dao.verifyQuantity(2));
        
    }    
    
}
