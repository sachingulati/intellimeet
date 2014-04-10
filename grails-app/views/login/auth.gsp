<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <!-- Bootstrap core CSS -->
    <link href="/intelliMeet/css/bootstrap/bootstrap.css" rel="stylesheet">

    <style>

    body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #eee;
    }

    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }
    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }
    .form-signin .checkbox {
        font-weight: normal;
    }
    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }
    .form-signin .form-control:focus {
        z-index: 2;
    }
    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    .navbar {
        margin-top: -21px;
    }
    .navbar-brand {
        height: auto;
    }
    </style>

    <title><g:message code="default.login.label"  /></title>
</head>

<body>
<nav class="navbar navbar-default" role="navigation">

    <!-- Brand and toggle get grouped for better mobile display -->

    <div class="navbar-header">
            <a class="navbar-brand" href="/intelliMeet"><img alt="logo" src="http://www.intelligrape.com/images/xlogo.png.pagespeed.ic.j8-OajH6oI.png" /></a>
    </div>
    %{--menu ends--}%
</nav>
<div class="container">

    <form class="form-signin" role="form" method="POST" action="${resource(file: 'j_spring_security_check')}">
        <h2 class="form-signin-heading">Please sign</h2>
        <g:if test="${flash.message}">
            <div class="message alert alert-warning" role="status">${flash.message}</div>
        </g:if>
        <g:textField name="j_username" class="form-control" placeholder="Username"  />
        <input type="password" name="j_password"  class="form-control" placeholder="Password" required>
        <label class="checkbox">
            <input type="checkbox" value="remember-me" name="_spring_security_remember_me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

        <oauth:connect provider="google" id="google-connect-link">Google</oauth:connect>

        Logged with google?
        <s2o:ifLoggedInWith provider="google">yes</s2o:ifLoggedInWith>
        <s2o:ifNotLoggedInWith provider="google">no</s2o:ifNotLoggedInWith>
    </form>





</div>
</body>
</html>