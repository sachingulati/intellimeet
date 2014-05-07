<%@ page import="com.ig.intellimeet.Topic" %>
<div class="well" id="sidebar-categories">
    <h4><g:message code="topic.sidebar.categories.label" default="Topic Categories"/></h4>

    <div class="row">
        <div class="col-lg-6">
            <ul class="list-unstyled">
                <li><a href="javascript:searchTopicByCategory('');">ALL (${Topic.count()})</a></li>
                <g:each in="${categoryTopicCounts}" var="categoryTopicCount" status="index">
                    <g:if test="${index < categoryTopicCounts?.size()/2}">
                        <li><a href="javascript:searchTopicByCategory('${categoryTopicCount?.category?.displayName}');">${categoryTopicCount?.category?.displayName} (${categoryTopicCount?.topicCount})</a></li>
                    </g:if>
                </g:each>
            </ul>
        </div>

        <div class="col-lg-6">
            <ul class="list-unstyled">
                <g:each in="${categoryTopicCounts}" var="categoryTopicCount" status="index">
                    <g:if test="${index >= categoryTopicCounts?.size()/2}">
                        <li><a href="javascript:searchTopicByCategory('${categoryTopicCount?.category?.displayName}');">${categoryTopicCount?.category?.displayName} (${categoryTopicCount?.topicCount})</a></li>
                    </g:if>
                </g:each>
            </ul>
        </div>
    </div>
</div>