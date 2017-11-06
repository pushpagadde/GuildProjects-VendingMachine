/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmasteryApp;

import com.sg.flooringmastery.controller.FlooringMasteryController;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.sg.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import com.sg.flooringmastery.dao.FlooringMasteryFileNotFoundException;
import com.sg.flooringmastery.service.FlooringMasteryServiceLayer;
import com.sg.flooringmastery.service.FlooringMasteryServiceLayerImpl;
import com.sg.flooringmastery.ui.FlooringMasteryView;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws FlooringMasteryFileNotFoundException {
        FlooringMasteryView view = new FlooringMasteryView();
        FlooringMasteryDao dao = new FlooringMasteryDaoFileImpl();
        FlooringMasteryServiceLayer service = new FlooringMasteryServiceLayerImpl(dao);
        FlooringMasteryController controller = new FlooringMasteryController(service, view);
        controller.run();
    }
    
}
