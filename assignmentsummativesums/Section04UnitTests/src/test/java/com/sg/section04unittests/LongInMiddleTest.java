/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

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
public class LongInMiddleTest {
    LongInMiddle inMiddle = new LongInMiddle();
    public LongInMiddleTest() {
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

    /**
     * Test of longInMiddle method, of class LongInMiddle.
     */
    @Test
    public void testLongInMiddle1() {
        assertEquals(inMiddle.longInMiddle("Hi", "Hello"), "HiHelloHi");
    }
    @Test
    public void testLongInMiddle2() {
        assertEquals(inMiddle.longInMiddle("Hello", "Hi"), "HiHelloHi");
    }
    @Test
    public void testLongInMiddle3() {
        assertEquals(inMiddle.longInMiddle("", "Hello"), "Hello");
    }
    @Test
    public void testLongInMiddle4() {
        assertEquals(inMiddle.longInMiddle("Hi", ""), "Hi");
    }
}
