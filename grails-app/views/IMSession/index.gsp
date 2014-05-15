<%@ page import="com.ig.intellimeet.Topic" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'imSession.label', default: 'Session')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <r:require modules="session,block_ui"/>
    <r:style>
        body { padding-top: 100px !important; }
    </r:style>
</head>

<body>
<a href="#list-topic" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="container" id="list-session">

    <div class="row">
        <div class="col-lg-8 searchable">
            <g:each in="${IMSessionInstanceList}" var="imSession" status="index">
                <div class="entry">
                    <div id="imSession${index}" class="session zone"></div>
                    <g:render template="sessionEntry" model="[imSession: imSession, index: index]"/>
                    <hr/>
                </div>
            </g:each>
        </div>


        <div class="col-lg-4">

            <div class="well sidebar-search">

                <h4><g:message code="session.sidebar.search.label" default="Session Search" /></h4>

                <div class="input-group">
                    <input type="text" class="form-control" id="search-input">
                    <span class="input-group-btn">
                        <button class="btn btn-default plusOneBtn" type="button">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>

                <g:link controller="IMSession" action="create" href="#" class="btn btn-primary btn-block" style="margin-top: 10px;"><g:message code="session.sidebar.propose.new.label" default="Propose New Session" /></g:link>

            </div>

            <!-- /well -->
            <div class="bs-docs-sidebar hidden-print">
                <ul class="nav bs-docs-sidenav">
                    <g:each in="${IMSessionInstanceList}" var="imSession" status="index">
                        <li><a href="#imSession${index}">${fieldValue(bean: imSession, field: 'title')}</a></li>
                    </g:each>
                </ul>
                <a class="back-to-top" href="#list-session"><g:message code="back.top.label" default="Back to top"/></a>
            </div>
            <!-- /well -->
        </div>
    </div>
</div>
<r:script>
    $('a[href^=#]:not([href=#])').on('click',function() {
        if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('div[id=' + this.hash.slice(1) +']');
            if (target.length) {
                var offsetTop = target.offset().top-60;
                $('html,body').animate({
                    scrollTop: offsetTop
                }, 1000);
                return false;
            }
        }
    });
    markAsActive("session");
</r:script>
</body>
</html>
