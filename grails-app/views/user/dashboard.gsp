<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Dashboard</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div content="container" style="margin: 10px 10px">

    <div class="row">
        <div class="col-lg-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Recently Created Topics</h3>
                </div>
                %{--<div class="panel-body">--}%
                <ul class="list-group">
                    <g:each in="${recentTopics}" var="topic">
                        <li class="list-group-item">
                            <span class="badge glyphicon glyphicon-thumbs-up"> ${topic?.interestedUsers?.size()}</span>
                            ${topic?.name}
                            %{--<p class="list-group-item-text">...</p>--}%
                        </li>
                    </g:each>
                </ul>
                %{--</div>--}%
            </div>
        </div>

        <div class="col-lg-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Recently Proposed Sessions</h3>
                </div>
                %{--<div class="panel-body">--}%
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
                %{--</div>--}%
            </div>
        </div>
    </div>
</div>
</body>
</html>