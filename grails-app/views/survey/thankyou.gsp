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
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.png')}" type="image/x-icon"/>
    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Google web font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800,300' rel='stylesheet' type='text/css'>
    <r:require module="suvey_thankyou"/>
    <r:style>
        #main {padding 0 400px 0 60px !important;}
    </r:style>
    <r:layoutResources/>
</head>

<body>

<section id="top-area">
    <header>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-xs-3 navbar-header"><a href="/" class="navbar-brand">IntelliMeet</a></div>

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

    <!-- Page content of course! -->
    <main class="bs-docs-masthead" id="content" role="main">
        <div class="container">
            <span class="bs-docs-booticon bs-docs-booticon-lg bs-docs-booticon-outline">IM</span>

            <p class="lead">Let's learn together</p>

            <div class="row">
                <div class="col-md-12 main-title">
                    <h1>Thank you for your time</h1>

                    <p>This help us to improve our service and your satisfaction.</p>
                </div>

                <div class="col-md-6 col-md-offset-3 wrap-cd">
                    <im:displayCountdown/>
                </div>
            </div>

            %{--<p class="lead">
                <sec:ifLoggedIn>
                    <g:link controller="topic" action="index" class="btn btn-outline-inverse btn-lg">
                        View Topics
                    </g:link>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <oauth:connect provider="google" id="google-connect-link" class="btn btn-outline-inverse btn-lg btn-google-plus">
                        <i class="fa fa-google-plus"></i> <g:message code="google.signin"/>
                    </oauth:connect>
                </sec:ifNotLoggedIn>
            </p>--}%
        </div>
    </main>

    %{--<div class="container">
    <span class="bs-docs-booticon bs-docs-booticon-lg bs-docs-booticon-outline">IM</span>
        <div class="row">
            <div class="col-md-12 main-title">
                <h1>Thank you for your time</h1>

                <p>This help us to improve our service and your satisfaction.</p>
            </div>

            <div class="col-md-6 col-md-offset-3 wrap-cd">
              <im:displayCountdown/>
            </div>
        </div>
    </div>--}%
</section>

<section class="container" id="main">


    %{--<div class="bs-docs-featurette">--}%
        %{--<div class="container">--}%
            <h2 class="bs-docs-featurette-title" style="text-transform: inherit;">Learning is part of IntelliGrape ethos </h2>

            <p class="lead">By providing training and development programmes, on-the-job learning, coaching and feedback, we make sure that everyone who works with us has the resources they need to learn more and build their careers.</p>

            <hr class="half-rule">

            <div class="row">
                <div class="col-sm-3">
                    <img src="${resource(dir: 'images/logo', file:'grails-logo.png')}" alt="Groovy & Grails Logo" class="img-responsive">

                    <h3>Groovy & Grails.</h3>

                    <p>We are one of the largest team of Grails developers in the world. We have been working on Groovy & Grails since early 2008 and have developed more than 50 live applications on Grails.</p>
                </div>

                <div class="col-sm-3">
                    <img src="${resource(dir: 'images/logo', file:'nodejs-logo.png')}" alt="Node JS Logo" class="img-responsive" style="height: 115px;">

                    <h3>Node JS</h3>

                    <p>We are one of the earliest adopters of Node.js and have gained extensive experience in delivering rich, high performance and scalable web applications using Node.js.</p>
                </div>

                <div class="col-sm-3">
                    <img src="${resource(dir: 'images/logo', file:'adobe-cq.png')}" alt="Adobe CQ5 Logo" class="img-responsive">

                    <h3>Adobe CQ5</h3>

                    <p>We help our clients with custom development, multi-channel content delivery and large-scale data migrations on Adobe CQ.</p>
                </div>

                <div class="col-sm-3">
                    <img src="${resource(dir: 'images/logo', file:'aws-logo.png')}" alt="AWS Logo" class="img-responsive">

                    <h3>AWS</h3>

                    <p>We provide consulting, implementation and managed services on Amazon Web Services. We help and manage cloud infrastructure for some of the Fortune 500 companies as well as SMBs.</p>
                </div>
            </div>

        %{--</div>--}%
    %{--</div>--}%
%{--

    <div class="divider"></div>

    <div class="row">
        <div class="col-md-12">
            <h3>About us<span>With a collective experience of more than 750 years between our team across 6 technologies, we are more than technology enablers. We are innovators.</span></h3>
        </div>
    </div>
    <!-- end row -->

    <div class="row">

        <div class="col-md-6">
            <h4>Our History</h4>

            <p>IntelliGrape is an agile off-shore development company renowned for quality custom web application development on open source frameworks like Grails.

            It was founded in June 2008. It was started primarily as a Grails development house and has diversified its expertize to mobile application development using PhoneGap, e-commerce solutions using Magento and CMS driven solutions in Magnolia, Drupal etc.

            IntelliGrape follows Agile methodologies for its work. It offers in-house training programmes as well as corporate trainings in domains of its expertize.
            In December 2011, IntelliGrape became a part of To The New, a digital media solutions provider.</p>
            <h4>Our Vision</h4>

            <p>To be the world's most trusted and preferred partner for building mission critical applications and cloud
            adoption.</p>
        </div>

        <div class="col-md-3">
            <div class="thumbnail">
                <div class="project-item-image-container"><img src="${resource(dir: 'images/team', file: 'dm.png')}" alt=""/>
                </div>

                <div class="caption">
                    <div class="transit-to-top">
                        <h4 class="p-title">Deepak Mittal
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
                        </div>1
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
                    <img src="${resource(dir: 'images/team', file: 'nk.png')}" alt=""/>
                </div>

                <div class="caption">
                    <div class="transit-to-top">
                        <h4 class="p-title">Narinder Kumar
                            <small>VP</small>
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
--}%
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