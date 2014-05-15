if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('.recipient-survey-stat .rs-nav li a').on('click', function () {
            $('.recipient-survey-stat .rs-nav li').removeClass('active');
            $(this).parents('li').addClass('active');
            var trigger = $(this).data('trigger');
            switch (trigger) {
                case 'all':
                    filterRecipients([]);
                    break;
                case 'completed':
                    filterRecipients(['COMPLETED']);
                    break;
                case 'waiting':
                    filterRecipients(['SENT', 'PENDING']);
                    break;
            }
        });
    })(jQuery);
}
var filterRecipients = function (stats) {
    console.log('filtering...');
    var $emailLis = $('.recipient-survey-stat .attendee-list li');
    $emailLis.hide();
    if (stats.length) {
        for (var i in stats) {
            $('.recipient-survey-stat .attendee-list li.' + stats[i]).show();
        }
    } else {
        $emailLis.show();
    }
};