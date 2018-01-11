/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.service.ItemListServiceImpl;
import java.beans.ConstructorProperties;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PG
 */
public class VendingMachineServiceLayerTest {
    private static final double DELTA = 1e-15;
    ItemListDao dao = null;
    ItemListServiceImpl service = null;
    
    public VendingMachineServiceLayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (ItemListDao) ctx.getBean("itemListDao");
        service = (ItemListServiceImpl)ctx.getBean("itemListServiceImpl", dao);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void Test1(){
        //test for no item selection
        service.validateAndCompletePurchase();
        assertEquals("Pick and item!", service.getMessage());
    }
    
    @Test
    public void Test2(){
        service.setSelection(1);
        
        //test for change return with no item selection
        service.addMoney(0.00);
        service.returnMoney();
        assertEquals("No amount entered.", service.getMessage());
    }
    /*    
    @Test
    public void Test3(){
        //test for insufficient funds
        service.setSelection(1);
        service.addMoney(1.00);
        service.validateAndCompletePurchase();
        assertEquals("Enter more $ 0.85 ", service.getMessage());                
    }*/
    @Test
    public void Test4(){
        //test for entered money to be correct
        service.setSelection(1);
        service.addMoney(1.00);
        double testAmount = 1.00;                
        double enteredMoneyTest = service.sendEnteredMoney();
        assertEquals( testAmount, enteredMoneyTest, DELTA);
        service.addMoney(0.25);
        testAmount = 1.25;                
        enteredMoneyTest = service.sendEnteredMoney();
        assertEquals( testAmount, enteredMoneyTest, DELTA);        
        
        service.addMoney(1.85);//3.75 added
//        service.validateAndCompletePurchase();
        //assertEquals("Thankyou!", service.getMessage());
        //assertEquals(8,dao.getItemById(0).getItemQuantity());
    }
    
    @Test
    public void Test5(){
        //test for return change
        service.calculateChange(1.00);
        assertEquals("1 Dollars ", service.getReturnChange());
        service.calculateChange(1.25);
        assertEquals("1 Dollars 1 Quarters ", service.getReturnChange());
        service.calculateChange(1.30);
        assertEquals("1 Dollars 1 Quarters 1 Nickles ", service.getReturnChange());
        
    }
    /*    
    @Test
    public void Test6(){
        //test for sold out item
        service.setSelection(8);
        service.validateAndCompletePurchase();
        assertEquals("SOLD OUT!", service.getMessage());
    }    
        
        
        
    */
        
}