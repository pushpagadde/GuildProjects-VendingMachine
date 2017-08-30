/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

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
public class CountXXTest {
    CountXX countX = new CountXX();
    
    public CountXXTest() {
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
    public void testCountX1() {
        System.out.println("test1");
        assertEquals(countX.countXX("axb"), 0);
    }
    @Test
    public void testCountX2() {
        System.out.println("test2");
        assertEquals(countX.countXX("axxxb"), 2);
    }
    @Test
    public void testCountNoX() {
        System.out.println("testx");
        assertEquals(countX.countXX("axbcxx"), 1);
    }
    @Test
    public void testCountX3() {
        System.out.println("test3");
        assertEquals(countX.countXX("axbxxx"), 2);
    }
    @Test
    public void testCountX4() {
        System.out.println("test4");
        assertEquals(countX.countXX("axbxxxx"), 3);
    }
}
