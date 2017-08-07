/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AddressBookDao {
    //add record to addressbook
    AddressBook addAddress(String lastName, AddressBook paddAddress); //#1
    AddressBook removeAddress(String pLastName); //#2
    List<AddressBook> getAllAddress();//#3
    int countAddress();//#4
    AddressBook findAddress(String pLastName);//#5
}
