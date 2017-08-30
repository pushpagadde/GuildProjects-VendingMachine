/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dto;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.FirstName);
        hash = 89 * hash + Objects.hashCode(this.LastName);
        hash = 89 * hash + Objects.hashCode(this.PhoneNumber);
        hash = 89 * hash + Objects.hashCode(this.EMailID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressBook other = (AddressBook) obj;
        if (!Objects.equals(this.FirstName, other.FirstName)) {
            return false;
        }
        if (!Objects.equals(this.LastName, other.LastName)) {
            return false;
        }
        if (!Objects.equals(this.PhoneNumber, other.PhoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.EMailID, other.EMailID)) {
            return false;
        }
        return true;
    }
    
}
