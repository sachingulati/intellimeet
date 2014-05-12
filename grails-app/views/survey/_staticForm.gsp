<%@ page import="com.ig.intellimeet.enums.SurveyStatus; com.ig.intellimeet.Survey" %>

<div class="col-lg-6">
    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'title', 'has-error')} required">
        <label for="title" class="col-sm-4 control-label">
            <g:message code="survey.title.label" default="Title"/>:
        </label>

        <div class="col-lg-6">
            <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'title')}</p>
        </div>
    </div>

    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'date', 'has-error')} required">
        <label for="date" class="col-sm-4 control-label">
            <g:message code="survey.date.label" default="Date"/>:

        </label>

        <div class="col-lg-6">
            <p class="form-control-static">
                <g:formatDate format="dd MMM yyyy" date="${surveyInstance.date}"/>
            </p>
        </div>
    </div>

    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'intelliMeetTitle', 'has-error')} required">
        <label for="intelliMeetId" class="col-sm-4 control-label">
            <g:message code="ntelliMeet.label" default="Intelli Meet"/>:

        </label>

        <div class="col-lg-6">
            <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'intelliMeetTitle')}</p>
        </div>
    </div>

    <div class="form-group ${hasErrors(bean: surveyInstance, field: 'type', 'has-error')} required">
        <label for="type" class="col-sm-4 control-label">
            <g:message code="survey.type.label" default="Type"/>:

        </label>

        <div class="col-lg-6">
            <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'type')}</p>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-6">
            <g:link class="btn btn-lg btn-primary" action="edit" resource="${surveyInstance}"><g:message code="default.button.edit.label" default="Edit"/></g:link>
            <g:link class="${surveyInstance?.recipients*.status?.contains(SurveyStatus.PENDING) ?: 'disabled'} btn btn-lg btn-primary" action="send" controller="survey"
                    id="${surveyInstance?.id}"><span class="glyphicon glyphicon-send"></span>&nbsp;<g:message code="default.button.email.label"
                                                                                                              default="Email"/></g:link>
        </div>
    </div>
</div>

<div class="col-lg-6">
    <legend>Recipient's Email Addresses</legend>
    <ol class="attendee-list">
        <g:each in="${surveyInstance.recipients}" var="recipient">
            <li>${recipient.email} (${recipient?.status})</li>
        </g:each>
    </ol>
</div>