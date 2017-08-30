/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookAuditDao;
import com.sg.addressbook.dao.AddressBookAuditDaoStubImpl;
import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoStubImpl;
import com.sg.addressbook.dto.AddressBook;
import java.util.List;
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
public class AddressBookServiceLayerTest {
    private AddressBookServiceLayer service;
    
    public AddressBookServiceLayerTest() {
        AddressBookDao dao = new AddressBookDaoStubImpl();
        AddressBookAuditDao auditDao = new AddressBookAuditDaoStubImpl();
        service = new AddressBookServiceLayerImpl(dao, auditDao);
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
     * Test of createAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testCreateAddress() throws Exception {
        AddressBook address = new AddressBook("lname1");
        address.setFirstName("fname");
        address.setPhoneNumber("phone");
        address.setEMailID("Email");
        service.createAddress(address);
    }
    
    @Test
    public void testCreateStudentDuplicateID() throws Exception {
        AddressBook address = new AddressBook("lname");
        address.setFirstName("fname");
        address.setPhoneNumber("phone");
        address.setEMailID("Email");
        
        try {
            service.createAddress(address);
            fail("Expected duplicate name exception was not thrown.");
        }catch (AddressBookDuplicateNameException e) {
            System.out.println("Exception thrown");
        }
        
    }

    @Test
    public void testCreateStudentInvalidData() throws Exception {
        AddressBook address = new AddressBook("lname1");
        address.setFirstName("");
        address.setPhoneNumber("phone");
        address.setEMailID("Email");
        
        try {
            service.createAddress(address);
            fail("Expected data validation error exception was not thrown.");
        }catch (AddressBookDataValidationErrorException e) {
            return;
        }
        
    }
    /**
     * Test of listAll method, of class AddressBookServiceLayer.
     */
    @Test
    public void testListAll() throws Exception {
        assertEquals(1, service.listAll().size());
    }

    /**
     * Test of findAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testFindAddress() throws Exception {
        AddressBook address = service.findAddress("lname");
        assertNotNull(address);
        address = service.findAddress("9999");
        assertNull(address);
    }

    /**
     * Test of removeAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testRemoveAddress() throws Exception {
        AddressBook address = service.removeAddress("lname");
        assertNotNull(address);
        address = service.removeAddress("9999");
        assertNull(address);
    }

}
