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
public class CanHazTable {
    // You and your date are trying to get a table at a restaurant. 
    // The parameter "you" is the stylishness of your clothes, in 
    // the range 0..10, and "date" is the stylishness of your date's 
    // clothes. The result getting the table is encoded as an int 
    // value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 
    // 8 or more, then the result is 2 (yes). With the exception that if 
    // either of you has style of 2 or less, then the result is 0 (no). 
    // Otherwise the result is 1 (maybe). 
    // Either of you >= 8 and 
    //            both > 2 return 2
    //            else return 0
    // canHazTable(5, 10) → 2
    // canHazTable(5, 2) → 0
    // canHazTable(5, 5) → 1
    public int canHazTable(int yourStyle, int dateStyle) {
        if( yourStyle >= 8 || dateStyle >= 8){
            if( yourStyle <= 2 || dateStyle <= 2 ) {
                return 0;
            } else {
                return 2;
            }
        } else if (yourStyle <= 2 || dateStyle <= 2) {
            return 0;
        } else {
            return 1;
        }
    }
        /*int sumStyle;
        sumStyle = yourStyle + dateStyle;
        boolean isValid;
        if (yourStyle >= 0 && dateStyle >= 0) {
            if (yourStyle <= 10 && dateStyle <= 10) {
                isValid = true;
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        if (isValid ) {
            if(sumStyle <= 15) {
                if (sumStyle <=10 ) {
                    return true;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }*/

}