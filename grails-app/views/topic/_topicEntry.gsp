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
    <span class="dateCreated">${topic?.dateCreated?.format("MMM dd, yyyy")}</span> <span class="meta-sep">/</span> <span class="category">POSTED IN: ${topic?.category?.displayName}</span>
</div>

%{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
    %{--<hr>--}%
<div class="desc"><strong>Expectations:</strong> &nbsp;<a href="javascript:void(0)" id="topic${topic?.id}" class="editClick"><i class="glyphicon glyphicon-pencil"></i></a>
<div class="desc-content topic${topic?.id}" data-title="Enter Expectations" data-pk="${topic?.id}"><p>${raw(topic?.description)}</p></div></div>
<topic:displayInterestedUsersCount topic="${topic}"/>
&nbsp;

<div style="display: none;" class="attendeesList">
    <g:each in="${topic?.interestedUsers}" var="interestedUserId">
        <span>${User.get(interestedUserId)?.username}</span> <br/>
    </g:each>
</div>
<g:link controller="IMSession" action="createNewSessionFromTopic" params="[topicId: topic?.id]" class="btn btn-primary pull-right">
    <g:message code="btn.register.presenter.label" default="Register as Presenter"/>
    </g:link>
