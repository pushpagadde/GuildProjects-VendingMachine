/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fruitsalad;

/**
 *
 * @author apprentice
 */
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        String[] fruitSalad = new String[12];
        
        int total, berries, apples, oranges, i, j, tomatos, other;
        total= 0;
        berries = 0;
        apples=0;
        oranges=0;
        tomatos=0;
        other = 0;
        i=0;
        for(j = 0; j<fruit.length && i < 12; j++) {
            if (fruit[j].contains("Tomato")) {
                tomatos ++;
            } else if(fruit[j].contains("Apple") ) {
                if (apples <3 ) {
                fruitSalad[i]= fruit[j];
                apples = apples+ 1; i++;}
            } else if(fruit[j].contains("Orange") ) {
                if(oranges <2) {
                fruitSalad[i]= fruit[j];
                oranges = oranges + 1; i++;}
            } else if(fruit[j].contains("berry")) {
                fruitSalad[i]= fruit[j];
                berries = berries + 1; i++;
            } else {
                fruitSalad[i]= fruit[j];i++;
                other = other + 1;
            }
            
            
        }
        for (i =0; i< 12; i++)         {
            System.out.println(i + ". " + fruitSalad[i] );
        }
        System.out.println("tomato=" + tomatos);
        System.out.println("apples=" + apples);
        System.out.println("oranges=" + oranges);
        System.out.println("berries=" + berries);
        System.out.println("other=" + other);
    }
    
}
