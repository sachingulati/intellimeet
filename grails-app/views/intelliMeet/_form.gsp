<%@ page import="com.ig.intellimeet.User; com.ig.intellimeet.IntelliMeet" %>

<div class="form-group ${hasErrors(bean: intelliMeetCO, field: 'title', 'has-error')} required">
    <label for="title" class="col-sm-2 control-label">
        <g:message code="intelliMeet.title.label" default="Title"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:textField name="title" required="" value="${intelliMeetCO?.title}" class="form-control"/>

        <g:if test="${hasErrors(bean: intelliMeetCO, field: 'title', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetCO}' field='title'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetCO, field: 'firstOwnerId', 'has-error')} ">
    <label for="firstOwner" class="col-sm-2 control-label">
        <g:message code="intelliMeet.firstOwner.label" default="First Owner"/>
    </label>

    <div class="col-sm-10">
        <g:select class="form-control" name="firstOwnerId" noSelection="['': 'Choose First owner' ]" from="${User.list([sort: 'username'])}" optionValue="username" optionKey="id" value="${imSessionCO?.copresenterId}"/>

        <g:if test="${hasErrors(bean: intelliMeetCO, field: 'firstOwnerId', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetCO}' field='firstOwnerId'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetCO, field: 'secondOwnerId', 'has-error')} ">
    <label for="maxCapacity" class="col-sm-2 control-label">
        <g:message code="I.coprenseterId.label" default="Co Presenter"/>
    </label>

    <div class="col-sm-10">
        <g:select class="form-control" name="secondOwnerId" noSelection="['': 'Choose second owner' ]" from="${User.list([sort: 'username'])}" optionValue="username" optionKey="id" value="${imSessionCO?.copresenterId}"/>

        <g:if test="${hasErrors(bean: intelliMeetCO, field: 'secondOwnerId', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetCO}' field='secondOwnerId'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetCO, field: 'description', 'has-error')} ">
    <label for="description" class="col-sm-2 control-label">
        <g:message code="intelliMeet.description.label" default="Description"/>

    </label>

    <div class="col-sm-10">
        <g:textField name="description" value="${intelliMeetCO?.description}" class="form-control"/>

        <g:if test="${hasErrors(bean: intelliMeetCO, field: 'description', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetCO}' field='description'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetCO, field: 'place', 'has-error')} ">
    <label for="place" class="col-sm-2 control-label">
        <g:message code="intelliMeet.place.label" default="Place"/>

    </label>

    <div class="col-sm-10">
        <g:textField name="place" value="${intelliMeetCO?.place}" class="form-control"/>

        <g:if test="${hasErrors(bean: intelliMeetCO, field: 'place', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetCO}' field='place'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetCO, field: 'dateOfEvent', 'has-error')} required">
    <label for="dateOfEvent" class="col-sm-2 control-label">
        <g:message code="intelliMeet.dateOfEvent.label" default="Date Of Event"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:textField class="form-control" name="dateOfEvent" data-date-calendar-weeks="true" data-date-today-highlight="true" data-date-orientation="auto left" data-provide="datepicker" data-date-autoclose="true" data-keyboard-navigation="true" data-format="MM/dd/yyyy"  value="${intelliMeetCO?.dateOfEvent?.format("MM/dd/yyyy")}" />

        <g:if test="${hasErrors(bean: intelliMeetCO, field: 'dateOfEvent', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetCO}' field='dateOfEvent'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetCO, field: 'status', 'has-error')} required">
    <label for="status" class="col-sm-2 control-label">
        <g:message code="intelliMeet.status.label" default="Status"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:select class="form-control" name="status" from="${com.ig.intellimeet.enums.IntelliMeetStatus?.values()}"
                  keys="${com.ig.intellimeet.enums.IntelliMeetStatus.values()*.name()}" required="" value="${intelliMeetCO?.status?.name()}"/>

        <g:if test="${hasErrors(bean: intelliMeetCO, field: 'status', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetCO}' field='status'/></span>
        </g:if>
    </div>
</div>

