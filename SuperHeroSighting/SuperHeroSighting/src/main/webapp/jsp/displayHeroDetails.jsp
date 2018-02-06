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
    </head>
    <body>
        <h1>Hero details</h1>
        <hr>
        <p> Hero Name: <c:out value="${hero.heroName}"/> </p>
        <p> Hero Power: <c:out value="${hero.heroPower}"/> </p>
        <form class="form-horizontal" role="form" modelAttribute="hero" action="superHero" method="GET">
              <input type="submit" class="btn btn-default" value="Back" name="Back"/>
        </form>    
    </body>
</html>
