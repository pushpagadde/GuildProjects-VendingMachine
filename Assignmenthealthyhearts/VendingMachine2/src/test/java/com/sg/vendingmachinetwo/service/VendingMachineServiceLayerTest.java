/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.service;

import com.sg.vendingmachinetwo.dao.VendingMachineDao;
import com.sg.vendingmachinetwo.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachinetwo.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerTest {
    
    private VendingMachineServiceLayer service;
        
    public VendingMachineServiceLayerTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        service = new VendingMachineServiceLayerImpl(dao);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddItem() throws Exception {
        Item item = new Item(2);
        item.setInventory(10);
        item.setItemName("kitkat");
        item.setPrice(BigDecimal.valueOf(1.00));
        service.addItem(2, item);
    }
    
    @Test
    public void testAddItemDuplicateNumber() throws Exception{
        Item item = new Item(1);
        item.setInventory(10);
        item.setItemName("Item 1");
        item.setPrice(BigDecimal.valueOf(1.00));
        
        try {
            service.addItem(1, item);
            fail("Expected VendingMachineDuplicate Number Exception was not thrown");
        }catch (VendingMachineDuplicateItemException e){
            return;
        }
    }
    @Test
    public void testInsufficientFunds() throws Exception {
        try {
            service.editItemInventoryGetChange(1, 1.00);
        }catch(VendingMachineInsufficientFundsException insFund){
            return;
        }
    }
    
    @Test
    public void testInvalidItemSelection() throws Exception{
        try {
            service.getItemInfo("Item 2");
        } catch(VendingMachineItemNotFoundException e){
            return;
        }
    }
    
    @Test
    public void testGetLastItemNumber() throws Exception {
        assertEquals(service.getLastItemNumber(),1);
        Item item = new Item(2);
        item.setInventory(10);
        item.setItemName("Item 2");
        item.setPrice(BigDecimal.valueOf(1.00));
        service.addItem(2,item);
        assertEquals(service.getLastItemNumber(),2);
    }

    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(service.getAllItems().size(),1);
    }

    @Test
    public void testEditItemInventoryGetChange() throws Exception {
        Change returnChange = service.editItemInventoryGetChange(1, 2.00);

        assertEquals(returnChange.getTotalDollar(),  1);
        assertEquals(returnChange.getTotalQuarter(), 0);
        assertEquals(returnChange.getTotalDime(),    0);
        assertEquals(returnChange.getTotalNickel(),  0);
        assertEquals(returnChange.getTotalPenny(),   0);
        
        returnChange = service.editItemInventoryGetChange(1, 1.50);
        assertEquals(returnChange.getTotalDollar(),  0);
        assertEquals(returnChange.getTotalQuarter(), 2);
        assertEquals(returnChange.getTotalDime(),    0);
        assertEquals(returnChange.getTotalNickel(),  0);
        assertEquals(returnChange.getTotalPenny(),   0);
    }
}