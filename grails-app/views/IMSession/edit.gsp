<%@ page import="com.ig.intellimeet.IMSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'IMSession.label', default: 'IMSession')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
        <r:require module="wysi_html5"/>
	</head>
	<body>
    <a href="#edit-IMSession" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#" class="navbar-brand"><g:message code="default.edit.label" args="[entityName]" /></a>
            </div>
        </div>
    </nav>
	<div id="edit-IMSession" class="container" role="main">
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
        <g:hasErrors bean="${IMSessionInstance}">
            <div class="alert alert-danger alert-dismissable">
                <ul class="list-unstyled" role="alert">
                    <g:eachError bean="${IMSessionInstance}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </div>
        </g:hasErrors>
        <g:form class="form-horizontal" url="[resource:IMSessionInstance, action:'update']" method="PUT" >
        <g:hiddenField name="version" value="${IMSessionInstance?.version}" />
        <g:render template="form" model="[imSessionCO: IMSessionInstance]"/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <g:actionSubmit class="btn btn-lg btn-primary" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
            </div>
        </div>
        </g:form>
    </div>
    </body>
</html>
