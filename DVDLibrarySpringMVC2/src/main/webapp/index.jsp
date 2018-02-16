<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <div class="row">
                <form name="createdvd" action="createDVDPage" method="POST">
                    <button type="submit">Create DVD</button>
                </form>
                
                <form name="searchdvd" action="searchDVDPage" method="POST">
                    <button type="submit">Search</button>
                </form>
           
                <select id="searchCategory" value="Search Category">
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
                            <th width="5%">Rating</th>
                            <th width="40%">Notes</th>                            
                            <th width="10%"></th>
                        </tr>
                    </table>                      
                </div>
                </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

<!--   
<div class="navbar">
    <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
    </ul>    
</div>           
-->