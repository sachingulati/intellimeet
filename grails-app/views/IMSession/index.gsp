
<%@ page import="com.ig.intellimeet.IMSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'IMSession.label', default: 'IMSession')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>

<body>
<a href="#list-IMSession" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

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
        
        <g:sortableColumn property="title" title="${message(code: 'IMSession.title.label', default: 'Title')}" />
        
        <g:sortableColumn property="maxCapacity" title="${message(code: 'IMSession.maxCapacity.label', default: 'Max Capacity')}" />
        
        <g:sortableColumn property="minCapacity" title="${message(code: 'IMSession.minCapacity.label', default: 'Min Capacity')}" />
        
        <g:sortableColumn property="score" title="${message(code: 'IMSession.score.label', default: 'Score')}" />
        
        <g:sortableColumn property="dateCreated" title="${message(code: 'IMSession.dateCreated.label', default: 'Date Created')}" />
        
        <g:sortableColumn property="description" title="${message(code: 'IMSession.description.label', default: 'Description')}" />
        
    </tr>
    </thead>
    <tbody>
    <g:each in="${IMSessionInstanceList}" status="i" var="IMSessionInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            
            <td><g:link action="show" id="${IMSessionInstance.id}">${fieldValue(bean: IMSessionInstance, field: "title")}</g:link></td>
            
            <td>${fieldValue(bean: IMSessionInstance, field: "maxCapacity")}</td>
            
            <td>${fieldValue(bean: IMSessionInstance, field: "minCapacity")}</td>
            
            <td>${fieldValue(bean: IMSessionInstance, field: "score")}</td>
            
            <td><g:formatDate date="${IMSessionInstance.dateCreated}" /></td>
            
            <td>${fieldValue(bean: IMSessionInstance, field: "description")}</td>
            
        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${IMSessionInstanceCount ?: 0}" />
</div>
</body>
</html>
