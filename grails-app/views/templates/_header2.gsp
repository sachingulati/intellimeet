<!-- Callout for the old docs link -->
<div class="bs-old-docs">
    <div class="container">
        <strong>
            <a href="${titleLink ?: '#'}">${title}</a>
        </strong>
        <g:if test="description">
            ${description}
        </g:if>
    </div>
    <g:if test="${requireSearch}">
        <form class="form-inline" role="form" class="">
            <div class="form-group">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Go!</button>
                    </span>
                </div>
            </div>
        </form>
    </g:if>
</div>