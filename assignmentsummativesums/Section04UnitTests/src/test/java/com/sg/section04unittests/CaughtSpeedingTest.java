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
public class CaughtSpeedingTest {
    CaughtSpeeding speed = new CaughtSpeeding() ;
    
    public CaughtSpeedingTest() {
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
     * Test of caughtSpeeding method, of class CaughtSpeeding.
     */
    @Test
    public void testCaughtSpeeding1() {
        assertEquals(speed.caughtSpeeding(59, false),0);
    }
    @Test
    public void testCaughtSpeeding2() {
        assertEquals(speed.caughtSpeeding(60, false),0);
    }
    @Test
    public void testCaughtSpeeding3() {
        assertEquals(speed.caughtSpeeding(61, false),1);
    }
    @Test
    public void testCaughtSpeeding4() {
        assertEquals(speed.caughtSpeeding(64, true),0);
    }
    @Test
    public void testCaughtSpeeding5() {
        assertEquals(speed.caughtSpeeding(65, true),0);
    }
    @Test
    public void testCaughtSpeeding6() {
        assertEquals(speed.caughtSpeeding(66, true),1);
    }
    @Test
    public void testCaughtSpeeding7() {
        assertEquals(speed.caughtSpeeding(79, false),1);
    }
    @Test
    public void testCaughtSpeeding8() {
        assertEquals(speed.caughtSpeeding(80, false),1);
    }
    @Test
    public void testCaughtSpeeding9() {
        assertEquals(speed.caughtSpeeding(81, false),2);
    }
    @Test
    public void testCaughtSpeeding10() {
        assertEquals(speed.caughtSpeeding(84, true),1);
    }
    @Test
    public void testCaughtSpeeding11() {
        assertEquals(speed.caughtSpeeding(85, true),1);
    }
    @Test
    public void testCaughtSpeeding12() {
        assertEquals(speed.caughtSpeeding(86, true),2);
    }
}
