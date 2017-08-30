/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dto.AddressBook;
import com.sg.addressbook.service.AddressBookDataValidationErrorException;
import com.sg.addressbook.service.AddressBookDuplicateNameException;
import com.sg.addressbook.service.AddressBookPersistenceException;
import com.sg.addressbook.service.AddressBookServiceLayer;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookController {
    private AddressBookServiceLayer service;
    AddressBookView view;
    private UserIO io = new UserIOConsoleImpl();
    //AddressBookDao dao;
    
    boolean keepGoing = true;
    int menuSelection = 0;

    public AddressBookController(AddressBookServiceLayer service, AddressBookView myView) {
        this.view = myView;
        this.service = service;
        System.out.println("constructor");
    }
    public void run() {
        try {
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
        } catch (AddressBookPersistenceException | AddressBookDuplicateNameException | AddressBookDataValidationErrorException e ) {
            view.displayErrorMessage("Error");
        }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void addAddress() throws AddressBookDuplicateNameException, AddressBookDataValidationErrorException, AddressBookPersistenceException {
        boolean hasErrors = false;
        do {
            AddressBook newAddress = view.getNewAddressInfo();
            try {
                service.createAddress(newAddress);
            } catch (AddressBookDuplicateNameException | AddressBookDataValidationErrorException e) {
                hasErrors = true;
                view.displayErrorMessage("Error.");
            }
        } while(hasErrors);
    }
    private void displayList() throws AddressBookPersistenceException {
        List<AddressBook> addressList = service.listAll();// getAllAddress();
        view.displayList(addressList);
    }
    private void removeAddress() throws AddressBookPersistenceException {
        String lastName = view.getLastNameChoice();
        service.removeAddress(lastName);
        io.print("Address removed");
    }
    private void displayAddress() throws AddressBookPersistenceException {
        String lastName = view.getLastNameChoice();
        service.findAddress(lastName);
    }
    private void countAddress() throws AddressBookPersistenceException {
        System.out.println(service.count());//   countAddress());
    }
}
