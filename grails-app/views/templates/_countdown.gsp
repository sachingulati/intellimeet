<r:require module="jquery_countdown" />
<div id="countdown"></div>
<r:script>
    $('#countdown').countdown('${dateString}', function(event) {
        $(this).html(event.strftime('%w weeks %d days <br /> %H:%M:%S'));
    });
</r:script>