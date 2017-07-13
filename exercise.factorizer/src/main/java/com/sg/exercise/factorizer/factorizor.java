/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.factorizer;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class factorizor {
    public static void main(String[] args) {
        int no, sum, i, j;
        int[] fac = new int[50];
        //int[] wholeNumbers = new int[24];
        
        sum = 0;
        j=0;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What number would you like to factor?");
        no = sc.nextInt();
        System.out.println("You entered number: " + no);
        
        for(i=1; i<no; i++) {
            if (no%i == 0) {
                //System.out.println(fac[j]+":"+i);                
                fac[j] = i;
                //System.out.println(fac[j]+":"+i);
                sum = sum+ i; 
                j++;
            }
        }
        
       
        
        
        if(sum == no){
            System.out.println(no + "is a perfect number.");
            
        } else {
            System.out.println(no + "is not a perfect number.");
        }
        if (fac.length == 2) {
            System.out.println(no + "is a prime number.");
        } else {
            System.out.println(no + "is not a prime number");
        }
            
     
    }
}
