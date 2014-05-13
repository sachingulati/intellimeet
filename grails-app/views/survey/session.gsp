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
    <r:require module="survey"/>
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

    <g:form name="example-1" controller="userPreference" action="save" method="POST">
        <g:hiddenField name="tokenId" value="${tokenId}" />
        <div id="middle-wizard">
            <div class="step row">
                <div class="col-md-10">
                    <h3>First Preference</h3>
                    <ul class="data-list-2">
                        <g:each in="${sessions}" var="session">
                            <li><input name="firstPreferredSessionId" type="radio" class="required check_radio"
                                       value="${session?.id}"><label>${session?.title} by ${session?.ownersEmail} - <small><g:link controller="IMSession" action="show" id="${session?.id}" target="_blank">View Agenda</g:link></small></label></li>
                        </g:each>
                        <li><input type="radio" class="required check_radio" name="firstPreferredSessionId" value="Not Available"/><label>Not Available</label></li>
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
                                       value="${session?.id}"><label>${session?.title} by ${session?.ownersEmail} - <small><g:link controller="IMSession" action="show" id="${session?.id}" target="_blank">View Agenda</g:link></small></label></li>
                        </g:each>
                        <li><input type="radio" class="required check_radio" name="secondPreferredSessionId" value="Not Available"/><label>Not Available</label></li>
                    </ul>
                </div>
            </div>
            <!-- end step -->


            <div class="step row">
                <div class="col-md-10">
                    <h3>Third Preference</h3>
                    <ul class="data-list-2">
                        <g:each in="${sessions}" var="session">
                            <li><input name="thirdPreferredSessionId" type="radio" class="required check_radio"
                                       value="${session?.id}"><label>${session?.title} by ${session?.ownersEmail} - <small><g:link controller="IMSession" action="show" id="${session?.id}" target="_blank">View Agenda</g:link></small></label></li>
                        </g:each>
                        <li><input type="radio" class="required check_radio" name="thirdPreferredSessionId" value="Not Available"/><label>Not Available</label></li>
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
    </g:form>

</div>
<!-- end Survey container -->

<h2 class="bs-docs-featurette-title" style="text-transform: inherit;">Learning is part of IntelliGrape ethos </h2>

    <p class="lead">By providing training and development programmes, on-the-job learning, coaching and feedback, we make sure that everyone who works with us has the resources they need to learn more and build their careers.</p>

    <div class="divider"></div>

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
                    </ul>
                </div>

                <div class="col-md-6" style="text-align:center">
                    <ul class="social-bookmarks clearfix">
                        <li class="facebook"><a href="https://www.facebook.com/intelligrape.software" target="_blank">facebook</a></li>
                        <li class="googleplus"><a href="https://plus.google.com/102688776692809350794/posts" target="_blank">googleplus</a></li>
                        <li class="twitter"><a href="https://twitter.com/IntelliGrape" target="_blank">twitter</a></li>
                        <li class="linkedin"><a href="http://www.linkedin.com/company/intelligrape" target="_blank">linkedin</a></li>
                        <li class="blogger"><a href="http://www.intelligrape.com/blog/" target="_blank">blogger</a></li>
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