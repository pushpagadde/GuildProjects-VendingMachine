$(document).ready(function(){

  clearAll();
  var itemsList = $('#contentRows');
  var priceList = [], nameList = [], quantityList = [] ;
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
        var itemQuantity = "Quantity: " + itemInfo.quantity;
        var row = '<tr>';
            row += '<td align="left>' + itemNumber + '</td></tr>';
            row += '<tr><td align="center">' + itemName + '</td></tr>';
            row += '<tr><td align="center">' + Number(itemPrice).toFixed(2) + '</td></tr>';
            row += '<tr><td align="center">' + itemQuantity + '</td></tr>';
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
      $('#errorMessages')
          .append($('<li>')
          .attr({class: 'list-group-item list-group-item-danger'})
          .text('Error calling web service.  Please try again later.'));
    }
  });
  var totalAmountEntered='0' ;
  $('#button1').click(function(){
    alert('1');
    buttonClick('1');
  });
  $('#button2').click(function(){
    alert("2");
    buttonClick('2');
  });
  $('#button3').click(function(){
    alert("3");
    buttonClick('3');
  });
  $('#button4').click(function(){
    alert("4");
    buttonClick('4');
  });
  $('#button5').click(function(){
    alert("5");
    buttonClick('5');
  });
  $('#button6').click(function(){
    alert("6");
    buttonClick('6');
  });
  $('#button7').click(function(){
    alert("7");
    buttonClick('7');
  });
  $('#button8').click(function(){
    alert("8");
    buttonClick('8');
  });
  $('#button9').click(function(){
    alert("9");
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

});
function buttonClick(buttonNumber){
  alert("ButtonNumber:"+buttonNumber);
  $('#itemPurchased').val('');
  $('#itemPurchased').append('ok');
  //$('#itemPurchased').attr('id').append(buttonNumber);
  alert($('#itemPurchased').attr('id'));
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
