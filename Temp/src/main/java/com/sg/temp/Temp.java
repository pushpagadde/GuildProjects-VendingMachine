/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.temp;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Temp {
    public static void main(String[] args) {
        
        String yourName;
           
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your Last name:");
        yourName = sc.nextLine();
        
        int c;
        if (yourName.compareTo("Baggins") <= 0) {
            System.out.println("Aha, You're on the team 'Black Holes'!");
        }
        else if (yourName.compareTo("Baggins") > 0 && yourName.compareTo("Dresden") <= 0) {
            System.out.println("Aha, You're on the team 'Dark Wizards'!");
        }
        else if (yourName.compareTo("Dresden") > 0 && yourName.compareTo("Howl") <= 0) {
            System.out.println("Aha, You're on the team 'Moving Castles'!");
        }
        else if (yourName.compareTo("Howl") > 0 && yourName.compareTo("Potter") <= 0) {
            System.out.println("Aha, You're on the team 'Golden Snitches'!");
        }
        else if (yourName.compareTo("Potter") > 0 && yourName.compareTo("Vimes") <= 0) {
            System.out.println("Aha, You're on the team 'Night Guards'!");
        }
        else {
            System.out.println("Aha, You're on the team 'Black Holes'!");
        }
    }
}
