var itemsList = $('#contentRows');
var priceList = [], nameList = [], quantityList = [], numbersList = [];
var buttonsList = $('#commandButtons');
var totalAmountEntered='0' ;
var itemNumber, itemName, itemPrice, itemQuantity;// row, row1, row2, row3;
$(document).ready(function(){
  loadItems();
  loadButtons();
});

function loadItems(){
  clearAll();
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/items",
    dataType: "json",
    contentType: "application/x-www-form-urlencoded",
    success: function(itemsArray) {
      $.each(itemsArray, function(index, itemInfo){
        itemNumber = itemInfo.id;
        itemName = itemInfo.name;
        itemPrice = itemInfo.price;
        itemQuantity = itemInfo.quantity;
        numbersList.push(itemNumber);
        nameList.push(itemName);
        priceList.push(Number(itemPrice).toFixed(2));
        quantityList.push(itemQuantity);
      });
      var row = null;
      for(i=0; i<9 ; i++){//populating the buttons information
        row = '<div class="row" >';
        row += '<div class="col-md-4" ><button type=button onclick="itemSelected(' + i + ')">';
        row += '<div class="row" align="left" style="width:150px">'+ numbersList[i] +'</div>';
        row += '<div class="row" align="center" >'+ nameList[i] +'</div>';
        row += '<div class="row" align="center"> $ '+ priceList[i] +'</div>';
        row += '<div class="row" align="center" id="quantityB"' + i + '> Quantity: ';
        row += quantityList[i] +'</div></button></div>';
        i++;
        row += '<div class="col-md-4" ><button type=button onclick="itemSelected(' + i + ')">';
        row += '<div class="row" align="left"  style="width:150px">'+ numbersList[i] +'</div>';
        row += '<div class="row" align="center">'+ nameList[i] +'</div>';
        row += '<div class="row" align="center"> $ '+ priceList[i] +'</div>';
        row += '<div class="row" align="center"> Quantity: '+ quantityList[i] +'</div></button></div>';
        i++;
        row += '<div class="col-md-4" ><button type=button onclick="itemSelected(' + i + ')">';
        row += '<div class="row" align="left"  style="width:150px">'+ numbersList[i] +'</div>';
        row += '<div class="row" align="center">'+ nameList[i] +'</div>';
        row += '<div class="row" align="center"> $ '+ priceList[i] +'</div>';
        row += '<div class="row" align="center"> Quantity: '+ quantityList[i] +'</div></button></div></div>';
        itemsList.append(row);
      }
    },
    error: function(){
      $('#messages').text('Service unavailable.  Please try again later.');
    }
  });
}
function loadButtons(){
  var row1=null;
  row1 = '<div class="row">';
  row1 += '<div class="row"><div class="col-md-12">Total $ IN</div></div>';
  row1 += '<div class="row">';
  row1 += '<div class="col-md-4 col-md-offset-4" ><button id="amountEntered" align="center" disabled>00.00</button></div></div>';
  row1 += '<div class="row">';
  row1 += '<div class="col-md-6" ><button id="dollar" type=button onclick="addMoney(1.00)" >Add Dollar </button></div>';
  row1 += '<div class="col-md-6" ><button id="quarter" type=button onclick="addMoney(0.25)">Add Quarter</button></div>';
  row1 += '</div><br>' ;
  row1 += '<div class="row">';
  row1 += '<div class="col-md-6" ><button id="dime" type=button onclick="addMoney(0.10)" >Add Dime </button></div>';
  row1 += '<div class="col-md-6" ><button id="nickle" type=button onclick="addMoney(0.05)" >Add Nickle</button></div>';
  row1 += '</div>';
  row1 += '</div>';
  buttonsList.append(row1);
  var row2=null;
  row2 = '<div class="row">';
  row2 += '<div class="row"><div class="col-md-12">Messages</div></div>';
  row2 += '<div class="row"><div class="col-md-12"><button id="messages" disabled>Welcome!</button></div></div>';
  row2 += '<div class="row"><div class="col-md-3">Item:</div>';
  row2 += '<div class="col-md-9 col-md-offset-0"><button id="itemPurchased" disabled>Select item</button></div></div><br>';
  row2 += '<div class="row">';
  row2 += '<div class="col-md-12"><button id="makePurchase" type=button onclick="purchaseFunction()">Make Purchase</button></div></div>';
  row2 += '</div>';
  buttonsList.append(row2);
  var row3 = null;
  row3 = '<div class="row">';
  row3 += '<div class="row"><div class="col-md-12">Change</div></div>';
  row3 += '<div class="row"><div = class="col-md-12"><button id="changeReturnedDisplay" align="center" disabled>Return Change</button></div></div><br>';
  row3 += '<div class="row"><div class="col-md-12"><button id="changeReturnedButton" type=button onclick="changeReturn()">Return Change</button></div></div><br>';
  row3 += '</div>';
  buttonsList.append(row3);
}
function purchaseFunction(){
  var returnChangeString='';
  var errorCode;
  var amtEntered = Number($('#amountEntered').text());
  var itemP = $('#itemPurchased').text();
  $.ajax({
    type: 'GET', url: 'http://localhost:8080/money/' + amtEntered + '/item/' + itemP,
    dataType: "json",
    async: false,
    contentType: "application/x-www-form-urlencoded",
    success: function(itemsArray) {
      $.each(itemsArray, function(index, itemInfo){
        if(Number(itemInfo) != 0){
          returnChangeString += " "+itemInfo +" "+ index+",";
        }
      });
      $('#messages').empty();
      $('#messages').append("Thank you!");
      totalAmountEntered = Number(0);
      $('#amountEntered').empty();
      $('#amountEntered').append(totalAmountEntered);
      $('#itemPurchased').empty();
      $('#itemPurchased').append("Pick an Item");
      $('#changeReturnedDisplay').empty();
      $('#changeReturnedDisplay').append(returnChangeString);

      loadItems();
    },
    error: function (request, status, error) {
      var msg = request.responseJSON.message;
      $('#messages').empty();
      $('#messages').append(msg);
    }
  });
}

function addMoney(amount){
  totalAmountEntered = Number(totalAmountEntered) + Number(amount);
  totalAmountEntered = Number(totalAmountEntered).toFixed(2);
  $('#amountEntered').empty();
  $('#amountEntered').append(totalAmountEntered);
}

function itemSelected(selectedItemNumber){
  selectedItemNumber ++;
  $('#itemPurchased').empty();
  $('#itemPurchased').append(selectedItemNumber);
  $('#changeReturnedDisplay').empty();
  $('#changeReturnedDisplay').append('$ 00.00');
}

function clearAll(){
  itemsList.empty();
  //buttonsList.empty();
  $('#amountEntered').empty();
  $('#amountEntered').append('00.00');
  $('#messages').empty();
  $('#messages').append('Thank you!' );
  $('#itemPurchased').empty();
  $('#itemPurchased').append('Click on an item');
  itemNumber = "";
  itemName = "";
  itemPrice = "";
  itemQuantity = "";
  numbersList = [];
  nameList = [];
  priceList =[];
  quantityList = [];
}
function changeReturn(){
  $('#messages').empty();
  $('#messages').append('Thank you!');
  $('#itemPurchased').empty();
  $('#itemPurchased').append('none picked');
  $('#changeReturnedDisplay').empty();
  $('#changeReturnedDisplay').append("none");
  returnChange(Number($('#amountEntered').text()));
  $('#amountEntered').empty();
  totalAmountEntered = Number(0.00).toFixed(2);
  $('#amountEntered').append(totalAmountEntered);
}
function returnChange(change){
  change = Number(change)* Number(100);
  var returnString = "", returnArray = [], denominationArray = [];
  var dollar = Number(change)/Number(100.00); dollar = parseInt(dollar);
  change = Number(change) % Number(100.00); change = Number(change).toFixed(2);
  returnArray.push(dollar); denominationArray.push('Dollar');
  var quarter = Number(change)/Number(25); quarter = parseInt(quarter);
  change = Number(change) % Number(25.00); change = Number(change).toFixed(2);
  returnArray.push(quarter);denominationArray.push('Quarter');
  var dime = Number(change)/Number(10); dime = parseInt(dime);
  change = Number(change) % Number(10.00); change = Number(change).toFixed(2);
  returnArray.push(dime);denominationArray.push('Dime');
  var nickle = Number(change)/Number(5); nickle = parseInt(nickle);
  change = Number(change) % Number(5.00); change = Number(change).toFixed(2);
  returnArray.push(nickle);denominationArray.push('Nickle');
  for(var i=0; i<4; i++) {
    if(Number(returnArray[i]) % Number(1) == 0 && returnArray[i] != 0){
      returnString += returnArray[i];
      returnString += ' ' + denominationArray[i] + ', ';
    }
  }
  $('#changeReturnedDisplay').empty();
  $('#changeReturnedDisplay').append(returnString);
}
