<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="public"/>
    <title>About</title>
    <r:require module="about" />
</head>

<body>
<!-- Docs page layout -->
<div class="bs-docs-header" id="content">
    <div class="container">
        <h1>About</h1>
        <p>Explore about the application status, meet the team, various plugin installed and controllers in the application.</p>
    </div>
</div>

<div class="container bs-docs-container">
    <div class="row">
        <div class="col-md-9" role="main">
            <!-- Application Status
================================================== -->
            <div class="bs-docs-section">
                <div class="page-header">
                    <h1 id="applicationStatus">Application Status</h1>
                </div>

                <ul class="list-unstyled">
                    <li>App version: <g:meta name="app.version"/></li>
                    <li>Grails version: <g:meta name="app.grails.version"/></li>
                    <li>Groovy version: ${GroovySystem.getVersion()}</li>
                    <li>JVM version: ${System.getProperty('java.version')}</li>
                    <li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
                    <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
                    <li>Domains: ${grailsApplication.domainClasses.size()}</li>
                    <li>Services: ${grailsApplication.serviceClasses.size()}</li>
                    <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
                </ul>
            </div>


            <!-- Installed Plugins
================================================== -->
            <div class="bs-docs-section">
                <div class="page-header">
                    <h1 id="installedPlugins">Installed Plugins</h1>
                </div>

                <ul class="list-unstyled">
                    <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                        <li>${plugin.name} - ${plugin.version}</li>
                    </g:each>
                </ul>
            </div>


            <!-- Available Controllers
================================================== -->
            <div class="bs-docs-section">
                <div class="page-header">
                    <h1 id="availableCtrl">Available Controllers</h1>
                </div>

                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nec felis mollis, fermentum sapien sed, rhoncus augue. Nullam sodales risus vel hendrerit iaculis.</p>
                <ul class="list-unstyled">
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                        <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
                    </g:each>
                </ul>
            </div>


            <!-- Core Team
================================================== -->
            <div class="bs-docs-section">
                <div class="page-header">
                    <h1 id="coreTeam">Core Team</h1>
                </div>

                <p class="lead">IntelliMeet is maintained by the founding team and a small group of invaluable core contributors, with the massive support and involvement of our community.</p>

                <div class="list-group bs-team">
                    <div class="list-group-item">
                        <iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=puneetbehl&amp;type=follow"></iframe>
                        <a class="team-member" href="https://github.com/puneetbehl">
                            <img src="http://www.gravatar.com/avatar/70e88a58bf8d13d2f7a80b14aa1e2167" alt="@puneetbhl">
                            <strong>Puneet Behl</strong> <small>@puneetbhl</small>
                        </a>
                    </div>

                    <div class="list-group-item">
                        <iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=farid&amp;type=follow"></iframe>
                        <a class="team-member" href="https://github.com/farid">
                            <img src="http://www.gravatar.com/avatar/70e88a58bf8d13d2f7a80b14aa1e2167" alt="@faridiflex">
                            <strong>Mohd Farid</strong> <small>@faridiflex</small>
                        </a>
                    </div>

                    <div class="list-group-item">
                        <iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=brijkishor&amp;type=follow"></iframe>
                        <a class="team-member" href="https://github.com/brijkishor">
                            <img src="http://www.gravatar.com/avatar/70e88a58bf8d13d2f7a80b14aa1e2167" alt="@brijkishor">
                            <strong>Brij Kishor</strong> <small>@brijkishor</small>
                        </a>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-3">
            <div class="bs-docs-sidebar hidden-print" role="complementary">
                <ul class="nav bs-docs-sidenav">

                    <li>
                        <a href="#applicationStatus">Application Status</a>
                    </li>
                    <li>
                        <a href="#installedPlugins">Installed Plugins</a>
                    </li>
                    <li>
                        <a href="#availableCtrl">Available Controllers</a>
                    </li>
                    <li>
                        <a href="#coreTeam">Core Team</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>
<r:script>
    $("#topNav li").removeClass("active");
    $("#topNav li#about").addClass("active");
</r:script>

</body>
</html>
