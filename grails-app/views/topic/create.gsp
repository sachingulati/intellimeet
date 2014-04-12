<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
    <r:require module="wysi_html5" />
</head>

<body>
<a href="#create-topic" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Create New Topic</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><g:link action="index"><span class="fa fa-th-list"></span>&nbsp;<g:message code="default.list.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</nav>

<div id="create-topic" class="container" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong>Success!</strong> ${flash.message}.
        </div>
    </g:if>
    <g:if test="${flash.error}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong>Error!</strong> ${flash.message}.
        </div>
    </g:if>
    <g:hasErrors bean="${topicInstance}">
        <div class="alert alert-danger alert-dismissable">
            <ul class="list-unstyled" role="alert">
                <g:eachError bean="${topicInstance}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
        </div>
    </g:hasErrors>
    <g:form class="form-horizontal" url="[resource: topicInstance, action: 'save']">
        <g:render template="form"/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <g:submitButton name="create" class="btn btn-lg btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}"/>
            </div>
        </div>
    </g:form>
</div>
</body>
</html>
