<%-- 
    Document   : searchDVDResultPage
    Created on : Jan 29, 2018, 7:01:04 PM
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
        <title>Search for DVD!</title>
    </head>
    <body>
        <h1>Search Result!</h1>
        <div class="container">
            <c:choose>
                <c:when test="${dvdList} == null">
                    <h1>No results to display.</h1>
                </c:when>
                <c:otherwise>
                    <table id="searchResultTable" class="table table-hover" border="1">
                    <tr>
                    <th width="5%">SNo</th>
                    <th width="20%">Title</th>
                    <th width="10%">Release Year</th>
                    <th width="10%">Director</th>
                    <th width="5%">Rating</th>
                    <th width="40%">Notes</th>                            
                    <th width="10%"></th>
                    </tr>
                    <c:forEach var="currentDVD" items="${dvdList}">
                    <tr>
                        <td><c:out value="${currentDVD.title}"/></td>
                    <td ><c:out value="${currentDVD.title}"/></td>
                    <td ><c:out value="${currentDVD.releaseYear}"/> </td>   
                    <td ><c:out value="${currentDVD.director}"/> </td>   
                    <td ><c:out value="${currentDVD.rating}"/> </td>   
                    <td ><c:out value="${currentDVD.notes}"/> </td>   
                    <br>
                    </tr>
                    </c:forEach>        
                </table>
                </c:otherwise>
            </c:choose>
            <form name="back" action="displayDVDPage" method="GET">
                    <button type="submit">Back</button>
            </form>
        </div>
       <!-- <form name="back" action="dvds" method="GET">
                    <button type="submit">Back</button>
        </form> -->
        
    </body>
</html>
