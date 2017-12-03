$(document).ready(function () {
//Page Load-Only the content in the Main section should display when the page is loaded.
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
    $(".table tr").not(':first').hover(
      //in function
      function () {
        $(this).css('background-color','WhiteSmoke');//addClass("selected");
      },
      //out function
      function () {
        $(this).css('background-color','');//removeClass("selected");
      }
    );
//main info button click
    $('#mainButton').click(function() {
      $('#mainInfoDiv').show();
      $('#minneapolisInfoDiv').hide();
      $('#louisvilleInfoDiv').hide();
      $('#akronInfoDiv').hide();
    });
//akron info button click
    $('#akronButton').click(function() {
      $('#mainInfoDiv').hide();
      $('#akronWeather').hide();
      $('#akronInfoDiv').show();
      $('#louisvilleInfoDiv').hide();
      $('#minneapolisInfoDiv').hide();
    });
//toggel akron wheather Button
    $('#akronWeatherButton').on('click', function() {
      $('#akronWeather').toggle();
      $('#akronWeatherButton').html('Show/Hide Weather');
    });
//minneapolis info button click
    $('#minneapolisButton').click(function() {
      $('#mainInfoDiv').hide();
      $('#minneapolisWeather').hide();
      $('#minneapolisInfoDiv').show();
      $('#louisvilleInfoDiv').hide();
      $('#akronInfoDiv').hide();
    });
//toggel minneapolis wheather Button
    $('#minneapolisWeatherButton').on('click', function() {
      $('#minneapolisWeather').toggle();
      $('#minneapolisWeatherButton').html('Show/Hide Weather');
    });
//louisville info button click
    $('#louisvilleButton').click(function() {
      $('#mainInfoDiv').hide();
      $('#louisvilleWeather').hide();
      $('#louisvilleInfoDiv').show();
      $('#minneapolisInfoDiv').hide();
      $('#akronInfoDiv').hide();
    });
//toggel louisville wheather Button
    $('#louisvilleWeatherButton').on('click', function() {
      $('#louisvilleWeather').toggle();
      $('#louisvilleWeatherButton').html('Show/Hide Weather');
    });
});
