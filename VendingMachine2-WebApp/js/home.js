var itemsList = $('#contentRows');
var priceList = [], nameList = [], quantityList = [] ;

$(document).ready(function(){
  clearAll();
  $('#itemPurchased').append('Click on an item');
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/items",
    dataType: "json",
    contentType: "application/x-www-form-urlencoded",
    success: function(itemsArray) {
      $.each(itemsArray, function(index, itemInfo){
        var itemNumber = itemInfo.id;
        var itemName = itemInfo.name;
        var itemPrice = itemInfo.price;
        var itemQuantity = itemInfo.quantity;
        var row = '<tr>';
            row += '<td align="left"><h1><h3>' + itemNumber + '</h3></td></tr>';
            row += '<tr><td align="center"><h3>' + itemName + '</h3></td></tr>';
            row += '<tr><td align="center"><h3>' + Number(itemPrice).toFixed(2) + '</h3></td></tr>';
            row += '<tr><td align="center"><h3> Quantity: ' + itemQuantity + '</h3></td></tr>';

        itemsList.append(row);
        priceList.push(Number(itemPrice).toFixed(2));
        nameList.push(itemName);
        quantityList.push(itemQuantity);
        if(index ==0){
            $('#button1').append(row);
        }
        if(index ==1){
            $('#button2').append(row);
        }
        if(index ==2){
            $('#button3').append(row);
        }
        if(index ==3){
            $('#button4').append(row);
        }
        if(index ==4){
            $('#button5').append(row);
        }
        if(index ==5){
            $('#button6').append(row);
        }
        if(index ==6){
            $('#button7').append(row);
        }
        if(index ==7){
            $('#button8').append(row);
        }
        if(index ==8){
            $('#button9').append(row);
        }
      });
    },
    error: function(){
      $('#messages').text('Service unavailable.  Please try again later.');
    }
  });
  //loadItems();
  $('#makePurchase').click(function(){//purchase button clicked
    var returnChangeString='';
    var errorCode;
    var itemP = $('#itemPurchased').text();
    /*if(quantityList[itemP-1] == 0){//item sold out
      $('#messages').empty();
      $('#messages').append('SOLD OUT');
      $('#itemPurchased').empty();
      $('#itemPurchased').append("Pick an Item");
      errorCode = 1 ;
      return false();
    }*/
    /*if($('#itemPurchased').text == null){//no item selected
      errorCode = 3;
      return false();
    }*/
    if(Number($('#amountEntered').text()) >= priceList[Number($('#itemPurchased').text())-1]){//amount entered is correct
      //errorCode = 2 ;
      alert('http://localhost:8080/money/'  + $('#amountEntered').text() + '/item/' +$('#itemPurchased').text());
      $.ajax({
        type: 'GET', url: 'http://localhost:8080/money/' + $('#amountEntered').text() + '/item/' +$('#itemPurchased').text(),
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        success: function(itemsArray) {
          alert(itemsArray);
          $.each(itemsArray, function(index, itemInfo){
            alert('index: ' + index + ' iteminfo: ' + itemInfo);
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
          //location.reload();
          //setTimeout("location.reload(true);",5000);
        },
        error: function(xhr, textStatus, errorThrown) {
      /*    if(errorCode == 1 ){
            $('#messages').empty();
            $('#messages').text('SOLD OUT.');
          }
          if(errorCode == 2) {
            $('#messages').empty();
            $('#messages').text('Error Reading file...');
          }
          if(errorCode == 3){
            $('#messages').empty();
            $('#messages').text('Select an item.');
          }*/
          $('#messages').clear();
          $('#messages').append('Error calling web service.  Please try again later.');
          //yourErrorHandler(xhr, textStatus, errorThrown);
          alert(xhr + " " + textStatus + " " + errorThrow );
        }
      });
    }else {
      $('#messages').empty();
      var moreDeposit = priceList[Number($('#itemPurchased').text())-1] - Number($('#amountEntered').text());
      moreDeposit = Number(moreDeposit).toFixed(2);
      if (moreDeposit == 'NaN'){
        $('#messages').append("Pick an Item.");
      } else {
        $('#messages').append("deposit: " + moreDeposit +' more.');
      }
    }
  });
  var totalAmountEntered='0' ;
  $('#button1').click(function(){
    buttonClick('1');
  });
  $('#button2').click(function(){
    buttonClick('2');
  });
  $('#button3').click(function(){
    buttonClick('3');
  });
  $('#button4').click(function(){
    buttonClick('4');
  });
  $('#button5').click(function(){
    buttonClick('5');
  });
  $('#button6').click(function(){
    buttonClick('6');
  });
  $('#button7').click(function(){
    buttonClick('7');
  });
  $('#button8').click(function(){
    buttonClick('8');
  });
  $('#button9').click(function(){
    buttonClick('9');
  });
  $('#dollar').click(function(){
    totalAmountEntered = $('#amountEntered').text();
    totalAmountEntered = Number(totalAmountEntered) + Number(1);
    totalAmountEntered = Number(totalAmountEntered).toFixed(2);
    $('#amountEntered').empty();
    $('#amountEntered').append(totalAmountEntered);
  });
  $('#quarter').click(function(){
    totalAmountEntered = $('#amountEntered').text();
    totalAmountEntered = Number(totalAmountEntered) + Number(0.25);
    totalAmountEntered = Number(totalAmountEntered).toFixed(2);
    $('#amountEntered').empty();
    $('#amountEntered').append(totalAmountEntered);
  });
  $('#dime').click(function(){
    totalAmountEntered = $('#amountEntered').text();
    totalAmountEntered = Number(totalAmountEntered) +  Number(0.10);
    totalAmountEntered = Number(totalAmountEntered).toFixed(2);
    $('#amountEntered').empty();
    $('#amountEntered').append(totalAmountEntered);
  });
  $('#nickle').click(function(){
    totalAmountEntered = $('#amountEntered').text();
    totalAmountEntered = Number(totalAmountEntered) + Number(0.05);
    totalAmountEntered = Number(totalAmountEntered).toFixed(2);
    $('#amountEntered').empty();
    $('#amountEntered').append(totalAmountEntered);
  });

  $('#changeReturnedButton').click(function(){
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
  });

});


function clearAll(){
  $('#amountEntered').empty();
  $('#amountEntered').append('00.00');
  $('#messages').empty();
  $('#messages').append('Thank you!' );
  $('#itemPurchased').empty();
  $('#changeReturnedDisplay').empty();
  $('#changeReturnedDisplay').append('$ 00.00');
  $('#button1').empty();
  $('#button2').empty();
  $('#button3').empty();
  $('#button4').empty();
  $('#button5').empty();
  $('#button6').empty();
  $('#button7').empty();
  $('#button8').empty();
  $('#button9').empty();
}
function buttonClick(buttonNumber){
  $('#itemPurchased').empty();
  $('#itemPurchased').append(buttonNumber+ '     ');
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
