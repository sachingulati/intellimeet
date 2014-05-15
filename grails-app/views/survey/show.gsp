<%@ page import="com.ig.intellimeet.Survey" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'survey.label', default: 'Survey')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-survey" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header"><a href="#" class="navbar-brand"><g:message code="default.show.label" args="[entityName]"/></a></div>

        <ul class="nav navbar-nav navbar-right">
            <li><g:link action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
            <li><g:link action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</nav>

<div id="show-survey" class="container" role="main">
    <g:if test="${surveyInstance?.isClosed}">
        <div class="alert alert-info">
            <g:message code="survey.closed.message"/>
        </div>
    </g:if>
    <g:if test="${flash.error}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong>Error!</strong> ${flash.message}.
        </div>
    </g:if>
    <g:form class="form-horizontal" url="[resource: surveyInstance, action: 'delete']" method="DELETE">
        <div class="col-lg-6">
            <g:render template="staticForm"/>
        </div>

        <div class="col-lg-6 recipient-survey-stat">
            <legend>Recipient's Email Addresses</legend>
            <ul class="nav nav-tabs nav-justified rs-nav">
                <li class="active"><a href="#" data-trigger="all">All</a></li>
                <li><a href="#" data-trigger="completed">Completed</a></li>
                <li><a href="#" data-trigger="waiting">Response Waiting</a></li>
            </ul>
            <ol class="attendee-list list-group">
                <g:each in="${surveyInstance?.recipients?.sort{it.email}}" var="recipient">
                    <li class="list-group-item ${recipient?.status}">${recipient.email}<span class="badge pull-right">${recipient?.status}</span></li>
                </g:each>
            </ol>
        </div>
    </g:form>
    <script type="text/javascript" src="${resource(dir: '/js/survey', file: 'show.js')}"></script>
</div>
</body>
</html>
