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
public class EveryOtherTest {
    EveryOther everyOther = new EveryOther();
    
    public EveryOtherTest() {
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
     * Test of everyOther method, of class EveryOther.
     */
    @Test
    public void testEveryOther1() {
        assertEquals(everyOther.everyOther("Hello"), "Hlo");
    }
    @Test
    public void testEveryOther2() {
        assertEquals(everyOther.everyOther("Hello World"), "HloWrd");
    }
    @Test
    public void testEveryOther3() {
        assertEquals(everyOther.everyOther(""), "");
    }
}
