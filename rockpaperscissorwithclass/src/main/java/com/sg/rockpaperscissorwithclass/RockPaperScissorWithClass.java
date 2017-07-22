/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissorwithclass;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class RockPaperScissorWithClass {
    
    public static void main(String[] args) {
        
        int play;
        String goOn;
        Scanner sc = new Scanner(System.in);
        RockPaperScissorMethods gamePlay = new RockPaperScissorMethods();
        
        do {
            
            
            play = gamePlay.setRockPaperScissorMethods();
            if(play >= 1 && play <= 10) {
                gamePlay.playGame(play);
                                  
            } else  {
                System.out.println("You can key numbers from 1 to 10");
                break;
            }
            System.out.println("Do you want to play again(y/n)?");
            goOn = sc.next();
        
        } while (goOn.equals("y"));
        
        System.out.println("Bye!");
        
    }
    
    
}
