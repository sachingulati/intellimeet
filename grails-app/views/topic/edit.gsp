<%@ page import="com.ig.intellimeet.Topic" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-topic" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><g:message code="default.edit.label" args="[entityName]" /></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><g:link action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                <li><g:link action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
        </nav>
		<div id="edit-topic" class="container" role="main">
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
			<g:form class="form-horizontal" url="[resource:topicInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${topicInstance?.version}" />
					<g:render template="form"/>
				<div class="form-group">
					<g:actionSubmit class="btn btn-lg btn-primary" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</div>
			</g:form>
		</div>
	</body>
</html>
