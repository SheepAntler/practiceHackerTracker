$(document).ready(function() {
    $('div.hidden').hide();

    $('#accountTypes').change(function() {
        let value = this.value;
        $('div.hidden').hide();
        $('#' + this.value).show();
    })
});