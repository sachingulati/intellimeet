<!-- Docs master nav -->
<header class="navbar navbar-fixed-top navbar-inverse" id="top" role="banner">
    <div class="container-fluid">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only"><g:message code="toggle.nav.label" default="Toggle navigation"/></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand"><g:message code="intellimeet.label" default="IntelliMeet"/></a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <sec:ifAnyGranted roles="ROLE_USER">
                    <li id="topic"><g:link controller="topic" action="index"><g:message code="topic.label"
                                                                                        default="Topics"/></g:link></li>
                    <li id="session"><g:link controller="IMSession" action="index"><g:message code="session.label"
                                                                                              default="Proposed Sessions"/></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_IM_OWNER">
                    <li id="preference"><g:link controller="userPreference" action="index"><g:message
                            code="preference.label" default="Preferences"/></g:link></li>
                    <li id="survey"><g:link controller="survey" action="index"><g:message code="survey.label"
                                                                                          default="Survey"/></g:link></li>
                    <li id="allocation"><g:link controller="sessionAllocation" action="show"><g:message
                            code="allocation.label" default="Allocations"/></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                    <li id="intellimeet"><g:link controller="intelliMeet" action="index"><g:message
                            code="intellimeet.label" default="IntelliMeet"/></g:link></li>
                </sec:ifAnyGranted>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <sec:ifLoggedIn>
                    <li>
                        <g:link controller="user" action="profile" style="padding:5px 15px;">
                            <user:displayUserImageInMainNav email="${sec.username()}"/>
                            <span style="padding: 10px 0;"><sec:username/></span>
                        </g:link>
                    </li>
                    <li><g:link controller="logout"><g:message code="logout.label" default="Log Out"/></g:link></li>
                </sec:ifLoggedIn>
            </ul>
        </nav>
    </div>
</header>
