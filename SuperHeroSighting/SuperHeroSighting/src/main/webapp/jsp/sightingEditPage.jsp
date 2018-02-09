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
        <form class="form-horizontal" action="${pageContext.request.contextPath}/saveSighting" role="form" method="POST">               
            <div class="row">
                <div class="col-md-offset-4 col-md-8">
                    <label for="add-hero-name" class="col-md-offset-4 col-md-8">Hero Name:</label>   
                    <input type="text" name="heroName" disabled value="${hero.heroName}">         
                </div>
                <div class="row">
                    <label for="add-description" class="col-md-4 control-label">Location Description:</label>
                    <input type="text" name="locationDescription" disabled value="${location.description}">                                      
                </div>
                <div class="row">
                    <label for="add-address" class="col-md-4 control-label">Location Address:</label>
                    <input type="text" name="locationAddress" disabled value="${location.address}">                                                       
                </div>
                <div class="row">
                    <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>                                      
                    <input type="text" name="latitude" disabled value="${location.latitude}">
                </div>    
                <div class="row">
                    <label for="add-longitude" class="col-md-4 control-label">Longitude:</label>
                    <input type="text" name="longitude" disabled value="${location.longitude}">
                </div>   
                <div class="row">
                    <label for="add-city" class="col-md-4 control-label">City:</label>                
                    <input type="text" name="city" disabled value="${zipCode.city}">
                </div> 
                <div class="row">
                    <label for="add-state" class="col-md-4 control-label">State:</label>                
                    <input type="text" name="state" disabled value="${zipCode.state}">
                </div>                                    
                <div class="row">
                    <label for="add-location-zipcode" class="col-md-4 control-label">Zip Code:</label>
                    <input type="text" name="zipCode" disabled value="${zipCode.zipCode}">
                </div>
                    <input type="hidden" name="sightingID"  value="${sighting.sightingID}" id="sightingID"/>
                <div class = "row">
                    <label for="add-DateOfSighting" class="col-md-4 control-label">Date of Sighting:</label>                
                    <input type="date" class="form-control" name="dateOfSighting" placeholder="DateOfSighting" value="${sighting.dateOfSighting}" id="dateOfSighting"/>                
                </div>             
            </div>
            <div class="col-md-offset-4 col-md-8" id="bottomPanel">
                <div class="row">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Cancel" name="cancelSightingsEdit"/>
                        <input type="submit" class="btn btn-default" value="Update Sightings" name="saveSighting"/>                    
                    </div>
                </div>
            </div>
        </form>
        </div>
    </body>
</html>
