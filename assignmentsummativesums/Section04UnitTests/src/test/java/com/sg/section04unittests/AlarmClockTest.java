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
public class AlarmClockTest {
    AlarmClock clock = new AlarmClock();
    
    public AlarmClockTest() {
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
     * Test of alarmClock method, of class AlarmClock.
     */
    @Test
    public void testVacationWeekDay1() {
        assertEquals(clock.alarmClock(0, true),"OFF");
    }
    @Test
    public void testVacationWeekDay2() {
        assertEquals(clock.alarmClock(0,false),"10:00");
    }
    @Test
    public void testVacationWeekDay3() {
        assertEquals(clock.alarmClock(1,false),"7:00");
    }
        @Test
    public void testVacationWeekDay4() {
        assertEquals(clock.alarmClock(1,true),"10:00");
    }

}
