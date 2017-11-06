/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

/**
 *
 * @author apprentice
 */
public class InsertWord {
        // Given an "out" String length 4, such as "<<>>", and a 
    // word, return a new String where the word is in the middle 
    // of the out String, e.g. "<<word>>".
    //
    // Hint: SubStrings are your friend here 
    //
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    // insertWord("[[]]", "word") -> "[[word]]"
    public String insertWord(String container, String word) {
        if(container.length() == 4) {
            
            String subString1 = container.substring(0,2);
            System.out.println(subString1);
            String subString2 = container.substring(2,4);
            System.out.println(subString2);
            String newWord = subString1 + word + subString2;
            System.out.println(newWord);
            return newWord;
        } else {
            return "invalid length of container";
        }
    }
}
