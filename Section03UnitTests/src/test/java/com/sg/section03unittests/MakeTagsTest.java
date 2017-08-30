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
public class MakeTagsTest {
    MakeTags tag = new MakeTags();
    
    public MakeTagsTest() {
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
    public void testNullContent() {
        assertEquals(tag.makeTags("i", ""), null);
    }
    @Test
    public void testNullTag() {
        assertEquals(tag.makeTags("", "content"), null);
    }
    @Test
    public void testNullTagContent() {
        assertEquals(tag.makeTags("", ""), null);
    }
    @Test
    public void testTagContent1() {
        assertEquals(tag.makeTags("i", "content"), "<i>content</i>");
    }
    @Test
    public void testTagContent2() {
        assertEquals(tag.makeTags("div", "new content"), "<div>new content</div>");
    }
}
