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
public class MakePi {
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public int[] makePi(int n) {
        if(n > 0) {
            double pi = 3.14159265359;
            
            System.out.println("n=" + n);
            System.out.println("pi=" + pi);
            for(int j=0; j<n-1; j++) {
                pi=pi*10;
                System.out.println(pi);
            }
            
            int intPi = (int)(pi);
            System.out.println("intpi= " + intPi);
            int[] piArray = new int[n];
            for (int i=n-1; i>=0; i--) {
                piArray[i] = intPi % 10;
                
                System.out.println(i + " " + piArray[i]);
                intPi = intPi/10;
            }
            //System.out.println("piarray=" + piArray);
            return piArray;
        } else {
            return null;
        }
    }
    /*public static void main(String args[]){
       double pi = 3.14159265359;
       String st =""+ pi * 10 * 10;
       System.out.print(st);
       
       char[] ch = st.toCharArray();
       System.out.print(ch[0]+"--"+ch[1]);
    }*/
}
