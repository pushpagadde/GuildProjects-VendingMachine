/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

//import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DVDLibraryUserIOConsoleImpl implements DVDLibraryUserIO{
    Scanner sc = new Scanner(System.in);
    
    /**
     *
     * @param message
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }
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
    /**
     *
     * @param prompt
     * @param min
     * @param max
     * @return
     */
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
    public String readString(String prompt){
        String temp;
        System.out.println(prompt);
        temp = sc.nextLine();
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
            System.out.println(prompt + " between " + min + " and " + max);
            temp = sc.nextFloat();
        } while(temp >max || temp < min);
        return temp;
    }
    public double readDouble(String prompt){
        System.out.println("Enter a decimal number: ");
        return sc.nextDouble();
    }
    public double readDouble(String prompt, double min, double max) {
        double temp;
        do {
            System.out.println(prompt);
            temp = sc.nextDouble();
        } while(temp >max || temp < min);
        return temp;
    }
    public long readLong(String prompt){
        System.out.println(prompt);
        return sc.nextLong();
    }
    public long readLong(String prompt, long min, long max) {
        long temp;
        do {
            System.out.println(prompt);
            temp = sc.nextLong();
        } while(temp >max || temp < min);
        return temp;
    }
}
