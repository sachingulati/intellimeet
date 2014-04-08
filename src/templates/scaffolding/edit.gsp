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
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><g:message code="default.edit.label" args="[entityName]" /></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><g:link action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
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
            <g:form class="form-horizontal" method="post" <%= multiPart ? ' enctype="multipart/form-data"' : '' %>>
                <g:hiddenField name="id" value="\${${propertyName}?.id}" />
                <g:hiddenField name="version" value="\${${propertyName}?.version}" />
                <g:render template="form"/>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <g:actionSubmit class="btn btn-lg btn-primary" action="update" value="\${message(code: 'default.button.update.label', default: 'Update')}" />
                        <g:actionSubmit class="btn btn-lg btn-danger" action="delete" value="\${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('\${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </div>
                </div>
            </g:form>
         </div>
	</body>
</html>
