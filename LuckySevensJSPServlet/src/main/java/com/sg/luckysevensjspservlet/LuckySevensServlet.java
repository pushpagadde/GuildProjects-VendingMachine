/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensjspservlet;

import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PG
 */
@WebServlet(name = "LuckySevensServlet", urlPatterns = {"/LuckySevensServlet"})
public class LuckySevensServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        
        request.setAttribute("amountEntered",request.getParameter("betAmount"));
        request.setAttribute("maxRoll",maxRoll);
        request.setAttribute("amountEarned",finalAmount);
        request.setAttribute("rollCount",rollCount);
        // Get the Request Dispatcher for result.jsp and forward the request to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);                                                   
    }   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*        
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
        request.setAttribute("amountPerYear", endingAmount);
        request.setAttribute("enteredAmount", startingAmount);
        request.setAttribute("amountEarned",interestEarned);
        
        // Get the Request Dispatcher for result.jsp and forward the request to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);                                                   
    }
}

*/