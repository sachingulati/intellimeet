<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload Image</title>
    <meta name="layout" content="main">
</head>

<body>

<div class="container">
    <g:if test="${flash.message}">
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            ${flash.message}
        </div>
    </g:if>

    <h1>Edit Profile</h1>
    <hr>

    <div class="row">
        <!-- left column -->
        <div class="col-md-3">
            <div class="text-center">
                <user:displayUserImage email="${employeeInstance?.emailAddress}"/>
                <h6>Upload a different photo...</h6>


                <g:uploadForm controller="user" action="uploadImage">
                    <div class="form-group">
                        <input id="uploadedFile" type="file" name="userImage" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <g:submitButton name="Upload" class="btn btn-primary"/>
                    </div>
                </g:uploadForm>
            </div>
        </div>

        <!-- edit form column -->
        <div class="col-md-9 personal-info">
            <h3>Personal info</h3>

            <g:form class="form-horizontal" role="form" controller="user" action="save">
                <g:hiddenField name="id" value="${employeeInstance?.id}"/>
                <g:hiddenField name="userId" value="${employeeInstance?.userId}"/>
                <g:hiddenField name="version" value="${employeeInstance?.version}"/>
                <div class="form-group">
                    <label class="col-lg-3 control-label">First name:</label>

                    <div class="col-lg-8">
                        <g:textField name="firstName" class="form-control" type="text"
                                     value="${employeeInstance?.firstName}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Last name:</label>

                    <div class="col-lg-8">
                        <g:textField name="lastName" class="form-control" type="text"
                                     value="${employeeInstance?.lastName}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Email Address:</label>

                    <div class="col-lg-8">
                        <g:hiddenField name="emailAddress" value="${employeeInstance?.emailAddress}" />
                        <input class="form-control" type="text" value="${employeeInstance?.emailAddress}" disabled/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Date Of Birth:</label>

                    <div class="col-lg-8">
                        <g:textField name="dateOfBirth" class="form-control" type="text"
                                     value="${employeeInstance?.dateOfBirth}" placeholder="MM/dd/YYYY"/>
                        <p class="help-block"><span class="glyphicon glyphicon-info-sign"></span> Enter date in <code>MM/dd/YYYY</code> format. Example 03/04/1988 (4th March, 1988)</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Employee ID:</label>

                    <div class="col-lg-8">
                        <g:textField name="employeeId" class="form-control" type="text"
                                     value="${employeeInstance?.employeeId}"/>
                        <p class="help-block">Example: IG0027</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Mobile Number:</label>

                    <div class="col-lg-8">
                        <g:textField name="cellNumber" class="form-control" type="text"
                                     value="${employeeInstance?.cellNumber}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label"></label>

                    <div class="col-md-8">
                        <input type="submit" class="btn btn-primary" value="Save Changes">
                        <span></span>
                        <input type="reset" class="btn btn-default" value="Cancel">
                    </div>
                </div>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>