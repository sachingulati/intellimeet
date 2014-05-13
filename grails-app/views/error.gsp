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
    <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="description" content="">
    <meta name="author" content="Puneet">

    <!-- Favicons-->
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.png')}" type="image/x-icon"/>
    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Google web font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800,300' rel='stylesheet' type='text/css'>
    <r:require module="suvey_thankyou"/>
    <style type="text/css">
        #main {padding: 60px 0 !important;}
        #top-area {height: 325px !important;}
        .bs-docs-masthead {padding: 100px 15px !important;}
        .main-title p {margin-top: 10px !important;}
    </style>
    <r:layoutResources/>
    <g:if env="development"><link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css"></g:if>
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
            <div class="row">
                <div class="col-md-12 main-title">
                    %{--<h1>Oops!</h1>--}%

                    <p>${flash.error ?: 'An error has occurred'}</p>
                </div>
            </div>
        </div>
    </main>
</section>

<g:if env="development">
    <section class="container" id="main">
        <g:renderException exception="${exception}"/>
    </section>
</g:if>

<div id="toTop">Back to Top</div>
<r:layoutResources/>
</body>
</html>
