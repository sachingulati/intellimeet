$(function() {
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
    var $body   = $(document.body);

    var navHeight = $('.navbar').outerHeight(true)+100;

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
                    var offsetTop      = $sideBar.offset().top;
                    var sideBarMargin  = parseInt($sideBar.children(0).css('margin-top'), 10);
                    var navOuterHeight = $('.navbar').height();

                    return (this.top = offsetTop - navOuterHeight - sideBarMargin)
                }
                , bottom: function () {
                    return (this.bottom = $('.bs-footer').outerHeight(true))
                }
            }
        })
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
            $(".searchable div[id^=topic]").parent().hide();
            $('.searchable div[id^=topic]').parent(':icontains("' + searchText + '")').show();
        }
        else {
            $(".searchable div[id^=topic]").parent().show();
        }
    });

    $.expr[':'].icontains = $.expr.createPseudo(function (text) {
        return function (elem) {
            return $(elem).text().toLowerCase().indexOf(text.trim().toLowerCase()) > -1;
        };
    });

});

var searchInTopics = function(input) {
    var searchText = $(this).val();
    if (searchText != "") {
        $(".searchable div[id^=topic]").parent().hide();
        $('.searchable div[id^=topic]').parent(':icontains("' + searchText + '")').show();
    }
    else {
        $(".searchable div[id^=topic]").parent().show();
    }
}