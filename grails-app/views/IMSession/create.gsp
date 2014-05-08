<%@ page import="org.springframework.validation.FieldError" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'IMSession.label', default: 'IntelliMeet Session')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
    <r:require module="wysi_html5"/>
</head>

<body>
<a href="#create-IMSession" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><g:message code="default.create.label" args="[entityName]"/></a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><g:link action="index"><span class="fa fa-th-list"></span>&nbsp;<g:message code="list.imSession.label" default="Sessions"/></g:link></li>
            <li><g:link controller="topic" action="index"><span class="fa fa-th-list"></span>&nbsp;<g:message code="list.topic.label" default="Topics"/></g:link>
            </li>
        </ul>
    </div>
</nav>

<div id="create-IMSession" class="container" role="main">
    <g:if test="${flash.message}">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong>Success!</strong> ${flash.message}.
        </div>
    </g:if>
    <g:if test="${flash.error}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong>Error!</strong> ${flash.message}.
        </div>
    </g:if>
    <g:hasErrors bean="${imSessionCO}">
        <div class="alert alert-danger alert-dismissable">
            <ul class="list-unstyled" role="alert">
                <g:eachError bean="${imSessionCO}" var="error">
                    <li <g:if test="${error in FieldError}">data-field-id="${error?.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
        </div>
    </g:hasErrors>
    <g:form class="form-horizontal" url="[controller: 'IMSession', action: 'save']">
        <g:render template="form" model="[imSessionCO: imSessionCO]"/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <g:submitButton name="create" class="btn btn-lg btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}"/>
            </div>
        </div>
    </g:form>
</div>
    <r:script>
        markAsActive("session");

        $('.numeric').keypress(function(evt) {
            var charCode = (evt.which) ? evt.which : event.keyCode;
            //console.log(charCode);
            if (charCode < 48 || charCode > 57) {
                return false;
            }
            return true;

        });

        $('.minCapacity').change(function() {
            var minValue = parseInt($(this).val());
            var maxValue = parseInt($('.maxCapacity').val());

            if (minValue > maxValue) {
                $('.maxCapacity').val(minValue);
            }
        });

    </r:script>
</body>
</html>
