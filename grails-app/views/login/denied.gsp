<!DOCTYPE html>
<html>
<head>
    <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    <g:if env="development"><link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css"></g:if>
    <r:style>
        footer { bottom:0px; position:fixed;width:100%;
        }
    </r:style>
</head>

<body>
<div class="container" style="margin-top: 20px;"><div class="alert alert-warning alert-dismissable">
    <strong>Access Denied!</strong> You are not authorized to view this page.
</div></div>

</body>
</html>
