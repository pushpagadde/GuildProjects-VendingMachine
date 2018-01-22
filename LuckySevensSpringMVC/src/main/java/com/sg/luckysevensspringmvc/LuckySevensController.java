/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensspringmvc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author PG
 */
@Controller
public class LuckySevensController {
    @RequestMapping(value="/luckySevens", method=RequestMethod.POST)
    public String luckySevens(HttpServletRequest request, Map<String, Object> model) {
        String amountEntered = request.getParameter("betAmount");
        int betAmount = Integer.parseInt(amountEntered);
        int finalAmount = Integer.parseInt(amountEntered);
        Random rand = new Random(); 
        int dice1, dice2, rollCount=1, maxRoll=0;
        do{
            dice1 = rand.nextInt(6); 
            dice2 = rand.nextInt(6); 
            System.out.println(dice1);
            if(dice1 + dice2 == 7) {
                betAmount = betAmount + 4;
            } else {
                betAmount = betAmount - 1;
            }
            if(finalAmount < betAmount) {
                finalAmount = betAmount;
                maxRoll = rollCount;
            }
            rollCount = rollCount + 1;
        }while(betAmount > 0);
        
        model.put("amountEntered",request.getParameter("betAmount"));
        model.put("maxRoll",maxRoll);
        model.put("amountEarned",finalAmount);
        model.put("rollCount",rollCount);
        return "result";
    }
}
