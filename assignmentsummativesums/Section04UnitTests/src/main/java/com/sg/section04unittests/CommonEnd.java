/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    // Given 2 arrays of ints, a and b, return true if they 
    // have the same first element or they have the same 
    // last element. Both arrays will be length 1 or more. 
    //
    // commonEnd({1, 2, 3}, {7, 3}) -> true
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    // commonEnd({1, 2, 3}, {1, 3}) -> true

package com.sg.section04unittests;

/**
 *
 * @author apprentice
 */
public class CommonEnd{
    public boolean commonEnd(int[] a, int[] b) {
    int i = a.length, j= b.length;
    if(a[0] == b[0]) {
        return true;
    } else if (a[i-1]==b[j-1]) {
        return true;
    }
    return false;
    }

}
