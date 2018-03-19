<%-- 
    Document   : member
    Created on : Feb 3, 2018, 7:30:15 PM
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
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>SuperHero Sighting - Member's Page</title>
        <style>
            #members {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            #members td, #members th {
                border: 1px solid #ddd;
                padding: 8px;
            }
            #members tr:nth-child(even){background-color: #f2f2f2;}
            #members tr:hover {background-color: #ddd;}
            #members th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            }
        </style>
    </head>
    <body>
        <h1>SuperHero Sighting - Member's Page!</h1>
        <hr/>
        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage">Home</a></li>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                            <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                            <li role="presentation" ><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>                                                                
                            <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li> 
                        </sec:authorize>                    
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>                    
                            <li role="presentation"><a href="${pageContext.request.contextPath}/displayUserPage">Users</a></li>
                        </sec:authorize>
                            <li role="presentation"><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                </ul>    
            </div>   
         
            <div class="row">                           
                <div class="col-md-6">
                    <h2>Members List</h2> 
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h4>Hello : ${pageContext.request.userPrincipal.name}</h4>
                    </c:if>
                    <table id="members" border="1">
                        <tr>
                            <th width="10%" height="20">No</th>
                            <th width="20%">Member Name</th>                            
                            <th width="40%">Address, City, State</th>
                            <th width="10%">Zip Code</th>
                            <th width="20%"></th>                    
                        </tr>                        
                        <c:forEach var="currentMember" items="${membersList}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td><a href="memberDetailsPage?memberID=${currentMember.memberID}">
                                        ${currentMember.firstName} ${currentMember.lastName} </a>
                                </td> 
                                <td>
                                <c:forEach var="currentZipCode" items="${zipCodes}">
                                    <c:choose >
                                        <c:when test="${currentMember.zipCode==currentZipCode.zipCode}">
                                            ${currentMember.address}, ${currentZipCode.city}  ${currentZipCode.state}
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                </td>
                                <td>${currentMember.zipCode}</td>   
                                <td> 
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">                                     
                                        <a href="memberEditPage?memberID=${currentMember.memberID}" >Edit</a>
                                        |<a href="deleteMember?memberID=${currentMember.memberID}">Delete</a>                             
                                    </sec:authorize>                                                                        
                                </td>
                            </tr>                    
                        </c:forEach>                                                    
                    </table>
                </div>       
                <div class="col-md-6">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <h2>Add new Member</h2>
                    <form class="form-horzontal" action= "createMember" role="form" method="POST">
                        <div class = "row">
                            <label for="add-firstName" class="col-md-4 control-label">First Name:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="firstName" placeholder="First Name"/>
                            </div>
                        </div>
                        <div class = "row">
                            <label for="add-lastName" class="col-md-4 control-label">Last Name:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="lastName" placeholder="Last Name"/>
                            </div>
                        </div>
                        <div class = "row">
                            <label for="add-address" class="col-md-4 control-label">Address:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="address" placeholder="Member Address"/>
                            </div>
                        </div>                                                                        
                        <div class = "row">
                            <label for="add-zipCode" class="col-md-4 control-label">Zip Code:</label>
                            <div class="col-md-8">
                                <select name="zipCode" id="zipCode">
                                    <c:forEach var="currentZipCode" items="${zipCodes}">
                                        <option value="${currentZipCode.zipCode}"/>
                                            ${currentZipCode.zipCode}
                                        </option>
                                    </c:forEach>                                
                                </select>                          
                            </div>
                        </div>
                        <div class = "row">
                            <label for="add-organization" class="col-md-4 control-label">Organization:</label>
                            <div class="col-md-8">
                                <select name="organization" id="organization">
                                    <c:forEach var="currentOrganization" items="${organizations}">
                                        <option value="${currentOrganization.organizationID}">
                                            ${currentOrganization.organizationName}
                                        </option>
                                    </c:forEach>                                
                                </select> 
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Member"/>
                            </div>
                        </div>
                    </form>
                    </sec:authorize>
                </div>
            </div>              
        </div>       
    </body>
</html>