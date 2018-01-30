<%-- 
    Document   : displayDVDDetails
    Created on : Jan 28, 2018, 8:21:06 PM
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
        <title>DVD details Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <h1>DVD details!</h1>
        <div class="container">
            <h1>Title : <c:out value="${dvd.title}"/></h1>
            <hr/>
            <p>Release Year : <c:out value="${dvd.releaseYear}"/></p>
            <p>Director : <c:out value="${dvd.director}"/></p>
            <p>Rating : <c:out value="${dvd.rating}"/></p>
            <p>Notes : <c:out value="${dvd.notes}"/></p>
        </div>
        <form name="back" action="displayDVDPage" method="GET">
                    <button type="submit">Back</button>
        </form>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
