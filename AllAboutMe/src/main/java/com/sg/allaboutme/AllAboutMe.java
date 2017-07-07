/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.allaboutme;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AllAboutMe {
    public static void main(String[] args) {
        String name, fav_food, nPets, wAge, yorn;
        int num_pets, age;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your name:");
        name = sc.nextLine();
        System.out.println("Enter your favorite food:");
        fav_food = sc.nextLine();
        System.out.println("How many pets do you have?");
        nPets = sc.nextLine();
        System.out.println("What was your age when you learned to whistle?");
        wAge = sc.nextLine();
        System.out.println("Have you ever eaten gnocchi?");
        yorn = sc.nextLine();
        
        num_pets = Integer.parseInt(nPets);
        age = Integer.parseInt(wAge);
        
        System.out.println("I am " + name + ".");
        System.out.println("I have " + num_pets + " pets.");
        System.out.println("My favorite food is " + fav_food + ".");
        if (yorn == "yes")
        {
            System.out.println("It is true that I have eaten gnocchi.");
        }
        else
        {
            System.out.println("It is not true that I have eaten gnocchi.");
        }
        
        System.out.println("And when I was " + age + " years old, I learned to whistle.");
        
        
        
    }
    
}
