<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="IntelliMeet"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.png')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <g:layoutHead/>
    <r:require module="core"/>
    <style>
    body { padding-top: 50px; }
    </style>
    <r:layoutResources/>
</head>

<body class="${pageProperty(name: 'body.class')}">
<a href="#content" class="sr-only"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<g:render template="/templates/navbar"/>
<g:layoutBody/>
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
<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
<r:layoutResources/>
</body>
</html>
