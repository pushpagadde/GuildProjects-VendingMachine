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
    </head>
    <body>
        <h1>Edit Hero!</h1>
        <hr>
        <sf:form class="form-horizontal" role="form" modelAttribute="hero" action="editHero" method="POST">
            <div class="form-group">
                <label for="add-hero-name" class="col-md-4 control-label">Hero Name:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-hero-name"
                              path="heroName" placeholder="Hero Name"/>
                    <sf:errors path="heroName" cssclass="error"></sf:errors>
                </div>
            </div>
            <div class="form-group">
                <label for="add-hero-power" class="col-md-4 control-label">Hero Power:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-hero-power"
                              path="heroPower" placeholder="Hero Power"/>
                    <sf:errors path="heroPower" cssclass="error"></sf:errors>
                    <sf:hidden path="heroID"/>
                </div>
            </div>
            <div class="form-group">
                <label for="add-hero-organization" class="col-md-4 control-label">Hero Organization:</label>
                <div class="col-md-8">
                    <select name="organization" id="organization">
                        <c:forEach var="currentOrganization" items="${organizationNames}">
                            <option value="${currentOrganization.organizationID}" ${currentOrganization.organizationID == heroOrgId ? 'selected' : ''}>
                                ${currentOrganization.organizationName}
                            </option>
                        </c:forEach>                                
                    </select>                    
                </div>
            </div>                    
            <div class="form-group">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Cancel" name="cancel"/>
                    <input type="submit" class="btn btn-default" name="saveHero" value="Update Hero"/>
                    
                </div>
            </div>
        </sf:form>
    </body>
</html>
