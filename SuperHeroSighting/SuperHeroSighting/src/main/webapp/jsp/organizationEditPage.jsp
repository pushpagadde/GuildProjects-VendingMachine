<%-- 
    Document   : organizationEditPage
    Created on : Feb 3, 2018, 5:16:32 PM
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
        <title>Edit Organization Page</title>
    </head>
    <body>
        <h1>Edit Organization!</h1>
        <hr>
        <sf:form class="form-horizontal" role="form" modelAttribute="organization" action="editOrganization" method="POST">
            <div class="form-group">
                <label for="add-organization-name" class="col-md-4 control-label">Organization Name:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-organization-name"
                              path="organizationName" placeholder="Organization Name"/>
                    <sf:errors path="organizationName" cssclass="error"></sf:errors>
                </div>
            </div>
            <div class="form-group">
                <label for="add-organization-address" class="col-md-4 control-label">Organization Address:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-organization-address"
                              path="address" placeholder="Organization Address"/>
                    <sf:errors path="address" cssclass="error"></sf:errors>
                    <sf:hidden path="organizationID"/>
                </div>
            </div>
            <div class="form-group">
                <label for="add-organization-zipcode" class="col-md-4 control-label">Zip Code:</label>
                <div class="col-md-8">
                    <select name="zipCode" id="zipCode">
                        <c:forEach var="currentZipCode" items="${zipCodes}">
                            <option value="${currentZipCode.zipCode}">
                                ${currentZipCode.zipCode}
                            </option>
                        </c:forEach>                                
                    </select>           
                    <sf:errors path="zipCode" cssclass="error"></sf:errors>                    
                </div>
            </div>
            <div class="form-group">
                <label for="add-organization-phone" class="col-md-4 control-label">Phone:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control" id="add-organization-phone"
                              path="phone" placeholder="Organization Phone"/>
                    <sf:errors path="phone" cssclass="error"></sf:errors>                    
                </div>
            </div>                                                                
            <div class="form-group">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Cancel" name="cancelOrgEdit"/>
                    <input type="submit" class="btn btn-default" name="saveOrganization" value="Update Organization"/>                    
                </div>
            </div>
        </sf:form>
    </body>
</html>
