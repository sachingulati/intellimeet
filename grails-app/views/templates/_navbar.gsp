<!-- Docs master nav -->
<header class="navbar navbar-fixed-top navbar-inverse" id="top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only"><g:message code="toggle.nav.label" default="Toggle navigation" /></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand"><g:message code="intellimeet.label" default="IntelliMeet" /></a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li id="topic"><g:link controller="topic" action="index"><g:message code="topic.label" default="Topic" /></g:link></li>
                <li id="session"><g:link controller="IMSession" action="index"><g:message code="session.label" default="Session" /></g:link></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <sec:ifLoggedIn>
                    <li><g:link controller="logout"><g:message code="logout.label" default="Log Out" /></g:link></li>
                </sec:ifLoggedIn>
            </ul>
        </nav>
    </div>
</header>
