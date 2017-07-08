/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class TriviaNight {
    public static void main(String[] args) {
        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        
        
        String ans1, ans2, ans3;
        int a1, a2, a3;
        int sum;
        
        Scanner sc = new Scanner(System.in);
              
               
        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code		2) Assembly Language\n" +
"3) C#				4) Machine Code");
        System.out.println("YOUR ANSWER:");
        ans1 = sc.nextLine();
        a1 = Integer.parseInt(ans1);
        
        System.out.println("SECOND QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper		2) Alan Turing\n" +
"3) Charles Babbage		4) Larry Page");
        System.out.println("YOUR ANSWER:");
        ans2 = sc.nextLine();
        a2 = Integer.parseInt(ans2);
        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity			2) The Battlestar Galactica\n" +
"3) The USS Enterprise	4) The Millennium Falcon");
        System.out.println("YOUR ANSWER:");
        ans3 = sc.nextLine();
        a3 = Integer.parseInt(ans3);
        
        sum = 0;
        if (a1 == 4) {
            sum = sum +1;
        }
        if (a2 == 2) {
            sum = sum + 1;
        }
        if (a3 == 3) {
            sum = sum + 1;
        }
        
        System.out.println("You got " + sum + " right.");
    }
    
}
