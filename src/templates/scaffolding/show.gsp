<% import grails.persistence.Event %>
<%=packageName%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
    <a href="#show-${domainClass.propertyName}" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header"><a href="#" class="navbar-brand"><g:message code="default.show.label" args="[entityName]" /></a></div>

            <ul class="nav navbar-nav navbar-right">
                <li><g:link action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                <li><g:link action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
    </nav>
    <div id="show-${domainClass.propertyName}" class="container" role="main">
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
        <g:form class="form-horizontal" url="[resource:${propertyName}, action:'delete']" method="DELETE">
            <g:render template="staticForm"/>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <g:link class="btn btn-lg btn-default" action="edit" resource="\${${propertyName}}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:actionSubmit class="btn btn-lg btn-danger" action="delete" value="\${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('\${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </div>
            </div>
        </div>
        </g:form>
    </div>
    </body>
</html>
