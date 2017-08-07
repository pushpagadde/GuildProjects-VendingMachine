/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.AddressBook;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookView {
    private UserIO io;

    public AddressBookView(UserIO myio) {
        this.io = myio;
    }
    public int printMenuAndGetSelection() {
        System.out.println("printMenuAndgetselection:"+this.io);
        this.io.print("Main Menu");
        io.print("1. Add Address");
        io.print("2. Remove Address");
        io.print("3. Find by Last Name");
        io.print("4. How many address in the boook?");
        io.print("5. List all addresses");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.", 1,5);
    }
    public AddressBook getNewAddressInfo() {
        String firstName = io.readString("Enter first name");
        String lastName = io.readString("Enter last name");
        String phoneNumber = io.readString("Enter Phone Number");
        String eMailID = io.readString("Enter email ID");
        AddressBook currentAddress = new AddressBook(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setPhoneNumber(phoneNumber);
        currentAddress.setEMailID(eMailID);
        System.out.println("Student added successfully.");
        return currentAddress;
    }
    public void displayList(List<AddressBook> AddressList) {
        io.print("======Display all address======");
        for(AddressBook currentAddress : AddressList) {
            String completeAddress;
            completeAddress = currentAddress.getFirstName() + " ";
            completeAddress = completeAddress + currentAddress.getLastName() + " ";
            completeAddress = completeAddress + currentAddress.getPhoneNumber() + " ";
            completeAddress = completeAddress + currentAddress.getEMailID();
            io.print(completeAddress);
        }
        io.readString("Please hit enter to coninute.");
    }
    public void displayAddress(AddressBook addressBook) {
        if (addressBook != null) {
            io.print(addressBook.getFirstName() + " " + addressBook.getLastName());
            io.print(addressBook.getPhoneNumber());
            io.print(addressBook.getEMailID());
        } else {
            io.print("No such person with that last name");
        }
        io.readString("Please hit enter to continue");
    }
    public String getLastNameChoice() {
        return io.readString("Enter last name");
    }
}
