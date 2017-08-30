/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author apprentice
 */
public class CountXX {
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    // countXX("axb")   -> 0 
    // countXX("abcxx") -> 1
    // countXX("xxx")   -> 2
    // countXX("xxxx")  -> 3
    public int countXX(String str) {
        int charactersInStr = str.length();
        int i, count=0;
        if(str.length() > 0) {
            for(i = 0; i < charactersInStr-1; i++) {
                if(str.charAt(i) == 'x' && str.charAt(i+1) == 'x')  {
                    count = count + 1;
                }
            }
            System.out.println(count);
            return count;
        } else {
            return 0;
        }
    }    
}