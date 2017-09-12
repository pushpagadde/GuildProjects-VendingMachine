/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingMachineItemDao {
    public List<Integer> updateInventory(int menuSelection, BigDecimal enteredMoney) throws Exception;
    public List<VendingMachineItem> getAllItems() throws VendingMachineDaoException;
}
