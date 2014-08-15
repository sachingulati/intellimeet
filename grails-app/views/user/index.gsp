<%@ page import="com.ig.intellimeet.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <r:require module="user_mgmt" />
</head>

<body>
<a href="#list-user" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><g:message code="default.list.label" args="[entityName]"/></a>
        </div>

        <g:form controller="user" action="search" class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="text" name="q" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Go!</button>
        </g:form>
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

        <g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'Username')}"/>

        <g:sortableColumn property="enabled" title="${message(code: 'user.enabled.label', default: 'Enabled')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${userInstanceList}" status="i" var="userInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>
                <user:displayUserImageInMainNav email="${userInstance?.username}"/>
                <g:link action="show"
                        id="${userInstance.id}">${fieldValue(bean: userInstance, field: "username")}</g:link></td>


            <td>
                <g:if test="${userInstance.enabled}">
                    <span class="fa fa-check-square-o fa-3x toggleAccountEnable" data-userid="${userInstance?.id}" style="cursor:pointer;"></span>
                </g:if>
                <g:else>
                    <span class="fa fa-square-o fa-3x toggleAccountEnable" data-userid="${userInstance?.id}" style="cursor:pointer;"></span>
                </g:else>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${userInstanceCount ?: 0}" params="${params}"/>
</div>
</body>
</html>
