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
public class Diff21Test {
    Diff21 diff21 = new Diff21();
    
    public Diff21Test() {
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
     * Test of diff21 method, of class Diff21.
     */
    @Test
    public void testDiff21For23() {
        assertEquals(diff21.diff21(23), 4);
    }
    @Test
    public void testDiff21For10() {
        assertEquals(diff21.diff21(10), 11);
    }
    @Test
    public void testDiff21For21() {
        assertEquals(diff21.diff21(21), 0);
    }
    @Test
    public void testDiff21ForNegativeNumber() {
        assertEquals(diff21.diff21(-3), 24);
    }
}
