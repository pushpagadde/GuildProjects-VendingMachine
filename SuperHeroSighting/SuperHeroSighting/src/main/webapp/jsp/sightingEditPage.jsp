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
    </head>
    <body>
        <h1>Super Hero Sighting - Sighting Edit Page!</h1>
        <hr>
        <sf:form class="form-horizontal" role="form" modelAttribute="location" action="editSighting" method="POST">
            <div class="form-group">
                <label for="add-hero-name" class="col-md-4 control-label">Hero Name:</label>
                <div class="col-md-8">
                    <select name="superHero" id="superHero">
                        <c:forEach var="currentHero" items="${allheros}">
                            <option value="${currentHero.heroID}" ${currentHero.heroID == heroid ? 'selected' : ''}>
                                ${currentHero.heroName}
                            </option>
                        </c:forEach>                                
                    </select>                               
                </div>
            </div>
            <div class="form-group">
                <label for="add-description" class="col-md-4 control-label">Location Description:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-description"
                              path="description" placeholder="Description"/>
                    <sf:errors path="description" cssclass="error"></sf:errors>                    
                </div>
            </div>
            <div class="form-group">
                <label for="add-address" class="col-md-4 control-label">Location Address:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-address"
                              path="address" placeholder="Address"/>
                    <sf:errors path="address" cssclass="error"></sf:errors>                    
                </div>
            </div>
            <div class="form-group">
                <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-latitude"
                              path="latitude" placeholder="Latitude"/>
                    <sf:errors path="latitude" cssclass="error"></sf:errors>                    
                </div>
            </div>    
            <div class="form-group">
                <label for="add-longitude" class="col-md-4 control-label">Longitude:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-longitude"
                              path="longitude" placeholder="Longitude"/>
                    <sf:errors path="longitude" cssclass="error"></sf:errors>                    
                </div>
            </div>                                    
            <div class="form-group">
                <label for="add-location-zipcode" class="col-md-4 control-label">Zip Code:</label>
                <div class="col-md-8">
                    <select name="zipCode" id="zipCode">
                        <c:forEach var="currentZipCode" items="${zipCodes}">
                            <option value="${currentZipCode.zipCode}">
                                ${currentZipCode.zipCode}
                            </option>
                        </c:forEach>                                
                    </select>                               
                </div>
            </div>
                                                             
            <div class="form-group">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Cancel" name="cancelSightingsEdit"/>
                    <input type="submit" class="btn btn-default" value="Update Sightings" name="saveSighting"/>                    
                </div>
            </div>
        </sf:form>
    </body>
</html>
