/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachineApp;

import com.sg.vendingmachinetwo.controller.VendingMachineController;
import com.sg.vendingmachinetwo.dao.VendingMachineDao;
import com.sg.vendingmachinetwo.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachinetwo.dao.VendingMachineFileNotFoundException;
import com.sg.vendingmachinetwo.service.VendingMachineDuplicateItemException;
import com.sg.vendingmachinetwo.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachinetwo.service.VendingMachineItemNotFoundException;
import com.sg.vendingmachinetwo.service.VendingMachineServiceLayer;
import com.sg.vendingmachinetwo.service.VendingMachineServiceLayerImpl;
import com.sg.vendingmachinetwo.ui.UserIO;
import com.sg.vendingmachinetwo.ui.UserIOImpl;
import com.sg.vendingmachinetwo.ui.VendingMachineView;

/**
 *
 * @author apprentice
 */
public class App {    
    public static void main(String[] args) throws VendingMachineFileNotFoundException,
                                                  VendingMachineDuplicateItemException,
                                                  VendingMachineFileNotFoundException,
                                                  VendingMachineItemNotFoundException,
                                                  VendingMachineInsufficientFundsException
                                                  {
        UserIO myIo = new UserIOImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao);
        VendingMachineController controller = new VendingMachineController(myService, myView);
        controller.run();
    }
}
