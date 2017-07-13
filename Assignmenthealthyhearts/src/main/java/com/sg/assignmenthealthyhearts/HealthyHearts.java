/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.assignmenthealthyhearts;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class HealthyHearts {
    public static void main(String[] args) {
        
        int age, rate;
        double mintarget, maxtarget;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is your age:");
        age = sc.nextInt();
        rate = 220-age;
        mintarget = age*0.5;
        maxtarget = age*0.85;
        
        System.out.println("Your maximum heart rate should be " + rate );
        System.out.println("Your target HR Zone is " + mintarget + " - " + maxtarget + "beats per minute.");
        
        
        
    }
    
}
