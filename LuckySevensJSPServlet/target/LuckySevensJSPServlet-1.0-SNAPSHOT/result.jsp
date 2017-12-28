<%-- 
    Document   : result
    Created on : Dec 27, 2017, 8:54:22 PM
    Author     : PG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
        <p>You bet : </p> <c:out value="${amountEntered}" />
        <p>You are broke after <c:out value="${rollCount}" /> rolls. </p>
        <p>You should have quit after <c:out value="${maxRoll}" /> rolls when you had
        <c:out value="${amountEarned}" /></p>

        <p><a href="index.jsp">Calculate again!</a></p>
    </body>
</html>

<%-- 



    <body>
        <h1>Result</h1>
        <p>The new principal amount is : </p>
            <c:set var= "i" value="0" />
            <c:forEach var="amount" items="${amountPerYear}"> 
                <p>Year <c:out value="${i+1} "/> : Starting amount $
                <c:out value= "${startingAmount[i]}" /> Interest Earned is $
                <c:out value="${amountEarned[i]}" /> Balance at end of year is $   
                <c:out value= "${amount}  "/><br></p>
                <c:set var="i" value="${i+1}"/>
            </c:forEach>
        <p><a href="index.jsp">Calculate again!</a></p>
    </body>
</html>
--%>