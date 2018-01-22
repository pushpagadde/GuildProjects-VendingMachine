<%-- 
    Document   : dvds
    Created on : Jan 5, 2018, 12:39:03 PM
    Author     : PG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <h1>DVD Library dvds.jsp!</h1>
        <div class="container">
            <div class="row">
                <form name="createdvd" action="createDVDPage" method="POST">
                    <button type="submit">Create DVD</button>
                </form>
                <button onClick="${pageContext.request.contextPath}/searchDVDPage">Search</button>
                <select id="searchCategory">
                    <option value="Title">Title</option>
                    <option value="Release Year">Release Year</option> 
                    <option value="Director's Name">Director's Name</option>
                    <option value="Rating">Rating</option>
                </select>
                <input type="text" id="searchTerm" value="Search Term"/>
            </div>
            <hr/>
            <h2>List of all DVDs</h2>
            <div class="row">
                <div class="col-md-12">
                    <h2>My Contacts</h2>
                    <table id="contactTable" class="table table-hover" border="1">
                        <tr>
                            <th width="20%">Title</th>
                            <th width="15%">Release Year</th>
                            <th width="10%">Director</th>
                            <th width="10%">Rating</th>
                            <th width="25%">Notes</th>                            
                            <th width="20%"></th>
                        </tr>                      
                        <c:forEach var="currentDVD" items="${dvdList}">
                            <tr>
                                <td >
                                    <a href="displayDVDDetails?dvdId=${currentDVD.dvdId}"><c:out value="${currentDVD.title}"/></a>
                                </td>
                                <td ><c:out value="${currentDVD.releaseYear}"/> </td>   
                                <td ><c:out value="${currentDVD.director}"/> </td>   
                                <td ><c:out value="${currentDVD.rating}"/> </td>   
                                <td ><c:out value="${currentDVD.notes}"/> </td>   
                                <td >
                                    <a href="displayEditDVDPage?dvdId=${currentDVD.dvdId}" >Edit</a> | 
                                    <a href="deleteDVD?dvdId=${currentDVD.dvdId}">Delete</a>
                                </td>
                                <br>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
