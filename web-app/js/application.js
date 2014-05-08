if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});

        $('.pagination').children().wrapAll('<ul class="pagination">');
        $('.pagination ul').children().wrap('<li>');
        $('.sortable.sorted.asc a').append("\&nbsp\;<span class='glyphicon glyphicon-sort-by-alphabet'></span><i class='cicon-sort-asc'></i>");
        $('.sortable.sorted.desc a').append("\&nbsp\;<span class='glyphicon glyphicon-sort-by-alphabet-alt'></span><i class='cicon-sort-desc'></i>");
    })(jQuery);
}

var markAsActive = function(id) {
    $("li#"+id).siblings().removeClass("active");
    $("li#"+id).addClass("active");
};

var blockUIWithMsg = function(msg) {
    $.blockUI({
        message: msg,
        css: {
        border: 'none',
        padding: '15px',
        backgroundColor: '#000',
        '-webkit-border-radius': '10px',
        '-moz-border-radius': '10px',
        opacity: .5,
        color: '#fff'
    } });
    setTimeout($.unblockUI, 2000);
};

$.fn.isOnScreen = function(){

    var win = $(window);

    var viewport = {
        top : win.scrollTop(),
        left : win.scrollLeft()
    };
    viewport.right = viewport.left + win.width();
    viewport.bottom = viewport.top + win.height();

    var bounds = this.offset();
    bounds.right = bounds.left + this.outerWidth();
    bounds.bottom = bounds.top + this.outerHeight();

    return (!(viewport.right < bounds.left || viewport.left > bounds.right || viewport.bottom < bounds.top || viewport.top > bounds.bottom));

};