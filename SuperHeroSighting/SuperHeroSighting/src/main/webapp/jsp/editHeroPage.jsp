<%-- 
    Document   : displayEditHeroPage
    Created on : Feb 3, 2018, 10:20:44 AM
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
        <title>Edit Hero Details Page</title>
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
        <h1 align="center">Edit Hero!</h1>
        <hr>
        <div class = "row"  id="displayDetails">
            <div class="row">
                <sf:form class="form-horizontal" role="form" modelAttribute="hero" action="editHero" method="POST">            
                <label for="add-hero-name" class="col-md-4 control-label">Hero Name:</label>                
                <sf:input type="text" class="form-control" id="add-hero-name" path="heroName" placeholder="Hero Name"/>
                <sf:errors path="heroName" cssclass="error"></sf:errors>
            </div>            
            <div class="row">
                <label for="add-hero-power" class="col-md-4 control-label">Hero Power:</label>                
                <sf:input type="text" class="form-control" id="add-hero-power" path="heroPower" placeholder="Hero Power"/>
                <sf:errors path="heroPower" cssclass="error"></sf:errors>
                <sf:hidden path="heroID"/>                
            </div>
            <div class="row">
                <label for="add-hero-organization" class="col-md-4 control-label">Hero Organization:</label>                
                <select name="organization" id="organization">
                    <c:forEach var="currentOrganization" items="${organizationNames}">
                        <option value="${currentOrganization.organizationID}" ${currentOrganization.organizationID == heroOrgId ? 'selected' : ''}>
                            ${currentOrganization.organizationName}
                        </option>
                    </c:forEach>                                
                </select>                                    
            </div>                    
            <div class="row">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Cancel" name="cancel" />
                    <input type="submit" class="btn btn-default" value="Update Hero" name="saveHero" />                    
                </div>
            </div>
        </sf:form>                        
        </div>
        
    </body>
</html>
