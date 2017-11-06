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
public class CommonEndTest {
    CommonEnd commonEnd = new CommonEnd();
    
    public CommonEndTest() {
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
     * Test of commonEnd method, of class CommonEnd.
     */
    @Test
    public void testFirstElementCommonEnd() {
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        assertFalse(commonEnd.commonEnd(a,b));
    }
    
    @Test
    public void testFirstSameElementCommonEnd() {
        int[] a = {4,2,3};
        int[] b = {4,5};
        assertTrue(commonEnd.commonEnd(a,b));
    }
    
    @Test
    public void testLastSameElementCommonEnd() {
        int[] a = {1,2,3};
        int[] b = {4,5,6,9,3};
        assertTrue(commonEnd.commonEnd(a,b));
    }
}