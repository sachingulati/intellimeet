<div class="form-group ${hasErrors(bean: bean, field: name, 'has-error')}">
    <label for="${name}">${label}${required ? ' *' : ''}</label>

    <input id="${name}" name="${name}" type="${type}" class="form-control" value="${value}"/>
    <g:if test="${hasErrors(bean: bean, field: name, 'has-error')}">
        <span class="help-block"><g:fieldError bean="${bean}" field="${name}"/></span>
    </g:if>
</div>