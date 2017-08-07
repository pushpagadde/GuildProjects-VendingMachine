/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dto;

/**
 *
 * @author apprentice
 */
public class AddressBook {
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String EMailID;

    public AddressBook(String pLastName) {
        this.LastName = pLastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEMailID() {
        return EMailID;
    }

    public void setEMailID(String Email) {
        this.EMailID = Email;
    }
    
}
