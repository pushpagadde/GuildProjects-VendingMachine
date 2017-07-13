/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.fors;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class TheCount {
    public static void main(String[] args) {
        int start, stop, count;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What number do you want to start at?");
        start = sc.nextInt();
        System.out.println("What number do you want to end at?");
        stop = sc.nextInt();
        System.out.println("What number do you want to count by?");
        count = sc.nextInt();
        
        int i, j=1;
        for (i=start; i<=stop; i=i+1) {
            System.out.println(start);
            start = start + count;
           
            if (j%3 == 0) {
                System.out.println("- Ah ah ah!");
            }
            j++;
        }
        
    }
}
