/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserIOConsoleImpl implements UserIO {
       Scanner sc = new Scanner(System.in);
    
    public void print(String message) {
        System.out.println("You entered: " + message);
    }
    //##1
    public int readInt(String prompt) {
        System.out.println("Enter an integer: ");
        int intCapture=0;
        while (!sc.hasNextInt()) {
            intCapture = sc.nextInt();
            System.out.println("Not a valid number. Please enter a valid number.");
        }
        String stemp2 = sc.nextLine();
        return intCapture;
        
    }
    //#2
    @Override
    public int readInt(String prompt, int min, int max){
        int temp; //temporaty number to take user input
        do {
            System.out.println(prompt + "Number has to be between " + min + " and " + max);
            while (!sc.hasNextInt()) {
                String stemp = sc.next();
                System.out.println("Not a valid number. Please enter a valid number between " + min + " and " + max);
            }
            temp = sc.nextInt();
            String stemp2 = sc.nextLine();
        }   while (temp > max || temp < min) ;
        return temp;
    }
    //#3
    public String readString(String prompt){
        String temp;
        System.out.println(prompt);
        temp = sc.next();
        return temp;
    }
    //#4
    public float readFloat(String prompt) {
        float temp; //temp variable to store user input
        System.out.println(prompt);
        temp = sc.nextFloat();
        return temp;
    }
    //#5
    public float readFloat(String prompt, float min, float max) {
        
        float temp;
        
        do {
        
            System.out.println("prompt");
            temp = sc.nextFloat();

        } while(temp >max || temp < min);
        return temp;
    }
    
    //#6
    public double readDouble(String prompt){
        System.out.println("Enter a decimal number: ");
        return sc.nextDouble();
    
    }
    //#7
    public double readDouble(String prompt, double min, double max) {
        double temp;
        
        do {
            
            System.out.println(prompt);
            temp = sc.nextDouble();
 
        } while(temp >max || temp < min);
        return temp;
    }
          
    //#8
    public long readLong(String prompt){
        System.out.println(prompt);
        return sc.nextLong();
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long temp;
        do {
            
            System.out.println(prompt);
            temp = sc.nextLong();
 
        } while(temp >max || temp < min);
        return temp;
    }
}
