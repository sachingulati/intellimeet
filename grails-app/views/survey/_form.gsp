<%@ page import="com.ig.intellimeet.Survey" %>

<basicForm:inputField label="${message(code: 'survey.title.label', default: 'Enter Survey Title')}" name="title" bean="${surveyInstance}" required="true"
                      value="${surveyInstance?.title}"/>
<div class="questions">
    <span class="label label-info pull-right"><span
            class="glyphicon glyphicon-info-sign"></span>&nbsp;<strong>Please note</strong> that questions are ordered according to the sequence shown below.</span>
    <legend>Questions</legend>
    <survey:question name="question[0]"/>
    <hr/>
    <survey:question name="question[1]"/>
    <hr/>
    <survey:question name="question[2]"/>
    <hr/>
    <survey:question name="question[3]"/>
    <hr/>
    <survey:question name="question[4]"/>
    <hr/>
</div>