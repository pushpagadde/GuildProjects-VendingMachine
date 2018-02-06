<%-- 
    Document   : mainPage
    Created on : Feb 5, 2018, 3:22:57 PM
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
        <title>Top 10 Super Hero listings</title>
        <style>
            #newsFeed {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #newsFeed td, #newsFeed th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #newsFeed tr:nth-child(even){background-color: #f2f2f2;}

            #newsFeed tr:hover {background-color: #ddd;}

            #newsFeed th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            }
        </style>
    </head>
    <body>
        <h1>Top 10 Super Hero Listings!</h1>
        <hr/>
        <div class="navbar">
             <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/mainPage.jsp">Home</a></li>
                <li role="presentation" ><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayAboutPage">About</a></li>
            </ul>    
        </div>
        <table id="newsFeed" border="1">
            <tr>
                <th width="10%" height="20">No.</th>
                <th width="30%">Hero Sighted</th>
                <th width="30%">Location</th>
                <th width="30%">Date of Sighting</th>                    
            </tr>
            <c:forEach var="currentSighting" items="${sightings}">
                <tr>
                    <td>${currentSighting.sightingID}</td>
                    <td><a href="sightingDetailsPage?sightingID=${currentSighting.sightingID}">
                        <c:forEach var="currentHero" items="${heros}">
                            <c:choose >
                                <c:when test="${currentHero.heroID==currentSighting.heroID}">
                                    ${currentHero.heroName}
                                </c:when>
                            </c:choose>
                        </c:forEach>    
                    </td>     
                    <td>
                        <c:forEach var="currentLocation" items="${locations}">
                            <c:choose >
                                <c:when test="${currentLocation.locationID==currentSighting.locationID}">
                                    ${currentLocation.description}
                                </c:when>
                            </c:choose>
                        </c:forEach>    
                    </td>                                 
                    <td>${currentSighting.dateOfSighting}</td>            
                </tr>                    
            </c:forEach>
        </table>                    
    </body>
</html>
