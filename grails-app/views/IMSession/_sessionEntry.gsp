<%@ page import="com.ig.intellimeet.User" %>
<h1>
    <im:ifLoggedInUsername username="${imSession?.ownersEmail}">
        <g:link controller="IMSession" action="edit" id="${imSession?.id}"><i class="glyphicon glyphicon-pencil"></i></g:link>&nbsp;
    </im:ifLoggedInUsername>

    <a href="${createLink(controller: 'IMSession', action: 'show', id: imSession?.id)}">${imSession?.title}</a>
</h1>

<p class="lead">owned by <a href="#">${imSession?.ownersEmail}</a>
</p>
<hr>

<p style="text-transform: uppercase;"><span class="fa fa-arrow-up"></span> Maximum Capacity: ${imSession?.maximumCapacity?:'undefined'}, <span class="fa fa-arrow-down"></span> Minimum Capacity: ${imSession?.minimumCapacity?:'undefined'}</p>

<hr>
<h4 style="text-transform: uppercase;">Agenda:</h4>

${raw(imSession?.description)}
%{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
%{--<hr>--}%
<h4 style="text-transform: uppercase;">List of Attendees:</h4>

<ul class="list">
    <g:each in="${imSession?.attendeesEmails?.sort()}" var="attendeeEmail">
        <li>&nbsp;${attendeeEmail}</li>
    </g:each>
</ul>