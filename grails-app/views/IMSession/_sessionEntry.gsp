<%@ page import="com.ig.intellimeet.User" %>
<h1>
    <im:ifLoggedInUsername username="${imSession?.ownersEmail}">
        <g:link controller="IMSession" action="edit" id="${imSession?.id}"><i class="glyphicon glyphicon-pencil"></i></g:link>&nbsp;
    </im:ifLoggedInUsername>

    <a href="${createLink(controller: 'IMSession', action: 'show', id: imSession?.id)}">${imSession?.title}</a>
</h1>

<p class="lead">owned by <a href="#">${imSession?.ownersEmail}</a>
</p>

<div class="session-entry"><span class="fa fa-arrow-up"></span> Maximum Capacity: ${imSession?.maxCapacity ?: 'undefined'}, <span
        class="fa fa-arrow-down"></span> Minimum Capacity: ${imSession?.minCapacity ?: 'undefined'}
</div>

<div class="desc"><h4 style="text-transform: uppercase;">Agenda:</h4>

    <div class="desc-agenda">${raw(imSession?.description)}</div>
    %{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
    %{--<hr>--}%
</div>

<div class="desc-attendees">
    <h4 style="text-transform: uppercase;">List of Attendees:</h4>

    <ul class="list-unstyled attendee-list">
        <g:each in="${imSession?.attendeesEmails}" var="attendeeEmail">
            <li><span class="fa fa-angle-double-right"></span>&nbsp;${attendeeEmail}</li>
        </g:each>
    </ul>
</div>