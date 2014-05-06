<%@ page import="com.ig.intellimeet.User" %>
<h4>
    <im:ifLoggedInUsername username="${topic?.createdByUsername}">
        <g:link controller="topic" action="edit" id="${topic?.id}"><i class="glyphicon glyphicon-pencil"></i></g:link>&nbsp;
    </im:ifLoggedInUsername>
    <a data-toggle="collapse" data-parent="#accordion" href="#collapse${index}">
    ${topic?.name}
    </a>&nbsp;&nbsp;&nbsp;
    <topic:displayInterestedUsersCount topic="${topic}"/>

    <div style="display: none;" class="attendeesList">
        <g:each in="${topic?.interestedUsers}" var="interestedUserId">
            <span>${User.get(interestedUserId)?.username}</span> <br/>
        </g:each>
    </div>

</h4>
<h6>Created by <a href="mailto:${topic?.createdByUsername}">${topic?.createdByUsername}</a></h6>

<hr>

%{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
%{--<hr>--}%
<div  id="collapse${index}" class="panel-collapse collapse out desc"><p>${raw(topic?.description)}</p></div>

&nbsp;%{--<g:link controller="IMSession" action="createNewSessionFromTopic" params="[topicId: topic?.id]" class="btn btn-default">
     <g:message code="btn.register.presenter.label" default="Register as Presenter"/>
<span class="fa fa-sign-in"></span></g:link>--}%


