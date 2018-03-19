<%-- 
    Document   : organizationDetailsPage
    Created on : Feb 3, 2018, 4:20:15 PM
    Author     : PG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            #tableHero{
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                font-size: 35px;
                border-collapse: collapse;
                width: 100%;
                border: 1px solid #ddd;
                padding: 8px;
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
                align: left;
                
            }
        </style>
    </head>
    <body>
        <h1 align="center">Organization Details!</h1><hr>
        <div class="container">
        <div class = "row"  >
        <table id="tableHero"   > 
            <tr>
                <th width="50%"></th>
                <th width="50%"></th>
            </tr> 
            <tr><td>Organization Name:</td>
                <td><c:out value="${organization.organizationName}"/></td>
            </tr>
            <tr><td>Address:</td>
                <td><c:out value="${organization.address}"/></td>
            </tr>
            <tr><td>Zip Code:</td>
                <td><c:out value="${organization.zipCode}"/></td>
            </tr>
            <tr><td>City, State:</td>
                <td><c:out value="${zipCode.city}"/>, <c:out value="${zipCode.state}"/></td>
            </tr>
            <tr><td>Phone: </td>
                <td><c:out value="${organization.phone}"/></td>
            </tr>
        </table>
        </div>
        <div class="col-md-offset-4 col-md-8" id="bottomPanel">
            <form class="form-horizontal" role="form" modelAttribute="organization" action="organization" method="GET">
                <input type="submit" class="btn btn-default" value="Back" name="back" style="width:100px;height:50px;font-size:25px"/>
            </form> 
        </div>
    </body>
</html>