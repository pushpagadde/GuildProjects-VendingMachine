/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserIOImpl implements UserIO{
    Scanner sc = new Scanner(System.in);
    
    public void print(String message) {
        System.out.println(message);
    }
    @Override
    public int readInt(String prompt) {
        int temp; //temporary number to take user input
        System.out.println(prompt);
        while (!sc.hasNextInt()) {
            String stemp = sc.next();
            System.out.println("Not a valid number. Please enter a valid number. ");
        }
        temp = sc.nextInt();
        String stemp2 = sc.nextLine();
        return temp;
    }
    @Override
    public int readInt(String prompt, int min, int max){
        int temp; //temporary number to take user input
        do {
            System.out.println(prompt + "Number has to be between " + min + " and " + max);
            while (!sc.hasNextInt()) {
                String stemp = sc.next();
                System.out.println("Not a valid number. Please enter a valid number between " + min + " and " + max);
            }
            temp = sc.nextInt();
            String stemp2 = sc.nextLine();
        }while (temp > max || temp < min) ;
        return temp;
    }
    @Override
    public String readString(String prompt){
        String temp;
        System.out.println(prompt);
        temp = sc.nextLine();
        return temp;
    }
    @Override
    public String readString(String prompt, String option1, String option2)
    {
        boolean invalidInput = true;
        String temp;
        do{
            System.out.println(prompt);
            temp = sc.next();
            if (temp.equalsIgnoreCase(option1) || temp.equalsIgnoreCase(option2)){
                invalidInput = false;
            } else {
                invalidInput = true;
                System.out.println("Invalid input. You must enter Y for Yes and N for No.");
            }
        }while(invalidInput);
        return temp;
    }
    public float readFloat(String prompt) {
        float temp; //temp variable to store user input
        System.out.println(prompt);
        temp = sc.nextFloat();
        return temp;
    }
    public float readFloat(String prompt, float min, float max) {
        float temp;
        do {
            System.out.println("prompt");
            temp = sc.nextFloat();
        } while(temp >max || temp < min);
        return temp;
    }
    public double readDouble(String prompt){
        //System.out.println("Enter a decimal number: ");
        //return sc.nextDouble();
        
        double temp; //temporary number to take user input
        System.out.println(prompt);
        while (!sc.hasNextDouble()) {
            String stemp = sc.next();
            System.out.println("Not a valid number." + prompt);
        }
        temp = sc.nextDouble();
        String stemp2 = sc.nextLine();
        return temp;
    }
    
    public double readNullDouble(String prompt) {
        System.out.println(prompt);
        return sc.nextDouble();
    }
    
    public double readDouble(String prompt, double min, double max) {
        double temp;
        do {
            System.out.println(prompt + "Number has to be between " + min + " and " + max);
            while (!sc.hasNextDouble()) {
                String stemp = sc.next();
                System.out.println("Not a valid number. Please enter a valid number between " + min + " and " + max);
            }
            temp = sc.nextDouble();
            String stemp2 = sc.nextLine();
        }   while (temp > max || temp < min) ;
        return temp;
    }
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
