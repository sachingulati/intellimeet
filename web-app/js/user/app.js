$(function() {
    $('span.toggleAccountEnable').on('click', function() {
        var id = $(this).data('userid');
        var elem = this;
        var jqxhr = $.post("/user/toggleAccount/"+id);
        jqxhr.done(function() {
            $(elem).toggleClass('fa-check-square-o');
            $(elem).toggleClass('fa-square-o');
        });
    });
});