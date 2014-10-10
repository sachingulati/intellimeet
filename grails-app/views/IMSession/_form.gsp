<%@ page import="com.ig.intellimeet.User; com.ig.intellimeet.enums.SessionStatus; com.ig.intellimeet.IMSession" %>

<g:hiddenField name="topicId" value="${imSessionCO?.topicId}"/>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'title', 'has-error')} required">
    <label for="title" class="col-sm-2 control-label">
        <g:message code="IMSession.title.label" default="Title"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:textField name="title" required="" value="${imSessionCO?.title}" class="form-control"/>

        <g:if test="${hasErrors(bean: imSessionCO, field: 'title', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='title'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'description', 'has-error')} ">
    <label for="description" class="col-sm-2 control-label">
        <g:message code="IMSession.description.label" default="Agenda"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:textArea rows="15" name="description" value="${imSessionCO?.description}" class="form-control"/>

        <g:if test="${hasErrors(bean: imSessionCO, field: 'description', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='description'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'coprenseterId', 'has-error')} ">
    <label for="maxCapacity" class="col-sm-2 control-label">
        <g:message code="IMSession.coprenseterId.label" default="Co Presenter"/>
    </label>

    <div class="col-sm-10">
        <g:select class="form-control" name="copresenterId" noSelection="['': 'Choose Co-Presenter if applicable']"
                  from="${User.list([sort: 'username'])}" optionValue="username" optionKey="id"
                  value="${imSessionCO?.copresenterId}"/>

        <g:if test="${hasErrors(bean: imSessionCO, field: 'copresenterId', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='copresenterId'/></span>
        </g:if>
    </div>
</div>
<g:if test="${actionName == 'edit'}">
    <div class="form-group ${hasErrors(bean: imSessionCO, field: 'sessionStatus', 'has-error')} ">
        <label for="status" class="col-sm-2 control-label">
            <g:message code="IMSession.status.label" default="Status"/>
        </label>

        <div class="col-sm-10">
            <g:select class="form-control" name="sessionStatus" noSelection="['': 'Select Status']"
                      from="${com.ig.intellimeet.enums.SessionStatus.values()}" value="${imSessionCO?.sessionStatus}"/>

            <g:if test="${hasErrors(bean: imSessionCO, field: 'sessionStatus', 'has-error')}">
                <span class="help-block"><g:fieldError bean='${imSessionCO}' field='sessionStatus'/></span>
            </g:if>
        </div>
    </div>
</g:if>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'minCapacity', 'has-error')} ">
    <label for="minCapacity" class="col-sm-2 control-label">
        <g:message code="IMSession.minCapacity.label" default="Min Capacity"/>
        %{--<span class="required-indicator">*</span>--}%
    </label>

    <div class="col-sm-10">
        <g:field class="form-control numeric minCapacity" name="minCapacity" type="number" maxlength="2" min="4"
                 value="${imSessionCO?.minCapacity ?: 4}"/>

        <g:if test="${hasErrors(bean: imSessionCO, field: 'minCapacity', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='minCapacity'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: imSessionCO, field: 'maxCapacity', 'has-error')} ">
    <label for="maxCapacity" class="col-sm-2 control-label">
        <g:message code="IMSession.maxCapacity.label" default="Max Capacity"/>
        %{--<span class="required-indicator">*</span>--}%
    </label>

    <div class="col-sm-10">
        <g:field class="form-control numeric maxCapacity" name="maxCapacity" type="number" maxlength="2" min="5"
                 value="${imSessionCO?.maxCapacity ?: 10}"/>

        <g:if test="${hasErrors(bean: imSessionCO, field: 'maxCapacity', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${imSessionCO}' field='maxCapacity'/></span>
        </g:if>
    </div>
</div>





