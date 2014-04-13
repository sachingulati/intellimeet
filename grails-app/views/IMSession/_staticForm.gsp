<%@ page import="com.ig.intellimeet.IMSession" %>

<div class="form-group ${hasErrors(bean: IMSessionInstance, field: 'title', 'has-error')} required">
	<label for="title" class="col-sm-2 control-label">
		<g:message code="IMSession.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: IMSessionInstance, field: 'title')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: IMSessionInstance, field: 'maxCapacity', 'has-error')} ">
	<label for="maxCapacity" class="col-sm-2 control-label">
		<g:message code="IMSession.maxCapacity.label" default="Max Capacity" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: IMSessionInstance, field: 'maxCapacity')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: IMSessionInstance, field: 'minCapacity', 'has-error')} ">
	<label for="minCapacity" class="col-sm-2 control-label">
		<g:message code="IMSession.minCapacity.label" default="Min Capacity" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: IMSessionInstance, field: 'minCapacity')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: IMSessionInstance, field: 'score', 'has-error')} ">
	<label for="score" class="col-sm-2 control-label">
		<g:message code="IMSession.score.label" default="Score" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: IMSessionInstance, field: 'score')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: IMSessionInstance, field: 'description', 'has-error')} ">
	<label for="description" class="col-sm-2 control-label">
		<g:message code="IMSession.description.label" default="Description" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: IMSessionInstance, field: 'description')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: IMSessionInstance, field: 'intelliMeetId', 'has-error')} required">
	<label for="intelliMeetId" class="col-sm-2 control-label">
		<g:message code="IMSession.intelliMeetId.label" default="Intelli Meet Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: IMSessionInstance, field: 'intelliMeetId')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: IMSessionInstance, field: 'sessionStatus', 'has-error')} required">
	<label for="sessionStatus" class="col-sm-2 control-label">
		<g:message code="IMSession.sessionStatus.label" default="Session Status" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: IMSessionInstance, field: 'sessionStatus')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: IMSessionInstance, field: 'topicId', 'has-error')} required">
	<label for="topicId" class="col-sm-2 control-label">
		<g:message code="IMSession.topicId.label" default="Topic Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: IMSessionInstance, field: 'topicId')}</p>
    </div>
</div>

