<!-- Docs master nav -->
<header class="navbar navbar-fixed-top navbar-inverse" id="top" role="banner">
    <div class="container-fluid">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand">IntelliMeet</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                    <li><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
                </g:each>
                <sec:ifLoggedIn>
                    <li><g:link controller="logout">Log Out</g:link></li>
                </sec:ifLoggedIn>
            </ul>
        </nav>
    </div>
</header>
