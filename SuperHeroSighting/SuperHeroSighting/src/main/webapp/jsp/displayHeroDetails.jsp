<%-- 
    Document   : displayHeroDetails
    Created on : Feb 2, 2018, 11:45:55 PM
    Author     : PG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
        <title>Hero Details</title>
        <style>
            #displayDetails{
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                font-size: 25px;
                border-collapse: collapse;
                width: 100%;
                border: 1px solid #ddd;
                padding: 8px;
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;                
            }             
            #bottomPanel {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                font-size: 50px;
                border-collapse: collapse;
                width: 100%;
                padding: 8px;
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;                
                color: gray;    
            }
        </style>
    </head>
    <body>
        <h1>Hero details</h1>
        <hr>
        <div class = "row"  id="displayDetails">
            <div class="col-md-offset-4 col-md-8">
                <p> Hero Name: <c:out value="${hero.heroName}"/> </p>
            </div>
            <div class="col-md-offset-4 col-md-8">
                <p> Hero Power: <c:out value="${hero.heroPower}"/> </p>
            </div>            
        </div>
        <div class="col-md-offset-4 col-md-8" id="bottomPanel">
                <form class="form-horizontal" role="form" modelAttribute="hero" action="superHero" method="GET">
                      <input type="submit" class="btn btn-default" value="Back" name="Back"/>
                </form>    
        </div>
    </body>
</html>
