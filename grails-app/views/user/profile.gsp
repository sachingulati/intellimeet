<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload Image</title>
    <meta name="layout" content="main">
</head>

<body>

<div class="container">
    <h1>Edit Profile</h1>
    <hr>
    <div class="row">
        <!-- left column -->
        <div class="col-md-3">
            <div class="text-center">
                <user:displayUserImage email="${userInstance?.username}" />
                <h6>Upload a different photo...</h6>


                <g:uploadForm controller="user" action="uploadImage">
                    <input id="uploadedFile" type="file" name="userImage" class="form-control"/>
                    <g:submitButton name="save"/>
                </g:uploadForm>
            </div>
        </div>

        <!-- edit form column -->
        <div class="col-md-9 personal-info">
            <h3>Personal info</h3>

            <g:form class="form-horizontal" role="form" controller="user" action="save">
                <g:hiddenField name="id" value="${userInstance?.id}" />
                <div class="form-group">
                    <label class="col-lg-3 control-label">First name:</label>
                    <div class="col-lg-8">
                        <g:textField name="firstName" class="form-control" type="text" value="${userInstance?.firstName}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Last name:</label>
                    <div class="col-lg-8">
                        <g:textField name="lastName" class="form-control" type="text" value="${userInstance?.lastName}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Username:</label>
                    <div class="col-lg-8">
                        <input class="form-control" type="text" value="${userInstance?.username}" disabled/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input type="button" class="btn btn-primary" value="Save Changes">
                        <span></span>
                        <input type="reset" class="btn btn-default" value="Cancel">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<hr>
</body>
</html>