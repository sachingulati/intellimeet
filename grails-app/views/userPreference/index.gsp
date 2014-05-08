<%@ page import="com.ig.intellimeet.UserPreference" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'userPreference.label', default: 'UserPreference')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-userPreference" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><g:message code="user.preference.list.label"/></a>
        </div>

        <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Go!</button>
        </form>
    </div>
</nav>

<div class="container-fluid">
    <table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="emailAddress" title="${message(code: 'userPreference.emailAddress.label', default: 'Email Address')}"/>
        <g:sortableColumn property="firstPreferredSessionTitle" title="${message(code: 'userPreference.firstPreferredSessionTitle.label', default: 'First Preference')}"/>

        <g:sortableColumn property="secondPreferredSessionTitle" title="${message(code: 'userPreference.secondPreferredSessionTitle.label', default: 'Second Preference')}"/>
        <g:sortableColumn property="thirdPreferredSessionTitle" title="${message(code: 'userPreference.thirdPreferredSessionTitle.label', default: 'Third Preference')}"/>

        <g:sortableColumn property="dateCreated" title="${message(code: 'userPreference.dateSubmitted.label', default: 'Date Submitted')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${userPreferenceInstanceList}" status="i" var="userPreferenceInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td>${fieldValue(bean: userPreferenceInstance, field: "emailAddress")}</td>

            <td>${UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreferenceInstance.firstPreferredSessionId,userPreferenceInstance.intelliMeetId)}</td>

            <td>${UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreferenceInstance.secondPreferredSessionId,userPreferenceInstance.intelliMeetId)}</td>

            <td>${UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreferenceInstance.thirdPreferredSessionId,userPreferenceInstance.intelliMeetId)}</td>

            <td><g:formatDate date="${userPreferenceInstance.dateCreated}"/></td>

        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${userPreferenceInstanceCount ?: 0}"/>
</div></div>
</body>
</html>
