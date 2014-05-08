package com.ig.intellimeet

class UtilController {

    def checkHealth() {
        render("Success")
    }

    def getUserList() {
        List<Long> userIds = Topic.list()*.interestedUsers?.unique()?.flatten()
        render(User.getAll(userIds)*.username)
    }
}
