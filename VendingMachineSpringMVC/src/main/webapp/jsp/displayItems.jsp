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
                <div class="col-md-9" ><!-- container for buttons alone-->
                    <form class="form-horizontal" role="form" method="GET" action="itemSelect">
                        <div class="row"><!-- row 1 for buttons-->
                            <div class="col-md-4" >
                                <button name="button1" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item1.itemId}"/></h4>
                                    <h4><c:out value="${item1.itemName}"/><br>                    
                                    $ <c:out value="${item1.itemPrice}"/><br>
                                    Quantity: <c:out value="${item1.itemQuantity}"/></h4>
                                </button>
                            </div><!-- style=" height:250px; width:250px -->
                            <div class="col-md-4" >
                                <button name="button2" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item2.itemId}"/></h4>
                                    <h4><c:out value="${item2.itemName}"/><br>                    
                                    $ <c:out value="${item2.itemPrice}"/><br>
                                    Quantity: <c:out value="${item2.itemQuantity}"/></h4>
                                </button>
                            </div>
                            <div class="col-md-4" >
                                <button name="button3" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item3.itemId}"/></h4>
                                    <h4><c:out value="${item3.itemName}"/><br>                    
                                    $ <c:out value="${item3.itemPrice}"/><br>
                                    Quantity: <c:out value="${item3.itemQuantity}"/></h4>
                                </button>
                            </div>                        
                        </div><br>
                        <div class="row"><!-- row 2 for buttons-->
                            <div class="col-md-4" >
                                <button name="button4" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item4.itemId}"/></h4>
                                    <h4><c:out value="${item4.itemName}"/><br>                    
                                    $ <c:out value="${item4.itemPrice}"/><br>
                                    Quantity: <c:out value="${item4.itemQuantity}"/></h4>
                                </button>
                            </div><!-- style=" height:250px; width:250px -->
                            <div class="col-md-4" >
                                <button name="button5" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item5.itemId}"/></h4>
                                    <h4><c:out value="${item5.itemName}"/><br>                    
                                    $ <c:out value="${item5.itemPrice}"/><br>
                                    Quantity: <c:out value="${item5.itemQuantity}"/></h4>
                                </button>
                            </div>
                            <div class="col-md-4" >
                                <button name="button6" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item6.itemId}"/></h4>
                                    <h4><c:out value="${item6.itemName}"/><br>                    
                                    $ <c:out value="${item6.itemPrice}"/><br>
                                    Quantity: <c:out value="${item6.itemQuantity}"/></h4>
                                </button>
                            </div>
                        </div><br>
                        <div class="row"><!-- row 3 for buttons-->
                            <div class="col-md-4" >
                                <button name="button7" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item7.itemId}"/></h4>
                                    <h4><c:out value="${item7.itemName}"/><br>                    
                                    $ <c:out value="${item7.itemPrice}"/><br>
                                    Quantity: <c:out value="${item7.itemQuantity}"/></h4>
                                </button>
                            </div>
                            <div class="col-md-4" >
                                <button name="button8" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item8.itemId}"/></h4>
                                    <h4><c:out value="${item8.itemName}"/><br>                    
                                    $ <c:out value="${item8.itemPrice}"/><br>
                                    Quantity: <c:out value="${item8.itemQuantity}"/></h4>
                                </button>
                            </div>
                            <div class="col-md-4" >
                                <button name="button9" style=" height:180px; width:180px">
                                    <h4 align="left"><c:out value="${item9.itemId}"/></h4>
                                    <h4><c:out value="${item9.itemName}"/><br>                    
                                    $ <c:out value="${item9.itemPrice}"/><br>
                                    Quantity: <c:out value="${item9.itemQuantity}"/></h4>
                                </button>
                            </div>
                        </div>                        
                    </form>
                </div>    
                <div class="col-md-3" >
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
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>