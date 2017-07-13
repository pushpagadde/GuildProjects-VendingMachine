/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.assignmentsummativesums;

/**
 *
 * @author apprentice
 */
public class SummativeSums {
    
    
    public static void add(int[] a) {
        int i, sum=0;
        for (i=0; i<a.length; i++) {
            sum = sum + a[i];
        }
        System.out.println("Sum of all the elements in the array= " + sum);
    }
    public static void main(String[] args) {
        int[] arr = { 1, 90, -33, -55, 67, -16, 28, -55, 15};
        
        add(arr);
        
        
        
    }
    
}
