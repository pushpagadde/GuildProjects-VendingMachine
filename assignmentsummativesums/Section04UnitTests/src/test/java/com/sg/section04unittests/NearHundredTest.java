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
public class NearHundredTest {
    NearHundred nearHundred = new NearHundred();
    
    public NearHundredTest() {
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
     * Test of nearHundred method, of class NearHundred.
     */
    @Test
    public void testNearHundred1() {
        assertFalse(nearHundred.nearHundred(0));
    }
    @Test
    public void testNearHundred2() {
        assertTrue(nearHundred.nearHundred(100));
    }
    @Test
    public void testNearHundred3() {
        assertTrue(nearHundred.nearHundred(51));
    }
    @Test
    public void testNearHundred4() {
        assertTrue(nearHundred.nearHundred(110));
    }
    @Test
    public void testNearHundred5() {
        assertFalse(nearHundred.nearHundred(160));
    }
}
