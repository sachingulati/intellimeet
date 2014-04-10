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
        resource url:'css/signin.css'
    }

    topic {
        resource url: 'css/topic/app.css'
    }
}