<%@ page import="com.ig.intellimeet.User; com.ig.intellimeet.IMSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'IMSession.label', default: 'IMSession')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <r:require module="session_allocation"/>
    <r:require module="iCheck"/>
</head>

<body>
<a href="#list-IMSession" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label"
                                                                   default="Skip to content&hellip;"/></a>

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

<div id="list-IMSession" class="container-fluid">
    <g:form controller="sessionAllocation" action="saveAsDraft">
        <table class="table table-striped">
            <thead>
            <tr>
                <g:sortableColumn property="sessionTitle" title="${message(code: 'IMSession.title.label', default: 'Title')}"/>
                <th><g:message code="IMSession.first.preference.label" default="First Preference"/></th>
                <th><g:message code="IMSession.second.preference.label" default="Second Preference"/></th>
                <th><g:message code="IMSession.third.preference.label" default="Third Preference"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${sessionPreferenceList}" status="i" var="sessionPreference">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td class="span4"><p class="lead">${sessionPreference?.sessionTitle}</p>
                        <span>- by ${sessionPreference?.sessionOwners}</span>
                        <g:hiddenField name="preferences[${i}].sessionId" value="${sessionPreference?.sessionId}"/>
                    </td>
                    <td>
                        <g:each in="${sessionPreference?.preferenceOneUserIds}" status="j" var="userId">
                            <g:render template="userSelectionCheckbox"
                                      model="[sessionPreference: sessionPreference, userId: userId, isChecked: sessionPreference?.purposedAttendees?.contains(userId), i:i]"/>
                        </g:each>
                    </td>
                    <td>
                        <g:each in="${sessionPreference?.preferenceTwoUserIds}" status="k" var="userId">
                            <g:render template="userSelectionCheckbox"
                                      model="[sessionPreference: sessionPreference, userId: userId, isChecked: sessionPreference?.purposedAttendees?.contains(userId), i:i]"/>
                        </g:each>
                    </td>
                    <td>
                        <g:each in="${sessionPreference?.preferenceThreeUserIds}" status="l" var="userId">
                            <g:render template="userSelectionCheckbox"
                                      model="[sessionPreference: sessionPreference, userId: userId, isChecked: sessionPreference?.purposedAttendees?.contains(userId), i:i]"/>
                        </g:each>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <g:submitButton name="saveAsDraft" value="Save As Draft" class="btn btn-primary btn-lg"/>
    </g:form>
</div>
<r:script>
    markAsActive("allocation");
</r:script>
</body>
</html>
