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
    </head>
    <body>
        <h1>Organization Details!</h1>
        <p> Organization Name: <c:out value="${organization.organizationName}"/></p>
        <p> Address:           <c:out value="${organization.address}"/></p>
        <p> Zip Code:          <c:out value="${organization.zipCode}"/></p>
        <p> City, State:                                               </p>
        <p> Phone:             <c:out value="${organization.phone}"/></p>
        <form class="form-horizontal" role="form" modelAttribute="organization" action="organization" method="GET">
            <input type="submit" class="btn btn-default" value="Back" name="back"/>
        </form>        
    </body>
</html>
