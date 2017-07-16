/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.assignment.rockpaperscissors;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class RockPaperScissors {
    
    public static void game(int no) {
        
        int youWin, computerWin, tie, computerPickNo;
        String computerPick, youPick;
        
        Scanner sc1 = new Scanner(System.in);
        
        youWin = computerWin = tie = 0;
        Random rand = new Random();
        
        for(int i = 0; i<no; i++) {
            
            
            //code to ask user to pick rock, paper or scissor
            System.out.println("Pick rock, paper or scissors:");
            youPick = sc1.next();
            
            //code for computer to pick rock, paper or sicssors
            computerPickNo = rand.nextInt(2);
            if (computerPickNo == 0) {
                computerPick = "Rock";
            } else if (computerPickNo == 1) {
                computerPick = "Paper";
            } else {
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
    
    
    public static void main(String[] args) {
        
        int play;
        String goOn;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("How many games would you like to play?");
            play = sc.nextInt();
            if(play > 1 && play <= 10) {
                game( play );
                                  
            } else  {
                System.out.println("You can key numbers from 1 to 10");
            
            }
            System.out.println("Do you want to play again(y/n)?");
            goOn = sc.next();
        
        } while (goOn.equals("y"));
        
        System.out.println("Bye!");
        
    }
    
}
