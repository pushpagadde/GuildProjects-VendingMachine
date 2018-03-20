<%-- 
    Document   : location
    Created on : Feb 1, 2018, 8:21:14 PM
    Author     : PG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Locations</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            #locations {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            #locations td, #locations th {
                border: 1px solid #ddd;
                padding: 8px;
            }
            #locations tr:nth-child(even){background-color: #f2f2f2;}
            #locations tr:hover {background-color: #ddd;}
            #locations th {
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
            <h1>Spring MVC Application from Archetype - Locations Page</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                   <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                   <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                   <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                   <li role="presentation"><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>
                   <li role="presentation"><a href="${pageContext.request.contextPath}/displayUserPage">Users</a></li>
                </sec:authorize>
                <li role="presentation"><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                </ul>    
            </div>
            <div class="row">                           
                <div class="col-md-7">
                    <h2>Locations List</h2> 
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h4>Hello : ${pageContext.request.userPrincipal.name}
                        </h4>
                    </c:if>
                    <table id="locations" border="1">
                        <tr>
                            <th width="5%" height="20">No.</th>
                            <th width="20%">Description</th>
                            <th width="25%">Address</th>
                            <th width="10%">Zip Code</th>
                            <th width="12%">Longitude</th>
                            <th width="12%">Latitude</th>                              
                        </tr>                                            
                        <c:forEach var="currentLocation" items="${locationsList}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td><a href="locationDetailsPage?locationID=${currentLocation.locationID}">
                                        ${currentLocation.description}</a>
                                </td> 
                                <td>
                                <c:forEach var="currentZipCode" items="${zipCodes}">
                                    <c:choose >
                                        <c:when test="${currentLocation.zipCode==currentZipCode.zipCode}">
                                            ${currentLocation.address}, ${currentZipCode.city}  ${currentZipCode.state}
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                </td>
                                <td>${currentLocation.zipCode}</td>   
                                <td>${currentLocation.longitude}</td>   
                                <td>${currentLocation.latitude}</td>   
                                <td> 
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                        <a href="locationEditPage?locationID=${currentLocation.locationID}" >Edit</a> 
                                            |<a href="deleteLocation?locationID=${currentLocation.locationID}"> Delete</a>                             
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ROLE_SIDEKICK')">
                                        <a href="locationEditPage?locationID=${currentLocation.locationID}" >Edit</a>                              
                                    </sec:authorize>
                                </td>
                            </tr>                    
                        </c:forEach>                                                    
                    </table>
                </div>       
                <div class="col-md-5">
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                    <h2>Add new Location</h2>
                    <form class="form-horzontal"  modelAttribute="location" action= "createLocation" role="form" method="POST">
                        <div class = "row">
                            <label for="add-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                              <input  class="form-control" type="text" name="description" placeholder="Description"/>                              
                            </div>
                        </div>
                        <div class = "row">
                            <label for="add-address" class="col-md-4 control-label">Address:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="address" placeholder="Location Address"/>                              
                            </div>
                        </div>                                                                        
                        <div class = "row">
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
                        <div class = "row">
                            <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="latitude" placeholder="Latitude"/>
                            </div>
                        </div>
                        <div class = "row">
                            <label for="add-Longitude" class="col-md-4 control-label">Longitude:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="longitude" placeholder="Longitude"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Location"/>
                            </div>
                        </div>
                    </form>
                    </sec:authorize>  
                </div>
            </div>
        </div>                
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
