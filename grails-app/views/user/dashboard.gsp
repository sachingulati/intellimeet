<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Dashboard</title>
    <meta name="layout" content="main"/>

    <style>
    .defaulters {
        height: 70em;
        overflow: scroll;
        overflow-x: hidden;
    }
    </style>
</head>

<body>
<div content="container" style="margin: 10px 10px">

    <div class="row">
        <div class="col-lg-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Recently Created Topics</h3>
                </div>
                <ul class="list-group">
                    <g:each in="${recentTopics}" var="topic">
                        <li class="list-group-item">
                            <span class="badge glyphicon glyphicon-thumbs-up">&nbsp;${topic?.interestedUsers?.size()}</span>
                            ${topic?.name}
                        </li>
                    </g:each>
                </ul>
            </div>
        </div>

        <div class="col-lg-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Recently Proposed Sessions</h3>
                </div>
                <g:if test="${recentProposedSessions?.size()}">
                    <ul class="list-group">
                        <g:each in="${recentProposedSessions}" var="imSession">
                            <li class="list-group-item">
                                <p>${imSession?.title}</p>
                                <span>
                                    <small>- by ${imSession?.ownersEmail}</small>
                                </span>
                                %{--<p class="list-group-item-text">...</p>--}%
                            </li>
                        </g:each>
                    </ul>
                </g:if>
                <g:else>
                    <div class="panel-body">
                        <h4 class="list-group-item-heading">Sorry! No session proposed yet.</h4>
                    </div>
                </g:else>
            </div>
        </div>

        <div class="col-lg-4">
            <h3>Who didn't like any topic?</h3>

            <div class="form-group">
                <input class="form-control" id="searchinput" type="search" placeholder="Search...">
            </div>
            <ul class="list-group searchable defaulters">
                <g:each in="${usersNotLikedAnyTopic}" var="user">
                    <li class="list-group-item search-item">${user?.username}</li>
                </g:each>
            </ul>
        </div>
    </div>
</div>
</div>

<r:script>
    markAsActive("dashboard");
</r:script>
</body>
</html>