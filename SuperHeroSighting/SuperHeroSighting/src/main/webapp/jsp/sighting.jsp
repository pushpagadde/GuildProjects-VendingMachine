<%-- 
    Document   : sighting
    Created on : Feb 1, 2018, 8:21:47 PM
    Author     : PG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            #sightings {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            #sightings td, #sightings th {
                border: 1px solid #ddd;
                padding: 8px;
            }
            #sightings tr:nth-child(even){background-color: #f2f2f2;}
            #sightings tr:hover {background-color: #ddd;}
            #sightings th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Spring MVC Application from Archetype - Sightings Page</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayAboutPage">About</a></li>
                </ul>    
            </div>
            <div class="row">                           
                <div class="col-md-8">
                    <h2>Sightings page</h2>            
                        <table id="sightings" border="1">
                            <tr>         
                                <th width="5%">No.</th>
                                <th width="30%">Hero Name</th>
                                <th width="30%">Sight Location</th>
                                <th width="25%">Date/Time of Sighting</th>                    
                            </tr>
                            <c:forEach var="currentSighting" items="${sightingsList}">
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
                                <td> 
                                    <a href="sightingEditPage?sightingID=${currentSighting.sightingID}" >Edit</a>| 
                                    <a href="deleteSighting?sightingID=${currentSighting.sightingID}">Delete</a>                             
                                </td>
                            </tr>                    
                            </c:forEach>                                                                    
                        </table>
                </div>       
                <div class="col-md-4">
                    <h2>Add new Sighting</h2>
                    <form class="form-horzontal" action= "createSighting" role="form" method="POST">
                        <div class = "form-group">
                            <label for="add-hero" class="col-md-4 control-label">Hero Sighted:</label>
                            <div class="col-md-8">
                                <select name="heroID" id="heroID">
                                    <c:forEach var="currentHero" items="${heros}">
                                        <option value="${currentHero.heroID}"/>
                                            ${currentHero.heroName}
                                        </option>
                                    </c:forEach>                                
                                </select>
                            </div>
                        </div>
                        <div class = "form-group">                            
                            <label for="add-description" class="col-md-4 control-label">Location Description:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="description" placeholder="Description"/>
                            </div>
                        </div>
                        <div class = "form-group">
                            <label for="add-address" class="col-md-4 control-label">Address:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="address" placeholder="Location Address"/>
                            </div>
                        </div>                                                                        
                        <div class = "form-group">
                            <label for="add-zipCode" class="col-md-4 control-label">Zip Code:</label>
                            <div class="col-md-8">
                                <select name="zipCode" id="zipCode">
                                    <c:forEach var="currentZipCode" items="${zipCodes}">
                                        <option value="${currentZipCode.zipCode}"/>
                                            ${currentZipCode.zipCode}
                                        </option>
                                    </c:forEach>                                
                                </select>                          
                            </div>
                        </div>
                        <div class = "form-group">
                            <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="latitude" placeholder="Latitude"/>
                            </div>
                        </div>
                        <div class = "form-group">
                            <label for="add-Longitude" class="col-md-4 control-label">Longitude:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="longitude" placeholder="Longitude"/>
                            </div>
                        </div>
                        <div class = "form-group">
                            <label for="add-DateOfSighting" class="col-md-4 control-label">Date of Sighting:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="dateOfSighting" placeholder="DateOfSighting"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Sighting"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
