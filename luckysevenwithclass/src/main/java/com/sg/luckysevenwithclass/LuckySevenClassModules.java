/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevenwithclass;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class LuckySevenClassModules {
    
    Random randomizer = new Random();
    Scanner sc = new Scanner(System.in);
    int amountToPlay, maxAmount, maxRoll=0, rollCount=1;
        
    //constructor
    public LuckySevenClassModules() {
        
    }
    
    //setter method to set amount
    public void setAmount(int amount) {
        this.amountToPlay = amount;
        
    }
    
    //getter method to get amount
    public int getAmount() {
        
        return amountToPlay;
    }
    
    public void playBet() {
        int dice1, dice2;
        maxAmount = amountToPlay;
                
        do  {
            dice1 = randomizer.nextInt(6);
            dice2 = randomizer.nextInt(6);
            if (dice1 + dice2 == 7){
                amountToPlay = amountToPlay + 4;
                System.out.print("win ");
                
            } else {
                amountToPlay = amountToPlay - 1;
                System.out.print("loose ");
            }
            
            if (amountToPlay > maxAmount ){
                maxAmount = amountToPlay;
                maxRoll = rollCount;
            }
            rollCount = rollCount + 1;
            System.out.print("number of Rolls " + rollCount + " Max roll: " + maxRoll + " maxamt " + maxAmount + ".");
            System.out.println(" amount now" + amountToPlay);
        } while(amountToPlay > 0);
        //maxRoll ++;
        
        System.out.println("You are broke after " + rollCount + " rolls.");
        System.out.println("You should have quit after " + maxRoll + " rolls when you had " + maxAmount + ".");   
    
    } 
    
}
