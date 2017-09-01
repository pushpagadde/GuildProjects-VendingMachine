/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.enumdaystofriday;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class TellDays {
    public enum DAYSOFWEEK {
            SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    
    //DAYSOFWEEK day;
    public static void main(String args[]){
        DAYSOFWEEK day;// = DAYSOFWEEK.SUNDAY;
        
        Scanner inDay = new Scanner(System.in);
 
        System.out.println("Enter a day in the week: ");
        String inputDay = inDay.nextLine();
        inputDay = inputDay.toUpperCase();
        //day = inputDay;
        day = DAYSOFWEEK.valueOf(inputDay);
        
        try {
            
            System.out.println("You entered the day "+ day);
            
            
            switch (day) {
                case SUNDAY:
                    System.out.println("5 days to Friday");
                    break;
                case MONDAY:
                    System.out.println("4 days to Friday");
                    break;
                case TUESDAY:
                    System.out.println("3 days to Friday");
                    break;
                case WEDNESDAY:
                    System.out.println("2 days to Friday");
                    break;
                case THURSDAY:
                    System.out.println("1 days to Friday");
                    break;
                case FRIDAY:
                    System.out.println("Friday Today");
                    break;
                case SATURDAY:
                    System.out.println("6 days to Friday");
                    break;
                default :
                    //Control will not come here as try catch will catch the invalid inputs
                    System.out.println("INVALID INPUT EXCEPTION.");
                    break;
            }            
        } catch(java.lang.IllegalArgumentException e){
            System.out.println("Invalid Input Exception");
        }
    }
}
