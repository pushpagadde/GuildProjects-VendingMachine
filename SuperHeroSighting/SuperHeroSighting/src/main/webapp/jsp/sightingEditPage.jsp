<%-- 
    Document   : sightingEditPage
    Created on : Feb 4, 2018, 11:14:10 PM
    Author     : PG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Sighting Edit Page</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/superherosighting.js"></script>        
        <style>
                
            #bottomPanel {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                font-size: 50px;
                border-collapse: collapse;
                width: 100%;
                padding: 8px;
                padding-top: 12px;
                padding-bottom: 12px;                               
                color: gray;    
            }
            #tableHero{
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                font-size: 35px;
                border-collapse: collapse;
                width: 50%;
                border: 1px solid #ddd;
                padding: 8px;
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;                
            }
        </style>
    </head>
    <body>
        <h1 align="center">Super Hero Sighting - Sighting Edit Page!</h1><hr>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/saveSighting" role="form" method="POST">                       
        <div class="row">                            
            <table id="tableHero" > 
            <tr>
                <th width="25%"></th>
                <th width="25%"></th>
            </tr> 
            <tr><td><label for="add-hero-name" class="col-md-offset-4 col-md-8">Hero Name:</label></td>
                <td>
                    <select name="heroN" id="heroN" class="form-control input-lg" style="width:100px;height:30px;font-size:20px">
                        <c:forEach var="currentHero" items="${heros}">
                            <option value="${currentHero.heroID}" ${currentHero.heroID == sighting.heroID ? 'selected' : ''}>
                                ${currentHero.heroName}
                            </option>
                        </c:forEach>                                
                    </select>
                </td>
            </tr>
            <tr><td><label for="add-description" class="col-md-4 control-label">Location Description:</label></td>
                <td>
                <select name="locationN" id="locationN" select="loadLocation()"  class="form-control input-lg" style="width:100px;height:30px;font-size:20px">
                        <c:forEach var="currentLocation" items="${locations}">
                            <option value="${currentLocation.locationID}" ${currentLocation.locationID == sighting.locationID ? 'selected' : ''}>
                                ${currentLocation.description}
                            </option>
                        </c:forEach>                                
                </select></td>
            </tr>
            <tr><td><label for="add-address" class="col-md-4 control-label">Location Address:</label></td>
                <td><input type="text" name="locationAddress" id="locationAddress" disabled value="${location.address}"></td>
            </tr>
            <tr><td><label for="add-latitude" class="col-md-4 control-label">Latitude:</label></label></td>
                <td><input type="text" name="latitude" id="latitude" disabled value="${location.latitude}"></td>
            </tr>
            <tr><td><label for="add-longitude" class="col-md-4 control-label">Longitude:</label></td>
                <td><input type="text" name="longitude" id="longitude" disabled value="${location.longitude}"></td>
            </tr>
            <tr><td><label for="add-city" class="col-md-4 control-label">City:</label></td>
                <td><input type="text" name="city" id="city" disabled value="${zipCode.city}"></td>
            </tr>
            <tr><td><label for="add-city" class="col-md-4 control-label">City:</label></td>
                <td><input type="text" name="city" disabled value="${zipCode.city}"></td>
            </tr>
            <tr><td><label for="add-state" class="col-md-4 control-label">State:</label></td>
                <td><input type="text" name="state" disabled value="${zipCode.state}"></td>
            </tr>
            <tr><td><label for="add-location-zipcode" class="col-md-4 control-label">Zip Code:</label></td>
                <td><input type="text" name="zipCode" id="zipCode" disabled value="${zipCode.zipCode}"></td>
            </tr>
            <tr><td><label for="add-DateOfSighting" class="col-md-4 control-label">Date of Sighting:</label></td>
                <td><input type="date" class="form-control" name="dateOfSighting" placeholder="DateOfSighting" value="${sighting.dateOfSighting}" id="dateOfSighting"/></td>
                <input type="hidden" path="sightingID" id="sightingID" name="sightingID" value="${sighting.sightingID}"/>
            </tr>
            </table>
        </div>
        <div class="col-md-offset-4 col-md-8" id="bottomPanel">
            <input type="submit" class="btn btn-default" value="Cancel" name="cancelSightingsEdit" style="width:100px;height:50px;font-size:25px"/>
            <input type="submit" class="btn btn-default" value="Update" name="saveSighting" style="width:100px;height:50px;font-size:25px"/>                    
        </div>
        </form>
    </body>
</html>
