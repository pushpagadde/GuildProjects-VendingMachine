/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalculator {
    
    public static void main(String[] args) {
        
        Scanner inData = new Scanner(System.in);
 
        System.out.println("Enter principal amount: ");
        BigDecimal principal = inData.nextBigDecimal();
        System.out.println("Enter annual interest rate: ");
        BigDecimal annualInterestRate = inData.nextBigDecimal();
        System.out.println("Enter if compounded years, half-yearly, quarterly, monthly, daily: ");
        
        String stringFrequency = inData.next();
        int compoundFrequency;
        boolean invalid= true;
        do {
            switch (stringFrequency.toUpperCase()) {
            case "YEARLY":
                compoundFrequency = 1;
                invalid = false;
                break;
            case "HALF-YEARLY":
                compoundFrequency = 6;
                invalid = false;
                break;
            case "QUARTERLY":
                compoundFrequency = 4;
                invalid = false;
                break;
            case "MONTHLY":
                compoundFrequency = 12;
                invalid = false;
                break;
            case "DAILY":
                compoundFrequency = 365;
                invalid = false;
                break;
            default:
                invalid= true;
                System.out.println("Frequency not recognized. Key one of the give below.");
                throw new UnsupportedOperationException("Not valid frequency.");
            
            }
        
        } while(invalid);
        
        System.out.println("Enter number of years: ");
        BigDecimal term = inData.nextBigDecimal();
        
        
        //BigDecimal principal = new BigDecimal("5000");
        //BigDecimal annualInterestRate = new BigDecimal("0.05");
        //int compoundFrequency = 12;
        //BigDecimal term = new BigDecimal("10");
        
        FindCompoundInterest cInterest1 = new FindCompoundInterest();
        System.out.println(cInterest1.calculate(principal, annualInterestRate, compoundFrequency, term));
        
    }
    
}
