<a class="btn ${currentUserAlreadyOpted ? 'btn-primary disabled' : 'btn-primary'} plusOneBtn" data-topicid="${topicId}" href="#">Like</a>
<div style="padding-left: 5px;display: inline" class="like-text">
    <span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;
    <g:if test="${interestedUserCount}">
        <a href="javascript:void();" class="interested-users-link"><span class="interestedUserCount">${interestedUserCount}</span>  people</a> like this.
    </g:if>
    <g:else>
        Be the first one to like this
    </g:else>
</div>