/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PG
 */
@Controller
@RequestMapping({"/displayHerosPage"})
public class MainController {
    public MainController() {
    }
    
    @RequestMapping(value="/hero", method=RequestMethod.GET)
    public String hero(Map<String, Object> model) {
        model.put("message", "Hello from the controller" );
        return "displayHerosPage";
    }
    
}
