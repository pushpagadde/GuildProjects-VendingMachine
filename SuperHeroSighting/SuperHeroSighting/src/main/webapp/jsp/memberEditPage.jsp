<%-- 
    Document   : memberEditPage
    Created on : Feb 3, 2018, 7:39:25 PM
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
        <title>Edit Member</title>
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
        <h1>Super Hero Sighting - Edit Member Page</h1>
        <hr>
        <div class = "row"  id="displayDetails">
            <sf:form class="form-horizontal" role="form" modelAttribute="member" action="editMember" method="POST">
            <div class="row">
                <label for="add-first-name" class="col-md-4 control-label">First Name:</label>                
                <sf:input type="text" class="form-control" id="add-first-name" path="firstName" placeholder="First Name" value="${member.firstName}"/>
                <sf:errors path="firstName" cssclass="error"></sf:errors>                
            </div>
            <div class="row">
                <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>                
                <sf:input type="text" class="form-control" id="add-last-name" path="lastName" placeholder="Last Name" value="${member.lastName}"/>
                <sf:errors path="lastName" cssclass="error"></sf:errors>                
            </div>
            <div class="row">
                <label for="add-member-address" class="col-md-4 control-label">Address:</label>                
                <sf:input type="text" class="form-control" id="add-member-address" path="address" placeholder="Address"/>
                <sf:errors path="address" cssclass="error"></sf:errors>
                <sf:hidden path="memberID"/>                
            </div>
            <div class="row">
                <label for="add-member-zipcode" class="col-md-4 control-label">Zip Code:</label>                
                <select name="zipCode" id="zipCode">
                    <c:forEach var="currentZipCode" items="${zipCodes}">
                        <option value="${currentZipCode.zipCode}">
                            ${currentZipCode.zipCode}
                        </option>
                    </c:forEach>                                
                </select>                                               
            </div>                                                                            
            <div class="row">
                <label for="add-member-organization" class="col-md-4 control-label">Organization:</label>                
                <select name="organization" id="organization">
                    <c:forEach var="currentOrganization" items="${organizations}">
                        <option value="${currentOrganization.organizationID}">
                            ${currentOrganization.organizationName}
                        </option>
                    </c:forEach>                                
                </select>                                               
            </div>                                                                            
            <div class="row" id="bottomPanel">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Cancel" name="cancelMemberEdit"/>
                    <input type="submit" class="btn btn-default" name="saveMember" value="Update Member"/>                    
                </div>
            </div>
        </sf:form>
            
        </div>    
            
    </body>
</html>
