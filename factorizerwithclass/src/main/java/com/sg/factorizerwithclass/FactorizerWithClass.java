/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizerwithclass;

/**
 *
 * @author apprentice
 */
public class FactorizerWithClass {
    public static void main(String[] args) {
        
        FactorizerClassModules factorOfNumber = new FactorizerClassModules();
        
        factorOfNumber.setfactorNumber();
        
        factorOfNumber.findFactors();
        factorOfNumber.isPerfect();
        factorOfNumber.isPrime();
        
        
    }
    
}
