<%-- 
    Document   : result
    Created on : Dec 28, 2017, 8:10:37 PM
    Author     : PG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Flooring Calculator - Result </title>
    </head>
    <body>
        <h1>Flooring Calculator - Result</h1>        
        <p>You asked to find cost of labor and material for an area of  square feet. </p>
        <p>Total Area: ${area}</p><br>
        <p>Time to install: ${timeToInstall}</p><br>
        <p>Material cost: ${materialCost}</p><br>
        <p>Total cost: ${totalCost}</p><br>
    </body>
</html>
