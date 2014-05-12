<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="public"/>
    <title>Welcome to IntelliMeet</title>
    <r:style>
        header {
        padding: 0;
        }
        #countdown {
  font-size: 48px;
  color: #FFF;
  line-height: 1.1em;
  margin: 20px 0px 20px;
}
        .bs-docs-masthead {
            padding: 40px 0;
        }

        .bs-docs-featurette {
            paddimg
        }

    </r:style>
</head>

<body class="bs-docs-home">

<!-- Page content of course! -->
<main class="bs-docs-masthead" id="content" role="main">
    <div class="container">
        <span class="bs-docs-booticon bs-docs-booticon-lg bs-docs-booticon-outline">IM</span>

        <p class="lead">Let's learn together</p>

        <div class="row">
            <div class="col-md-6 col-md-offset-3 wrap-cd">
                <im:displayCountdown/>
            </div>
        </div>

        <div class="row">
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
        </div>
    </div>
</main>

<div class="bs-docs-featurette">
    <div class="container">
        <h2 class="bs-docs-featurette-title" style="text-transform: inherit;">Learning is part of IntelliGrape ethos</h2>

        <p class="lead">By providing training and development programmes, on-the-job learning, coaching and feedback, we make sure that everyone who works with us has the resources they need to learn more and build their careers.</p>

        <hr class="half-rule">

        <div class="row">
            <div class="col-sm-3">
                <img src="${resource(dir: 'images/logo', file: 'grails-logo.png')}" alt="Groovy & Grails Logo" class="img-responsive">

                <h3>Groovy & Grails.</h3>

                <p>We are one of the largest team of Grails developers in the world. We have been working on Groovy & Grails since early 2008 and have developed more than 50 live applications on Grails.</p>
            </div>

            <div class="col-sm-3">
                <img src="${resource(dir: 'images/logo', file: 'nodejs-logo.png')}" alt="Node JS Logo" class="img-responsive" style="height: 115px;">

                <h3>Node JS</h3>

                <p>We are one of the earliest adopters of Node.js and have gained extensive experience in delivering rich, high performance and scalable web applications using Node.js.</p>
            </div>

            <div class="col-sm-3">
                <img src="${resource(dir: 'images/logo', file: 'adobe-cq.png')}" alt="Adobe CQ5 Logo" class="img-responsive">

                <h3>Adobe CQ5</h3>

                <p>We help our clients with custom development, multi-channel content delivery and large-scale data migrations on Adobe CQ.</p>
            </div>

            <div class="col-sm-3">
                <img src="${resource(dir: 'images/logo', file: 'aws-logo.png')}" alt="AWS Logo" class="img-responsive">

                <h3>AWS</h3>

                <p>We provide consulting, implementation and managed services on Amazon Web Services. We help and manage cloud infrastructure for some of the Fortune 500 companies as well as SMBs.</p>
            </div>
        </div>

    </div>
</div>

<!-- Footer
================================================== -->
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

                <div class="latest-tweets" data-number="10" data-username="intelligrape" data-mode="fade" data-pager="false" data-nextselector=".tweets-next"
                     data-prevselector=".tweets-prev" data-adaptiveheight="true"><p class="loading">loading tweets...</p></div>

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
                        <li>Copyright © 2014 <a href="http://www.intelligrape.com" target="_blank">IntelliGrape</a>. All rights reserved.</li>
                        %{--<li><a href="#">Terms of Use</a></li>--}%
                        %{--<li><a href="#">Privacy</a></li>--}%
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
<r:script>
    $("#topNav li").removeClass("active");
    $("#topNav li#home").addClass("active");
</r:script>
</body>
</html>
