/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookAuditDao;
import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dto.AddressBook;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookServiceLayerImpl implements AddressBookServiceLayer{
    
    private AddressBookDao dao;
    private AddressBookAuditDao auditDao;
    
    public AddressBookServiceLayerImpl(AddressBookDao dao, AddressBookAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createAddress(AddressBook address) throws AddressBookDuplicateNameException, 
            AddressBookDataValidationErrorException, AddressBookPersistenceException {
                String completeName;
                completeName = address.getFirstName() + address.getLastName();
                if (dao.findAddress(address.getLastName()) != null) {
                    throw new AddressBookDuplicateNameException("Could not add address. Duplicate address");
                }
                validateAddressData(address);
                dao.addAddress(address.getLastName(), address);
                auditDao.writeAuditEntry("address " + address.getLastName() + " created.");
    }

    @Override
    public List<AddressBook> listAll() throws AddressBookPersistenceException {
        return dao.getAllAddress();
    }

    @Override
    public AddressBook findAddress(String name) throws AddressBookPersistenceException {
        return dao.findAddress(name);
    }

    @Override
    public AddressBook removeAddress(String name) throws AddressBookPersistenceException {
        auditDao.writeAuditEntry("address " + name + " removed.");
        return dao.removeAddress(name);
    }

    @Override
    public int count() throws AddressBookPersistenceException {
        return dao.countAddress();
    }
    
    private void validateAddressData(AddressBook address) throws AddressBookDataValidationErrorException{
        if(address.getFirstName() == null || address.getFirstName().trim().length() == 0 ||
                address.getLastName() == null || address.getLastName().trim().length() == 0 ||
                address.getPhoneNumber() == null || address.getPhoneNumber().trim().length() == 0 ||
                address.getEMailID() == null || address.getEMailID().trim().length() == 0 ) {
            throw new AddressBookDataValidationErrorException("Error: all fields required");
        }
    }
}
