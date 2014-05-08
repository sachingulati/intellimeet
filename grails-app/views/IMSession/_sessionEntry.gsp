<%@ page import="com.ig.intellimeet.User" %>
<h1>
    <im:ifLoggedInUsername username="${imSession?.ownersEmail}">
        <g:link controller="IMSession" action="edit" id="${imSession?.id}"><i class="glyphicon glyphicon-pencil"></i></g:link>&nbsp;
    </im:ifLoggedInUsername>

    <a href="${createLink(controller: 'IMSession', action: 'show', id: imSession?.id)}">${imSession?.title}</a>
</h1>

<p class="lead">owned by <a href="#">${imSession?.ownersEmail}</a>
</p>

<g:if test="${imSession?.maxCapacity && imSession?.minCapacity}">
    <div class="session-entry">
        <strong>Capacity:</strong>  ${imSession?.minCapacity ?: 'NA'} - ${imSession?.maxCapacity ?: 'NA'} people
    </div>
</g:if><g:else>
    <hr/>
</g:else>
<div class="desc"><h4 style="text-transform: uppercase;">Agenda:</h4>

    <div class="desc-agenda">${raw(imSession?.description)}</div>
    %{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
    %{--<hr>--}%
</div>

<g:if test="${imSession.attendeesEmails}">
    <div class="desc-attendees">
        <h4 style="text-transform: uppercase;">List of Attendees:</h4>

        <ol class="attendee-list">
            <g:each in="${imSession?.attendeesEmails}" var="attendeeEmail">
                <li>${attendeeEmail}</li>
            </g:each>
        </ol>
    </div>
</g:if>