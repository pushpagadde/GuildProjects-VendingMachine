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
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/createDVDPage">Create DVD</a></li>                	
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySearchPage">Search</a></li>  
                    <li role="presentation">
                        <select id="searchCategory">
                            <option value="Title">Title</option>
                            <option value="Release Year">Release Year</option> 
                            <option value="Director's Name">Director's Name</option>
                            <option value="Rating">Rating</option>
                        </select>
                    </li>  
                    <li><input type="text" id="searchTerm" value="Search Term"/></li>
                </ul>    
            </div>
            <hr>
            
            <div class=row">
                <a href="${pageContext.request.contextPath}/displayDVDsListPage">
            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </form>

    </body>
</html>