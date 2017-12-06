$(document).ready(function(){
  clearAll();
  var itemsList = $('#contentRows');
  var priceList = [], nameList = [], quantityList = [] ;
  $('#changeReturnedButton').click(function(){
    $('#messages').empty();
    $('#messages').append('Welcome!');
    $('#changeReturnedDisplay').empty();
    returnChange(Number($('#amountEntered').text()));
    $('#itemPurchased').empty();
    $('#itemPurchased').append('     ');
    $('#amountEntered').empty();
    totalAmountEntered = Number(0);
    $('#amountEntered').append(totalAmountEntered);
  });

  $.ajax({
    type: "GET",
    url: "http://localhost:8080/items",
    dataType: "json",
    contentType: "application/x-www-form-urlencoded",
    success: function(itemsArray) {
      $.each(itemsArray, function(index, itemInfo){
        var itemNumber = index+1;
        var itemName = itemInfo.name;
        var itemPrice = itemInfo.price;
        var itemQuantity = itemInfo.quantity;
        var row = '<tr>';
            row += '<td align="left">' + itemNumber + '</td></tr>';
            row += '<tr><td align="center">' + itemName + '</td></tr>';
            row += '<tr><td align="center">' + Number(itemPrice).toFixed(2) + '</td></tr>';
            row += '<tr><td align="center">' + "Quantity: " + itemQuantity + '</td></tr>';
        itemsList.append(row);
        priceList.push(Number(itemPrice).toFixed(2));
        nameList.push(itemName);
        quantityList.push(itemQuantity);
        if(index == 0){
            $('#button1').append(row);
        }
        if(index == 1){
            $('#button2').append(row);
        }
        if(index == 2){
            $('#button3').append(row);
        }
        if(index == 3){
            $('#button4').append(row);
        }
        if(index == 4){
            $('#button5').append(row);
        }
        if(index == 5){
            $('#button6').append(row);
        }
        if(index == 6){
            $('#button7').append(row);
        }
        if(index == 7){
            $('#button8').append(row);
        }
        if(index == 8){
            $('#button9').append(row);
        }
      });
    },
    error: function(){
      $('#errorMessages')
          .append($('<li>')
          .attr({class: 'list-group-item list-group-item-danger'})
          .text('Error calling web service.  Please try again later.'));
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

  $('#makePurchase').click(function() {
    if(Number(quantityList[Number($('#itemPurchased').val())-1]) > Number(0) ){
      if(Number($('#amountEntered').text()) >= priceList[Number($('#itemPurchased').val())-1] ){
        $('#messages').empty();
        $('#messages').val("Thank you!!");
        $('#changeReturnedDisplay').empty();
        var amountToReturn = $('#amountEntered').text() - priceList[Number($('#itemPurchased').val())-1];
        returnChange( amountToReturn );
        totalAmountEntered = Number(0);
        $('#amountEntered').empty();
        $('#amountEntered').append(totalAmountEntered);
        $('#itemPurchased').empty();
        /*ajax put method goes here - code in the bottom of this page*/
      }else {
        $('#messages').empty();
        var moreDeposit = priceList[Number($('#itemPurchased').val())-1] - Number($('#amountEntered').text());
        moreDeposit = Number(moreDeposit).toFixed(2);
        $('#messages').val("deposit: " + moreDeposit +' more.');
      }
    }else {
      $('#messages').empty();
      $('#messages').val('SOLD OUT!');
    }
  });
});

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
  $('#changeReturnedDisplay').append(returnString);
}

function buttonClick(buttonNumber){
  $('#itemPurchased').val('');
  $('#itemPurchased').val(buttonNumber);
}

function clearAll(){
  $('#amountEntered').empty();
  $('#amountEntered').append('00.00');
  $('#messages').empty();
  $('#messages').append('Welcome!!' );
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
/*$.ajax({//reduce quantity by 1
  type: 'PUT', url: 'http://localhost:8080/item/' + $('#itemPurchased').val(),
  data: JSON.stringify({
    id: $('#itemPurchased').val(),
    name: nameList[Number($('#itemPurchased').val())-1],
    price: priceList[Number($('#itemPurchased').val())-1],
    quantity: quantityList[Number($('#itemPurchased').val())-1],
  }),
  headers: {'Accept': 'application/json','Content-Type': 'application/json'},
  'dataType': 'json',
  success: function() {
    alert('success');
  },
  error:  function() {
   $('#messages')
      .append($('<li>')
      .attr({class: 'list-group-item list-group-item-danger'})
      .text('Error calling web service.  Please try again later.'));
  }
});*/
