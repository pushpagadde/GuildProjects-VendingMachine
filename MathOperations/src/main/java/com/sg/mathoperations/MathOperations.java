/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.mathoperations;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MathOperations {
    public static enum MATHOPERATOR {
        PLUS, MINUS, MULTIPLY, DIVIDE
    }
   
    public static void main(String[] args) {
        MATHOPERATOR operator;
        int operand1, operand2=1, result;
        String userOperator;
        boolean flag = false;
        
        Scanner userInput = new Scanner(System.in);
        do {
            flag = false;
            System.out.println("Enter an operator:");
            userOperator = userInput.next();
            if( !( userOperator.equals("plus")     || userOperator.equals("minus") 
                || userOperator.equals("multiply") || userOperator.equals("divide") )){
                System.out.println("You have to enter PLUS, MINUS, MULTIPLY or DIVIDE ");
                flag = true;
            }
        } while(flag);
        
        System.out.println("Enter a number: ");
        operand1 = userInput.nextInt();
        
        do {
            flag = false;
            System.out.println("Enter a second number: ");
            operand2 = userInput.nextInt();
            if(operand2 == 0 && userOperator.equals("divide")) {
                System.out.println("2nd number cannot be equal to 0 for division operation.");
                flag = true;
            }
        } while (flag);
        userOperator = userOperator.toUpperCase();
        System.out.println(userOperator);
        operator = MATHOPERATOR.valueOf(userOperator);
        
        try {
            result = calculate(operator, operand1, operand2);
            System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result);
        } catch (Exception e) {
            System.out.println("not a valid operation");
        }
    }
    
    public static int calculate(MATHOPERATOR operator, int operand1, int operand2) {
        try {
            switch(operator) {
                   case PLUS:
                         return operand1 + operand2;
                   case MINUS:
                         return operand1 - operand2;
                   case MULTIPLY:
                         return operand1 * operand2;
                   case DIVIDE:
                         return operand1 / operand2;
                   default:
                         throw new UnsupportedOperationException();
            }
        } catch (Exception e) {
            System.out.println("Invalid function");
            throw new UnsupportedOperationException();
        }
    }
}