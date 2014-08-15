cloudinary.config = [
        cloud_name: "intellimeet",
        api_key: "172426774796548",
        api_secret: "JSIa2_royIdNFL7MbuAdveO49SM",
        folder: 'dev',
        mimeType: 'png'
]

environments {
    dev {
        cloudinary.config['folder'] = 'dev'
    }
    qa {
        cloudinary.config['folder'] = 'qa'
    }
    prod {
        cloudinary.config['folder'] = 'prod'
    }
    test {
        cloudinary.config['folder'] = 'test'
    }
}


cloudinary.config['baseUrl'] = "http://res.cloudinary.com/${cloudinary.config['cloud_name']}/image/upload/${cloudinary.config['folder']}"