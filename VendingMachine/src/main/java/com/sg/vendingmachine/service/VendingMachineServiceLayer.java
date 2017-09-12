/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import java.util.List;
import com.sg.vendingmachine.dao.VendingMachineItemDao;

/**
 *
 * @author apprentice
 */
public interface VendingMachineServiceLayer {
    public boolean validItemSelection(int itemSelected, List<Integer> availableItems);
}
