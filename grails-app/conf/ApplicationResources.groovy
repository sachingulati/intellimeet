modules = {
    core {
        dependsOn 'bootstrap, holder, font_awesome, datepicker, application'
        defaultBundle 'ui'
        resource url: '/css/docs.min.css'
    }

    application {
        dependsOn 'jquery'
        resource url: 'js/application.js'
    }

    bootstrap {
        dependsOn 'jquery'
        resource url: '/css/bootstrap.css'
        resource url: '/js/bootstrap.min.js'
    }

    holder {
        dependsOn 'jquery'
        resource url: '/js/holder.js'
    }

    font_awesome {
        resource url: 'css/font-awesome.min.css'
    }

    signin {
        resource url: 'css/signin.css'
    }

    topic {
        resource url: 'css/topic/app.css'
        resource url: 'js/topic/app.js'
    }

    about {
        resource url: 'js/about/app.js'
    }

    wysi_html5 {
        dependsOn 'jquery, bootstrap'
        resource url: 'css/bootstrap3-wysiwyg5.css'
        resource url: 'js/wysihtml5-0.3.0.js'
        resource url: 'js/bootstrap3-wysihtml5.js'
        resource url: 'js/wysi.js'
    }

    survey {
        dependsOn 'jquery, bootstrap, font_awesome, jquery_switch, html5, jquery_ui, jquery_wizard, modernizer, respond,jquery_validate, jquery_placeholder, jquery_tweet ,bx_slider'
        resource url: '/css/survey/style.css'
        resource url: '/css/survey/socialize-bookmarks.css'
        resource url: '/css/survey/aero.css'
        resource url: '/js/survey/check.min.js'
        resource url: '/js/survey/quantity-bt.js'
        resource url: 'js/survey/functions.js'
    }

    html5 {
        resource url: 'http://html5shim.googlecode.com/svn/trunk/html5.js'
    }

    bx_slider {
        resource url: '/js/jquery.bxslider.min.js'
    }

    jquery_validate {
        resource url: '/js/jquery.validate.js'
    }

    jquery_placeholder {
        resource url: '/js/jquery.placeholder.js'
    }

    jquery_tweet {
        resource url: '/js/survey/jquery.tweet.min.js'
    }

    jquery_switch {
        resource url: '/css/survey/jquery.switch.css'
    }

    jquery_ui {
        resource url: '/js/jquery-ui-1.8.12.min.js'
    }

    jquery_wizard {
        resource url: '/js/survey/jquery.wizard.js'
    }

    modernizer {
        resource url: '/js/modernizr.custom.17475.js'
    }

    respond {
        resource url: '/js/respond.min.js'
    }

    datepicker {
        dependsOn 'jquery'
        resource url: '/css/datepicker/datepicker3.css'
        resource url:'/js/datepicker/bootstrap-datepicker.js'
    }

    block_ui {
        resource url:'/js/jquery.blockUI.js'
    }
}