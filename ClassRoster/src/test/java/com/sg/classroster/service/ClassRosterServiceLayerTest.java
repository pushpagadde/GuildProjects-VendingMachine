/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dto.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class ClassRosterServiceLayerTest {
    private ClassRosterServiceLayer service;
    
    public ClassRosterServiceLayerTest() {
        /*ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
        
        service = new ClassRosterServiceLayerImpl(dao, auditDao);*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
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
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Stuart");
        student.setCohort("Java jan 16");
        service.createStudent(student);
    }
    
    @Test
    public void testCreateStudentDuplicateId() throws Exception{
        Student student = new Student("0001");
        student.setFirstName("Sally");
        student.setLastName("Stuart");
        student.setCohort("Java jan 16");
        try {
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateId Exception was not thrown");
        } catch (ClassRosterDuplicateIdException e) {
            return;
        }
        
    }
    
    @Test
    public void testStudentInvalidData() throws Exception {
        Student student = new Student("002");
        student.setFirstName("");
        student.setLastName("Stuart");
        student.setCohort("Java jan 16");
        try {
            service.createStudent(student);
            fail("Expected ClassRosterDataValidation Exception was not thrown");
        } catch (ClassRosterDataValidationException e) {
            return;
        }
    }
    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        assertEquals(1, service.getAllStudents().size());
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
        Student student = service.getStudent("0001");
        assertNotNull(student);
        student = service.getStudent("9999");
        assertNull(student);
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        Student student = service.removeStudent("0001");
        assertNotNull(student);
        student = service.removeStudent("9999");
        assertNull(student);
        
    }

}
