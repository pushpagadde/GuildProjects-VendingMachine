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
public class MultipleEndingsTest {
    MultipleEndings endingsTest = new MultipleEndings();
    
    
    public MultipleEndingsTest() {
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
     * Test of multipleEndings method, of class MultipleEndings.
     */
    @Test
    public void testMultipleEndings1() {
        assertEquals(endingsTest.multipleEndings("Hello"), "lololo");
    }
    @Test
    public void testMultipleEndings2() {
        assertEquals(endingsTest.multipleEndings("hi"), "hihihi");
    }
    @Test
    public void testMultipleEndings3() {
        assertEquals(endingsTest.multipleEndings("o"), "");
    }
    @Test
    public void testMultipleEndings4() {
        assertEquals(endingsTest.multipleEndings(""), "");
    }
    
}
