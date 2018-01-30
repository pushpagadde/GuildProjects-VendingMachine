<%-- 
    Document   : createDVDPage
    Created on : Jan 5, 2018, 9:43:13 AM
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
        <title>Add a new DVD</title>
    </head>
    <body>
        <h1>Add a new DVD !(NEW)----</h1>        
        <hr>
        <sf:form class="form-horizontal" role="form" method="POST" action="createDVD" modelAttribute="dvd">
            <div class="row">
                <div class="col-md-6"><label for="add-dvd-title" class="col-md-4 control-label">DVD Title:</label></div>                
                <div class="col-md-6">
                <sf:input type="text" class="form-control" id = "title" name="title" path="title" placeholder="DVD Title"/></div>                 
                <sf:errors path="title" cssclass="error"></sf:errors>
            </div>              
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-year" class="col-md-4 control-label">Release Year:</label></div>   
                <div class="col-md-6">
                <sf:input type="number" class="form-control" id="releaseYear" path="releaseYear" name="releaseYear" placeholder="Year"/></div>
                <sf:errors path="releaseYear" cssclass="error"></sf:errors>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-director" class="col-md-4 control-label">Director:</label></div>
                <div class="col-md-6">
                <sf:input type="text" class="form-control" name="director" id="director" path="director" placeholder="Director"/></div>
                <sf:errors path="director" cssclass="error"></sf:errors>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-rating" class="col-md-4 control-label">Rating:</label></div>
                <div class="col-md-6">
                <sf:input type="rating" class="form-control" name="rating" id="rating" path="rating" placeholder="Rating"/></div>                
                <sf:errors path="rating" cssclass="error"></sf:errors>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-notes" class="col-md-4 control-label">Notes:</label></div>
                <div class="col-md-6">
                <input type="textarea" class="form-control" name="notes" id="notes" title="notes" placeholder="Notes"/></div>
                
            </div>
            <br> 
            <div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="cancel" value="Cancel" formnovalidate >Cancel</button>                    
                    <button type="submit" class="btn btn-primary" name="save" value="Create DVD"/>Create DVD </button>
                </div>
            </div>
            <br>     
            
        </sf:form>                
    </body>
</html>
