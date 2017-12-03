$(document).ready(function () {
    //    Center all H1 elements
    $('h1').addClass('text-center');
    //    Center all H2 elements
    $('h2').addClass('text-center');
    //    Replace the class that is on the element containing the text “Team Up!” with the class page-header
    $('.col-md-12').remove();
    $('#myBanner').append('<header class="header" id="header"><h1 id="headerPlaceholder">Team Up</h1></header>' );
    $('#myBanner').css('text-align','center');
    //    Change the text of “The Squad” to “Yellow Team”
    $('div h2').each(function() {
      var text = $(this).text();
      $(this).text(text.replace('The Squad', 'Yellow Team'));
    });
    //    Change the background color for each team list to match the name of the team
    $('#orangeHeading').css('background-color','orange');
    $('#redHeading').css('background-color','red');
    $('#blueHeading').css('background-color','blue');
    $('#yellowHeading').css('background-color','yellow');
    //    Add Joseph Banks and Simon Jones to the Yellow Team list
    $('#yellowTeamList').append('<li> Joseph Banks </li>');
    $('#yellowTeamList').append('<li> Simon Jones </li>');
    //    Hide the element containing the text “Hide Me!!!”
    $('#oops').hide();
    //    Remove the element containing the text “Bogus Contact Info” from the footer
    $('#footerPlaceholder').remove();
    //    Add a paragraph element containing your name and email to the footer. The text must be in Courier font and be 24 pixels in height
    $("#footer").append('<h2><center> Pushpa Gadde pushpa_gadde@yahoo.com </center></h2>');
    $('#footer').css('font-size','24');
    $('#footer').css('font-family','Courier');
});
