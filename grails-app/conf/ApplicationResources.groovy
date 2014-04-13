modules = {
    core {
        dependsOn 'bootstrap, holder, font_awesome, application'
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
}