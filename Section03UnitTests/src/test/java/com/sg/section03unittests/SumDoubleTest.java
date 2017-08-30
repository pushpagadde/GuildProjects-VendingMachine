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
public class SumDoubleTest {
    SumDouble sumDouble = new SumDouble();
    
    public SumDoubleTest() {
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
    public void test1() {
        assertEquals(sumDouble.sumDouble(2, 3), 5);
    }
    @Test
    public void test2() {
        assertEquals(sumDouble.sumDouble(-2, 3), 1);
    }
    @Test
    public void test3() {
        assertEquals(sumDouble.sumDouble(2, -3), -1);
    }
    @Test
    public void test5() {
        assertEquals(sumDouble.sumDouble(2, 2), 8);
    }

}
