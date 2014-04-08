<%=packageName%>
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
                <li><g:link action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </nav>
        <div class="container">
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

            <g:form class="form-horizontal" role="form" action="save" <%= multiPart ? ' enctype="multipart/form-data"' : '' %>>
                <g:render template="form"/>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <g:submitButton name="create" class="btn btn-lg btn-primary" value="\${message(code: 'default.button.create.label', default: 'Create')}" />
                    </div>
                </div>
            </g:form>
        </div>
	</body>
</html>
