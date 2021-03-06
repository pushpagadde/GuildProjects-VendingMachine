$(document).ready(function(){
  $('#errorMessages').empty();
  $('#mainFormDiv').show();
  $('#currentConditionDiv').hide();
  $('#fiveDayForecastDiv').hide();

  $('#weather-button').click(function (event){
    clearAll();
    $('#errorMessages').empty();
    var haveValidationErrors = false;
    var imageLink = "", description = "", temperature = 0, humidity = 0, windSpeed = 0, city = "", zip = "", link = "", tempConvert;
    link = 'http://api.openweathermap.org/data/2.5/weather?zip=';
    imageLink = 'http://openweathermap.org/img/w/';
    haveValidationErrors = checkAndDisplayValidationErrors($('#zipCode').val());
    if (haveValidationErrors) {// if we have errors, bail out by returning false
        displayError();
        return false;
    }else {
      var listItem = $('#units option:selected').text();
      //alert(listItem);
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
                if (detID == "temp"){
                  temperature = detail;
                  if(listItem == "Metric") {
                    tempConvert = (temperature - 32)/(1.8);
                    tempConvert = Math.round(tempConvert,2);
                    temperature = tempConvert + ' C';
                  } else {
                      temperature = "Temperature: "+ temperature + ' F';
                  }
                }
                if (detID == "humidity"){ humidity = detail; humidity = 'Humidity:' + humidity + ' %'; }
              })
            }
            if (title == 'wind'){
              $.each(details, function(detID, detail) {
                if (detID == "speed"){
                    windSpeed = detail;
                    if(listItem == "Metric") {
                      windSpeed = 'Wind Speed: ' + Math.round(detail*1.61,2) + ' KM/hour';
                    }else {
                        windSpeed = 'Wind Speed: ' + windSpeed + ' miles/hour';
                    }
                  }
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
                      $.each(listItemDetails, function(tempID, temperatureDetails) {
                        if(tempID == 'min') {
                          if(listItem == "Metric") {
                            tempConvert = (temperatureDetails - 32)/(1.8);
                            tempConvert = Math.round(tempConvert,2);
                            temperatureTemp = 'Low: ' + tempConvert + ' C';
                          } else {
                              temperatureTemp = 'Low: ' + temperatureDetails + ' F';
                          }
                        }
                        if(tempID == 'max') {
                          if(listItem == "Metric"){
                            temperatureDetails = (temperatureDetails - 32)/(1.8);
                            tempConvert = Math.round(temperatureDetails,2);
                            temperatureTemp += ' High: ' + tempConvert + ' C';
                          }else {
                              temperatureTemp = temperatureTemp + ' High: ' + temperatureDetails + ' F';
                          }
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
