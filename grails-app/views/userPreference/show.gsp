<!DOCTYPE html>
<!--[if IE 8 ]>
<html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]>
<html class="ie ie9" lang="en"> <![endif]-->
<html lang="en">
<!--<![endif]-->
<head>

    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <title>IntelliMeet Preference Survey</title>
    <meta name="description" content="">
    <meta name="author" content="Puneet">

    <!-- Favicons-->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="apple-touch-icon" type="image/x-icon" href="img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114"
          href="img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144"
          href="img/apple-touch-icon-144x144-precomposed.png">

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Google web font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800,300' rel='stylesheet' type='text/css'>
    <r:require module="survey"/>
    <r:layoutResources/>
</head>

<body>

<section id="top-area">
    <header>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-xs-3 navbar-header"><a href="#" class="navbar-brand">IntelliMeet</a></div>

                <div class="btn-responsive-menu"><span class="bar"></span> <span class="bar"></span> <span
                        class="bar"></span></div>

                <nav class="col-md-8 col-xs-9" id="top-nav">
                    <ul>
                    </ul>

                </nav>
                <!-- End Nav -->

            </div>
            <!-- End row -->
        </div>
        <!-- End container -->
    </header>
    <!-- End header -->

    <div class="container">
        <div class="row">
            <div class="col-md-12 main-title">
                <h1>Preference survey</h1>

                <p>Please select your first, second and third preferences.</p>
            </div>
        </div>
    </div>
</section>

<section class="container" id="main">

<!-- Start Survey container -->
<div id="survey_container">

    <div id="top-wizard">
        <strong>Progress <span id="location"></span></strong>

        <div id="progressbar"></div>

        <div class="shadow"></div>
    </div>
    <!-- end top-wizard -->

    <form name="example-1" id="wrapped" action="survey_send_1.php" method="POST">
        <div id="middle-wizard">
            <div class="step row">
                <div class="col-md-10">
                    <h3>First Preference</h3>
                    <ul class="data-list-2">
                        <g:each in="${sessions}" var="session">
                            <li><input name="firstPreferredSessionId" type="radio" class="required check_radio"
                                       value="0"><label>${session?.title} by ${session?.ownersEmail}</label></li>
                        </g:each>
                    </ul>
                </div>
            </div>
            <!-- end step -->


            <div class="step row">
                <div class="col-md-10">
                    <h3>Second Preference</h3>
                    <ul class="data-list-2">
                        <g:each in="${sessions}" var="session">
                            <li><input name="secondPreferredSessionId" type="radio" class="required check_radio"
                                       value="0"><label>${session?.title} by ${session?.ownersEmail}</label></li>
                        </g:each>
                    </ul>
                </div>
            </div>
            <!-- end step -->


            <div class="step row">
                <div class="col-md-10">
                    <h3>Third Preference</h3>
                    <ul class="data-list-2">
                        <g:each in="${sessions}" var="session">
                            <li><input name="thirdPreferredSessionId" type="radio" class="required check_radio" value="0"><label>${session?.title} by ${session?.ownersEmail}</label></li>
                        </g:each>
                    </ul>
                </div>
            </div>
            <!-- end step -->

            <div class="submit step" id="complete">

                <i class="fa fa-check-square-o"></i>

                <h3>Survey complete! Please submit & Thank you for you time.</h3>
                <button type="submit" name="process" class="submit">Submit the survey</button>
            </div>
            <!-- end submit step -->

        </div>
        <!-- end middle-wizard -->

        <div id="bottom-wizard">
            <button type="button" name="backward" class="backward">Backward</button>
            <button type="button" name="forward" class="forward">Forward</button>
        </div>
        <!-- end bottom-wizard -->
    </form>

</div>
<!-- end Survey container -->

<div class="row">
    <div class="col-md-12">
        <h2>Thank you for your time<span>This help us to improve our service and customer satisfaction.</span></h2>
    </div>
</div>
<!-- end row -->

<div class="row">

    <div class="col-md-4 col-sm-4 add_bottom_30 box">
        <p><img src="http://www.ansonika.com/annova/img/icon-1.png" alt="Icon"></p>

        <h3>Fully responsive</h3>

        <p>
            Lorem ipsum dolor sit amet, in porro albucius qui, in nec quod novum accumsan, mei ludus tamquam dolores id.
            No sit debitis meliore postulant, per ex prompta alterum sanctus, pro ne quod dicunt sensibus.
        </p>
        <a href="#" title="read more" class="button_medium_2">Read more</a>
    </div>

    <div class="col-md-4 col-sm-4 add_bottom_30 box">
        <p><img src="http://www.ansonika.com/annova/img/icon-2.png" alt="Icon"></p>

        <h3>Useful survey data</h3>

        <p>
            Lorem ipsum dolor sit amet, in porro albucius qui, in nec quod novum accumsan, mei ludus tamquam dolores id.
            No sit debitis meliore postulant, per ex prompta alterum sanctus, pro ne quod dicunt sensibus.
        </p>
        <a href="#" title="read more" class="button_medium_2">Read more</a>
    </div>

    <div class="col-md-4 col-sm-4 add_bottom_30 box">
        <p><img src="http://www.ansonika.com/annova/img/icon-3.png" alt="Icon"></p>

        <h3>Receive it by email</h3>

        <p>
            Lorem ipsum dolor sit amet, in porro albucius qui, in nec quod novum accumsan, mei ludus tamquam dolores id.
            No sit debitis meliore postulant, per ex prompta alterum sanctus, pro ne quod dicunt sensibus.
        </p>
        <a href="#" title="read more" class="button_medium_2">Read more</a>
    </div>

</div>
<!-- end row -->

<div class="divider"></div>

<div class="row">
    <div class="col-md-12">
        <h3>About us<span>This help us to improve our service and customer satisfaction.</span></h3>
    </div>
</div>
<!-- end row -->

<div class="row">

    <div class="col-md-6">
        <h4>Our History</h4>

        <p>
            Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
            condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod.
            Donec sed odio dui.
        </p>
        <h4>Our Vision</h4>

        <p>To be the world's most trusted and preferred partner for building mission critical applications and cloud
        adoption.</p>
    </div>

    <div class="col-md-3">
        <div class="thumbnail">
            <div class="project-item-image-container"><img src="http://www.ansonika.com/annova/img/team_1.jpg" alt=""/>
            </div>

            <div class="caption">
                <div class="transit-to-top">
                    <h4 class="p-title">Patricia Doe
                        <small>CEO</small>
                    </h4>

                    <div class="widget_nav_menu">
                        <ul class="social-bookmarks team">
                            <li class="facebook"><a href="#">facebook</a></li>
                            <li class="googleplus"><a href="#">googleplus</a></li>
                            <li class="twitter"><a href="#">twitter</a></li>
                            <li class="linkedin"><a href="#">linkedin</a></li>
                        </ul>

                        <div class="phone-info"><i class="icon-phone-sign"></i> + 4 (123) 456-7890</div>
                    </div>
                    <!-- transition top -->
                </div>
                <!-- caption -->
            </div>
        </div>
    </div>
    <!-- team  item -->

    <div class="col-md-3">
        <div class="thumbnail">
            <div class="project-item-image-container">
                <img src="http://www.ansonika.com/annova/img/team_2.jpg" alt=""/>
            </div>

            <div class="caption">
                <div class="transit-to-top">
                    <h4 class="p-title">Megan Fox
                        <small>MANAGER</small>
                    </h4>

                    <div class="widget_nav_menu">
                        <ul class="social-bookmarks team">
                            <li class="facebook"><a href="#">facebook</a></li>
                            <li class="googleplus"><a href="#">googleplus</a></li>
                            <li class="twitter"><a href="#">twitter</a></li>
                            <li class="linkedin"><a href="#">linkedin</a></li>
                        </ul>

                        <div class="phone-info">
                            <i class="icon-phone-sign"></i> + 4 (123) 456-7890
                        </div>
                    </div>
                    <!-- transition top -->
                </div>
                <!-- caption -->
            </div>
        </div>
    </div>
    <!-- team  item -->

</div>
<!-- end row -->
</section>
<!-- end section main container -->

<footer>
    <section class="container">
        <div class="row">
            <div class="col-md-4">
                <h3>About us</h3>

                <p>A leader in Groovy and Grails Development,
                the company was one of the earliest adopters of the framework and is an expert on the entire Spring
                Source suite of products. IntelliGrape is also is an Advanced Consulting Partner and Channel
                Reseller for Amazon Web Services (AWS).
                </p>
            </div>

            <div class="col-md-4" id="contact">
                <h3>Contact info</h3>

                <p>IntelliGrape Software (P) Ltd</p>
                <ul>
                    <li><i class="icon-home"></i> SDF L-6, NSEZ, Noida Phase 2, India</li>
                    <li><i class="icon-phone"></i> Telephone: (+91) 120-6493668</li>
                    <li><i class="icon-print">Fax: (+91) 120-4207689</i></li>
                    <li><i class="icon-envelope"></i> Email: <a href="mailto:info@intelligrape.com">info@intelligrape.com</a></li>
                    <li><i class="icon-skype"></i> Skype name: IntelliMeet</li>
                </ul>
            </div>

            <div class="col-md-4">
                <h3>Latest tweet</h3>

                <div class="latest-tweets" data-number="10" data-username="ansonika" data-mode="fade"
                     data-pager="false" data-nextselector=".tweets-next" data-prevselector=".tweets-prev"
                     data-adaptiveheight="true"></div>

                <div class="tweet-control">
                    <div class="tweets-prev"></div>

                    <div class="tweets-next"></div>
                </div>
                <!-- End .tweet-control -->
            </div>

        </div>
        <!-- end row -->
    </section>

    <section id="footer_2">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <ul id="footer-nav">
                        <li>Copyright © 2014 <a href="#">IntelliGrape</a>. All rights reserved.</li>
                        <li><a href="#">Terms of Use</a></li>
                        <li><a href="#">Privacy</a></li>
                    </ul>
                </div>

                <div class="col-md-6" style="text-align:center">
                    <ul class="social-bookmarks clearfix">
                        <li class="facebook"><a href="#">facebook</a></li>
                        <li class="googleplus"><a href="#">googleplus</a></li>
                        <li class="twitter"><a href="#">twitter</a></li>
                        <li class="linkedin"><a href="#">linkedin</a></li>
                        <li class="blogger"><a href="#">blogger</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>

</footer>

<div id="toTop">Back to Top</div>
<r:layoutResources/>
</body>
</html>