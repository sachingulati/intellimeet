
<%@ page import="com.ig.intellimeet.IntelliMeet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'intelliMeet.label', default: 'IntelliMeet')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>

<body>
<a href="#list-intelliMeet" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

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
        <strong>Error!</strong> ${flash.error}.
    </div>
</g:if>

<table class="table table-striped">
    <thead>
    <tr>
        
        <g:sortableColumn property="title" title="${message(code: 'intelliMeet.title.label', default: 'Title')}" />
        
        <g:sortableColumn property="description" title="${message(code: 'intelliMeet.description.label', default: 'Description')}" />
        
        <g:sortableColumn property="place" title="${message(code: 'intelliMeet.place.label', default: 'Place')}" />
        
        <g:sortableColumn property="dateCreated" title="${message(code: 'intelliMeet.dateCreated.label', default: 'Date Created')}" />
        
        <g:sortableColumn property="dateOfEvent" title="${message(code: 'intelliMeet.dateOfEvent.label', default: 'Date Of Event')}" />
        
        <g:sortableColumn property="lastUpdated" title="${message(code: 'intelliMeet.lastUpdated.label', default: 'Last Updated')}" />
        
    </tr>
    </thead>
    <tbody>
    <g:each in="${intelliMeetInstanceList}" status="i" var="intelliMeetInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            
            <td><g:link action="show" id="${intelliMeetInstance.id}">${fieldValue(bean: intelliMeetInstance, field: "title")}</g:link></td>
            
            <td>${fieldValue(bean: intelliMeetInstance, field: "description")}</td>
            
            <td>${fieldValue(bean: intelliMeetInstance, field: "place")}</td>
            
            <td><g:formatDate date="${intelliMeetInstance.dateCreated}" /></td>
            
            <td><g:formatDate date="${intelliMeetInstance.dateOfEvent}" /></td>
            
            <td><g:formatDate date="${intelliMeetInstance.lastUpdated}" /></td>
            
        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${intelliMeetInstanceCount ?: 0}" />
</div>
</body>
</html>
