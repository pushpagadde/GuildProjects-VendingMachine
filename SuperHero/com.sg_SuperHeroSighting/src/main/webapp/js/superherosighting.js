/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
   
    $('#locationN').change(function() {    
        alert("js");
        loadLocation();
    });
    
});

function loadLocation(){
    var locid = '/SuperHeroSighting/sightingEditPageJasonCall/'  + $("#locationID").val();
   $.ajax({
        type: 'POST',
        url: locid,
        
        success:function(locationInfo) {
            $('#locationAddress').text(locationInfo.address );
            $('#latitude').text(locationInfo.latitude );
            $('#longitude').text(locationInfo.longitude );
            $('#zipCode').text(locationInfo.zipCode);  
            alert(locationInfo);
        },
        error: function(){
            alert("fail");
        }
        
        
    });
}