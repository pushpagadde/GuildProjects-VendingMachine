/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.random4;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class HighRoller {
    public static void main(String[] args) {

        Random diceRoller = new Random();    
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Tell the number of sides a dice has:");
        
        int diceSides = sc.nextInt();
        int rollResult = diceRoller.nextInt(diceSides);
        
        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        
        if (rollResult == 1) {
        System.out.println("You rolled a crit failure! Ouch.");
        } else if ( rollResult == diceSides) {
            System.out.println("You rolled a critical! Nice Job!");
        } else {
            System.out.println("You rolled a " + rollResult);
        }
    }
}
