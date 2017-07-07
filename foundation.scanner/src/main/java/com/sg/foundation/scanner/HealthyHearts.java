/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundation.scanner;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int age;
        float min, max;
        String sAge;
        
        System.out.print("What is your age? ");
        sAge = sc.nextLine();
        
        age = Integer.parseInt(sAge);
        age = 200 - age;
        min = (50 * age)/100;
        max = (85 * age)/100;
        
              
        
        System.out.println("Your maximum heart rate should be " + age + "beats per minute.");
       
           
        System.out.println("Your targe HR Zone is " + min + " - " + max + "beats per minute." );
              
        
    }
    
}
