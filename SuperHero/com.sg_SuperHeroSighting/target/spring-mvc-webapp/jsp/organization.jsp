<%-- 
    Document   : organization
    Created on : Feb 1, 2018, 8:21:35 PM
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
        <title>Organizations Page</title>
        <!-- Bootstrap core CSS -->        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            #organizations {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            #organizations td, #organizations th {
                border: 1px solid #ddd;
                padding: 8px;
            }
            #organizations tr:nth-child(even){background-color: #f2f2f2;}
            #organizations tr:hover {background-color: #ddd;}
            #organizations th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Super Hero Sighting - Organizations</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">                                          
                    <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                       <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayUserPage">Users</a></li>
                    </sec:authorize>
                    <li role="presentation"><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                </ul>    
            </div>
            <div class="row">                           
                <div class="col-md-6">
                    <h2>Organizations</h2> 
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h4>Hello : ${pageContext.request.userPrincipal.name}
                        </h4>
                    </c:if>
                    <table id="organizations" border="1">
                        <tr>
                            <th width="10%" height="20">No</th>
                            <th width="20%">Organization Name</th>
                            <th width="40%">Address, City, State</th>
                            <th width="10%">Zip Code</th>
                            <th width="20%"></th>                    
                        </tr>
                        
                        <c:forEach var="currentOrganization" items="${organizationsList}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td><a href="organizationDetailsPage?organizationID=${currentOrganization.organizationID}">
                                        ${currentOrganization.organizationName}</a>
                                </td>
                                
                                <c:forEach var="currentZipCode" items="${zipCodes}">
                                    <c:choose >
                                        <c:when test="${currentOrganization.zipCode==currentZipCode.zipCode}">
                                            <td>${currentOrganization.address}, ${currentZipCode.city}  ${currentZipCode.state}</td>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                <td>${currentOrganization.zipCode}</td>                                                
                                <td>
                                    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                                        <a href="organizationEditPage?organizationID=${currentOrganization.organizationID}" >Edit</a>                                     
                                    </sec:authorize>                                             
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                       |<a href="deleteOrganization?organizationID=${currentOrganization.organizationID}" >Delete</a>
                                    </sec:authorize>                                                                        
                                </td>
                            </tr>                    
                        </c:forEach>                                                    
                    </table>
                </div>        
                <div class="col-md-6">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <h2>Add new Organization</h2>
                    <form class="form-horzontal" action= "createOrganization" role="form" method="POST">
                        <div class = "row">
                            <label for="add-organizationName" class="col-md-4 control-label">Organization Name:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="organizationName" placeholder="Organization Name"/>
                            </div>
                        </div>
                        <div class = "row">
                            <label for="add-organizationAddress" class="col-md-4 control-label">Organization Address:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="organizationAddress" placeholder="Organization Address"/>
                            </div>
                        </div>
                        <div class = "row">
                            <label for="add-organizationPhone" class="col-md-4 control-label">Phone Number:</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control" name="organizationPhone" placeholder="Organization Phone"/>
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
                        <div class="row">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Organization"/>
                            </div>
                        </div>
                    </form>
                    </sec:authorize>
                </div>
            </div>
        </div>
            <!-- 
        
        Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
