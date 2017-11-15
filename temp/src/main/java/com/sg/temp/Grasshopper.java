/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.temp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */


public class Grasshopper {
    public Grasshopper(String n) {
	name = n;
    }
    public static void main(String[] args) {
        Grasshopper one = new Grasshopper("g1");
        Grasshopper two = new Grasshopper("g2");
        one = two;
        two = null;
        one = null;
    }
    private String name; 
}

