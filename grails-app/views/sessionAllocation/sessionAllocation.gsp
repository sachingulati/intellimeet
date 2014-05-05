<%@ page import="com.ig.intellimeet.User; com.ig.intellimeet.IMSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'IMSession.label', default: 'IMSession')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <r:require module="session_allocation"/>
</head>

<body>
<a href="#list-IMSession" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><g:message code="default.list.label" args="[entityName]"/></a>
        </div>

        <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Go!</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><g:link action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</nav>

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

<div class="container-fluid"><table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="title" title="${message(code: 'IMSession.title.label', default: 'Title')}"/>
        <g:sortableColumn property="maxCapacity" title="${message(code: 'IMSession.first.preference.label', default: 'First Preference')}"/>
        <g:sortableColumn property="minCapacity" title="${message(code: 'IMSession.second.preference.label', default: 'Second Preference')}"/>
        <g:sortableColumn property="score" title="${message(code: 'IMSession.third.preference.label', default: 'Third Preference')}"/>
    </tr>
    </thead>
    <tbody>
    <g:each in="${sessionPreferenceMap}" status="i" var="sessionPreference">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td >${sessionPreference?.value?.sessionTitle}</td>
            <td>
                <g:each in="${sessionPreference?.value?.preferenceOneUserIds}" status="j" var="userId">
                    <span class="user${userId}Span interestedUserSpan">
                        <g:checkBox name="imsession[${sessionPreference?.value?.sessionId}].attendeeIds"
                                    value="${userId}" class="allocationChck user${userId}"
                                    checked="false"
                                    sessionName="${sessionPreference?.value?.sessionTitle}"/>
                        ${User.get(userId)?.username}
                    </span>
                </g:each>
            </td>
            <td>
                <g:each in="${sessionPreference?.value?.preferenceTwoUserIds}" status="k" var="userId">
                    <span class="user${userId}Span interestedUserSpan">
                        <g:checkBox name="imsession[${sessionPreference?.value?.sessionId}].attendeeIds"
                                    value="${userId}" class="allocationChck user${userId}"
                                    checked="false"
                                    sessionName="${sessionPreference?.value?.sessionTitle}"/>
                        ${User.get(userId)?.username}
                    </span>
                </g:each>
            </td>
            <td>
                <g:each in="${sessionPreference?.value?.preferenceThreeUserIds}" status="l" var="userId">
                    <span class="user${userId}Span interestedUserSpan">
                        <g:checkBox name="imsession[${sessionPreference?.value?.sessionId}].attendeeIds"
                                    value="${userId}" class="allocationChck user${userId}"
                                    checked="false"
                                    sessionName="${sessionPreference?.value?.sessionTitle}"/>
                        ${User.get(userId)?.username}
                    </span>
                </g:each>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
    <div class="pagination">
        <g:paginate total="${IMSessionInstanceCount ?: 0}"/>
    </div></div>
<r:script>
    markAsActive("session");
</r:script>
</body>
</html>
