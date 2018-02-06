<%-- 
    Document   : locationDetailsPage
    Created on : Feb 4, 2018, 4:48:21 PM
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
        <title>Location Details Page</title>
    </head>
    <body>
        <h1>Super Hero Sighting! - Location Details Page </h1>
        <p> Member Name:       <c:out value="${location.description}"/> </p>
        <p> Address:           <c:out value="${location.address}"/></p>
        <p> City, State:       <c:out value="${zipCode.city}"/>, <c:out value="${zipCode.state}"/></p>                                                
        <p> Zip Code:          <c:out value="${location.zipCode}"/></p>
        <p> Longitude:          <c:out value="${location.longitude}"/></p>
        <p> Latitude:          <c:out value="${location.latitude}"/></p>
        <form class="form-horizontal" role="form" modelAttribute="location" action="location" method="GET">
            <input type="submit" class="btn btn-default" value="Back" name="back"/>
        </form>        
    </body>
</html>