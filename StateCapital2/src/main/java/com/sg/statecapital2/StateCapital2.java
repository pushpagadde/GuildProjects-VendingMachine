/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapital2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapital2 {
    public static void main(String[] args) {
        //Capital capital = new Capital();
        Map<String, Capital> stateList = new HashMap<>();
        
        Capital alabama = new Capital("Montogomery", 100000.00, 100000.00);
        stateList.put("Alabama", alabama);
        Capital alaska = new Capital("Juneau",200000,200000);
        stateList.put("Alaska", alaska);
        Capital arizona = new Capital("Phoenix",30000,30000);
        stateList.put("Arizona", arizona);
        Capital arkansas = new Capital("Little Rock",40000,40000);
        stateList.put("Arkansas", arkansas);
        Capital california = new Capital("Sacromento",500000,50000);
        stateList.put("California", california);
        Capital colorado = new Capital("Denver",600000,60000);
        stateList.put("Colorado", colorado);
        Capital connecticut = new Capital("Hartford",700000,70000);
        stateList.put("Connecticut", connecticut);
        Capital delaware = new Capital("Dover",800000,800000);
        stateList.put("Delaware", delaware);
        Capital florida = new Capital("Tallahassee",900000,900000);
        stateList.put("Florida", florida);
        Capital atlanta = new Capital("Georgia",1000000,100000);
        stateList.put("Atlanta", atlanta);
        
                
        //Display content using Iterator
        System.out.println();
        System.out.println("States and their Capitals with population and mileage");
        System.out.println("=====================================================");
        System.out.println();
        
        
        Set<String> kSet = stateList.keySet();
        
        for (String k : kSet) {
                System.out.println(k + ", " + stateList.get(k).displayAll() );
        }
        
        Set set = stateList.entrySet();
        Iterator iterator = set.iterator();
        Map.Entry mentry = (Map.Entry)iterator.next();
        while (iterator.hasNext()) {
            System.out.println(mentry.getKey() + ", " + stateList.get(mentry.getKey()).displayAll());
            mentry = (Map.Entry)iterator.next();
                             
        }
        
        Scanner sc = new Scanner(System.in);
        double minPopulation;
        System.out.println("Enter minimum population:");
        minPopulation = sc.nextDouble();
        System.out.print("States with atleast " + minPopulation + " are: ");
        for (String k : kSet) {
                if (minPopulation < stateList.get(k).getPopulation()) {
                    System.out.print(k + " ");
                }
                
        }
        
    }
    
}
