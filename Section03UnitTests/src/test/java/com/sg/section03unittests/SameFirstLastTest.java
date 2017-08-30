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
public class SameFirstLastTest {
    SameFirstLast sameFirstLast = new SameFirstLast();
    
    public SameFirstLastTest() {
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
     * Test of sameFirstLast method, of class SameFirstLast.
     */
    @Test
    public void testOneElementSameFirstLast() {
        int[] number = {6};
        assertTrue(sameFirstLast.sameFirstLast(number));
    }
    @Test
    public void testMoreElementSameFirstLast() {
        int[] number = {6,1,2,3,4,6};
        assertTrue(sameFirstLast.sameFirstLast(number));
    }
    @Test
    public void testMoreElementNotSame1FirstLast() {
        int[] number = {6,1,6,8,9};
        assertFalse(sameFirstLast.sameFirstLast(number));
    }
    @Test
    public void testMoreElementNotSame2FirstLast() {
        int[] number = {6,1,2,3,4,6,8,9};
        assertFalse(sameFirstLast.sameFirstLast(number));
    }
    
}
