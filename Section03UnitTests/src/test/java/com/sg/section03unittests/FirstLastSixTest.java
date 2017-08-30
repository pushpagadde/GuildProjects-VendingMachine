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
public class FirstLastSixTest {
    FirstLastSix sixTest = new FirstLastSix();
    
    public FirstLastSixTest() {
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

    @Test
    public void testOneElementSix() {
        int[] numbers = new int[1];
        numbers[0] = 6;
        assertTrue(sixTest.firstLast6(numbers ));
    }
    @Test
    public void testOneNotSixElementSix() {
        int[] numbers = new int[1];
        numbers[0] = 5;
        assertFalse(sixTest.firstLast6(numbers ));
    }
    @Test
    public void testFirstElementSix() {
        int[] numbers = {6,5,4,3,2,1};
        assertTrue(sixTest.firstLast6(numbers ));
    }
    @Test
    public void testLastElementSix() {
        int[] numbers = {5,4,3,2,1,0,6};
        assertTrue(sixTest.firstLast6(numbers ));
    }
    @Test
    public void testMiddleElementSix() {
        int[] numbers = {7,6,5,4,3,2,1};
        assertFalse(sixTest.firstLast6(numbers ));
    }
    @Test
    public void testNoSixElementSix() {
        int[] numbers = {5,4,3,2,1};
        assertFalse(sixTest.firstLast6(numbers ));
    }
}
