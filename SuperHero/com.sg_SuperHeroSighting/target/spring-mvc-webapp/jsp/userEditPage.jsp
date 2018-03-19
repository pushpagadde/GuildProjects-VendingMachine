<%-- 
    Document   : userEditPage
    Created on : Mar 18, 2018, 5:29:57 PM
    Author     : PG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <h1 align="center">Edit User!</h1><hr>                        
        <sf:form class="form-horizontal" role="form" modelAttribute="user" action="editUser" method="POST" >            
            <div class="row">                            
                <table id="tableUser"   > 
                <tr>
                    <th width="25%"></th>
                    <th width="25%"></th>
                </tr>                    
                <tr>
                    <td>
                        <label for="add-user-name" class="col-md-4 control-label" align="right" >User Name:</label> 
                    </td>               
                    <td>
                        <sf:input type="text" class="form-control" id="add-username" path="username" placeholder="username" align="left" style="width:100px;height:30px;font-size:20px"/>                        
                    </td>
                </tr>       
                <tr>
                    <td>
                        <label for="add-user-enabled" class="col-md-4 control-label" align="right">User Enabled:</label>  
                    </td>              
                    <td>                        
                        <div class="col-md-8" id="active">
                            <input type="radio" id="yes" name="active" value="Yes"> Yes
                            <input type="radio" id="no" name="active" value="No"> No                                
                        </div>
                    </td> 
                </tr>
                <tr>
                    <td><label for="add-user-authority" class="col-md-4 control-label" align="right">User Authority:</label></td>              
                    <td>                        
                        <div class="col-md-8" id="authority">
                            <input type="radio" id="admin" name="authority" value="Admin"> Admin
                            <input type="radio" id="sidekick" name="authority" value="SideKick"> Side Kick                                
                            <input type="radio" id="anon" name="authority" value="Anon" checked="checked"> Anon                                
                        </div>
                    </td> 
                </tr>
            </table>
            </div>
            <div class="row" id="bottomPanel" > 
            <div class="col-md-offset-8 col-md-4">
                <input type="submit" class="btn btn-default" value="Cancel" name="userCancel" style="width:100px;height:50px;font-size:25px"/>
                <input type="submit" class="btn btn-default" value="Update User" name="saveUser" style="width:100px;height:50px;font-size:25px"/>             
            </div></div>
        </sf:form>              

    </body>
</html>
