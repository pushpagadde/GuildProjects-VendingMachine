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
public class ParrotTroubleTest {
    ParrotTrouble parrotTrouble = new ParrotTrouble();
    
    public ParrotTroubleTest() {
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
     * Test of parrotTrouble method, of class ParrotTrouble.
     */
    @Test
    public void testParrotIsTalking1() {
        assertFalse(parrotTrouble.parrotTrouble(true, 7));
    }
    @Test
    public void testParrotIsTalking2() {
        assertTrue(parrotTrouble.parrotTrouble(true, 6));
    }
    @Test
    public void testParrotIsTalking3() {
        assertFalse(parrotTrouble.parrotTrouble(true, 20));
    }
    @Test
    public void testParrotIsTalking4() {
        assertTrue(parrotTrouble.parrotTrouble(true, 21));
    }
    @Test
    public void testParrotIsTalking5() {
        assertFalse(parrotTrouble.parrotTrouble(false, 7));
    }
    @Test
    public void testParrotIsTalking6() {
        assertFalse(parrotTrouble.parrotTrouble(false, 6));
    }
    @Test
    public void testParrotIsTalking7() {
        assertFalse(parrotTrouble.parrotTrouble(false, 21));
    }
    @Test
    public void testParrotIsTalking8() {
        assertFalse(parrotTrouble.parrotTrouble(false, 20));
    }
}
