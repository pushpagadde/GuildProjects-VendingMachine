/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class CalculatorConsole {
    Scanner sc = new Scanner(System.in);
    SimpleCalculator calc = new SimpleCalculator();
    int operand1, operand2, result;
    String operation;
    int control=0;
    
    public void displayConsole() {
        
        System.out.println("");
        System.out.println("|======================================|");
        System.out.println("|       1            2            3    |");
        System.out.println("|       4            5            6    |");
        System.out.println("|       7            8            9    |");
        System.out.println("|======================================|");
        System.out.println("");
    }
    
    public void getOperands(){
        System.out.println("Enter the operation you would like to perform:");
        operation = sc.next();
        System.out.println("Enter the operand 1:");
        operand1 = sc.nextInt();
        System.out.println("Enter the operand 2:");
        operand2 = sc.nextInt();
        
    }
    
    public void performOperation() {
        
        switch (operation) {
            case "+":
                result = calc.add(operand1, operand2);
                break;
            case "-":
                result = calc.subtract(operand1, operand2);
                break;
            case "*":
                result = calc.multiply(operand1, operand2);
                break;
            case "/":
                result = calc.divide(operand1, operand2);
                break;
            default:
                System.out.println("Did not pick a right operator");
                control = 1;
                break;
        }
    }
    
    public void getResult() {
        if (control == 1){
            System.out.println("Operation failed");
        } else {
            System.out.println("Result of " + operand1 + " " + operation + " " + operand2 + " = " + result);
        }
        
    }
    
    
}
