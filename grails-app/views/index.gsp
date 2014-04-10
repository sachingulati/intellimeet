<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to IntelliMeet</title>
</head>

<body class="bs-docs-home">

<!-- Page content of course! -->
<main class="bs-docs-masthead" id="content" role="main">
    <div class="container">
        <span class="bs-docs-booticon bs-docs-booticon-lg bs-docs-booticon-outline">IM</span>
        <p class="lead">Let's learn together</p>
        <sec:ifNotLoggedIn>
            <p class="lead">
                <a href="#" class="btn btn-outline-inverse btn-lg">Register Now</a>
            </p>
            <oauth:connect provider="google" id="google-connect-link" class="btn-google-plus">
                    <i class="fa fa-google-plus"></i><g:message code="google.signin"/>
            </oauth:connect>

            %{--<s2o:ifLoggedInWith provider="google">yes</s2o:ifLoggedInWith>
            <s2o:ifNotLoggedInWith provider="google">no</s2o:ifNotLoggedInWith>--}%
        </sec:ifNotLoggedIn>
    </div>
</main>

<div class="bs-docs-featurette">
    <div class="container">
        <h2 class="bs-docs-featurette-title">Designed for everyone, everywhere.</h2>

        <p class="lead">Bootstrap makes front-end web development faster and easier. It's made for folks of all skill levels, devices of all shapes, and projects of all sizes.</p>

        <hr class="half-rule">

        <div class="row">
            <div class="col-sm-4">
                <img src="http://getbootstrap.com/assets/img/sass-less.png" alt="Sass and Less support" class="img-responsive">

                <h3>Preprocessors</h3>

                <p>In addition to vanilla CSS, Bootstrap includes support for the two most popular CSS preprocessors, <a href="../css/#less">Less</a> and <a
                        href="#">Sass</a>.</p>
            </div>

            <div class="col-sm-4">
                <img src="http://getbootstrap.com/assets/img/devices.png" alt="Responsive across devices" class="img-responsive">

                <h3>One framework, every device.</h3>

                <p>Bootstrap easily and efficiently scales your project with one code base, from phones to tablets to desktops.</p>
            </div>

            <div class="col-sm-4">
                <img src="http://getbootstrap.com/assets/img/components.png" alt="Components" class="img-responsive">

                <h3>Comprehensive docs</h3>

                <p>With Bootstrap, you get extensive and beautiful documentation with hundreds of live examples, code snippets, and more.</p>
            </div>
        </div>

    </div>
</div>

<!-- Footer
================================================== -->
<footer class="bs-docs-footer" role="contentinfo">
    <div class="container">
        <div class="bs-docs-social">
            <ul class="bs-docs-social-buttons">
                <li class="follow-btn">
                    <a href="https://twitter.com/IntelliGrape " class="twitter-follow-button" data-link-color="#0069D6" data-show-count="true">Follow @IntelliGrape</a>
                </li>
            </ul>
        </div>


        <p>Designed and built with all the love in the world by <a href="http://twitter.com/puneetbhl" target="_blank">@puneetbhl</a> and <a href="http://twitter.com/faridiflex"
                                                                                                                                 target="_blank">@faridiflex</a>.</p>

        <p>Maintained by the <a href="/about#coreTeam">core team</a></p>

        <p>Copyright © 2014 <a href="http://intelligrape.com/" target="_blank">Intelligrape</a>. All rights reserved. </p>
    </div>
</footer>
<r:script>
   $("#topNav li").removeClass("active");
   $("#topNav li#home").addClass("active");
</r:script>
</body>
</html>
