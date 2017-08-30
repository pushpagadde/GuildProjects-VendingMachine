/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoTest {
    private AddressBookDao dao = new AddressBookDaoFileImpl();
    
    public AddressBookDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<AddressBook> addressList = dao.getAllAddress();
        for(AddressBook address : addressList) {
            dao.removeAddress(address.getLastName());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDao.
     */
    @Test
    public void testAddGetAddress() throws Exception {
        AddressBook address = new AddressBook("Lname");
        address.setFirstName("Fname");
        address.setPhoneNumber("0000000");
        address.setEMailID("emailid");
        dao.addAddress(address.getLastName(), address);
        
        AddressBook fromDao = dao.findAddress(address.getLastName());
        assertEquals(address,fromDao);
        
    }

    /**
     * Test of removeAddress method, of class AddressBookDao.
     */
    @Test
    public void testRemoveAddress() {
        AddressBook address1 = new AddressBook("lname1");
        address1.setFirstName("fname1");
        address1.setPhoneNumber("99999");
        address1.setEMailID("email1");
        dao.addAddress(address1.getLastName(), address1);
        
        AddressBook address2 = new AddressBook("lname2");
        address2.setFirstName("fname2");
        address2.setPhoneNumber("000000");
        address2.setEMailID("email2");
        dao.addAddress(address2.getLastName(), address2);
        
        assertEquals(2, dao.getAllAddress().size());
        dao.removeAddress(address2.getLastName());
        assertEquals(1, dao.getAllAddress().size());
        assertNull(dao.findAddress(address2.getLastName()));
        dao.removeAddress(address1.getLastName());
        assertEquals(0, dao.getAllAddress().size());
        assertNull(dao.findAddress(address2.getLastName()));
    }

    /**
     * Test of getAllAddress method, of class AddressBookDao.
     */
    @Test
    public void testGetAllAddress() {
        AddressBook address1 = new AddressBook("lname1");
        address1.setFirstName("fname1");
        address1.setPhoneNumber("99999");
        address1.setEMailID("email1");
        dao.addAddress(address1.getLastName(), address1);
        
        AddressBook address2 = new AddressBook("lname2");
        address2.setFirstName("fname2");
        address2.setPhoneNumber("000000");
        address2.setEMailID("email2");
        dao.addAddress(address2.getLastName(), address2);
        
        assertEquals(2, dao.getAllAddress().size());
    }
}
