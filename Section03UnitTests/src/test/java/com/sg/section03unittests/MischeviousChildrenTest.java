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
public class MischeviousChildrenTest {
    MischeviousChildren mischeviousChildren = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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
     * Test of areWeInTrouble method, of class MischeviousChildren.
     */
    @Test
    public void testBothSmileAreWeInTrouble() {
        assertTrue(mischeviousChildren.areWeInTrouble(true, true));
    }
    @Test
    public void testBothNotSmileAreWeInTrouble() {
        assertTrue(mischeviousChildren.areWeInTrouble(false, false));
    }
    @Test
    public void testASmileAreWeInTrouble() {
        assertFalse(mischeviousChildren.areWeInTrouble(true, false));
    }
    @Test
    public void testBSmileAreWeInTrouble() {
        assertFalse(mischeviousChildren.areWeInTrouble(false, true));
    }
}
