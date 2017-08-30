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
public class AbbaTest {
    Abba abba = new Abba();
    
    public AbbaTest() {
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
     * Test of abba method, of class Abba.
     */
    @Test
    public void testANullAbba() {
        assertEquals(abba.abba("", "b"),null);
    }
    @Test
    public void testBNullAbba() {
        assertEquals(abba.abba("a", ""), null);
    }
    @Test
    public void testBothNullAbba() {
        assertEquals(abba.abba("", ""), null);
    }
    @Test
    public void testBothNotNull1Abba() {
        assertEquals(abba.abba("Hi", "Joy"),"HiJoyJoyHi");
    }
    @Test
    public void testBothNotNull2Abba() {
        assertEquals(abba.abba("Bye", "Joy"),"ByeJoyJoyBye");
    }
}
