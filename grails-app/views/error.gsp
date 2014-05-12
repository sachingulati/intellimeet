<!DOCTYPE html>
<html>
<head>
    <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    <g:if env="development"><link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css"></g:if>
</head>

<body>
<g:if test="${flash.error}">
    <div class="alert alert-warning">${flash.error}</div>
</g:if>
<g:else>
    <g:if env="development">
        <g:renderException exception="${exception}"/>
    </g:if>
    <g:else>
        <ul class="errors">
            <li>An error has occurred</li>
        </ul>
    </g:else>
</g:else>
</body>
</html>
