<%@ page import="com.ig.intellimeet.UserPreference" %>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'firstPreferredSessionId', 'has-error')} required">
	<label for="firstPreferredSessionId" class="col-sm-2 control-label">
		<g:message code="userPreference.firstPreferredSessionId.label" default="First Preferred Session Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:field class="form-control" name="firstPreferredSessionId" type="number" value="${userPreferenceInstance.firstPreferredSessionId}" required=""/>

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'firstPreferredSessionId', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='firstPreferredSessionId' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'secondPreferredSessionId', 'has-error')} required">
	<label for="secondPreferredSessionId" class="col-sm-2 control-label">
		<g:message code="userPreference.secondPreferredSessionId.label" default="Second Preferred Session Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:field class="form-control" name="secondPreferredSessionId" type="number" value="${userPreferenceInstance.secondPreferredSessionId}" required=""/>

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'secondPreferredSessionId', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='secondPreferredSessionId' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'thirdPreferredSessionId', 'has-error')} required">
	<label for="thirdPreferredSessionId" class="col-sm-2 control-label">
		<g:message code="userPreference.thirdPreferredSessionId.label" default="Third Preferred Session Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:field class="form-control" name="thirdPreferredSessionId" type="number" value="${userPreferenceInstance.thirdPreferredSessionId}" required=""/>

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'thirdPreferredSessionId', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='thirdPreferredSessionId' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'emailAddress', 'has-error')} ">
	<label for="emailAddress" class="col-sm-2 control-label">
		<g:message code="userPreference.emailAddress.label" default="Email Address" />
		
	</label>
    <div class="col-sm-10">
	    <g:textField name="emailAddress" value="${userPreferenceInstance?.emailAddress}"class="form-control" />

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'emailAddress', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='emailAddress' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'firstPreferredSessionTitle', 'has-error')} ">
	<label for="firstPreferredSessionTitle" class="col-sm-2 control-label">
		<g:message code="userPreference.firstPreferredSessionTitle.label" default="First Preferred Session Title" />
		
	</label>
    <div class="col-sm-10">
	    <g:textField name="firstPreferredSessionTitle" value="${userPreferenceInstance?.firstPreferredSessionTitle}"class="form-control" />

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'firstPreferredSessionTitle', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='firstPreferredSessionTitle' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'fullName', 'has-error')} ">
	<label for="fullName" class="col-sm-2 control-label">
		<g:message code="userPreference.fullName.label" default="Full Name" />
		
	</label>
    <div class="col-sm-10">
	    <g:textField name="fullName" value="${userPreferenceInstance?.fullName}"class="form-control" />

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'fullName', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='fullName' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'intelliMeetId', 'has-error')} required">
	<label for="intelliMeetId" class="col-sm-2 control-label">
		<g:message code="userPreference.intelliMeetId.label" default="Intelli Meet Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:field class="form-control" name="intelliMeetId" type="number" value="${userPreferenceInstance.intelliMeetId}" required=""/>

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'intelliMeetId', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='intelliMeetId' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'secondPreferredSessionTitle', 'has-error')} ">
	<label for="secondPreferredSessionTitle" class="col-sm-2 control-label">
		<g:message code="userPreference.secondPreferredSessionTitle.label" default="Second Preferred Session Title" />
		
	</label>
    <div class="col-sm-10">
	    <g:textField name="secondPreferredSessionTitle" value="${userPreferenceInstance?.secondPreferredSessionTitle}"class="form-control" />

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'secondPreferredSessionTitle', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='secondPreferredSessionTitle' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'thirdPreferredSessionTitle', 'has-error')} ">
	<label for="thirdPreferredSessionTitle" class="col-sm-2 control-label">
		<g:message code="userPreference.thirdPreferredSessionTitle.label" default="Third Preferred Session Title" />
		
	</label>
    <div class="col-sm-10">
	    <g:textField name="thirdPreferredSessionTitle" value="${userPreferenceInstance?.thirdPreferredSessionTitle}"class="form-control" />

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'thirdPreferredSessionTitle', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='thirdPreferredSessionTitle' /></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'userId', 'has-error')} required">
	<label for="userId" class="col-sm-2 control-label">
		<g:message code="userPreference.userId.label" default="User Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <g:field class="form-control" name="userId" type="number" value="${userPreferenceInstance.userId}" required=""/>

        <g:if test="${hasErrors(bean: userPreferenceInstance, field: 'userId', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${userPreferenceInstance}' field='userId' /></span>
        </g:if>
    </div>
</div>

