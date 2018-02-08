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
        <style>
            #displayDetails{
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                font-size: 25px;
                border-collapse: collapse;
                width: 100%;
                border: 1px solid #ddd;
                padding: 8px;
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;                
            }             
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
        </style>
    </head>
    <body>
        <h1 align="center">Super Hero Sighting - Sighting Edit Page!</h1>
        <hr>
        <div class = "row"  id="displayDetails">
            <sf:form class="form-horizontal" role="form" modelAttribute="sighting" action="saveSighting" method="POST">
            <div class="row">
                <div class="col-md-offset-4 col-md-8">
                <label for="add-hero-name" class="col-md-offset-4 col-md-8">Hero Name:</label>                
                <select name="superHero" id="superHero">
                    <c:forEach var="currentHero" items="${allheros}">
                        <option value="${currentHero.heroID}" ${currentHero.heroID == heroid ? 'selected' : ''}>
                            ${currentHero.heroName}
                        </option>
                    </c:forEach>                                
                </select>     </div>                                          
            </div>
            <div class = "row">
                <label for="add-DateOfSighting" class="col-md-4 control-label">Date of Sighting:</label>                
                <input type="date" class="form-control" name="dateOfSighting" placeholder="DateOfSighting" value = "02/06/2018"/>                
            </div> 
            </sf:form>
            <sf:form class="form-horizontal" role="form" modelAttribute="location" action="saveSighting" method="POST">

            <div class="row">
                <label for="add-description" class="col-md-4 control-label">Location Description:</label>
                    <sf:input type="text" class="form-control" id="add-description"
                              path="description" placeholder="Description"/>
                    <sf:errors path="description" cssclass="error"></sf:errors>                    
                
            </div>
            <div class="row">
                <label for="add-address" class="col-md-4 control-label">Location Address:</label>
                    <sf:input type="text" class="form-control" id="add-address"
                              path="address" placeholder="Address"/>
                    <sf:errors path="address" cssclass="error"></sf:errors>                    
                
            </div>
            <div class="row">
                <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>
                    <sf:input type="text" class="form-control" id="add-latitude"
                              path="latitude" placeholder="Latitude"/>
                    <sf:errors path="latitude" cssclass="error"></sf:errors>                    
                
            </div>    
            <div class="row">
                <label for="add-longitude" class="col-md-4 control-label">Longitude:</label>
                    <sf:input type="text" class="form-control" id="add-longitude"
                              path="longitude" placeholder="Longitude"/>
                    <sf:errors path="longitude" cssclass="error"></sf:errors>                    
                
            </div>                                    
            <div class="row">
                <label for="add-location-zipcode" class="col-md-4 control-label">Zip Code:</label>
                    <select name="zipCode" id="zipCode">
                        <c:forEach var="currentZipCode" items="${zipCodes}">
                            <option value="${currentZipCode.zipCode}">
                                ${currentZipCode.zipCode}
                            </option>
                        </c:forEach>                                
                    </select>                               
                
            </div>
                                            
            
            
        </div>
            <div class="col-md-offset-4 col-md-8" id="bottomPanel">
            <div class="row">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Cancel" name="cancelSightingsEdit"/>
                    <input type="submit" class="btn btn-default" value="Update Sightings" name="saveSighting"/>                    
                </div>
            </div></div>
        </sf:form>
    </body>
</html>
