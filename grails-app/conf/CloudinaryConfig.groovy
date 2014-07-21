cloudinary.config = [
        cloud_name: "intellimeet",
        api_key: "172426774796548",
        api_secret: "JSIa2_royIdNFL7MbuAdveO49SM",
]

environments {
    dev {
        cloudinary.baseDir = 'dev'
    }
    qa {
        cloudinary.baseDir = 'qa'
    }
    prod {
        cloudinary.baseDir = 'prod'
    }
    test {
        cloudinary.baseDir = 'dev'
    }
}


cloudinary {
    baseUrl = "http://res.cloudinary.com/${cloudinary.config['cloud_name']}/image/upload/${cloudinary.baseDir}"
    mimeType = "png"
}