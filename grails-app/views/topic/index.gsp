<%@ page import="com.ig.intellimeet.Topic" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <r:require module="topic"/>
</head>

<body>
<a href="#list-topic" class="sr-only" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="container" id="list-topic">

    <div class="row">
        <div class="col-lg-8">
            <g:each in="${topicInstanceList}" var="topic" status="index">
                <div id="topic${index}"></div>
                <g:render template="topicEntry" model="[topic: topic, index: index]"/>
                <hr/>
            </g:each>
        </div>


        <div class="col-lg-4">

            <div class="well">

                <h4>Topic Search</h4>

                <div class="input-group">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>

                <a href="#" class="btn btn-primary btn-block" style="margin-top: 10px;">Register New Topic</a>
            </div>

            <div class="well">
                <h4>Topic Categories</h4>

                <div class="row">
                    <div class="col-lg-6">
                        <ul class="list-unstyled">
                            <li><a href="#dinosaurs">Dinosaurs (10)</a>
                            </li>
                            <li><a href="#spaceships">Spaceships (2)</a>
                            </li>
                            <li><a href="#fried-foods">Fried Foods (1)</a>
                            </li>
                            <li><a href="#wild-animals">Wild Animals (12)</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-lg-6">
                        <ul class="list-unstyled">
                            <li><a href="#alien-abductions">Alien Abductions (5)</a>
                            </li>
                            <li><a href="#business-casual">Business Casual(12)</a>
                            </li>
                            <li><a href="#robots">Robots (2)</a>
                            </li>
                            <li><a href="#fireworks">Fireworks (1)</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /well -->
            <div class="bs-docs-sidebar hidden-print">
                <ul class="nav bs-docs-sidenav">
                    <g:each in="${topicInstanceList}" var="topic" status="index">
                        <li><a href="#topic${index}">${topic?.name}</a></li>
                    </g:each>
                </ul>
                <a class="back-to-top" href="#list-topic">Back to top</a>
            </div>
            <!-- /well -->
        </div>
    </div>
</div>
</body>
</html>
