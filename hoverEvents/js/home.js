$(document).ready(function(){

    // wire up the toggleNumbers button
    $('#toggleNumbers').on('click', function() {
       $('h2').toggle('slow');
    });

    //center all items on screen
    $('#centerUp').on('click', function() {
      $('h1').addClass('text-center');
      $('h2').addClass('text-center');
      $('#buttonDiv').addClass('text-center');
    });

    $('#headingsBlue').on('click', function() {
      $('h1').css('color','blue');
      $('h2').css('color','blue');
    });

    $('div').hover(
      //in fucntion
      function() {
        $(this).css('background-color','cornflowerBlue');
        //$(this).css('color','purple');
      },
      //out function
      function() {
        $(this).css('background-color','');
      });

    $('h2').hover(
      //in function
      function() {
        $(this).css('color','DarkOrange');
      },
      //out function
      function() {
        $(this).css('color','');
      });

      $('#mainHeading').hover(
        //in function
        function() {
          $(this).css('color','yellow');
        },
        //out function
        function() {
          $(this).css('color','pink');
        });

});
