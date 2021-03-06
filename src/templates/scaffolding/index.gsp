<% import grails.persistence.Event %>
<%=packageName%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>

<body>
<a href="#list-${domainClass.propertyName}" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

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

<g:if test="\${flash.message}">
    <div class="container alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <strong>Success!</strong> \${flash.message}.
    </div>
</g:if>

<g:if test="\${flash.error}">
    <div class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <strong>Error!</strong> \${flash.error}.
    </div>
</g:if>

<table class="table table-striped">
    <thead>
    <tr>
        <%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
        allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
        props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && it.type != null && !Collection.isAssignableFrom(it.type) && (domainClass.constrainedProperties[it.name] ? domainClass.constrainedProperties[it.name].display : true) }
        Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
        props.eachWithIndex { p, i ->
            if (i < 6) {
                if (p.isAssociation()) { %>
        <th><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" /></th>
        <%      } else { %>
        <g:sortableColumn property="${p.name}" title="\${message(code: '${domainClass.propertyName}.${p.name}.label', default: '${p.naturalName}')}" />
        <%  }   }   } %>
    </tr>
    </thead>
    <tbody>
    <g:each in="\${${propertyName}List}" status="i" var="${propertyName}">
        <tr class="\${(i % 2) == 0 ? 'even' : 'odd'}">
            <%  props.eachWithIndex { p, i ->
                if (i == 0) { %>
            <td><g:link action="show" id="\${${propertyName}.id}">\${fieldValue(bean: ${propertyName}, field: "${p.name}")}</g:link></td>
            <%      } else if (i < 6) {
                if (p.type == Boolean || p.type == boolean) { %>
            <td><g:formatBoolean boolean="\${${propertyName}.${p.name}}" /></td>
            <%          } else if (p.type == Date || p.type == java.sql.Date || p.type == java.sql.Time || p.type == Calendar) { %>
            <td><g:formatDate date="\${${propertyName}.${p.name}}" /></td>
            <%          } else { %>
            <td>\${fieldValue(bean: ${propertyName}, field: "${p.name}")}</td>
            <%  }   }   } %>
        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="\${${propertyName}Count ?: 0}" />
</div>
</body>
</html>
