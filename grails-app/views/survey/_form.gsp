<%@ page import="com.ig.intellimeet.Survey" %>



<div class="form-group ${hasErrors(bean: surveyInstance, field: 'title', 'has-error')} required">
    <label for="title" class="col-sm-2 control-label">
        <g:message code="survey.title.label" default="Title"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:textField name="title" required="" value="${surveyInstance?.title}" class="form-control"/>

        <g:if test="${hasErrors(bean: surveyInstance, field: 'title', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${surveyInstance}' field='title'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: surveyInstance, field: 'date', 'has-error')} required">
    <label for="date" class="col-sm-2 control-label">
        <g:message code="survey.date.label" default="Date"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <input type="text" class="form-control" name="date" data-date-calendar-weeks="true" data-date-today-highlight="true" data-date-orientation="auto left" data-provide="datepicker" data-date-autoclose="true" data-keyboard-navigation="true" data-format="MM/dd/yyyy" value="${surveyInstance?.date?.format("MM/dd/yyyy")}" id="dateOfEvent">

        <g:if test="${hasErrors(bean: surveyInstance, field: 'date', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${surveyInstance}' field='date'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: surveyInstance, field: 'recipientsEmail', 'has-error')} required">
    <label for="intelliMeetId" class="col-sm-2 control-label">
        <g:message code="survey.recipientsEmail.label" default="Please enter recipients email separated by comma(,)"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:textArea rows="10" class="form-control" name="recipientsEmail" type="number" value="${surveyInstance.recipientsEmail}" required=""/>

        <g:if test="${hasErrors(bean: surveyInstance, field: 'recipientsEmail', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${surveyInstance}' field='recipientsEmail'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: surveyInstance, field: 'type', 'has-error')} required">
    <label for="type" class="col-sm-2 control-label">
        <g:message code="survey.type.label" default="Type"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:select class="form-control" name="type" from="${com.ig.intellimeet.enums.SurveyType?.values()}" keys="${com.ig.intellimeet.enums.SurveyType.values()*.name()}"
                  required="" value="${surveyInstance?.type?.name()}"/>

        <g:if test="${hasErrors(bean: surveyInstance, field: 'type', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${surveyInstance}' field='type'/></span>
        </g:if>
    </div>
</div>

