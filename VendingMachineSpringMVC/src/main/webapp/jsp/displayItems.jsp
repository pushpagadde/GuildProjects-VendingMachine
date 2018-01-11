<%-- 
    Document   : displayItems
    Created on : Jan 6, 2018, 12:15:20 PM
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
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <title>Vending Machine</title>
    </head>
    <body>
        <div class="container" align="center">
            <div class="row"><!--main heading--><h1 id="mainHeading" align="center">Vending Machine</h1><hr></div>
            <div class="row">
                <div class="col-md-9" id="buttonsBox"><!-- container for buttons alone-->
                        <c:forEach var="item" items="${items}">
                            <div class="col-md-4" >
                                <a href="${pageContext.request.contextPath}/itemSelection/${item.itemId}">
                                <button id="${item.itemId}" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item.itemId}"/></h4>
                                    <h4><c:out value="${item.itemName}"/><br>                    
                                    $ <c:out value="${item.itemPrice}"/><br>
                                    Quantity: <c:out value="${item.itemQuantity}"/></h4>
                                </button></a>
                            </div>
                        </c:forEach>
                    
                </div>    
                <div class="col-md-3" >
                    <div class="row"><!--money box-->
                        <form class="form-horizontal" role="form" method="GET" action="addMoney">                            
                            <div class="row" aligh="center" ><!--column for buttons-->
                                <div class="col-md-12"><h3 align="center">Total $ IN</h3></div></div>
                            <div class="row" aligh="center">
                                <div class="col-md-4 col-md-offset-4" style=" height:50px">
                                    <button id="amountEntered" align="center" disabled>
                                        $ <c:out value="${enteredMoney}"/>
                                    </button>
                                </div>
                            </div>
                            <div class="row" aligh="center">
                                <div class="col-md-6" style=" height:30px"><button name="dollar" >Add Dollar </button></div>
                                <div class="col-md-6" style=" height:30px"><button name="quarter" >Add Quarter</button></div>
                            </div>
                            <div class="row" aligh="center">
                                <div class="col-md-6" style=" height:30px"><button name="dime" >Add Dime </button></div>
                                <div class="col-md-6" style=" height:30px"><button name="nickle" >Add Nickel</button></div>
                            </div><hr>                            
                        </form>                
                    </div> 
                    <div class="row"><!--message box-->
                        <form class="form-horizontal" role="form" method="GET" action="purchaseClick">                        
                            <div class="row" aligh="center" >
                                <div class="col-md-12"><h3 align="center">Messages</h3></div>
                            </div>
                            <div class="row" aligh="center" >
                                <div class="col-md-12" style=" height:40px">
                                    <button id="messages" align="center" disabled><c:out value="${message}"/></button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6" style=" height:40px;" align="right"><h4>Item: </h4></div>
                                <div class="col-md-6" ><button id="itemPurchased" align="left" disabled><c:out value="${id}"/></button></div>
                            </div>
                            <div class="row" aligh="left">
                                <div class="col-md-6 col-md-offset-3" style=" height:30px"><button name="makePurchase">Make Purchase</button></div>
                            </div><hr>                        
                        </form>
                    </div> 
                    <div class="row"><!--change box-->
                        <form class="form-horizontal" role="form" method="GET" action="change">
                            <div class="col-md-12" >
                                <div class="row" aligh="center" ><!--column for buttons-->
                                    <div class="col-md-12"><h3 align="center">Change</h3></div>
                                </div>
                                <div class="row" aligh="center" >
                                    <div class="col-md-12" style=" height:50px">
                                        <button id="changeReturnedDisplay" align="center" disabled><c:out value="${returnChange}" /></button>
                                    </div>
                                </div>
                                <div class="row" aligh="center">
                                    <div class="col-md-6 col-md-offset-3" style=" height:30px">
                                        <button id="changeReturnedButton" >Return Change</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div> 
                </div>                                                        
            </div>                                    
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>