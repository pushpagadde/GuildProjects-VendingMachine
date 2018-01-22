/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {



});

function fillDVDTable(data) {
    // we need to clear the previous content so we don't append to it
    clearDVDTable();

    // grab the the tbody element that will hold the rows of contact information
    var contentRows = $('#contentRows');

    $.each(data, function (index, dvd) {
        var title = dvd.title;
        var releaseYear = dvd.releaseYear;
        var director = dvd.director;
        var rating = dvd.rating;
        var notes = dvd.notes;

        var row = '<tr>';
        row += '<td>' + title + '</td>';
        row += '<td>' + releaseYear + '</td>';
        row += '<td>' + director + '</td>';
        row += '<td>' + rating + '</td>';
        row += '<td>' + notes + '</td>';
        row += '</tr>';
        contentRows.append(row);
    });
}

function clearDVDTable() {
    $('#contentRows').empty();
 } 

/*
 

    // Add Button onclick handler
    $('#search-button').click(function (event) {

        $.ajax({
            type: 'POST',
            url: 'search/contacts',
            data: JSON.stringify({
                firstName: $('#search-first-name').val(),
                lastName: $('#search-last-name').val(),
                company: $('#search-company').val(),
                phone: $('#search-phone').val(),
                email: $('#search-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function (data) {
                // clear errorMessages
                $('#errorMessages').empty();
                fillContactTable(data);
            },
            error: function () {
                $('#errorMessages')
                        .append($('<li>')
                                .attr({class: 'list-group-item list-group-item-danger'})
                                .text('Error calling web service.  Please try again later.'));
            }
        });
    });
});
 */