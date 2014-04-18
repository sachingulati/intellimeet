<%@ page import="com.ig.intellimeet.User" %>
<h1><a href="#">${topic?.name}</a>
</h1>
<p class="lead">created by <a href="#">${topic?.createdByUsername}</a>
</p>
<hr>
<p><span class="glyphicon glyphicon-time"></span> Posted on ${topic?.dateCreated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
<p></p><span class="glyphicon glyphicon-time"></span> Last updated on ${topic?.lastUpdated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
<hr>
%{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
%{--<hr>--}%
<p>${topic?.description}</p>
<a class="btn btn-default plusOneBtn" topicid="${topic?.id}" href="#"><g:message code="plus.one.label" default="+1" /></a>
&nbsp;<g:link controller="IMSession" action="createNewSessionFromTopic" params="[topicId: topic?.id]" class="btn btn-default"><g:message code="btn.register.presenter.label" default="Register as Presenter" /> <span class="fa fa-sign-in"></span></g:link>

<div style="display: none;" class="attendeesList">
    <g:each in="${topic?.interestedUsers}" var="interestedUserId">
        <span>${User.get(interestedUserId)?.username}</span> <br/>
    </g:each>
</div>