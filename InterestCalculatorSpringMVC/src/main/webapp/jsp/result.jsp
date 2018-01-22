<%-- 
    Document   : result
    Created on : Dec 28, 2017, 8:53:56 PM
    Author     : PG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Result</title>
    </head>
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
