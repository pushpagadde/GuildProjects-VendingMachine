/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class StudentQuizUserIO implements UserIO{
    Scanner sc = new Scanner(System.in);
    
    public void print(String message) {
        System.out.println("You entered: " + message);
    }//#1
    public int readInt(String prompt) {
        System.out.println(prompt);
        return sc.nextInt();
    }//#2
    public int readInt(String prompt, int min, int max){
        int temp; //temporaty number to take user input
        
        do {
            System.out.println(prompt);
            temp = sc.nextInt();
            
        }   while (temp >= max || temp < min) ;
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
    public long readLong(String prompt){
        System.out.println(prompt);
        return sc.nextLong();
    }//#5
}
