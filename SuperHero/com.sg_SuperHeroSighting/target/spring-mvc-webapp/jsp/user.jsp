<%-- 
    Document   : user
    Created on : Mar 13, 2018, 8:15:39 PM
    Author     : PG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Super Hero Sighting</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Super Hero Sighting - Users Page</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">                    
                    <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>
                       <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayUserPage">Users</a></li>
                    </sec:authorize>
                    <li role="presentation"><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                </ul>    
            </div>
            <div class="row">                           
                <div class="col-md-7">
                    <h2>Locations List</h2> 
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h4>Hello : ${pageContext.request.userPrincipal.name}
                        </h4>
                    </c:if>
                    <table id="users" border="1">
                        <tr>
                            <th width="5%" height="20">No.</th>
                            <th width="20%">User Name</th>                              
                            <th></th>
                        </tr>                                            
                        <c:forEach var="currentUser" items="${users}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">                                        
                                        <a href="displayUserDetails?username=${currentUser.username}"><c:out value="${currentUser.username}"/></a>
                                    </sec:authorize>                                                                       
                                </td> 
                                <td>
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">                                        
                                        |<a href="deleteUser?username=${currentUser.username}">Delete</a><br/><br/>
                                    </sec:authorize>                                                                       
                                </td>                                
                            </tr>                    
                        </c:forEach>                               
                    </table>
                </div>       
                <div class="col-md-5">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <h2>Add new User</h2>
                    <form class="form-horzontal"  modelAttribute="user" action= "addUser" role="form" method="POST">
                        <div class = "row">
                            <label for="add-user" class="col-md-4 control-label">User Name:</label>
                            <div class="col-md-8">
                              <input  class="form-control" type="text" name="username" placeholder="User Name"/>                              
                            </div>
                        </div>
                        <div class = "row">
                            <label for="add-password" class="col-md-4 control-label">Password:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="password" placeholder="Password" maxlength="8"/>                              
                            </div>
                        </div>                                                                        
                        <div class = "row">
                            <label for="add-admin" class="col-md-4 control-label">User Type:</label>
                            <div class="col-md-8" id="userType">
                                <input type="radio" id="admin" name="userType" value="Admin"> Admin
                                <input type="radio" id="sidekick" name="userType" value="SideKick"> Side Kick
                                <input type="radio" id="anon" name="userType" value="Anon" checked="checked"> Anon                                
                            </div>
                        </div>                        
                        <div class="row">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create User"/>
                            </div>
                        </div>
                    </form>
                    </sec:authorize>  
                </div>
            </div>
        </div>                
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
