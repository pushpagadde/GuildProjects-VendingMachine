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
public class DoubleXTest {
    DoubleX doubleX = new DoubleX();
    
    public DoubleXTest() {
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
     * Test of doubleX method, of class DoubleX.
     */
    @Test
    public void testDoubleX1() {
        assertTrue(doubleX.doubleX("abcxxa"));
    }
    @Test
    public void testDoubleX2() {
        assertFalse(doubleX.doubleX("abcxa"));
    }
    @Test
    public void testDoubleX3() {
        assertTrue(doubleX.doubleX("abcXXa"));
    }
    @Test
    public void testDoubleX4() {
        assertFalse(doubleX.doubleX("abcXa"));
    }
    @Test
    public void testDoubleX5() {
        assertTrue(doubleX.doubleX("xxabc"));
    }
    @Test
    public void testDoubleX6() {
        assertTrue(doubleX.doubleX("axaXXabc"));
    }
    @Test
    public void testDoubleX7() {
        assertTrue(doubleX.doubleX("abcxxxxa"));
    }
    @Test
    public void testDoubleX8() {
        assertTrue(doubleX.doubleX("abcxaxxx"));
    }
}
