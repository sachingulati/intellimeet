<div class="form-group ${hasError ? 'has-error' : ''}">
    <label for="${name}" class="col-sm-2 control-label">${label}${required ? ' *' : ''}</label>

    <div class="col-sm-3">
        <div class="checkbox">
            <label><g:checkBox id="${name}" name="${name}" value="${value}"/></label>
        </div>
    </div>
</div>