<%@ page import="com.ig.intellimeet.UserPreference" %>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'firstPreferredSessionId', 'has-error')} required">
	<label for="firstPreferredSessionId" class="col-sm-2 control-label">
		<g:message code="userPreference.firstPreferredSessionId.label" default="First Preferred Session Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: userPreferenceInstance, field: 'firstPreferredSessionId')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'secondPreferredSessionId', 'has-error')} required">
	<label for="secondPreferredSessionId" class="col-sm-2 control-label">
		<g:message code="userPreference.secondPreferredSessionId.label" default="Second Preferred Session Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: userPreferenceInstance, field: 'secondPreferredSessionId')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'thirdPreferredSessionId', 'has-error')} required">
	<label for="thirdPreferredSessionId" class="col-sm-2 control-label">
		<g:message code="userPreference.thirdPreferredSessionId.label" default="Third Preferred Session Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: userPreferenceInstance, field: 'thirdPreferredSessionId')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'emailAddress', 'has-error')} ">
	<label for="emailAddress" class="col-sm-2 control-label">
		<g:message code="userPreference.emailAddress.label" default="Email Address" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: userPreferenceInstance, field: 'emailAddress')}</p>
    </div>
</div>

<div class="form-group">
	<label for="firstPreferredSessionTitle" class="col-sm-2 control-label">
		<g:message code="userPreference.firstPreferredSessionTitle.label" default="First Preferred Session Title" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${${UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreferenceInstance.firstPreferredSessionId,userPreferenceInstance.intelliMeetId)}}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'fullName', 'has-error')} ">
	<label for="fullName" class="col-sm-2 control-label">
		<g:message code="userPreference.fullName.label" default="Full Name" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: userPreferenceInstance, field: 'fullName')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'intelliMeetId', 'has-error')} required">
	<label for="intelliMeetId" class="col-sm-2 control-label">
		<g:message code="userPreference.intelliMeetId.label" default="Intelli Meet Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: userPreferenceInstance, field: 'intelliMeetId')}</p>
    </div>
</div>

<div class="form-group ">
	<label for="secondPreferredSessionTitle" class="col-sm-2 control-label">
		<g:message code="userPreference.secondPreferredSessionTitle.label" default="Second Preferred Session Title" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${${UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreferenceInstance.secondPreferredSessionId,userPreferenceInstance.intelliMeetId)}}</p>
    </div>
</div>

<div class="form-group ">
	<label for="thirdPreferredSessionTitle" class="col-sm-2 control-label">
		<g:message code="userPreference.thirdPreferredSessionTitle.label" default="Third Preferred Session Title" />
		
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${${UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreferenceInstance.thirdPreferredSessionId,userPreferenceInstance.intelliMeetId)}}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: userPreferenceInstance, field: 'userId', 'has-error')} required">
	<label for="userId" class="col-sm-2 control-label">
		<g:message code="userPreference.userId.label" default="User Id" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-10">
	    <p class="form-control-static">${fieldValue(bean: userPreferenceInstance, field: 'userId')}</p>
    </div>
</div>

