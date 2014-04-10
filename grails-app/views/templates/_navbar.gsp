<!-- Docs master nav -->
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand">IntelliMeet</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" id="topNav" role="navigation">
            <ul class="nav navbar-nav">
                <li id="home"><a href="/">Home</a></li>
                <li><a href="#">Features</a></li>
                <li><a href="#">Contact Us</a></li>
                <li id="about"><a href="/about">About</a></li></ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Expo</a></li>
                <li><a href="#">Blog</a></li>
                <sec:ifLoggedIn>
                <li><g:link controller="logout">Log Out</g:link></li>
                </sec:ifLoggedIn>
            </ul>
        </nav>
    </div>
</header>
