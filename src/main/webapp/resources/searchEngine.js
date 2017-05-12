/**
 * Created by dR3wD on 12.05.2017.
 */
$(document).ready(function() {
    $('#searchRef').click(function() {
        var searchString;
        searchString = $('#searchIn').val();
        window.location.href="http://www.localhost:8080/find/"+searchString;
    });
});