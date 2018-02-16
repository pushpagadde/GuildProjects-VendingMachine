<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : searchDVDPage
    Created on : Jan 5, 2018, 9:43:26 AM
    Author     : PG
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>DVD Search result</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <h1>DVD Search result</h1>
        <div class="container">

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
        </div>
        <form name="back" action="displayDVDPage" method="GET">
                    <button type="submit">Back</button>
        </form>
        
        
        
        <%--
                    
            <h1>Title : <c:out value="${dvdList.title}"/></h1>
            <hr/>
            <p>Release Year : <c:out value="${dvdList.releaseYear}"/></p>
            <p>Director : <c:out value="${dvdList.director}"/></p>
            <p>Rating : <c:out value="${dvdList.rating}"/></p>
            <p>Notes : <c:out value="${dvdList.notes}"/></p>

        --%>
        
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
