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
        
        int uWin, cWin, tie, cp;
        String cpick, upick;
        
        Scanner sc1 = new Scanner(System.in);
        
        uWin = cWin = tie = 0;
        Random rand = new Random();
        
        cp = rand.nextInt(2);
        if (cp == 0) {
            cpick = "Rock";
        } else if (cp == 1) {
            cpick = "Paper";
        } else {
            cpick = "Scissors";
        }
               
        
        for(int i = 0; i<no; i++) {
            
            System.out.println("Pick rock, paper or scissors:");
            upick = sc1.next();
        
            if (upick.equalsIgnoreCase(cpick) ) {
                tie ++ ;
            } else if (upick.equalsIgnoreCase("Rock") && cpick.equalsIgnoreCase("Paper")) {
                cWin++;
            } else if (upick.equalsIgnoreCase("Paper") && cpick.equalsIgnoreCase("Scissors")) {
                cWin++;
            }else if (upick.equalsIgnoreCase("Scissors") && cpick.equalsIgnoreCase("Rock")) {
                cWin++;
            } else if (upick.equalsIgnoreCase("Paper") && cpick.equalsIgnoreCase("Rock")) {
                uWin++;
            } else if (upick.equalsIgnoreCase("Scissors") && cpick.equalsIgnoreCase("Paper")) {
                uWin++;
            } else if (upick.equalsIgnoreCase("Rock") && cpick.equalsIgnoreCase("Scissors")) {
                uWin++;
            }    
            System.out.println("iteration " + i + " upick:" + upick + " cpick:" + cpick);
        }
        
        System.out.println("Computer wins: " + cWin);
        System.out.println("Tie: " + tie);
        System.out.println("User wins: " + uWin);
        
    }
    
    
    public static void main(String[] args) {
        
        int play;
        String goon;
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
        goon = sc.next();
        
        } while (goon.equals("y"));
        
        System.out.println("Bye!");
        
    }
    
}
