/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

/**
 *
 * @author apprentice
 */
public class AlarmClock {
    // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // “10:00" and weekends it should be "off". 
    // vacation - weekday 10 weekend off
    // not vacation - weekday 7 weekend 10
    // alarmClock(1, false) → "7:00"
    // alarmClock(5, false) → "7:00"
    // alarmClock(0, false) → "10:00"
    public String alarmClock(int day, boolean vacation) {
        String wakeUpTime;
        switch(day) {
            case 0:
                if(vacation == true){
                    wakeUpTime = "OFF";
                    break;
                } else {
                    wakeUpTime = "10:00";
                    break;
                }
            case 1:
                if(vacation == true){
                    wakeUpTime = "10:00";
                    break;
                } else {
                    wakeUpTime = "7:00";
                    break;
                }
            case 2:
                if(vacation == true){
                    wakeUpTime = "10:00";
                    break;
                } else {
                    wakeUpTime = "7:00";
                    break;
                }
            case 3:
                if(vacation == true){
                    wakeUpTime = "10:00";
                    break;
                } else {
                    wakeUpTime = "7:00";
                    break;
                }
            case 4:
                if(vacation == true){
                    wakeUpTime = "10:00";
                    break;
                } else {
                    wakeUpTime = "7:00";
                    break;
                }
            case 5:
                if(vacation == true){
                    wakeUpTime = "10:00";
                    break;
                } else {
                    wakeUpTime = "7:00";
                    break;
                }
            case 6:
                if(vacation == true){
                    wakeUpTime = "10:00";
                    break;
                } else {
                    wakeUpTime = "7:00";
                    break;
                }
            case 7:
                if(vacation == true){
                    wakeUpTime = "OFF";
                    break;
                } else {
                    wakeUpTime = "10:00";
                    break;
                }
            default :
                wakeUpTime = "not valid";
                    
        }
        return wakeUpTime;
    }
}
