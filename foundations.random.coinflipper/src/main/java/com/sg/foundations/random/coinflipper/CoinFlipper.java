/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.random.coinflipper;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class CoinFlipper {
    public static void main(String[] args) {
        Random cnflip = new Random(); 
        int coinFlip = cnflip.nextInt(2);
        System.out.println("Ready, Set, Flip....!!");
        if (coinFlip == 1) {
            System.out.println("You got TAILS!");
        }
        else {
            System.out.println("You got HEADS!");
        }
    }
}
