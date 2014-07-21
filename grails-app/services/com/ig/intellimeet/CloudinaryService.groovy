package com.ig.intellimeet

import com.cloudinary.Cloudinary

class CloudinaryService {

    def grailsApplication

    static transactional = false

    Map uploadImage(Object bytesOrString, String imageName, List<String> tags) throws Exception {
        if ((bytesOrString instanceof byte[]) || (bytesOrString instanceof String)) {
            try {
                return client.uploader().upload(bytesOrString, ['public_id': getPublicId(imageName),
                        'tags': tags.collect { replaceSpaces(it) }.join(',')])
            } catch (Exception e) {
                log.debug("file not found")
            }
        } else {
            throw new Exception('data not accepted. Use either byte[] or String URL.')
        }
    }

    String getPublicId(String imageName) {
        imageName
    }

    String replaceSpaces(String name) {
        return name.replaceAll(' ', '-')
    }

    Cloudinary getClient() {
        new Cloudinary(grailsApplication.config.cloudinary.config as Map)
    }

}

