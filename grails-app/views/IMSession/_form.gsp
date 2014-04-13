<%@ page import="com.ig.intellimeet.enums.SessionStatus; com.ig.intellimeet.IMSession" %>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'title', 'has-error')} required">
	<label for="title" class="col-sm-2 control-label">
		<g:message code="IMSession.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:textField name="title" required="" value="${imSessionCO?.title}" class="form-control" />

        <g:if test="${hasErrors(bean: imSessionCO, field: 'title', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='title' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'description', 'has-error')} ">
    <label for="description" class="col-sm-2 control-label">
        <g:message code="IMSession.description.label" default="Description" />
        <span class="required-indicator">*</span>
    </label>
    <div class="col-sm-10">
        <g:textArea rows="10" name="description" value="${imSessionCO?.description}" class="form-control" />

        <g:if test="${hasErrors(bean: imSessionCO, field: 'description', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='description' /></span>
        </g:if>
    </div>
</div>


<div class="form-group ${hasErrors(bean: imSessionCO, field: 'maxCapacity', 'has-error')} ">
	<label for="maxCapacity" class="col-sm-2 control-label">
		<g:message code="IMSession.maxCapacity.label" default="Max Capacity" />
        <span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:field class="form-control" name="maxCapacity" type="number" value="${imSessionCO.maxCapacity}"/>

        <g:if test="${hasErrors(bean: imSessionCO, field: 'maxCapacity', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='maxCapacity' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'minCapacity', 'has-error')} ">
	<label for="minCapacity" class="col-sm-2 control-label">
		<g:message code="IMSession.minCapacity.label" default="Min Capacity" />
        <span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:field class="form-control" name="minCapacity" type="number" value="${imSessionCO.minCapacity}"/>

        <g:if test="${hasErrors(bean: imSessionCO, field: 'minCapacity', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='minCapacity' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'sessionStatus', 'has-error')} required">
	<label for="sessionStatus" class="col-sm-2 control-label">
		<g:message code="IMSession.sessionStatus.label" default="Session Status" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:select class="form-control" name="sessionStatus" from="${SessionStatus?.values()}" keys="${SessionStatus.values()*.name()}" required="" value="${imSessionCO?.sessionStatus?.name()}" />

        <g:if test="${hasErrors(bean: imSessionCO, field: 'sessionStatus', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='sessionStatus' /></span>
        </g:if>
    </div>
</div>
