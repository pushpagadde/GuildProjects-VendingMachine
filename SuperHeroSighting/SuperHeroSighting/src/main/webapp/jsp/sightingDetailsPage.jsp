<%-- 
    Document   : sightingDetailsPage
    Created on : Feb 4, 2018, 11:13:55 PM
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
        <title>Sighting Details Page</title>
    </head>
    <body>
        <h1>Super Hero Sighting - Sighting Details page!</h1>
        <p> Hero Sighted: <c:out value="${hero.heroName}"/></p>
        <p> Sighted at:           <c:out value="${location.description}"/></p>
        <p> Address:          <c:out value="${location.address}"/></p>
        <p> City, State:      <c:out value="${zipCode.city}"/>, <c:out value="${zipCode.state}"/>    </p>
        <p> Longitude:             <c:out value="${location.longitude}"/></p>
        <p> Latitude:             <c:out value="${location.latitude}"/></p>
        <p> Date and time of Sighting:             <c:out value="${sighting.dateOfSighting}"/></p>
        <form class="form-horizontal" role="form" modelAttribute="sighting" action="sighting" method="GET">
            <input type="submit" class="btn btn-default" value="Back" name="back"/>
        </form>        
    </body>
</html>
