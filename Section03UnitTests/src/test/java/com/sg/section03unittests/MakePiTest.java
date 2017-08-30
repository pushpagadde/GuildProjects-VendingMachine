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
public class MakePiTest {
    MakePi pi = new MakePi();
    
    public MakePiTest() {
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
     * Test of makePi method, of class MakePi.
     */
    @Test
    public void testZeroMakePi() {
        assertEquals(pi.makePi(0), null);
    }
    @Test
    public void testNegativeMakePi() {
        assertEquals(pi.makePi(-1), null);
    }
    @Test
    public void testValidNumberMakePi1() {
        int[] piArray = {3,1,4};
        System.out.println("test1");
        assertArrayEquals(pi.makePi(3), piArray );
    }
    @Test
    public void testValidNumberMakePi2() {
        int[] piArray = {3,1,4,1,5,9,2,6};
        System.out.println("test2");
        assertArrayEquals(pi.makePi(8), piArray);
    }
}
