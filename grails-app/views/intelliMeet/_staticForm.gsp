<%@ page import="com.ig.intellimeet.IntelliMeet" %>

<div class="form-group ${hasErrors(bean: intelliMeetInstance, field: 'title', 'has-error')} required">
	<label for="title" class="col-sm-2 control-label">
		<g:message code="intelliMeet.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: intelliMeetInstance, field: 'title')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetInstance, field: 'description', 'has-error')} ">
	<label for="description" class="col-sm-2 control-label">
		<g:message code="intelliMeet.description.label" default="Description" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: intelliMeetInstance, field: 'description')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetInstance, field: 'place', 'has-error')} ">
	<label for="place" class="col-sm-2 control-label">
		<g:message code="intelliMeet.place.label" default="Place" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: intelliMeetInstance, field: 'place')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: intelliMeetInstance, field: 'dateOfEvent', 'has-error')} required">
	<label for="dateOfEvent" class="col-sm-2 control-label">
		<g:message code="intelliMeet.dateOfEvent.label" default="Date Of Event" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: intelliMeetInstance, field: 'dateOfEvent')}</p>
    </div>
</div>

