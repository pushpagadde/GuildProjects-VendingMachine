/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.grasshopper;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.function.Predicate;
import java.util.*;
/**
 *
 * @author apprentice
 */
public class Grasshopper {
    private String color;
    public Grasshopper() {
        this("white");
    }
    public Grasshopper(String color) {
        color = color;
    }

    public static void main(String[] args) {
        Grasshopper e = new Grasshopper();
        System.out.println("Color:" + e.color);
  
}
}

