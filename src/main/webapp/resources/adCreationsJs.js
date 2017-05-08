/**
 * Created by dR3wD on 08.05.2017.
 */
$(document).ready(function() {
    $('#bookCreationDiv').hide();
    $('#authorCreationDiv').hide();

    $('#requireNewBookBox').change(function() {
        if(this.checked){
            $('#bookCreationDiv').show('slow');
            $('#selectBook').hide('slow');
            $('#requireNewBookBox').val('true');
        }else{
            $('#bookCreationDiv').hide('slow');
            $('#selectBook').show('slow');
            $('#requireNewBookBox').val('false');
        }
    });

    $('#requireNewAuthorBox').change(function() {
        if(this.checked) {
            $('#authorCreationDiv').show('slow');
            $('#selectAuthor').hide('slow');
            $('#requireNewAuthorBox').val('true');
        }else{
            $('#authorCreationDiv').hide('slow');
            $('#selectAuthor').show('slow');
            $('#requireNewAuthorBox').val('false');
        }
    });

    $('#typeSelection').change(function() {
        var selected = $(this).find("option:selected");
        if(selected.val().localeCompare("sell") !== 0){
            $('#priceInput').hide('slow');
        }else{
            $('#priceInput').show('slow');
        }
    })
});