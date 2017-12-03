$(document).ready(function(){
  $('#errorMessages').empty();
  $('#mainFormDiv').show();
  $('#currentConditionDiv').hide();
  $('#fiveDayForecastDiv').hide();

  $('#weather-button').click(function (event){
    clearAll();
    $('#errorMessages').empty();
    var haveValidationErrors = false;
    var imageLink = "", description = "", temperature = 0, humidity = 0, windSpeed = 0, city = "", zip = "", link = "";
    link = 'http://api.openweathermap.org/data/2.5/weather?zip=';
    imageLink = 'http://openweathermap.org/img/w/';
    haveValidationErrors = checkAndDisplayValidationErrors($('#zipCode').val());
    if (haveValidationErrors) {// if we have errors, bail out by returning false
        displayError();
        return false;
    }else {
      $('#currentConditionDiv').show();
      $('#fiveDayForecastDiv').show();
      zip = $('#zipCode').val();
      link= link + zip;
      link = link +',us&appid=c797b0d47332a3e16a4cca24ddc1070d';
      $.ajax ({
        type: "GET",
        url: link,
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        success: function(detailsArray){
          $.each(detailsArray, function(title, details) {
            if (title == 'weather'){
              $.each(details, function(detID, detail) {
                $.each(detail, function(subDetID, subDetail) {
                  if (subDetID == 'icon'){
                    imageLink = imageLink + subDetail;
                    imageLink = imageLink + ".png";//&appid=c797b0d47332a3e16a4cca24ddc1070d';
                  }
                  if (subDetID == 'description'){ description = subDetail;  }
                })
              })
            }
            if (title == 'name'){
              city = "Current Condition in: "+ details;
            }
            if (title == 'main'){
              $.each(details, function(detID, detail) {
                if (detID == "temp"){ temperature = detail; temperature = "Temperature: "+ temperature + ' F'; }
                if (detID == "humidity"){ humidity = detail; humidity = 'Humidity:' + humidity + ' %'; }
              })
            }
            if (title == 'wind'){
              $.each(details, function(detID, detail) {
                if (detID == "speed"){  windSpeed = detail; windSpeed = 'Wind Speed: ' + windSpeed + ' miles/hour'; }
              })
            }
          });
          clearAll();
          //$('#currentConditionHeading').append(city);
          var img = $('<img />',{id: 'currentConditionImage', src:imageLink }).appendTo($('#tableRow1'));
          $('#weatherDescription').append(description);
          $('#temp').append(temperature);
          $('#humidity').append(humidity);
          $('#wind').append(windSpeed);
          $('#city').append(city);
        },
        error: function(){
            alert('error');
            clearAll();
            $('#currentConditionDiv').hide();
            $('#fiveDayForecastDiv').hide();

        }
      });
      var forecastLink = "", forecastDate = [], forecastImage = [], forecastDescription = [], forecastTemperature = [];
      var img1 = "", img2 = "", img3 = "",img4 = "" ,img5 = "";
      forecastLink = 'http://samples.openweathermap.org/data/2.5/forecast/daily?zip=94040&appid=b1b15e88fa797225412429c1c50c122a1';
      var forecastImageTemp="";
      var temperatureTemp='';
      var m_names = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
      forecastImageTemp = 'http://openweathermap.org/img/w/';
      $.ajax ({
        type: "GET",
        url: forecastLink,
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        success: function(forecastDetailsArray){
          $.each(forecastDetailsArray, function(title, details) {
            if(title == 'list'){
                $.each(details, function(listIndex, listDetails) {
                  $.each(listDetails, function(listItemId, listItemDetails) {
                    if (listItemId == "dt"){
                      var date = new Date(listItemDetails*1000);
                      var curr_date = date.getDate();
                      var curr_month = date.getMonth();
                      date = curr_date +  " " + m_names[curr_month];
                      forecastDate.push(date);
                    } else if (listItemId == "temp"){
                      temperatureTemp = "";
                      $.each(listItemDetails, function(tempID, temparatureDetails) {
                        if(tempID == 'min') {
                          temperatureTemp = 'Low: ' + temparatureDetails + ' F';
                        }
                        if(tempID == 'max') {
                          temperatureTemp = temperatureTemp + ' High: ' + temparatureDetails + ' F';
                          forecastTemperature.push(temperatureTemp);
                        }
                      });
                    } else if (listItemId == 'weather'){
                      $.each(listItemDetails, function(detID, detail) {
                          if (detID == 0){
                            $.each(detail, function(subDetID, subDetail) {
                              if( subDetID == 'icon') {
                                orecastImageTemp = subDetail;
                                forecastImage.push(forecastImageTemp + subDetail +".png");
                              }
                              if( subDetID == 'main') {
                                forecastDescription.push(subDetail);
                              }
                            });
                          }
                      });
                    }
                  });
                });
            }
          });
          $('#currentConditionHeading').append( city);

          $('#date1').append(forecastDate[0]);
          img1 = $('<img />',{id: 'day1ForecastImage', src:forecastImage[0] }).appendTo($('#tableColumn1'));
          $('#weatherDescription1').append(forecastDescription[0]);
          $('#temperature1').append(forecastTemperature[0]);

          $('#date2').append(forecastDate[1]);
          img2 = $('<img />',{id: 'day2ForecastImage', src:forecastImage[1] }).appendTo($('#tableColumn2'));
          $('#weatherDescription2').append(forecastDescription[1]);
          $('#temperature2').append(forecastTemperature[1]);

          $('#date3').append(forecastDate[2]);
          img3 = $('<img />',{id: 'day3ForecastImage', src:forecastImage[2] }).appendTo($('#tableColumn3'));
          $('#weatherDescription3').append(forecastDescription[2]);
          $('#temperature3').append(forecastTemperature[2]);

          $('#date4').append(forecastDate[3]);
          img4 = $('<img />',{id: 'day4ForecastImage', src:forecastImage[3] }).appendTo($('#tableColumn4'));
          $('#weatherDescription4').append(forecastDescription[3]);
          $('#temperature4').append(forecastTemperature[3]);

          $('#date5').append(forecastDate[4]);
          img5 = $('<img />',{id: 'day5ForecastImage', src:forecastImage[4] }).appendTo($('#tableColumn5'));
          $('#weatherDescription5').append(forecastDescription[4]);
          $('#temperature5').append(forecastTemperature[4]);
        },
        error: function(){
            alert('error');
            clearAll();
            $('#currentConditionDiv').hide();
            $('#fiveDayForecastDiv').hide();

        }
      });
    }
  });
});

function clearAll(){
  $('#currentConditionImage').html("");
  $('#tableColumn1').html("");
  $('#tableColumn2').html("");
  $('#tableColumn3').html("");
  $('#tableColumn4').html("");
  $('#tableColumn5').html("");
  $('#temp').html("");
  $('#weatherDescription').html("");
  $('#currentConditionHeading').empty();
  $('#weatherDescription').empty();
  $('#temp').empty();
  $('#humidity').empty();
  $('#wind').empty();
  $('#city').empty();
  $('#tableRow1').empty();
  $('#date1').empty();
  $('#weatherDescription1').empty();
  $('#temperature1').empty();
  $('#day1ForecastImage').html("");
  $('#tableRow2').empty();
  $('#date2').empty();
  $('#weatherDescription2').empty();
  $('#temperature2').empty();
  $('#day2ForecastImage').html("");
  $('#tableRow3').empty();
  $('#date3').empty();
  $('#weatherDescription3').empty();
  $('#temperature3').empty();
  $('#day3ForecastImage').html("");
  $('#tableRow4').empty();
  $('#date4').empty();
  $('#weatherDescription4').empty();
  $('#temperature4').empty();
  $('#day4ForecastImage').html("");
  $('#tableRow5').empty();
  $('#date5').empty();
  $('#weatherDescription5').empty();
  $('#temperature5').empty();
  $('#day5ForecastImage').html("");
}

function displayError(){
  $('#errorMessages')
     .append($('<li>')
     .attr({class: 'list-group-item list-group-item-danger'})
     .text(''));//Error calling web service.  Please try again later.
}

function checkAndDisplayValidationErrors(input) {
  $('#errorMessages').empty();     // clear displayed error message if there are any
  var errorMessages = [];// check for HTML5 validation errors and process/display appropriately a place to hold error messages
  if(input.length != 5 ){
    errorMessages.push("Zip Code: Please enter 5 digit zip code");
  }
  if (errorMessages.length > 0){    // put any error messages in the errorMessages div
      $.each(errorMessages,function(index,message){
          $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text(message));
      });
      return true;  // return true, indicating that there were errors
  } else {
      return false;// return false, indicating that there were no errors
  }
}


/*
loadContacts();
$('#add-button').click(function (event) {// Add Button onclick handler
    // check for errors and display any that we have pass the input associated with the add form to the validation function
    var haveValidationErrors = checkAndDisplayValidationErrors($('#add-form').find('input'));
    if (haveValidationErrors) {// if we have errors, bail out by returning false
        return false;
    }
    $.ajax({// if we made it here, there are no errors so make the ajax call
        type: 'POST', url: 'http://localhost:8080/contact',
        data: JSON.stringify({
            firstName: $('#add-first-name').val(),
            lastName: $('#add-last-name').val(),
            company: $('#add-company').val(),
            phone: $('#add-phone').val(),
            email: $('#add-email').val()
        }),
        headers: {'Accept': 'application/json','Content-Type': 'application/json'},
        'dataType': 'json',
        success: function() {
            $('#errorMessages').empty();// clear errorMessages
            $('#add-first-name').val('');// Clear the form and reload the table
            $('#add-last-name').val('');
            $('#add-company').val('');
            $('#add-phone').val('');
            $('#add-email').val('');
            loadContacts();
        },
    });
});
$('#edit-button').click(function (event) {// Update Button onclick handler
    // check for errors and display any that we have pass the input associated with the edit form to the validation function
    var haveValidationErrors = checkAndDisplayValidationErrors($('#edit-form').find('input'));
    if (haveValidationErrors) {// if we have errors, bail out by returning false
        return false;
    }
    $.ajax({// if we get to here, there were no errors, so make the Ajax call
      type: 'PUT', url: 'http://localhost:8080/contact/' + $('#edit-contact-id').val(),
      data: JSON.stringify({
        contactId: $('#edit-contact-id').val(),
        firstName: $('#edit-first-name').val(),
        lastName: $('#edit-last-name').val(),
        company: $('#edit-company').val(),
        email: $('#edit-email').val(),
        phone: $('#edit-phone').val()
      }),
      headers: {'Accept': 'application/json','Content-Type': 'application/json'},
      'dataType': 'json',
      success: function() {
          $('#errorMessages').empty();// clear errorMessages
          hideEditForm(); loadContacts();
      },
      error: function() {
       $('#errorMessages')
          .append($('<li>')
          .attr({class: 'list-group-item list-group-item-danger'})
          .text('Error calling web service.  Please try again later.'));
      }
  })
});
});

function loadContacts() {
clearContactTable();  // we need to clear the previous content so we don't append to it
var contentRows = $('#contentRows');// grab the the tbody element that will hold the rows of contact information
$.ajax ({
    type: "GET", url: "http://localhost:8080/contacts", dataType: "json",
    contentType: "application/x-www-form-urlencoded",
    success: function(contactArray) {
        $.each(contactArray, function (index, contact) {
            var name = contact.firstName + ' ' + contact.lastName;
            var company = contact.company;
            var id = contact.contactId;
            var row = '<tr>';
                row += '<td>' + name + '</td>';
                row += '<td>' + company + '</td>';
                row += '<td><a onclick="showEditForm(' + id + ')">Edit</a></td>';
                row += '<td><a onclick="deleteContact(' + id + ')">Delete</a></td>';
                row += '</tr>';
            contentRows.append(row);
        });
    },
    error: function() {
      $('#errorMessages')
          .append($('<li>')
          .attr({class: 'list-group-item list-group-item-danger'})
          .text('Error calling web service.  Please try again later.'));
    }
});
}

function deleteContact(contactId) {
$.ajax ({
    type: 'DELETE', url: "http://localhost:8080/contact/" + contactId,
    success: function (status) {loadContacts();}});}

function clearContactTable() {$('#contentRows').empty();}

function showEditForm(contactId) {
$('#errorMessages').empty();// clear errorMessages
$.ajax({// get the contact details from the server and then fill and show the form on success
    type: 'GET', url: 'http://localhost:8080/contact/' + contactId,
    success: function(data, status) {
          $('#edit-first-name').val(data.firstName);$('#edit-last-name').val(data.lastName);
          $('#edit-company').val(data.company);$('#edit-email').val(data.email);
          $('#edit-phone').val(data.phone);$('#edit-contact-id').val(data.contactId);
      },
      error: function() {
        $('#errorMessages')
           .append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text('Error calling web service.  Please try again later.'));
      }
});
$('#contactTableDiv').hide(); $('#editFormDiv').show();}
function hideEditForm() {
$('#errorMessages').empty();// clear errorMessages
$('#edit-first-name').val('');// clear the form and then hide it
$('#edit-last-name').val('');$('#edit-company').val('');$('#edit-phone').val('');$('#edit-email').val('');
$('#editFormDiv').hide();$('#contactTableDiv').show();
}

*/
