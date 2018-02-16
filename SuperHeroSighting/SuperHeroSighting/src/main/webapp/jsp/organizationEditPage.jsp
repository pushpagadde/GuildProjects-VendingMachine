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
        <h1 align="center">Edit Organization!</h1>
        <hr>
        <sf:form class="form-horizontal" role="form" modelAttribute="organization" action="editOrganization" method="POST">
        <div class = "row" >
            <table id="tableHero"   > 
                <tr>
                    <th width="25%"></th>
                    <th width="25%"></th>
                </tr>
                <tr><td>
                        <label for="add-organization-name" class="col-md-4 control-label">Organization Name:</label>
                    </td>
                    <td>
                        <sf:input type="text" class="form-control" id="add-organization-name" path="organizationName" placeholder="Organization Name"/>
                        <sf:errors path="organizationName" cssclass="error"></sf:errors>     
                    </td>
                </tr>                
                <tr><td><label for="add-organization-address" class="col-md-4 control-label">Organization Address:</label></td>
                    <td><sf:input type="text" class="form-control" id="add-organization-address" path="address" placeholder="Organization Address"/>
                        <sf:errors path="address" cssclass="error"></sf:errors>
                        <sf:hidden path="organizationID"/>
                    </td>
                </tr>
                <tr><td><label for="add-organization-zipcode" class="col-md-4 control-label">Zip Code:</label></td>
                    <td>
                        <select name="zipCode" id="zipCode">
                            <c:forEach var="currentZipCode" items="${zipCodes}">
                                <option value="${currentZipCode.zipCode}">
                                    ${currentZipCode.zipCode}
                                </option>
                            </c:forEach>                                
                        </select>           
                        <sf:errors path="zipCode" cssclass="error"></sf:errors>
                    </td>
                </tr>
                <tr><td><label for="add-organization-phone" class="col-md-4 control-label">Phone:</label>                </td>
                    <td><sf:input type="text" class="form-control" id="add-organization-phone" path="phone" placeholder="Organization Phone"/>
                        <sf:errors path="phone" cssclass="error"></sf:errors> </td>
                </tr>
            </table>
            <div class="row" id="bottomPanel">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Cancel" name="cancelOrgEdit" style="width:100px;height:30px;font-size:20px"/>
                    <input type="submit" class="btn btn-default" name="saveOrganization" value="Update" style="width:100px;height:30px;font-size:20px"/>                    
                </div>
            </div>
        </sf:form>
    </body>
</html>
