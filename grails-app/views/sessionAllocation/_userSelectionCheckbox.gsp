<%@ page import="com.ig.intellimeet.User" %>
<label>
    <g:checkBox name="imsession[${sessionPreference?.sessionId}].attendeeIds"
                value="${userId}"
                class="i-check-square"
                checked="false"/>
    <span><user:displayUsername userId="${userId}"/></span>
</label>