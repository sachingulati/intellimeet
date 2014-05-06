<%@ page import="com.ig.intellimeet.Topic" %>



<div class="form-group ${hasErrors(bean: topicInstance, field: 'name', 'has-error')} required">
    <label for="name" class="col-sm-2 control-label">
        <g:message code="topic.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <p class="form-control-static">${fieldValue(bean: topicInstance, field: 'name')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: topicInstance, field: 'description', 'has-error')} required">
    <label for="description" class="col-sm-2 control-label">
        <g:message code="topic.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <p class="form-control-static">${fieldValue(bean: topicInstance, field: 'description')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: topicInstance, field: 'category', 'has-error')} required">
    <label for="category" class="col-sm-2 control-label">
        <g:message code="topic.category.label" default="Category"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <p class="form-control-static">${fieldValue(bean: topicInstance, field: 'category')}</p>
    </div>
</div>

<div class="form-group ${hasErrors(bean: topicInstance, field: 'createdBy', 'has-error')} required">
    <label for="createdBy" class="col-sm-2 control-label">
        <g:message code="topic.createdBy.label" default="Created By"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="col-sm-10">
        <p class="form-control-static">${fieldValue(bean: topicInstance, field: 'createdBy')}</p>
    </div>
</div>

