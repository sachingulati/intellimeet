<%=packageName%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
    <a href="#edit-${domainClass.propertyName}" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#" class="navbar-brand"><g:message code="default.edit.label" args="[entityName]" /></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><g:link action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                <li><g:link action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
    </nav>
	<div id="edit-${domainClass.propertyName}" class="container" role="main">
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
        <g:form class="form-horizontal" url="[resource:${propertyName}, action:'update']" method="PUT" <%= multiPart ? ' enctype="multipart/form-data"' : '' %>>
        <g:hiddenField name="version" value="\${${propertyName}?.version}" />
        <g:render template="form"/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <g:actionSubmit class="btn btn-lg btn-primary" action="update" value="\${message(code: 'default.button.update.label', default: 'Update')}" />
            </div>
        </div>
        </g:form>
    </div>
    </body>
</html>
