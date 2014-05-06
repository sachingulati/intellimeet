<%@ page import="com.ig.intellimeet.Survey" %>

<div class="form-group ${hasErrors(bean: surveyInstance, field: 'title', 'has-error')} required">
    <label for="title" class="col-sm-2 control-label">
        <g:message code="survey.title.label" default="Title"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'title')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: surveyInstance, field: 'date', 'has-error')} required">
    <label for="date" class="col-sm-2 control-label">
        <g:message code="survey.date.label" default="Date"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'date')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: surveyInstance, field: 'intelliMeetTitle', 'has-error')} required">
    <label for="intelliMeetId" class="col-sm-2 control-label">
        <g:message code="ntelliMeet.label" default="Intelli Meet"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'intelliMeetTitle')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: surveyInstance, field: 'type', 'has-error')} required">
    <label for="type" class="col-sm-2 control-label">
        <g:message code="survey.type.label" default="Type"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <p class="form-control-static">${fieldValue(bean: surveyInstance, field: 'type')}</p>
    </div>
</div>

