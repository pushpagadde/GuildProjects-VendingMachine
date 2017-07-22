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
public class SimpleCalculatorMainMethod {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorConsole calculatorObject = new CalculatorConsole();
        String goOn = "y";
        
        
        do {
            calculatorObject.displayConsole();
            calculatorObject.getOperands();
            calculatorObject.performOperation();
            calculatorObject.getResult();
            
            System.out.println("Do you want to perform another operation?");
            goOn = sc.next();
        } while (goOn.equalsIgnoreCase("y")  );
        
        System.out.println("Bye!");
        
        
    }
    
}
