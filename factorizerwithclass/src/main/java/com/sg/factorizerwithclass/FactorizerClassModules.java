/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizerwithclass;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FactorizerClassModules {
    
    int counter1, counter2=0, sumOfFactors=0;
    int[] factorsArrary = new int[10];
            
    int factorNumber;
    int[] factorsArray = new int[10];
        
        public FactorizerClassModules(){
        }
        //constructor
        public FactorizerClassModules(int pNumber) {
            this.factorNumber = pNumber;
       
        }
        //setter method
        public void setfactorNumber() {
            Scanner sc = new Scanner(System.in);
            System.out.println("What number would you like to factor?");
            factorNumber = sc.nextInt();
            System.out.println("You entered number: " + factorNumber);
        }
        //getter method
        public int getfactorNumber() {
            return factorNumber;
        }
        
        //method to find factors, find sum of factors, count the number of factors and print all of them
        public void findFactors() {
            
            for(counter1=1; counter1<factorNumber; counter1++) {
                if (factorNumber%counter1 == 0) {
                    //System.out.println(fac[j]+":"+i);                
                    factorsArray[counter2] = counter1;
                    //System.out.println(fac[j]+":"+i);
                    sumOfFactors = sumOfFactors + counter1; 
                    counter2++;
                }
            
            factorsArray[counter2] = factorNumber;
            }
            System.out.println("The number we are factorizing: " + factorNumber);
            System.out.println("Sum of all factors is : " + sumOfFactors);
            System.out.print("Factors of the number are: ");
            for(counter1=0; counter1<factorsArray.length; counter1++ ) {
                if (factorsArray[counter1] != 0) {
                    System.out.print( factorsArray[counter1] + " ");
                }
                
            }
            System.out.println("");
            
        }
        //method to identify if the number is prime or not
        public void isPrime() {
            if (factorsArray[1] == factorNumber ) {
                System.out.println(factorsArray[1]);
                System.out.println("The number you entered is a Prime Number.");
            }
            else {
                System.out.println(factorsArray[1]);
                System.out.println("The number you entered is not a Prime Number.");
            }
        }
        //method to identify if the number is perfect or not
        public void isPerfect() {
            if (sumOfFactors == factorNumber) {
                System.out.println("The number you entered is a Perfect Number.");
            }
            else {
                System.out.println("The number you entered is not a Perfect Number.");
            }
        }
}
