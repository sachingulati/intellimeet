
<%@ page import="com.ig.intellimeet.Survey" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'survey.label', default: 'Survey')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>

<body>
<a href="#list-survey" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><g:message code="default.list.label" args="[entityName]" /></a>
        </div>

        <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Go!</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><g:link action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
        </ul>
    </div>
</nav>

<g:if test="${flash.message}">
    <div class="container alert alert-success alert-dismissable">
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

<table class="table table-striped">
    <thead>
    <tr>
        
        <g:sortableColumn property="title" title="${message(code: 'survey.title.label', default: 'Title')}" />
        
        <g:sortableColumn property="date" title="${message(code: 'survey.date.label', default: 'Date')}" />
        
        <g:sortableColumn property="intelliMeetId" title="${message(code: 'survey.intelliMeetId.label', default: 'Intelli Meet Id')}" />
        
    </tr>
    </thead>
    <tbody>
    <g:each in="${surveyInstanceList}" status="i" var="surveyInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            
            <td><g:link action="show" id="${surveyInstance.id}">${fieldValue(bean: surveyInstance, field: "title")}</g:link></td>
            
            <td><g:formatDate date="${surveyInstance.date}" /></td>
            
            <td>${fieldValue(bean: surveyInstance, field: "intelliMeetId")}</td>
            
        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${surveyInstanceCount ?: 0}" />
</div>
<r:script>
    markAsActive("survey");
</r:script>
</body>
</html>
