/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.userio;

/**
 *
 * @author apprentice
 */
public interface UserIO {
    void print(String message);//#1
    //double readDouble(String prompt);
    //double readDouble(String prompt, double min, double max);
    //float readFloat(String prompt);
    //float readFloat(String prompt, float min, float max);
    int readInt(String prompt);//#2
    int readInt(String prompt, int min, int max);//#3
    long readLong(String prompt);//#4
    String readString(String prompt);//#5  
}
