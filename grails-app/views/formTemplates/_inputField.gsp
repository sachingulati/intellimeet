<div class="form-group ${errors ? 'has-error' : ''}">
    <label for="${name}" class="col-sm-2 control-label">${label}${required ? ' *' : ''}</label>

    <div class="col-sm-3">
        <input id="${name}" name="${name}" type="${type}" class="form-control" placeholder="${label}" value="${value}"/>
        <g:if test="${errors}">
            <span class="help-block">${errors}</span>
        </g:if>
    </div>
</div>