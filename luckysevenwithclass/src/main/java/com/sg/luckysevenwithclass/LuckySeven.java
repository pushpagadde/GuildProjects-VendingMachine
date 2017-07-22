/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevenwithclass;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class LuckySeven {
    public static void main(String[] args) {
        int amount;
        Scanner sc = new Scanner(System.in);
        LuckySevenClassModules LSObject = new LuckySevenClassModules();
        
        System.out.println("How many dollars do you have to bet?");
        amount = sc.nextInt();
        LSObject.setAmount(amount);
        LSObject.playBet();
    }
    
    
        
}
