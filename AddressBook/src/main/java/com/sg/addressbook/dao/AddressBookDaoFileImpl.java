/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoFileImpl implements AddressBookDao{
    private Map<String, AddressBook> addresses = new HashMap<>();
    
    public AddressBook addAddress(String pLastName, AddressBook paddAddress) {
        AddressBook newAddress = addresses.put(pLastName, paddAddress);
        return newAddress;
    }
    public AddressBook removeAddress(String pLastName) {
        AddressBook removedAddress = addresses.remove(pLastName);
        return removedAddress;
    }
    public List<AddressBook> getAllAddress() {
        return new ArrayList<AddressBook>(addresses.values());
    }
    public int countAddress() {
        return(addresses.size());
    }
    public AddressBook findAddress(String pLastName) {
        return(addresses.get(pLastName));
    }
}
