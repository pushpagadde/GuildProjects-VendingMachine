/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorspringmvc;
import java.math.BigDecimal;
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
public class FlooringCalculatorController {
    @RequestMapping(value="/flooringCalculator", method=RequestMethod.POST)
    public String flooringCalculator(HttpServletRequest request, Map<String, Object> model) {
    
        String lengthS, widthS, costS;            
        BigDecimal installC = new BigDecimal("20.00");
        BigDecimal laborC = new BigDecimal("86.00");
        //BigDecimal length, width, materialcost, laborCost, timeToInstall;
        lengthS = request.getParameter("length");
        widthS = request.getParameter("width");
        costS = request.getParameter("costPerSqFoot");
        BigDecimal length = new BigDecimal(lengthS);
        BigDecimal width = new BigDecimal(widthS);
        BigDecimal cost = new BigDecimal(costS);
        BigDecimal area;
        area = length.multiply(width);

        //calculations
        //cost of material
        BigDecimal materialCost = area.multiply(cost);            
        //time to install
        BigDecimal timeToInstall = area.divide(installC);
        //cost for labor
        BigDecimal costOfLabor = timeToInstall.multiply(laborC);
        //total cost
        BigDecimal totalCost = materialCost.add(materialCost);
        totalCost = totalCost.add(costOfLabor);        
        
        // Set all the results in the model Map so they
        // are available to result.jsp
        model.put("totalCost", totalCost);
        model.put("timeToInstall", timeToInstall);
        model.put("materialCost", materialCost);
        model.put("laborCost", costOfLabor);
        model.put("area", area);
        return "result";
    }
}
