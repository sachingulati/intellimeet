<html>
<head>
    <meta name='layout' content='public'/>
    <title><g:message code="springSecurity.login.title" default="Login"/></title>
    <r:require module="signin"/>
</head>

<body>

<div class="container">

    <form class="form-signin" role="form" action='${postUrl}' method="post" autocomplete="off" id='loginForm'>
        <h2 class="form-signin-heading">Please sign in</h2>
        <input name="j_username" type="text" class="form-control" placeholder="${message(code: 'springSecurity.login.username.label', default: 'Username')}" required
               autofocus>
        <input name="j_password" type="password" class="form-control" placeholder="${message(code: 'springSecurity.login.password.label', default: 'Password')}" required>
        <label class="checkbox">
            <input type="checkbox" value="remember-me" name='${rememberMeParameter}' <g:if test='${hasCookie}'>checked='checked'</g:if>> <g:message
                code="springSecurity.login.remember.me.label" default="Remember me"/>
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">${message(code: "springSecurity.login.button", default: 'Sign in')}</button>
    </form>

</div> <!-- /container -->

<r:script type='text/javascript'>
    (function () {
        document.forms['loginForm'].elements['j_username'].focus();
    })();
</r:script>
</body>
</html>
