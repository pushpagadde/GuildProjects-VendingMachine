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
public class GreatPartyTest {
    GreatParty party = new GreatParty();
    
    public GreatPartyTest() {
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
     * Test of greatparty method, of class GreatParty.
     */
    @org.junit.Test
    public void test30False() {
        assertFalse(party.greatparty(30, false));
    }
    @Test
    public void test50False() {
        assertTrue(party.greatparty(50, false));
    }
    @Test
    public void test70False() {
        assertTrue(party.greatparty(70, true));
    }
    @Test
    public void test39False() {
        assertFalse(party.greatparty(39, false));
    }
    @Test
    public void test39True() {
        assertFalse(party.greatparty(39, true));
    }
   @Test
   public void test40True(){
       assertTrue(party.greatparty(40, true));
   }
   @Test
   public void test40False() {
       assertTrue(party.greatparty(40, false));
   }
   @Test
   public void test60True(){
       assertTrue(party.greatparty(60,true));
   }
   @Test
   public void test60False() {
       assertTrue(party.greatparty(60, false));
   }
   @Test
   public void test61True() {
       assertTrue(party.greatparty(61, true));
   }
   @Test
   public void test61False() {
       assertFalse(party.greatparty(61, false));
   }
}
