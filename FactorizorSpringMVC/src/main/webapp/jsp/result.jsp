<%-- 
    Document   : result
    Created on : Dec 28, 2017, 6:16:49 PM
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
        <p>You asked to factor ${numberToFactor}</p>
        <p>
            Factors are:
            <c:forEach var="currentFactor" items="${factors}">
                <c:out value="${currentFactor} "/>
            </c:forEach>
        </p>
        <p>
            <c:choose>
                <c:when test="${isPerfect}">
                    <c:out value="The number is perfect."/>
                </c:when>
                <c:otherwise>
                    <c:out value="The number is not perfect."/>
                </c:otherwise>
            </c:choose>
        </p>
        <p>
            <c:choose>
                <c:when test="${isPrime}">
                    <c:out value="The number is prime."/>
                </c:when>
                <c:otherwise>
                    <c:out value="The number is not prime."/>
                </c:otherwise>
            </c:choose>            
        </p>       
        <p><a href="index.jsp">Factor Another One!</a></p>
    </body>
</html>
