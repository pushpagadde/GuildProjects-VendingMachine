<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Hero Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            #heros {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            #heros td, #heros th {
                border: 1px solid #ddd;
                padding: 8px;
            }
            #heros tr:nth-child(even){background-color: #f2f2f2;}
            #heros tr:hover {background-color: #ddd;}
            #heros th {
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
            <h1>Spring MVC Application from Archetype - Super Hero Page</h1>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                       <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>
                       <li role="presentation"><a href="${pageContext.request.contextPath}/displayUserPage">Users</a></li>
                    </sec:authorize>
                    <li role="presentation"><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                </ul>    
            </div>                            
            <div class="col-md-8">
                <h2>Super Heros</h2>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <h4>Hello : ${pageContext.request.userPrincipal.name}
                    </h4>
                </c:if>
                <table id="heros" border="1">
                <tr>
                    <th width="10%" height="20">No.</th>
                    <th width="30%">Hero Name</th>
                    <th width="20%">Hero Power</th>                     
                    <th width="20%"></th>
                </tr>
                <c:forEach var="currentHero" items="${heroList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1} </td>
                        <td><a href="displayHeroDetails?heroID=${currentHero.heroID}">
                            ${currentHero.heroName}
                        </a></td>
                        <td>${currentHero.heroPower}</td>                        
                        <td>                             
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="displayEditHeroPage?heroID=${currentHero.heroID}" >Edit</a> 
                                |<a href="deleteHero?heroID=${currentHero.heroID}"> Delete</a>                             
                            </sec:authorize>                             
                        </td>                        
                    </tr>                    
                </c:forEach>                                         
            </table>
            </div>            
            <div class="col-md-4">                
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SIDEKICK')">
                <h2>Add new Hero</h2>
                <form class="form-horzontal" action= "createHero" role="form" method="POST">
                    <div class = "row">
                        <label for="add-heroName" class="col-md-4 control-label">Hero Name:</label>
                        <div class="col-md-8">
                          <input type="text" class="form-control" name="heroName" placeholder="Hero Name"/>
                        </div>
                    </div>
                    <div class = "row">
                        <label for="add-heroPower" class="col-md-4 control-label">Hero Power:</label>
                        <div class="col-md-8">
                          <input type="text" class="form-control" name="heroPower" placeholder="Hero Power"/>
                        </div>
                    </div>
                    <div class = "row">
                        <label for="add-heroOrganization" class="col-md-4 control-label">Hero Organization:</label>
                        <div class="col-md-8">
                            <select name="organization" id="organization">
                                <c:forEach var="currentOrganization" items="${organizations}">
                                    <option value="${currentOrganization.organizationID}"/>
                                        ${currentOrganization.organizationName}
                                    </option>
                                </c:forEach>                                
                            </select>                          
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Hero"/>
                        </div>
                    </div>
                </form>
                </sec:authorize> 
            </div>            
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

