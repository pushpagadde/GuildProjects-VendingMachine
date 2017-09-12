/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoImpl;
import com.sg.vendingmachine.dao.VendingMachineDAOFileImpl;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import com.sg.vendingmachine.dao.VendingMachineItemDao;


/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws VendingMachineDaoException {
        UserIO userIO = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineView(userIO);
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
        VendingMachineItemDao dao = new VendingMachineDAOFileImpl();
        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao);
        VendingMachineController controller = new VendingMachineController(service, view);
        controller.run();
    }
}
