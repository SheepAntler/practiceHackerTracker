/*
    This simple jQuery function, along with its corresponding sign-up form, is inspired by some
    code snippets I found on this Stack Overflow thread:

    https://stackoverflow.com/questions/37390865/change-form-fields-based-on-dropdown-values

    A big thanks to R4nc1d for creating a working demo for me to play around with, and to
    hemanth kumar for asking about all this in the first place.
 */

$(document).ready(function() {
    $('div.hidden').hide();

    $('#accountTypes').change(function() {
        let value = this.value;
        $('div.hidden').hide();
        $('#' + this.value).show();
    })
});