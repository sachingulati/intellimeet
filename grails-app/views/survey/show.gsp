<%@ page import="com.ig.intellimeet.Survey" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'survey.label', default: 'Survey')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
    <r:style>
    .attendee-list li {
        width: 50%;
        float: left;
    }

    ol.attendee-list {
        overflow: hidden;
        list-style-type: decimal;
        padding: 20px;
    }
    </r:style>
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
    <g:form class="form-horizontal" url="[resource: surveyInstance, action: 'delete']" method="DELETE">
        <g:render template="staticForm"/>
    </g:form>
</div>
</body>
</html>
