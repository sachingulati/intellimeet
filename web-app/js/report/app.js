$(function () {
    // portfolio

    var $isotopeWrapper = $('.isotopeWrapper');
    if ($isotopeWrapper.length) {

        var $container = $isotopeWrapper;
        var $resize = $isotopeWrapper.attr('id');
        // initialize isotope

        $container.isotope({
            itemSelector: '.isotopeItem',
            resizable: false, // disable normal resizing
            masonry: {
                columnWidth: $container.width() / $resize
            }
        });

        var $filterAnchor = $('#filter').find('a');
        $filterAnchor.click(function () {
            $filterAnchor.removeClass('current');
            $(this).addClass('current');
            var selector = $(this).attr('data-filter');
            $container.isotope({
                filter: selector,
                animationOptions: {
                    duration: 1000,
                    easing: 'easeOutQuart',
                    queue: false
                }
            });
            return false;
        });

        $(window).smartresize(function () {
            $container.isotope({
                // update columnWidth to a percentage of container width
                masonry: {
                    columnWidth: $container.width() / $resize
                }
            });
        });
    }


    // fancybox
    $(".fancybox").fancybox();
    $("#public-nav").find("li a").on('click', function(){
        var $anchor=$(this);
        $("#public-nav").find("li").removeClass("active");
        $anchor.parents("li").addClass("active");
    });
});