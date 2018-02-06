<%-- 
    Document   : memberDetailsPage
    Created on : Feb 3, 2018, 7:39:06 PM
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
        <title>Member details</title>
    </head>
    <body>
        <h1>Member Details!</h1>
        <p> Member Name:       <c:out value="${member.firstName}"/> <c:out value="${member.lastName}"/></p>
        <p> Address:           <c:out value="${member.address}"/></p>
        <p> City, State:       <c:out value="${zipCode.city}"/>, <c:out value="${zipCode.state}"/></p>                                                
        <p> Zip Code:          <c:out value="${member.zipCode}"/></p>
        <form class="form-horizontal" role="form" modelAttribute="member" action="member" method="GET">
            <input type="submit" class="btn btn-default" value="Back" name="back"/>
        </form>        
    </body>
</html>
