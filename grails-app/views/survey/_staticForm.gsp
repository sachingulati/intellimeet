<%@ page import="com.ig.intellimeet.Survey" %>

<div class="col-lg-8">
    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'title', 'has-error')} required">
        <label for="title" class="col-sm-4 control-label">
            <g:message code="survey.title.label" default="Title"/>:

        </label>

        <div class="col-lg-8">
            <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'title')}</p>
        </div>
    </div>

    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'date', 'has-error')} required">
        <label for="date" class="col-sm-4 control-label">
            <g:message code="survey.date.label" default="Date"/>:

        </label>

        <div class="col-lg-8">
            <p class="form-control-static">
                 <g:formatDate format="dd MMM yyyy" date="${surveyInstance.date}"/>
            </p>
        </div>
    </div>

    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'intelliMeetTitle', 'has-error')} required">
        <label for="intelliMeetId" class="col-sm-4 control-label">
            <g:message code="ntelliMeet.label" default="Intelli Meet"/>:

        </label>

        <div class="col-lg-8">
            <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'intelliMeetTitle')}</p>
        </div>
    </div>

    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'type', 'has-error')} required">
        <label for="type" class="col-sm-4 control-label">
            <g:message code="survey.type.label" default="Type"/>:

        </label>

        <div class="col-lg-8">
            <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'type')}</p>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-7">
            <g:link class="btn btn-md btn-primary" action="edit" resource="${surveyInstance}"><g:message code="default.button.edit.label" default="Edit"/></g:link>
        </div>
    </div>
</div>
<div class="bs-docs-sidebar hidden-print col-lg-4 well pre-scrollable">
    <h4><g:message code="survey.recipients.label" default="Recipients"/></h4>
    <ul class="nav bs-docs-sidenav">

        <g:each in="${surveyInstance.recipients}" var="recipient">
            <li>
            ${recipient.email}  (${recipient.status})</li>
        </g:each>
    </ul>
</div>
%{--<div class="col-lg-4">
    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'recipients', 'has-error')} required">
        <label for="type" class="col-sm-2 control-label">
            <g:message code="survey.type.label" default="Type"/>

        </label>

        <div class="col-lg-10">
            <g:each in="${surveyInstance.recipients}" var="recipient">
                ${recipient.email}    ||   ${recipient.status}
            </g:each>
        </div>
    </div>
</div>--}%
