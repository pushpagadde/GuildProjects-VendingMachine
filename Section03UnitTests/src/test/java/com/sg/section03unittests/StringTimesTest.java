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
public class StringTimesTest {
    StringTimes strTimes = new StringTimes();
    
    public StringTimesTest() {
        
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
     * Test of stringTimes method, of class StringTimes.
     */
    @Test
    public void testNullStringStringTimes() {
        assertEquals(strTimes.stringTimes(null, 5), null);
    }
    @Test
    public void testEmptyStringStringTimes() {
        assertEquals(strTimes.stringTimes("", 5), null);
    }
    @Test
    public void testZeroStringTimes() {
        assertEquals(strTimes.stringTimes("Hi", 0), null);
    }
    @Test
    public void testNegativeNumberStringTimes() {
        assertEquals(strTimes.stringTimes("Hi", -3), null);
    }
    @Test
    public void testOneStringTimes() {
        assertEquals(strTimes.stringTimes("Hi", 5),"HiHiHiHiHi");
    }
    @Test
    public void testTwoStringTimes() {
        assertEquals(strTimes.stringTimes("Hi", 10), "HiHiHiHiHiHiHiHiHiHi");
    }
}
