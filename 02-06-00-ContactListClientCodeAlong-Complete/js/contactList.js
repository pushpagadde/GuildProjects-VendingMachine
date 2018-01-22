$(document).ready(function () {
    loadContacts();
    $('#add-button').click(function (event) {// Add Button onclick handler
        // check for errors and display any that we have pass the input associated with the add form to the validation function
        var haveValidationErrors = checkAndDisplayValidationErrors($('#add-form').find('input'));
        if (haveValidationErrors) {// if we have errors, bail out by returning false
            return false;
        }
        $.ajax({// if we made it here, there are no errors so make the ajax call
            type: 'POST', url: 'http://localhost:8080/ContactListSpringMVC/contact',
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
            error: function() {
                $('#errorMessages')
                   .append($('<li>')
                   .attr({class: 'list-group-item list-group-item-danger'})
                   .text('Error calling web service.  Please try again later.'));
            }
        });
    });
    $('#edit-button').click(function (event) {// Update Button onclick handler
        // check for errors and display any that we have pass the input associated with the edit form to the validation function
        var haveValidationErrors = checkAndDisplayValidationErrors($('#edit-form').find('input'));
        if (haveValidationErrors) {// if we have errors, bail out by returning false
            return false;
        }
        $.ajax({// if we get to here, there were no errors, so make the Ajax call
          type: 'PUT', url: 'http://localhost:8080/ContactListSpringMVC/contact/' + $('#edit-contact-id').val(),
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
        type: "GET", url: "http://localhost:8080/ContactListSpringMVC/contacts", dataType: "json",
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
        type: 'DELETE', url: "http://localhost:8080/ContactListSpringMVC/contact/" + contactId,
        success: function (status) {
            loadContacts();
        }
    });
}

function clearContactTable() {
    $('#contentRows').empty();
}

function showEditForm(contactId) {
    $('#errorMessages').empty();// clear errorMessages
    $.ajax({// get the contact details from the server and then fill and show the form on success
        type: 'GET', url: 'http://localhost:8080/ContactListSpringMVC/contact/' + contactId,
        success: function(data, status) {
              $('#edit-first-name').val(data.firstName);
              $('#edit-last-name').val(data.lastName);
              $('#edit-company').val(data.company);
              $('#edit-email').val(data.email);
              $('#edit-phone').val(data.phone);
              $('#edit-contact-id').val(data.contactId);
          },
          error: function() {
            $('#errorMessages')
               .append($('<li>')
               .attr({class: 'list-group-item list-group-item-danger'})
               .text('Error calling web service.  Please try again later.'));
          }
    });
    $('#contactTableDiv').hide(); $('#editFormDiv').show();
}
function hideEditForm() {
    $('#errorMessages').empty();// clear errorMessages
    $('#edit-first-name').val('');// clear the form and then hide it
    $('#edit-last-name').val('');
    $('#edit-company').val('');
    $('#edit-phone').val('');
    $('#edit-email').val('');
    $('#editFormDiv').hide();
    $('#contactTableDiv').show();
}

function checkAndDisplayValidationErrors(input) {
    $('#errorMessages').empty();     // clear displayed error message if there are any
    var errorMessages = [];// check for HTML5 validation errors and process/display appropriately a place to hold error messages
    input.each(function() {// loop through each input and check for validation errors
        if(!this.validity.valid)// Use the HTML5 validation API to find the validation errors
        {
            var errorField = $('label[for='+this.id+']').text();
            errorMessages.push(errorField + ' ' + this.validationMessage);
        }
    });
    if (errorMessages.length > 0){    // put any error messages in the errorMessages div
        $.each(errorMessages,function(index,message){
            $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text(message));
        });
        return true;  // return true, indicating that there were errors
    } else {
        return false;// return false, indicating that there were no errors
    }
}
