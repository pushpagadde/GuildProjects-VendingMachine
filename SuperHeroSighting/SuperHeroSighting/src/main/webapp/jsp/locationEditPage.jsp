<%-- 
    Document   : locationEditPage
    Created on : Feb 4, 2018, 4:48:36 PM
    Author     : PG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Location Edit Page</title>
    </head>
    <body>
        <h1>Super Hero Sighting! - Location Edit Page</h1>
        <hr>
        <sf:form class="form-horizontal" role="form" modelAttribute="location" action="editLocation" method="POST">
            <div class="form-group">
                <label for="add-location-description" class="col-md-4 control-label">Location Description:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-location-description"
                              path="description" placeholder="Location Description"/>
                    <sf:errors path="description" cssclass="error"></sf:errors>
                </div>
            </div>
            <div class="form-group">
                <label for="add-location-address" class="col-md-4 control-label">Address:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-location-address"
                              path="address" placeholder="Location Address"/>
                    <sf:errors path="address" cssclass="error"></sf:errors>
                    <sf:hidden path="locationID"/>
                </div>
            </div>
            <div class="form-group">
                <label for="add-location-zipcode" class="col-md-4 control-label">Zip Code:</label>
                <div class="col-md-8">
                    <select name="zipCode" id="zipCode">
                        <c:forEach var="currentZipCode" items="${zipCodes}">
                            <option value="${currentZipCode.zipCode}"  ${currentZipCode.zipCode == zipCode ? 'selected' : ''}>
                                ${currentZipCode.zipCode}
                            </option>
                        </c:forEach>                                
                    </select>           
                    <sf:errors path="zipCode" cssclass="error"></sf:errors>                    
                </div>
            </div>
            <div class="form-group">
                <label for="add-location-latitude" class="col-md-4 control-label">Latitude:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-location-latitude"
                              path="latitude" placeholder="Location Latitude"/>
                    <sf:errors path="latitude" cssclass="error"></sf:errors>                    
                </div>
            </div>                                                                
            <div class="form-group">
                <label for="add-location-longitude" class="col-md-4 control-label">Longitude:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-location-longitude"
                              path="longitude" placeholder="Location Longitude"/>
                    <sf:errors path="longitude" cssclass="error"></sf:errors>                    
                </div>
            </div>                                                                            
            <div class="form-group">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Cancel" name="cancelLocationEdit"/>
                    <input type="submit" class="btn btn-default" name="saveLocation" value="Update Location"/>                    
                </div>
            </div>
        </sf:form>
    </body>
</html>