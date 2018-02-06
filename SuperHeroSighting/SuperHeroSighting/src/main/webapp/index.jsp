<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <style>
            #newsFeed {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #newsFeed td, #newsFeed th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #newsFeed tr:nth-child(even){background-color: #f2f2f2;}

            #newsFeed tr:hover {background-color: #ddd;}

            #newsFeed th {
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
            <h1>SuperHero Sighting Spring MVC application - Home Page</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/mainPage.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Super Heros</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayMembersPage">Members</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayAboutPage">About</a></li>
                </ul>    
            </div>
            <h2>Super Hero Sightings</h2>
            <h4>
                With the rising popularity of superhero movies there has been a heightened awareness of super heroes in our midst.
                The frequency of superhero (and super villain) sightings is increasing at an alarming rate.  
                Given this development, the Hero Education and Relationship Organization (HERO) has asked our company to develop a database and 
                data layer for their new super hero sightings web application.
                Use the links on this page to navigate and add/view all SuperHero Sightings.
                The Application also allows you to view the organizations they work for and members that work for that organization.
            </h4>
            <h1>
                <a href="mainPage" >Enter!</a>
                
            </h1>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>