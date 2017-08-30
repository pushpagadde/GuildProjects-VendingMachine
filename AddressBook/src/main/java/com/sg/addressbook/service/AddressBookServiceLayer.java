/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dto.AddressBook;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AddressBookServiceLayer {
    void createAddress(AddressBook address) throws AddressBookDuplicateNameException,
            AddressBookDataValidationErrorException,
            AddressBookPersistenceException;
    List<AddressBook> listAll() throws AddressBookPersistenceException;
    AddressBook findAddress(String name) throws AddressBookPersistenceException;
    AddressBook removeAddress(String name) throws AddressBookPersistenceException;
    int count() throws AddressBookPersistenceException;
}
