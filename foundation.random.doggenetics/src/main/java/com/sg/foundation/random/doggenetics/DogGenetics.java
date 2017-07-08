/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundation.random.doggenetics;
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
        int p1 = dogGenes.nextInt(100);
        int p2, p3, p4, p5, c;
        
        c = 100 - p1;
        p2 = dogGenes.nextInt(c);
        c = 100 - (p1 + p2);
        p3 = dogGenes.nextInt(c);
        c = 100 - (p1+ p2 + p3);
        p4 = dogGenes.nextInt(c);
        p5 = 100 - (p1 + p2 + p3 + p4);
        
        
        System.out.println("Well then, I have this highly reliable report on" + dogGenesName + "'s prestigious background right here.");
        
        System.out.println(p1 + "% St. Bernard");
        System.out.println(p2 + "% Chihuahua");
        System.out.println(p3 + "% Dramatic RedNosed Asian Pug");
        System.out.println(p4 + "% Common Cur");
        System.out.println(p5 + "% King Doberman");
        
        System.out.println("wow, that's QUITE a dog!");
    }
}
