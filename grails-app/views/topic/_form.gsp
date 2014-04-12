<%@ page import="com.ig.intellimeet.Topic" %>



<div class="form-group ${hasErrors(bean: topicInstance, field: 'name', 'has-error')} required">
    <label for="name" class="col-sm-2 control-label">
        <g:message code="topic.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:textField name="name" required="" value="${topicInstance?.name}" class="form-control"/>

        <g:if test="${hasErrors(bean: topicInstance, field: 'name', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${topicInstance}' field='name'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: topicInstance, field: 'description', 'has-error')} required">
    <label for="description" class="col-sm-2 control-label">
        <g:message code="topic.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:textField name="description" required="" value="${topicInstance?.description}" class="form-control"/>

        <g:if test="${hasErrors(bean: topicInstance, field: 'description', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${topicInstance}' field='description'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: topicInstance, field: 'category', 'has-error')} required">
    <label for="category" class="col-sm-2 control-label">
        <g:message code="topic.category.label" default="Category"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:select class="form-control" name="category" from="${com.ig.intellimeet.enums.TopicCategory?.values()}" keys="${com.ig.intellimeet.enums.TopicCategory.values()*.name()}"
                  required="" value="${topicInstance?.category?.name()}"/>

        <g:if test="${hasErrors(bean: topicInstance, field: 'category', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${topicInstance}' field='category'/></span>
        </g:if>
    </div>
</div>

<div class="form-group ${hasErrors(bean: topicInstance, field: 'createdBy', 'has-error')} required">
    <label for="createdBy" class="col-sm-2 control-label">
        <g:message code="topic.createdBy.label" default="Created By"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <g:field class="form-control" name="createdBy" type="number" value="${topicInstance.createdBy}" required=""/>

        <g:if test="${hasErrors(bean: topicInstance, field: 'createdBy', 'has-error')}">
            <span class="help-block"><g:fieldError bean='${topicInstance}' field='createdBy'/></span>
        </g:if>
    </div>
</div>

