/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.dto.AddressBook;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookController {
    AddressBookView view;
    private UserIO io = new UserIOConsoleImpl();
    AddressBookDao dao;
    
    boolean keepGoing = true;
    int menuSelection = 0;

    public AddressBookController(AddressBookDao myDao, AddressBookView myView) {
        this.view = myView;
        this.dao = myDao;
        System.out.println("constructor");
    }
    public void run() {
        while(keepGoing) {
            menuSelection = getMenuSelection();
            switch(menuSelection) {
                case 1: 
                    io.print("Add");
                    addAddress();
                    break;
                case 2: 
                    io.print("Remove"); 
                    removeAddress();
                    break;
                case 3: 
                    io.print("Find");
                    displayAddress();
                    break;
                case 4: 
                    io.print("How many"); 
                    countAddress();
                    break;
                case 5: 
                    io.print("List all"); 
                    displayList();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default: 
                    io.print("unknown command"); 
            }
        }
        io.print("Bye");
        //exit;
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void addAddress() {
        AddressBook newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress );
    }
    private void displayList() {
        List<AddressBook> addressList = dao.getAllAddress();
        view.displayList(addressList);
    }
    private void removeAddress() {
        String lastName = view.getLastNameChoice();
        dao.removeAddress(lastName);
        io.print("Address removed");
    }
    private void displayAddress() {
        String lastName = view.getLastNameChoice();
        dao.findAddress(lastName);
    }
    private void countAddress() {
        System.out.println(dao.countAddress());
    }
}
