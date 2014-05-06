<%@ page import="com.ig.intellimeet.Topic" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <r:require modules="topic,block_ui"/>
</head>

<body>
<a href="#list-topic" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="container" id="list-topic">

    <div class="row">
        <div class="col-lg-8 searchable">
            <g:each in="${topicInstanceList}" var="topic" status="index">
                <div class="entry">
                    <div id="topic${index}" class="topic zone"></div>
                    <g:render template="topicEntry" model="[topic: topic, index: index]"/>
                    <hr/>
                </div>
            </g:each>
        </div>


        <div class="col-lg-4">

            <div class="well">

                <h4><g:message code="topic.sidebar.search.label" default="Topic Search" /></h4>

                <div class="input-group">
                    <input type="text" class="form-control" id="search-input">
                    <span class="input-group-btn">
                        <button class="btn btn-default plusOneBtn" type="button">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>

                <g:link controller="topic" action="create" href="#" class="btn btn-primary btn-block" style="margin-top: 10px;"><g:message code="topic.sidebar.propose.new.label" default="Propose New Topic" /></g:link>
            </div>

            <topic:sideBarCategoriesPanel/>

            <!-- /well -->
            <div class="bs-docs-sidebar hidden-print">
                <ul class="nav bs-docs-sidenav">
                    <g:each in="${topicInstanceList}" var="topic" status="index">
                        <li><a href="#topic${index}">${topic?.name}</a></li>
                    </g:each>
                </ul>
                <a class="back-to-top" href="#list-topic"><g:message code="back.top.label" default="Back to top"/></a>
            </div>
            <!-- /well -->
        </div>
    </div>
</div>
<r:script>
    markAsActive("topic");
    $(function () {
        $('.plusOneBtn').popover({
            html: true,
            trigger: 'hover',
            title: 'Interested Users',
            content:  function(){
                return $(this).siblings('.attendeesList').html();
            }});

        $('.plusOneBtn').on('click', function() {
            var plusOneLink = $(this);
            var data = plusOneLink.data();
            var jqxhr = $.post( "/api/v1.0/topic/plusOne", { topicId: data.topicid });
            jqxhr.done(function(data) {
                if(data.status =='success') {
                    plusOneLink.removeClass('btn-default');
                    plusOneLink.text("+"+data.count);
                    plusOneLink.addClass('btn-primary');
                    plusOneLink.siblings('.attendeesList').append(data.username);
                } else if(data.status=='error') {
                    blockUIWithMsg(data.message);
                }
            });
            jqxhr.fail(function() {console.log("Failed doing plusOne ");});
            return false;
        });
    });
</r:script>
</body>
</html>
