/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDAOFileImpl;
import java.util.List;
import com.sg.vendingmachine.dao.VendingMachineItemDao;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    private VendingMachineItemDao dao;

    public VendingMachineServiceLayerImpl(VendingMachineItemDao dao) {
        this.dao = dao;
    }

    public boolean validItemSelection(int itemSelected, List<Integer> availableItems){
        boolean invalidSelection = false;
        System.out.println("item selected=" + itemSelected);
        if (availableItems.contains(itemSelected)) {
            invalidSelection = false;
        } else {
            invalidSelection = true;
        }
        return invalidSelection;
    }
}
