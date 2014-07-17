<%@ page import="com.ig.intellimeet.User" %>
<label>
    <g:checkBox name="preferences[${i}].attendees"
                value="${userId}"
                class="i-check-square"
                checked="${isChecked}"/>
    <span><user:displayUsername userId="${userId}"/></span>
</label>