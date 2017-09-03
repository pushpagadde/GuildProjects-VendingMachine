/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author apprentice
 */
public class FindCompoundInterest {

    public FindCompoundInterest() {
    }
    
    public BigDecimal calculate(BigDecimal principal, BigDecimal rate, int frequency, BigDecimal term) {
        BigDecimal temporary = new BigDecimal("0");
        //temporary = rate.divide(BigDecimal.valueOf(frequency), BigDecimal.ROUND_HALF_UP);
        
        temporary = rate.divide( BigDecimal.valueOf(frequency), 5, BigDecimal.ROUND_HALF_UP);
        
        System.out.println("step1=" + temporary);
        temporary = temporary.add(BigDecimal.valueOf(1.00)); 
        System.out.println("step2=" + temporary);
        temporary = temporary.pow(frequency);
        System.out.println("step3=" + temporary);
        
        double dTemporary = (Math.pow(temporary.doubleValue(), term.doubleValue()));
        System.out.println("double =" + dTemporary);
        temporary = BigDecimal.valueOf(dTemporary);
        System.out.println("step5=" + temporary);
        temporary = temporary.multiply(principal);
        System.out.println("total=" + temporary);
        return temporary;
    }
}