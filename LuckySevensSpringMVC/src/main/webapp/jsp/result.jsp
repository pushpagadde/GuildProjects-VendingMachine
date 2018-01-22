<%-- 
    Document   : result
    Created on : Dec 28, 2017, 9:37:50 PM
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
        <h1>Lucky Sevens</h1>
        <p>You bet : </p> <c:out value="${amountEntered}" />
        <p>You are broke after <c:out value="${rollCount}" /> rolls. </p>
        <p>You should have quit after <c:out value="${maxRoll}" /> rolls when you had
        <c:out value="${amountEarned}" /></p>

        <p><a href="index.jsp">Calculate again!</a></p>
    </body>
</html>
