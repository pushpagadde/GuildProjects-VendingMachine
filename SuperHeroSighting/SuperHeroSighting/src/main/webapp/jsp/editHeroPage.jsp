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
                         
            #bottomPanel {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                font-size: 50px;
                border-collapse: collapse;
                width: 100%;
                padding: 8px;
                padding-top: 12px;
                padding-bottom: 12px;                               
                color: gray;  
                align: center;
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
        <h1 align="center">Edit Hero!</h1><hr>                        
        <sf:form class="form-horizontal" role="form" modelAttribute="hero" action="editHero" method="POST" >            
            <div class="row">                            
                <table id="tableHero"   > 
                <tr>
                    <th width="25%"></th>
                    <th width="25%"></th>
                </tr>                    
                <tr>
                    <td>
                        <label for="add-hero-name" class="col-md-4 control-label" align="right" >Hero Name:</label> 
                    </td>               
                    <td>
                        <sf:input type="text" class="form-control" id="add-hero-name" path="heroName" placeholder="Hero Name" align="left" style="width:100px;height:30px;font-size:20px"/>
                        <sf:errors path="heroName" cssclass="error"></sf:errors>
                    </td>
                </tr>            
                <tr>
                    <td>
                        <label for="add-hero-power" class="col-md-4 control-label" align="right">Hero Power:</label>        
                    </td>        
                    <td>
                        <sf:input type="text" class="form-control input-lg" id="add-hero-power" style="width:100px;height:30px;font-size:20px" path="heroPower" placeholder="Hero Power" align="left"/>
                        <sf:errors path="heroPower" cssclass="error"></sf:errors>
                        <sf:hidden path="heroID"/>           
                    </td> 
                </tr>    
                <tr>
                    <td>
                        <label for="add-hero-organization" class="col-md-4 control-label" align="right">Hero Organization:</label>  
                    </td>              
                    <td>
                        <select name="organization" id="organization" class="form-control input-lg" style="width:100px;height:30px;font-size:20px">
                        <c:forEach var="currentOrganization" items="${organizationNames}">
                            <option value="${currentOrganization.organizationID}" ${currentOrganization.organizationID == heroOrgId ? 'selected' : ''}>
                                ${currentOrganization.organizationName}
                            </option>
                        </c:forEach>                                
                        </select>   
                    </td> 
                </tr>                                    
            </table>
            </div>
            <div class="row" id="bottomPanel" > 
            <div class="col-md-offset-8 col-md-4">
                <input type="submit" class="btn btn-default" value="Cancel" name="cancel" style="width:100px;height:50px;font-size:25px"/>
                <input type="submit" class="btn btn-default" value="Update Hero" name="saveHero" style="width:100px;height:50px;font-size:25px"/>             
            </div></div>
        </sf:form>              

    </body>
</html>
