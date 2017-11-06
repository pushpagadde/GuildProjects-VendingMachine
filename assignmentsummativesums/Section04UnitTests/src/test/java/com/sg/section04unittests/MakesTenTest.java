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
public class MakesTenTest {
    MakesTen makesTen = new MakesTen();
    
    public MakesTenTest() {
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
     * Test of makes10 method, of class MakesTen.
     */
    @Test
    public void testMakes101() {
        assertTrue(makesTen.makes10(10, 0));
    }
    @Test
    public void testMakes102() {
        assertTrue(makesTen.makes10(10, 10));
    }
    @Test
    public void testMakes103() {
        assertTrue(makesTen.makes10(100, 10));
    }
    @Test
    public void testMakes104() {
        assertFalse(makesTen.makes10(0, 0));
    }
    @Test
    public void testMakes105() {
        assertTrue(makesTen.makes10(5, 5));
    }
    @Test
    public void testMakes106() {
        assertTrue(makesTen.makes10(6, 4));
    }
    @Test
    public void testMakes107() {
        assertFalse(makesTen.makes10(3, 4));
    }
}
