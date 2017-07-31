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
public class UserIOMain {
    public static void main(String[] args) {
        ImplementUserIO userio = new ImplementUserIO();
        int temporary;
        
        temporary = userio.readInt("Enter a number between 3 and 7", 3,7);
        System.out.println("Bye!");
        
    }
    
}
