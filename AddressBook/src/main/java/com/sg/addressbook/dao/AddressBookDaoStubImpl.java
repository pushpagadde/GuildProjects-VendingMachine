/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;
import com.sg.addressbook.service.AddressBookPersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoStubImpl implements AddressBookDao{
    AddressBook onlyAddress;
    List<AddressBook> addressList = new ArrayList<>();
    
    public AddressBookDaoStubImpl( ) {
        onlyAddress = new AddressBook("lname");
        onlyAddress.setFirstName("Fname");
        onlyAddress.setEMailID("email");
        onlyAddress.setPhoneNumber("phone");
        addressList.add(onlyAddress);
    }

    @Override
    public AddressBook addAddress(String lastName, AddressBook paddAddress) { // throws AddressBookPersistenceException{
        if(lastName.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public AddressBook removeAddress(String pLastName) { //throws AddressBookPersistenceException {
        if(pLastName.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public List<AddressBook> getAllAddress() {
        return addressList;
    }

    @Override
    public int countAddress() {
        return addressList.size();
    }

    @Override
    public AddressBook findAddress(String pLastName) {
        if(pLastName.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }
}