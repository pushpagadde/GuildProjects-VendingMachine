/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SimpleFileIO {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        
        out.println("First line in the file.");
        out.println("Second line in the file.");
        out.print("Third line to the file.");
        out.flush();
        out.close();
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        System.out.println("That is all the content in the file.");
        
    }
    
}
