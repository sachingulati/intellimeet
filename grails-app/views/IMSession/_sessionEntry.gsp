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

<p><span class="glyphicon glyphicon-time"></span> Posted on ${imSession?.dateCreated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>

<p></p><span class="glyphicon glyphicon-time"></span> Last updated on ${imSession?.lastUpdated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
<hr>
<h4 style="text-transform: uppercase;">Agenda:</h4>

${raw(imSession?.description)}
%{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
%{--<hr>--}%
<h4 style="text-transform: uppercase;">List of Attendees:</h4>

<ul class="list-unstyled">
    <g:each in="${imSession?.attendeesEmails}" var="attendeeEmail">
        <li><span class="fa fa-angle-double-right"></span>&nbsp;${attendeeEmail}</li>
    </g:each>
</ul>