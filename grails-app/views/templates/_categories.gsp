<div class="row">
    <div class="col-lg-6">
        <ul class="list-unstyled">

            <g:each in="${categoryCountMap.keySet()}" var="currKey">
                <li><a href="#${currKey}">${currKey} (${categoryCountMap.get(currKey)})</a>
                </li>
            </g:each>
        </ul>
    </div>
</div>