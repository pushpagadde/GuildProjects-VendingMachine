/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import com.sg.addressbook.controller.AddressBookController;
import com.sg.addressbook.dao.AddressBookAuditDao;
import com.sg.addressbook.dao.AddressBookAuditDaoFileImpl;
import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.service.AddressBookServiceLayer;
import com.sg.addressbook.service.AddressBookServiceLayerImpl;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookAuditDao myAuditDao = new AddressBookAuditDaoFileImpl();
        AddressBookServiceLayer service = new AddressBookServiceLayerImpl(myDao, myAuditDao);
        AddressBookController controller = new AddressBookController(service, myView);
        controller.run();
    }
    
}
