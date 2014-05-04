<%@ page import="com.ig.intellimeet.IntelliMeet" %>



<div class="form-group ${hasErrors(bean: intelliMeetInstance, field: 'title', 'has-error')} required">
	<label for="title" class="col-sm-2 control-label">
		<g:message code="intelliMeet.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:textField name="title" required="" value="${intelliMeetInstance?.title}"class="form-control" />

        <g:if test="${hasErrors(bean: intelliMeetInstance, field: 'title', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetInstance}' field='title' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetInstance, field: 'description', 'has-error')} ">
	<label for="description" class="col-sm-2 control-label">
		<g:message code="intelliMeet.description.label" default="Description" />
		
	</label>
    <div class="col-sm-10">
	    <g:textField name="description" value="${intelliMeetInstance?.description}"class="form-control" />

        <g:if test="${hasErrors(bean: intelliMeetInstance, field: 'description', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetInstance}' field='description' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetInstance, field: 'place', 'has-error')} ">
	<label for="place" class="col-sm-2 control-label">
		<g:message code="intelliMeet.place.label" default="Place" />
		
	</label>
    <div class="col-sm-10">
	    <g:textField name="place" value="${intelliMeetInstance?.place}"class="form-control" />

        <g:if test="${hasErrors(bean: intelliMeetInstance, field: 'place', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetInstance}' field='place' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetInstance, field: 'dateOfEvent', 'has-error')} required">
	<label for="dateOfEvent" class="col-sm-2 control-label">
		<g:message code="intelliMeet.dateOfEvent.label" default="Date Of Event" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:datePicker name="dateOfEvent" precision="day"  value="${intelliMeetInstance?.dateOfEvent}"  />

        <g:if test="${hasErrors(bean: intelliMeetInstance, field: 'dateOfEvent', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${intelliMeetInstance}' field='dateOfEvent' /></span>
        </g:if>
    </div>
</div>

