<%-- 
    Document   : index
    Created on : Dec 27, 2017, 8:54:09 PM
    Author     : PG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens </title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
        <p>Please enter money to bet:</p>
        <form method="post" action="LuckySevensServlet">
            <p>Money to bet : <input type="number" name="betAmount"/></p><br/>
            <input type="submit" value="Play!!!"/>
        </form>
    </body>
</html>
