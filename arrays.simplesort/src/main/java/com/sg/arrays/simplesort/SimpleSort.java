/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrays.simplesort;

/**
 *
 * @author apprentice
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];
        
        int i,  j, temp;
        
        for (i = 0; i < firstHalf.length; i++) {
            wholeNumbers[i] = firstHalf[i];
            
        }
        for (j = i; j< secondHalf.length+i; j++) {
            wholeNumbers[j] = secondHalf[j-i];
        }
        
        for (j = 0; j < wholeNumbers.length; j ++) {
            System.out.print(wholeNumbers[j] + " ");
        }
        
        for(i = 0; i < wholeNumbers.length; i++) {
            for(j = i+1; j <  wholeNumbers.length; j++) {
                
                if(wholeNumbers[i] > wholeNumbers[j]) {
                    temp = wholeNumbers[j];
                    wholeNumbers[j] = wholeNumbers[i];
                    wholeNumbers[i] = temp;
                }
                
            }
            
        }
        
        System.out.println("");
        for (j = 0; j < wholeNumbers.length; j ++) {
            System.out.print(wholeNumbers[j] + " ");
        }
        
    }
}
