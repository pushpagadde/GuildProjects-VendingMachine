/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizorspringmvc;
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
public class FactorizorController {
     @RequestMapping(value="/factorNumber", method=RequestMethod.POST)
    public String factorNumber(HttpServletRequest request, Map<String, Object> model) {
        // A List to hold our factors
    List<Integer> factorList = new ArrayList<>();
    // A sum to help us calculate whether or not the number is perfect
    int factorSum = 0;
    boolean isPrime = false;
    boolean isPerfect = false;
    // Get the input from the user and convert it to an int
    String input = request.getParameter("numberToFactor");
    int numberToFactor = Integer.parseInt(input);

    // Factor the number - there are more efficient ways of doing this!
    for (int i = 1; i < numberToFactor; i++) {
        if (numberToFactor % i == 0) {
            // i goes into numberToFactor evenly so it
            // is a factor, add it to the list and add
            // it to the sum
            factorList.add(i);
            factorSum += i;
        }
    }
    factorList.add(numberToFactor);
    if (factorSum == numberToFactor) {
        isPerfect = true;
    }

    if (factorSum == 1) {
        isPrime = true;
    }

    // Set all the results in the model Map so they
    // are available to result.jsp
    model.put("numberToFactor", numberToFactor);
    model.put("factors", factorList);
    model.put("isPrime", isPrime);
    model.put("isPerfect", isPerfect);
    return "result";
    }
}
