/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculatorspringmvc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PG
 */
@Controller
public class InterestCalculatorController {
    @RequestMapping(value="/interestCalculator", method=RequestMethod.POST)
    public String interestCalculator(HttpServletRequest request, Map<String, Object> model) {
        // A List to hold our factors
    
        String amount = request.getParameter("principalAmount");
        String years = request.getParameter("numberOfYears");
        String interest = request.getParameter("annualInterestRate");
        BigDecimal principalAmount = new BigDecimal(amount);
        int numberOfYears = Integer.parseInt(years);
        BigDecimal interestRate = new BigDecimal(interest);
        BigDecimal difference = new BigDecimal(0);
        interestRate = interestRate.divide(new BigDecimal(100));
        List<BigDecimal> endingAmount = new ArrayList<>();
        List<BigDecimal> interestEarned = new ArrayList<>();
        List<BigDecimal> startingAmount = new ArrayList<>();
        int i=0;
        BigDecimal newAmount = new BigDecimal(0);
        
        for(i = 0; i < numberOfYears; i++) {
            startingAmount.add(principalAmount);
            newAmount = interestRate.divide(new BigDecimal(4));
            newAmount = newAmount.add(new BigDecimal(1));
            newAmount = newAmount.pow(4);
            newAmount = newAmount.multiply(principalAmount);             
            newAmount = newAmount.setScale(2, RoundingMode.CEILING);
            difference = newAmount.subtract(principalAmount);
            principalAmount = newAmount;
            endingAmount.add(newAmount);
            interestEarned.add(difference);
        }        
        
        // Set all the results in the model Map so they
        // are available to result.jsp
        model.put("amountPerYear", endingAmount);
        model.put("enteredAmount", startingAmount);
        model.put("amountEarned",interestEarned);
        return "result";
    }
}
