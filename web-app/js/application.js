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
