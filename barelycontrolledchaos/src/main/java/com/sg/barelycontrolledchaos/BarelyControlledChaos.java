/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.barelycontrolledchaos;
import java.util.Random;
import java.awt.*;
//import java.awt.event.*;
/**
 *
 * @author apprentice
 */
public class BarelyControlledChaos {
    public static void main(String[] args) {
        
        
        
        Color color = getColor(); // call color method here 
        int c = color.getRGB();
        
        System.out.println("color is " + c);
    /*    ??? animal = ???; // call animal method again here 
        ??? colorAgain = ???; // call color method again here 
        ??? weight = ???; // call number method, 
            // with a range between 5 - 200 
        ??? distance = ???; // call number method, 
            // with a range between 10 - 20 
        ??? number = ???; // call number method, 
            // with a range between 10000 - 20000 
        ??? time = ???; // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");*/
    
    
    } 
    
    public static Color getColor(){
        Random randomizer = new Random();
        float r = randomizer.nextFloat();
        float g = randomizer.nextFloat();
        float b = randomizer.nextFloat();
        Color randomColor = new Color(r,g,b);
        
        return randomColor;
        
    }
    // ??? Method 1 ??? 
    // ??? Method 2 ??? 
    // ??? Method 3 ??? 
}

