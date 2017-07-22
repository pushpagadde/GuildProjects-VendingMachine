/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissorwithclass;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class RockPaperScissorMethods {
    
    int youWin, computerWin, tie, computerPickNo;
    String computerPick, youPick;
    Random rand = new Random();
    Scanner sc1 = new Scanner(System.in);
    
    //constructor
    public RockPaperScissorMethods() {
      
        //initializing all counters to 0
        youWin = computerWin = tie = 0;
    
    }
    
    //setter method
    public int setRockPaperScissorMethods() {
        System.out.println("How many games would you like to play?");
        return this.sc1.nextInt();
    }
    
    //getter method
    public void getRockPaperScissorMethods() {
        
    }
    
    public void playGame(int numberOfRounds) {
        
        
        //loop to go user keyed number of times
        for(int i = 0; i<numberOfRounds; i++) {
                        
            //code to ask user to pick rock, paper or scissor
            System.out.println("Pick rock, paper or scissors:");
            youPick = sc1.next();
            
            //code for computer to pick rock, paper or sicssors
            computerPickNo = rand.nextInt(3);
            
            switch (computerPickNo) {
                case 0:
                    computerPick = "Rock";
                    break;
                case 1:
                    computerPick = "Paper";
                    break;
                default:
                    computerPick = "Scissors";
            }
        
            //comparing to count and decide winner
            if (youPick.equalsIgnoreCase(computerPick) ) {
                tie ++ ;
            } else if (youPick.equalsIgnoreCase("Rock") && computerPick.equalsIgnoreCase("Paper")) {
                computerWin++;
            } else if (youPick.equalsIgnoreCase("Paper") && computerPick.equalsIgnoreCase("Scissors")) {
                computerWin++;
            }else if (youPick.equalsIgnoreCase("Scissors") && computerPick.equalsIgnoreCase("Rock")) {
                computerWin++;
            } else if (youPick.equalsIgnoreCase("Paper") && computerPick.equalsIgnoreCase("Rock")) {
                youWin++;
            } else if (youPick.equalsIgnoreCase("Scissors") && computerPick.equalsIgnoreCase("Paper")) {
                youWin++;
            } else if (youPick.equalsIgnoreCase("Rock") && computerPick.equalsIgnoreCase("Scissors")) {
                youWin++;
            }    
            System.out.println("iteration " + i + " youPick:" + youPick + " computerPick:" + computerPick);
            
        }
        
        System.out.println("Computer wins: " + computerWin);
        System.out.println("Tie: " + tie);
        System.out.println("User wins: " + youWin);
        
        
    }
    
}
