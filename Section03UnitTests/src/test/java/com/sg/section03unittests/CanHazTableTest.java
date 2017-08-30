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
public class CanHazTableTest {
    CanHazTable hasTable = new CanHazTable();
    
    public CanHazTableTest() {
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
     * Test of canHazTable method, of class CanHazTable.
     */
    @Test
    public void test1() {
        assertEquals(hasTable.canHazTable(9,9), 2);
    }
    @Test
    public void test2() {
        assertEquals(hasTable.canHazTable(8,10), 2);
    }
    @Test
    public void test3() {
        assertEquals(hasTable.canHazTable(8,5), 2);
    }
    @Test
    public void test4() {
        assertEquals(hasTable.canHazTable(8,2), 0);
    }
    @Test
    public void test5() {
        assertEquals(hasTable.canHazTable(5,5), 1);
    }
    @Test
    public void test6() {
        assertEquals(hasTable.canHazTable(2,5), 0);
    }
    @Test
    public void test7() {
        assertEquals(hasTable.canHazTable(2,2), 0);
    }
    @Test
    public void test8() {
        assertEquals(hasTable.canHazTable(0,1), 0);
    }
}
