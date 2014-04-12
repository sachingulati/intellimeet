package com.ig.intellimeet.utils

import com.ig.intellimeet.Role
import com.ig.intellimeet.Topic
import com.ig.intellimeet.User
import com.ig.intellimeet.UserRole
import com.ig.intellimeet.enums.TopicCategory

class TestUtil {

    static final List<String> SAMPLE_ROLES = ['ROLE_ATTENDEE', 'ROLE_ADMIN', 'ROLE_PRESENTER', 'ROLE_ORGANIZER']
    static final List<String> SAMPLE_USERNAME_LIST = ['john@rediffmail.com', 'amelia@gmail.com', 'bdegroote@gmail.com', 'dextermorgan@ymail.com', 'debramorgan@miamimetro.com']
    static final List<String> SAMPLE_TOPICS = ['Getting started with MongoDB',
            'Learning insights of Grails',
            'Going one step advance by learning the concepts of Meta-programming',
            'Extend HTML vocabulary using Angular JS',
            'How to build high performance applications using Node JS',
            'What is continuous integration of application? and how AWS helps achieving the same?',
            'How to manage Start-ups?',
            'Getting started with Test Driven development.']

    static def getRandom(Object[] array) {
        array[(array.length * Math.random()).toInteger()]
    }

    static Topic createTopic(String name) {
        Topic topic = new Topic()
        topic.name = name
        Object[] userIdList = User.list()*.id
        topic.createdBy =(Long) getRandom(userIdList)
        topic.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rutrum interdum ipsum, nec convallis purus venenatis eget. Ut consequat, elit a congue posuere, nibh diam mollis felis, sit amet ultrices tellus turpis non massa. Sed vitae ante lobortis, ullamcorper nisl non, faucibus ante. Donec a mi ut nunc dictum scelerisque vel tempus est. Sed quis mattis dolor. Vestibulum convallis, sapien non tempor molestie, arcu ipsum venenatis libero, at vestibulum velit diam at libero. Donec elementum erat in eros tristique molestie. Ut sed lacinia sapien, in varius mauris. Phasellus porttitor, est quis porta vehicula, odio dui pulvinar libero, vitae gravida nisl ipsum nec dui. Morbi quis rutrum arcu, quis suscipit leo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Maecenas commodo ante nulla, at tincidunt tellus convallis nec. Nulla pretium volutpat euismod. Nunc ut accumsan nulla. Sed facilisis lacus nec tellus auctor vulputate."
        topic.expectations = ["Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec ante ipsum.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec ante ipsum.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec ante ipsum.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec ante ipsum.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec ante ipsum."]
        topic.category = getRandom(TopicCategory.values()) as TopicCategory
        topic.interestedUsers = User.list([max: 5])*.id
        topic
    }

    static User createUser(String username) {
        new User(username: username, password: 'test')
    }

    static createUserRole(String username, String authority) {
        User user = createUser(username).save(flush: true)
        Role role = Role.findByAuthority(authority)
        UserRole userRole = role ? new UserRole(user: user, role: role) : null
        userRole
    }
}
