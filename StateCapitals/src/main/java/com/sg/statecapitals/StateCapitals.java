/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapitals {
    
    public static void main(String[] args) {
        HashMap<String, String> list = new HashMap<String, String>();
    
        list.put("Alabama", "Montgomery");
        list.put("Alaska", "Juneau");
        list.put("Arizona", "Phoenix");
        list.put("Arkansas", "Little Rock");
        list.put("California", "Sacromento");
        list.put("Colorado", "Denver");
        list.put("Connecticut", "Hartford");
        list.put("Delaware", "Dover");
        list.put("Florida", "Tallahassee");
        list.put("Atlanta", "Georgia");
        
        list.put("Hawaii", "Honolulu");
        list.put("Idaho", "Boise");
        list.put("Illinois", "Soringfield");
        list.put("Indiana", "Indianapolis");
        list.put("Iowa", "Des Moines");
        list.put("Kansas", "Topeka");
        list.put("Kentucky", "Frankfort");
        list.put("Louisiana", "Baton Rouge");
        list.put("Maine", "Augusta");
        list.put("Maryland", "Annapolis");
        
        list.put("Massachusetts", "Boston");
        list.put("Michingan", "Lansing");
        list.put("Minnesota", "Saint Paul");
        list.put("Mississippi", "Jackson");
        list.put("Montana", "Helena");
        list.put("Nebraska", "Lincoln");
        list.put("Nevada", "Carson City");
        list.put("New Hampshire", "Concord");
        list.put("New Jersey", "Trenton");
        list.put("New Mexico", "Santa Fe");
        
        list.put("New York", "Albany");
        list.put("North Carolina", "Raleigh");
        list.put("North Dakota", "Bismarck");
        list.put("Ohio", "Columbus");
        list.put("Oklahoma", "Oklahoma City");
        list.put("Oregon", "salem");
        list.put("Pennsylvania", "Harrisburg");
        list.put("Providence", "Rhode Island");
        list.put("South Carolina", "Columbia");
        list.put("South Dakota", "Pierre");
        
        list.put("Tennessee", "Nashville");
        list.put("Texas", "Austin");
        list.put("Utah", "Salt lake City");
        list.put("Vermont", "Montpelier");
        list.put("Virginia", "Richmond");
        list.put("Washington", "Olympia");
        list.put("West Virginia", "Charleston");
        list.put("Wisconsin", "Madison");
        list.put("Missouri", "Jefferson City");
        list.put("Wyoming", "Cheyenne");
        
        Set set = list.entrySet();
        Set<String> kSet = list.keySet();
        
        
        //Display the keys
        System.out.println();
        System.out.println("States in USA");
        System.out.println("_____________");
        System.out.println();
        for (String k : kSet) {
            System.out.println(k);
        }
        
        //Display the values
        System.out.println();
        System.out.println("Capitals of all states of USA");
        System.out.println("______________________________");
        System.out.println();
        for (String k : kSet) {
            System.out.println(list.get(k));
        }
                
        //Display content using Iterator
        System.out.println();
        System.out.println("States and their Capitals");
        System.out.println("__________________________");
        System.out.println();
        
        for (String k : kSet) {
            System.out.println(k + ", " + list.get(k));
        }
        System.out.println();
        System.out.println("States and their Capitals");
        System.out.println("__________________________");
        System.out.println();
        
        Iterator iterator = set.iterator();
        Map.Entry mentry = (Map.Entry)iterator.next();
        while (iterator.hasNext()) {
            System.out.println(mentry.getKey() + ", " + mentry.getValue());
            mentry = (Map.Entry)iterator.next();
        }
        
        
    }
    
    
    
    
    
}
