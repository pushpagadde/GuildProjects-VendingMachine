<%-- 
    Document   : organizationDetailsPage
    Created on : Feb 3, 2018, 4:20:15 PM
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
        <title>Organization Details</title>
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
                color: gray;    
            }
        </style>
    </head>
    <body>
        <h1 align="center">Organization Details!</h1>
        <div class = "row"  id="displayDetails">
            <p> Organization Name: <c:out value="${organization.organizationName}"/></p><div>
        <div class = "row"  id="displayDetails">
            <p> Address:           <c:out value="${organization.address}"/></p></div>
        <div class = "row"  id="displayDetails">
            <p> Zip Code:          <c:out value="${organization.zipCode}"/></p></div>
        <div class = "row"  id="displayDetails">
            <p> City, State:                                               </p></div>
        <div class = "row"  id="displayDetails">
            <p> Phone:             <c:out value="${organization.phone}"/></p></div>
        <div class="col-md-offset-4 col-md-8" id="bottomPanel">
            <form class="form-horizontal" role="form" modelAttribute="organization" action="organization" method="GET">
                <input type="submit" class="btn btn-default" value="Back" name="back"/>
            </form> 
        </div>
    </body>
</html>
