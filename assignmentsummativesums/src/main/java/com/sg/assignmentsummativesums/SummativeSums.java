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
        int[] arr1 = { 999, -60, -77, 14, 160, 301 };
        int[] arr2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
        140, 150, 160, 170, 180, 190, 200, -99 };
        
        
        //calling the function add that will pass the array as parameter and also print the sum of all elements in array
        //touching all code for commit
        add(arr);
        add(arr1);
        add(arr2);
        
    }   
}
