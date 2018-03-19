

<%-- 
    Document   : about
    Created on : Feb 1, 2018, 8:21:59 PM
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
        <title>About Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>        
        <div class="container">
            <h1>Spring MVC Application from Archetype - About Page</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage">Home</a></li>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayAboutPage">About</a></li>                        
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayUserPage">Users</a></li>
                    </sec:authorize>
                </ul>    
            </div>
            <h2>About page</h2>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h4>Hello : ${pageContext.request.userPrincipal.name}
                    | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
                </h4>
            </c:if>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
