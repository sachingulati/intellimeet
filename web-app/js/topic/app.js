$(function () {
    // IE10 viewport hack for Surface/desktop Windows 8 bug
    //
    // See Getting Started docs for more information
    if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
        var msViewportStyle = document.createElement("style");
        msViewportStyle.appendChild(
            document.createTextNode(
                "@-ms-viewport{width:auto!important}"
            )
        );
        document.getElementsByTagName("head")[0].
            appendChild(msViewportStyle);
    }


    var $window = $(window);
    var $body = $(document.body);

    var navHeight = $('.navbar').outerHeight(true) + 100;
    var sidebarCategories = $('#sidebar-categories');

    $body.scrollspy({
        target: '.bs-docs-sidebar',
        offset: navHeight
    });

    // back to top
    setTimeout(function () {
        var $sideBar = $('.bs-docs-sidebar');

        $sideBar.affix({
            offset: {
                top: function () {
                    var offsetTop = $sideBar.offset().top;
                    var sideBarMargin = parseInt($sideBar.children(0).css('margin-top'), 10);
                    var navOuterHeight = $('.navbar').height();

                    return (this.top = offsetTop - navOuterHeight - sideBarMargin)
                }, bottom: function () {
                    if (!sidebarCategories.isOnScreen()) {
                        return (this.bottom = $('.bs-docs-footer').outerHeight(true))
                    }
                }
            }
        });
    }, 100);

    setTimeout(function () {
        $('.bs-top').affix()
    }, 100);

    $window.on('load', function () {
        $body.scrollspy('refresh')
    });

    $('.bs-docs-container [href=#]').click(function (e) {
        e.preventDefault()
    });

    $('#search-input').bind('keyup', function () {
        var searchText = $(this).val();
        if (searchText != "") {
            $(".searchable div.zone").parent().hide();
            $('.searchable div.zone').parent(':icontains("' + searchText + '")').show();
        }
        else {
            $(".searchable div.zone").parent().show();
        }
        updateRightNav();
    });

    $.expr[':'].icontains = $.expr.createPseudo(function (text) {
        return function (elem) {
            return $(elem).text().toLowerCase().indexOf(text.trim().toLowerCase()) > -1;
        };
    });

    $('div.desc-content').editable({
        type: 'wysihtml5',
        mode:'inline',
        wysihtml5:{html:true},
        name:'description',
        url: '/api/v1.0/topic/updateDescription',
        error: function(response, newValue) {
        if(response.status === 500) {
            blockUIWithMsg('Service unavailable. Please try later.');
        } else {
            return blockUIWithMsg('Sorry for inconvenience. Please contact site admin.');
        }
    }
    });

});

var searchInTopics = function (input) {
    var searchText = $(this).val();
    if (searchText != "") {
        $(".searchable div.zone").parent().hide();
        $('.searchable div.zone').parent(':icontains("' + searchText + '")').show();
    }
    else {
        $(".searchable div.zone").parent().show();
    }
};

var searchTopicByCategory = function (searchText) {
    if (searchText != "") {
        $(".searchable .topic-entry .category").parents('.entry').hide();
        $('.searchable .topic-entry .category:icontains("' + searchText + '")').parents('.entry').show();
    } else {
        $(".searchable div.zone").parent().show();
    }
    updateRightNav();
};

var updateRightNav = function () {
    $(".bs-docs-sidebar ul.bs-docs-sidenav li").hide();
    $('.searchable .entry:visible .topic').each(function () {
        var idVal = $(this).attr('id');
        $('.bs-docs-sidebar ul.bs-docs-sidenav li>a[href=#' + idVal + ']').parent().show();
    });
}