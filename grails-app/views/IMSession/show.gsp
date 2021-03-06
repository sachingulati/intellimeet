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
    <div class="container">

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

    <h1>
        <im:canEdit imSession="${IMSessionInstance}">
            <g:link controller="IMSession" action="edit" id="${IMSessionInstance?.id}"><i class="glyphicon glyphicon-pencil"></i></g:link>&nbsp;
        </im:canEdit>
    ${IMSessionInstance?.title}
    </h1>

    <p class="lead">owned by <a href="#">${IMSessionInstance?.ownersEmail} </a>
    </p>
    <hr>

    <div class="row">
        <div class="col-lg-6">
            <p><span class="glyphicon glyphicon-time"></span> Posted on ${IMSessionInstance?.dateCreated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>

            <p><span class="glyphicon glyphicon-time"></span> Last updated on ${IMSessionInstance?.lastUpdated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
        </div>
        <div class="col-lg-6">
            <p>Status: ${fieldValue(bean: IMSessionInstance, field: 'sessionStatus')}</p>
            <p>Capacity: ${fieldValue(bean: IMSessionInstance, field: 'minCapacity')} - ${fieldValue(bean: IMSessionInstance, field: 'maxCapacity')} people</p>
        </div>
    </div>
    <hr>
    <h4 style="text-transform: uppercase;">Agenda:</h4>

    ${raw(IMSessionInstance?.description)}
    %{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
    %{--<hr>--}%
    <g:if test="${IMSessionInstance?.attendeesEmails}" >
        <h4 style="text-transform: uppercase;">List of Attendees:</h4>
        <ul class="list-unstyled">
            <g:each in="${IMSessionInstance?.attendeesEmails?.sort()}" var="attendeeEmail">
                <li><span class="fa fa-angle-double-right"></span>&nbsp;${attendeeEmail}</li>
            </g:each>
        </ul>

        <br/>
    </g:if>

</div>
</body>
</html>
