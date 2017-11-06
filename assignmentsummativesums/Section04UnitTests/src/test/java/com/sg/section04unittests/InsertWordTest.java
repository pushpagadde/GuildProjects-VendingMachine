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
public class InsertWordTest {
    InsertWord insertWord = new InsertWord();
    
    public InsertWordTest() {
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
     * Test of insertWord method, of class InsertWord.
     */
    @Test
    public void testInsertWord1() {
        System.out.println("ONE:"+insertWord.insertWord("<<>>", "word"));
        assertEquals(insertWord.insertWord("<<>>", "word"), "<<word>>");
    }
    @Test
    public void testInsertWord2() {
        assertEquals(insertWord.insertWord("[[]]", "wordart"), "[[wordart]]");
    }
    
    @Test
    public void testInsertWord3() {
        assertEquals(insertWord.insertWord("[[]]]", "wordart"), "invalid length of container");
    }
    @Test
    public void testInsertWord4() {
        assertEquals(insertWord.insertWord("[[]", "wordart"), "invalid length of container");
    }
}
