<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Vending Machine! </h1><hr/>                        
            <div class="row">
                <div class="col-md-9" id="buttons"><!--Display items on buttons -->
                    <form class="form-horizontal" role="form" method="GET" action="itemSelection">
                        <c:forEach var="item" items="${items}">                    
                            <div class="col-sm-4">                        
                                <button style=" height:180px; width:180px" id="${item.itemId}">
                                    <h4 align="left"><c:out value="${item.itemId}"/></h4>
                                    <h4><c:out value="${item.itemName}"/><br>                    
                                    $ <c:out value="${item.itemPrice}"/><br>
                                    Quantity: <c:out value="${item.itemQuantity}"/></h4>
                                </button>                                                
                            </div>
                        </c:forEach>
                    </form>                    
                </div>
                <div class="col-md-9"><!--Display forms on buttons for operations-->
                    <div class="row"><!--money box-->
                        <form class="form-horizontal" role="form" method="GET" action="addMoney">                            
                            <div class="row" aligh="center" ><!--column for buttons-->
                                <div class="col-md-12"><h3 align="center">Total $ IN</h3></div></div>
                            <div class="row" aligh="center">
                                <div class="col-md-4 col-md-offset-4" style=" height:50px">
                                    <button id="amountEntered" align="center" disabled>
                                        $ <c:out value="${moneyAdded}"/>
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
                                    <button id="messages" align="center" disabled><c:out value="${messageToSend}"/></button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6" style=" height:40px;" align="right"><h4>Item: </h4></div>
                                <div class="col-md-6" ><button id="itemPurchased" align="left" disabled><c:out value="${itemPurchasedText}"/></button></div>
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
                                        <button id="changeReturnedDisplay" align="center" disabled><c:out value="${changeDue}" /></button>
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
        </div>
        <!--<div class="navbar">
            <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
            </ul>    
        </div>-->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

