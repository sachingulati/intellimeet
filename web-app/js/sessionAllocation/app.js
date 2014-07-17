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

    var navHeight = $('.navbar').outerHeight(true) + 10;

    $body.scrollspy({
        target: '.bs-docs-sidebar',
        offset: navHeight
    });

    $window.on('load', function () {
        $body.scrollspy('refresh')
    });

    $('.bs-docs-container [href=#]').click(function (e) {
        e.preventDefault()
    });

    // back to top
    setTimeout(function () {
        var $sideBar = $('.bs-docs-sidebar');

        $sideBar.affix({
            offset: {
                top: function () {
                    var offsetTop      = $sideBar.offset().top;
                    var sideBarMargin  = parseInt($sideBar.children(0).css('margin-top'), 10);
                    var navOuterHeight = $('.bs-docs-nav').height();

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

    $('.bs-docs-navbar').tooltip({
        selector: "a[data-toggle=tooltip]",
        container: ".bs-docs-navbar .nav"
    });

    $('.allocationChck').bind('change', function () {
        var userId = $(this).val();
        var sessionName = $(this).attr('sessionName');
        if ($(this).is(":checked")) {
            $('.user'+userId).attr('disabled', 'disabled').removeClass('unchecked');
            $('.user'+userId+'Span').attr('title', 'Already allocated session:' + sessionName).addClass('locked');
            $(this).parent('span').attr('title', '').removeClass('locked');
            $(this).removeAttr('disabled');
        } else {
            $('.user'+userId).removeAttr('disabled').addClass('unchecked');
            $('.user'+userId+'Span').attr('title', '').removeClass('locked');
        }
    });
});