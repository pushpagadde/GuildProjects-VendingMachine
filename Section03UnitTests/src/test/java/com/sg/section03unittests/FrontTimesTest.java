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
public class FrontTimesTest {
    FrontTimes frontTimes = new FrontTimes();
    
    public FrontTimesTest() {
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
     * Test of frontTimes method, of class FrontTimes.
     */
    @Test
    public void testStringNullFrontTimes() {
        assertEquals(frontTimes.frontTimes("", 5), null);
    }
    @Test
    public void testIntZeroFrontTimes() {
        assertEquals(frontTimes.frontTimes("Hi", 0), null);
    }
    @Test
    public void testIntInvalidFrontTimes() {
        assertEquals(frontTimes.frontTimes("Hi, Joy", -4), null);
    }
    @Test
    public void testPrintFrontTimes() {
        assertEquals(frontTimes.frontTimes("HiJoy", 2), "HiJHiJ");
    }
    @Test
    public void testBothInvalidFrontTimes() {
        assertEquals(frontTimes.frontTimes( "", -1), null);
    }
    @Test
    public void testSmallStringFrontTimes() {
        assertEquals(frontTimes.frontTimes( "ab", 2), "abab");
    }
}
