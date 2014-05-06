<%@ page import="com.ig.intellimeet.IMSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'IMSession.label', default: 'IMSession')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-IMSession" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header"><a href="#" class="navbar-brand"><g:message code="default.show.label" args="[entityName]"/></a></div>

        <ul class="nav navbar-nav navbar-right">
            <li><g:link action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
            <li><g:link action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</nav>

<div id="show-IMSession" class="container" role="main">
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

    <h1><g:link controller="IMSession" action="edit" id="${IMSessionInstance?.id}"><i class="glyphicon glyphicon-pencil"></i></g:link>&nbsp;${IMSessionInstance?.title}
    </h1>

    <p class="lead">owned by <a href="#">${IMSessionInstance?.ownersEmail?.join(", ")}</a>
    </p>
    <hr>

    <div class="row">
        <div class="col-lg-6">
            <p><span class="glyphicon glyphicon-time"></span> Posted on ${IMSessionInstance?.dateCreated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>

            <p><span class="glyphicon glyphicon-time"></span> Last updated on ${IMSessionInstance?.lastUpdated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
        </div>
        <div class="col-lg-6">
            <p>Status: ${fieldValue(bean: IMSessionInstance, field: 'sessionStatus')}</p>
            <p>Min Cap: ${fieldValue(bean: IMSessionInstance, field: 'minCapacity')}, Max Cap: ${fieldValue(bean: IMSessionInstance, field: 'maxCapacity')}</p>
        </div>
    </div>
    <hr>
    <h4 style="text-transform: uppercase;">Agenda:</h4>

    ${raw(IMSessionInstance?.description)}
    %{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
    %{--<hr>--}%
    <h4 style="text-transform: uppercase;">List of Attendees:</h4>

    <ul class="list-unstyled">
        <g:each in="${IMSessionInstance?.attendeesEmails}" var="attendeeEmail">
            <li><span class="fa fa-angle-double-right"></span>&nbsp;${attendeeEmail}</li>
        </g:each>
    </ul>

    <br/>

</div>
</body>
</html>
