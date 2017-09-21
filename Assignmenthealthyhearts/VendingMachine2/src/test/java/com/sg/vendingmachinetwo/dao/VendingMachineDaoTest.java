/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.dao;

import com.sg.vendingmachinetwo.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoTest {
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl("VendingMachine2Test.txt");
    
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass()  {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws VendingMachineFileNotFoundException {
        List<Item> itemList = dao.getAllItems();
        for (Item item : itemList) {
            dao.removeItem(item.getItemNumber());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class VendingMachineDao.
     */
    @Test
    public void testAddgetItem() throws Exception {
        Item item = new Item(0);
        item.setItemName("Kitkat");
        item.setPrice(BigDecimal.valueOf(1.00));
        item.setInventory(10);
        dao.addItem(0, item);
        
        Item fromDao = dao.getItem(0);
        assertEquals(item, fromDao);
    }

    /**
     * Test of removeItem method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveItem() throws Exception {
        Item item1 = new Item(1);
        item1.setInventory(10);
        item1.setItemName("kitkat");
        item1.setPrice(BigDecimal.valueOf(2.00));
        dao.addItem(1, item1);
        
        assertEquals(dao.getAllItems().size(),1);
        dao.removeItem(1);
        assertEquals(dao.getAllItems().size(),0);
        assertNull(dao.getItem(1));
    }

    /**
     * Test of editItem method, of class VendingMachineDao.
     */
    @Test
    public void testEditItem() throws Exception {
    }

    /**
     * Test of getAllItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItems() throws Exception {
        Item item1 = new Item(1);
        item1.setInventory(10);
        item1.setItemName("kitkat");
        item1.setPrice(BigDecimal.valueOf(2.00));
        dao.addItem(1, item1);
        
        Item item2 = new Item(2);
        item2.setInventory(10);
        item2.setItemName("chocobar");
        item2.setPrice(BigDecimal.valueOf(1.00));
        dao.addItem(2, item2);
        
        assertEquals(dao.getAllItems().size(),2);
    }

    /**
     * Test of getItemInfo method, of class VendingMachineDao.
     */
    @Test
    public void testGetItemInfo() throws Exception {
    }

    /**
     * Test of editItemInventory method, of class VendingMachineDao.
     */
    @Test
    public void testEditItemInventory() throws Exception {
        Item item1 = new Item(1);
        item1.setInventory(10);
        item1.setItemName("kitkat");
        item1.setPrice(BigDecimal.valueOf(2.00));
        dao.addItem(1, item1);
        dao.editItem(1, 20);
        assertEquals(dao.getItemInfo("kitkat").getInventory(),20);
        
    }

    /**
     * Test of getKeySet method, of class VendingMachineDao.
     */
    @Test
    public void testGetKeySet() throws Exception {
    }
}
