<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload Image</title>
    <meta name="layout" content="main">
</head>

<body>
<g:uploadForm controller="user" action="saveImage">
    Upload user image : <input id="uploadedFile" type="file" name="userImage"/>
    <g:submitButton name="save"/>
</g:uploadForm>
</body>
</html>