/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.doggenetics;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class DogGenetics {
    public static void main(String[] args) {
        Random dogGenes = new Random();    
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is your dog's name?");
        
        String dogGenesName = sc.nextLine();
        int percent1 = dogGenes.nextInt(100);
        int percent2, percent3, percent4, percent5, temp;
        
        //calculating % for the entered dog name
        //touching all code for commit
        temp = 100 - percent1;
        percent2 = dogGenes.nextInt(temp);
        temp = 100 - (percent1 + percent2);
        percent3 = dogGenes.nextInt(temp);
        temp = 100 - (percent1+ percent2 + percent3);
        percent4 = dogGenes.nextInt(temp);
        percent5 = 100 - (percent1 + percent2 + percent3 + percent4);
        
        System.out.println("Well then, I have this highly reliable report on " + dogGenesName + "'s prestigious background right here.");
        
        System.out.println(percent1 + "% St. Bernard");
        System.out.println(percent2 + "% Chihuahua");
        System.out.println(percent3 + "% Dramatic RedNosed Asian Pug");
        System.out.println(percent4 + "% Common Cur");
        System.out.println(percent5 + "% King Doberman");
        
        System.out.println("wow, that's QUITE a dog!");
    }
}
