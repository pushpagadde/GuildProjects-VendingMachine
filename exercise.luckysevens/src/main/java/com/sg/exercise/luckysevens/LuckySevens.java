/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.luckysevens;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class LuckySevens {
    public static void main(String[] args) {
        Random randomizer = new Random();
        Scanner sc = new Scanner(System.in);
        int d1, d2, amt, rollCount, maxAmt, maxRoll;
        rollCount = 0;
                
        System.out.println("How many dollars do you have to bet?");
        amt = sc.nextInt();
        maxAmt = amt;
        maxRoll = 1;
        
        do  {
            d1 = randomizer.nextInt(6);
            d2 = randomizer.nextInt(6);
            if (d1 + d2 == 7){
                amt = amt + 4;
                
            } else {
                amt = amt - 1;
            }
            
            if (amt > maxAmt ){
                maxAmt = amt;
                maxRoll = rollCount;
            }
            rollCount = rollCount + 1;
            
        } while(amt > 0);
        
        
        System.out.println("You are broke after " + rollCount + " rolls.");
        System.out.println("You should have quit after " + maxRoll + " rolls when you had " + maxAmt + ".");   
    }    
}
