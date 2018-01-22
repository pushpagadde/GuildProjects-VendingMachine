<%-- 
    Document   : createDVDPage
    Created on : Jan 5, 2018, 9:43:13 AM
    Author     : PG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Add a new DVD</title>
    </head>
    <body>
        <h1>Add a new DVD !----</h1>        
        <hr>
        <form class="form-horizontal" role="form" method="POST" action="createDVD">
            <div class="row">
                <div class="col-md-6"><label for="add-dvd-title" class="col-md-4 control-label">DVD Title:</label></div>
                <div class="col-md-6"><input type="text" class="form-control" name="title" placeholder="DVD Title"/></div>                 
            </div>              
            <br>
            <div class="row">
                <div class="col-md-6"><label for="add-year" class="col-md-4 control-label">Release Year:</label></div>   
                <div class="col-md-6"><input type="number" class="form-control" name="releaseYear" placeholder="Year"/></div>
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
                    <input type="submit" class="btn btn-default" name="cancel" value="Cancel"/>
                    <input type="submit" class="btn btn-default" name="save" value="Create DVD"/>
                </div>
            </div>
            <br>     
            <div class="row">
        </form>        
                <!-- 
            Add a col to hold the summary table - have it take up half the row 
        -->
         <!-- End col div -->
        
        
    </body>
</html>
