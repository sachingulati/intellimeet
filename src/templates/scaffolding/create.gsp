<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-${domainClass.propertyName}" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><g:message code="default.create.label" args="[entityName]"/></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><g:link action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</nav>
		<div id="create-${domainClass.propertyName}" class="container" role="main">
			<g:if test="\${flash.message}">
                <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <strong>Success!</strong> \${flash.message}.
                </div>
			</g:if>
            <g:if test="\${flash.error}">
                <div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <strong>Error!</strong> \${flash.message}.
                </div>
            </g:if>
			<g:hasErrors bean="\${${propertyName}}">
                <div class="alert alert-danger alert-dismissable">
                    <ul class="list-unstyled" role="alert">
				        <g:eachError bean="\${${propertyName}}" var="error">
				        <li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>><g:message error="\${error}"/></li>
				        </g:eachError>
			        </ul>
                </div>
			</g:hasErrors>
			<g:form class="form-horizontal" url="[resource:${propertyName}, action:'save']" <%= multiPart ? ' enctype="multipart/form-data"' : '' %>>
				<g:render template="form"/>
				<div class="form-group">
					<g:submitButton name="create" class="btn btn-lg btn-primary" value="\${message(code: 'default.button.create.label', default: 'Create')}" />
				</div>
			</g:form>
		</div>
	</body>
</html>
