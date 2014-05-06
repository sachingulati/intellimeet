<%@ page import="com.ig.intellimeet.User" %>
<h1>
    <im:ifLoggedInUsername username="${topic?.createdByUsername}">
        <g:link controller="topic" action="edit" id="${topic?.id}"><i class="glyphicon glyphicon-pencil"></i></g:link>&nbsp;
    </im:ifLoggedInUsername>
    ${topic?.name}
</h1>
<p class="lead">created by <a href="mailto:${topic?.createdByUsername}">${topic?.createdByUsername}</a>
</p>
<div class="topic-entry">
    <span class="dateCreated">${topic?.dateCreated?.format("MMM dd, yyyy")}</span> <span class="meta-sep">/</span> <span class="category">POSTED IN: ${topic?.category}</span>
</div>

%{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
    %{--<hr>--}%
<div class="desc"><strong>Expectations:</strong><p>${raw(topic?.description)}</p></div>
<topic:displayInterestedUsersCount topic="${topic}"/>
&nbsp;
%{--<g:link controller="IMSession" action="createNewSessionFromTopic" params="[topicId: topic?.id]" class="btn btn-default">
     <g:message code="btn.register.presenter.label" default="Register as Presenter"/>
<span class="fa fa-sign-in"></span></g:link>--}%

<div style="display: none;" class="attendeesList">
    <g:each in="${topic?.interestedUsers}" var="interestedUserId">
        <span>${User.get(interestedUserId)?.username}</span> <br/>
    </g:each>
</div>