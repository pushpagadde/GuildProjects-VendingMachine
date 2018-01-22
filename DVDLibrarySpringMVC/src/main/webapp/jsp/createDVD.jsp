<%-- 
    Document   : createDVD
    Created on : Jan 3, 2018, 8:32:24 PM
    Author     : PG
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Create DVD</title>
    </head>
    <body>
        
        <h1>Add a new DVD</h1>
        <hr>
        <form class="form-horizontal" role="form" method="POST" action="saveNewDVD">
            <div class="row">
                <div class="col-md-6"><label for="add-dvd-title" class="col-md-4 control-label">DVD Title:</label></div>
                <div class="col-md-6"><input type="text" class="form-control" name="dvdTitle" placeholder="DVD Title"/></div>                 
            </div>              
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-year" class="col-md-4 control-label">Year:</label></div>   
                <div class="col-md-6"><input type="text" class="form-control" name="year" placeholder="Year"/></div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-director" class="col-md-4 control-label">Director:</label></div>
                <div class="col-md-6"><input type="text" class="form-control" name="director" placeholder="Director"/></div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-rating" class="col-md-4 control-label">Rating:</label></div>
                <div class="col-md-6"><input type="rating" class="form-control" name="rating" placeholder="Rating"/></div>                
            </div>
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-notes" class="col-md-4 control-label">Notes:</label></div>
                <div class="col-md-6"><input type="textarea" class="form-control" name="notes" placeholder="Notes"/></div>
            </div>
            <br> 
            <div class="row">
                <div class="col-md-12">
                    <input type="submit" class="btn btn-default" value="Cancel"/>
                    <input type="submit" class="btn btn-default" value="Create DVD"/>
                </div>
            </div>
            <br>     
            <div class="row">
        <!-- 
            Add a col to hold the summary table - have it take up half the row 
        -->
        <div class="col-md-6">
            <h2>DVDs List</h2>
            <table id="contactTable" class="table table-hover">
                <tr>
                    <th width="40%">Title</th>
                    <th width="30%">Director</th>
                </tr>
            <c:forEach var="currentDVD" items="${dvdList}">
            <tr>
                <td>
                 <c:out value="${currentDVD.title}"/> 
                </td>
                <td>
                    <c:out value="${currentDVD.director}"/>
                </td>
            </tr>
            </c:forEach>
            </table>                    
        </div> <!-- End col div -->
        </form>        
        </div>
    </body>
</html>
