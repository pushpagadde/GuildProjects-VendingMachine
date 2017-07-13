/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.fors.traditionalfizzbuss;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int count, i,j=0;
        
        System.out.println("How much units fizz and buzz do you need in your life?");
        count = sc.nextInt();
        
        for (i = 1; j<=count; i++) {
            if (i%3 == 0 && i%5 == 0)
            {   System.out.print("fizz buzz");
                j++;
            }
            else if (i%5 == 0)
            {    System.out.print("buzz");
                j++;
            }
            else if (i%3 ==0)
            
            {    System.out.print("fizz");
                j++;
            }
            else 
            {    System.out.print(i);}
            
            System.out.println("");
           
            
        }
        System.out.println("TRADITION!!");
    }
    
}
