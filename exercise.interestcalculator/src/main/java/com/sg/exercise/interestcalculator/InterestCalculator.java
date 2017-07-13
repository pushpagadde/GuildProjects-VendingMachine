/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.interestcalculator;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float intRate, prinAmt, noYear, interest, nAmt, comterm;
        int i;
                
        System.out.println("What is the principle amount?");
        prinAmt = sc.nextFloat();
        System.out.println("What is the annual interest rate?");
        intRate = sc.nextFloat();
        System.out.println("What is the number of years the money will stay in fund?");
        noYear = sc.nextFloat();
        System.out.println("What is the period of compound interest? (Q/A/M/D/H)");
        comterm = sc.nextFloat();
        
        
        
        for(i = 1; i <= noYear; i++) {
            nAmt = prinAmt *((1 + intRate/noYear)^(noYear*comterm));
            interest = nAmt - prinAmt;
                        
            System.out.println("year " + i + ":" );
            System.out.println("Principal amout =" + prinAmt);
            System.out.println("Interest earned this year =" + interest);
            System.out.println("Principal at the end of the year: " + nAmt);
            
            prinAmt = nAmt;
        }
        
        
    }
    
}
