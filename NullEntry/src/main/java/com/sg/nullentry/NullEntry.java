/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.nullentry;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class NullEntry {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String readString = input.nextLine();
        //while(readString!=null) {
            System.out.println(readString);
            if (readString.equals(""))
                System.out.println("Read Enter Key.");
            if (input.hasNextLine())
                readString = input.nextLine();
            else
                readString = null;
        //}
    }
    
}













