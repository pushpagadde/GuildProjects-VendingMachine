/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundation.random.guessmemore;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class GuessMeMore {
    public static void main(String[] args) {
        Random guessNo = new Random(); 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("I've chosen a number between -100 and 100. Betcha you can't guess it!");
        
        int ugNo = sc.nextInt();
        int gNo = guessNo.nextInt(200);
        gNo = gNo - 99;
        
        System.out.println("Your guess: " + ugNo );
        if (gNo == ugNo ) {
            System.out.println("Wow, nice try! That was it!");
        } else if ( gNo < ugNo) {
            System.out.println("Ha, nice try - too high! Try again!");
        } else if ( gNo > ugNo ) {
            System.out.println("Ha, nice try - too low! Try again!");
        } 
        
        ugNo = sc.nextInt();
        System.out.println("Your guess: " + ugNo );
        if (gNo == ugNo ) {
            System.out.println("Wow, nice guess! That was it!");
        } else if ( gNo < ugNo) {
            System.out.println("Ha, nice try - too high!");
        } else if ( gNo > ugNo ) {
            System.out.println("Ha, nice try - too low!");
        }
        System.out.println("My guess: " + gNo);
    }
}
