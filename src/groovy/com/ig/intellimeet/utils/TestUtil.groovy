package com.ig.intellimeet.utils

import com.ig.intellimeet.*
import com.ig.intellimeet.enums.SessionStatus
import com.ig.intellimeet.enums.TopicCategory

class TestUtil {

    static final List<String> SAMPLE_ROLES = ['ROLE_USER', 'ROLE_IM_OWNER', 'ROLE_ADMIN']

    static
    final List<String> SAMPLE_USERNAME_LIST = ['john@rediffmail.com', 'amelia@gmail.com', 'bdegroote@gmail.com', 'dextermorgan@ymail.com', 'debramorgan@miamimetro.com',
                                               'testUser7@ig.com', 'testUser8@ig.com', 'testUser9@ig.com', 'testUser10@ig.com', 'testUser11@ig.com', 'testUser13@ig.com', 'testUser14@ig.com', 'testUser15@ig.com', 'testUser16@ig.com',
                                               'testUser23@ig.com', 'testUser24@ig.com', 'testUser25@ig.com', 'testUser32@ig.com', 'testUser33@ig.com', 'testUser34@ig.com', 'testUser35@ig.com']
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
        topic.createdBy = (Long) getRandom(userIdList)
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

    static IMSession createSession(Topic topic, Long intelliMeetId) {
        IMSession imSession = new IMSession()
        imSession.topicId = topic?.id
        imSession.title = topic?.name
        imSession.description = topic?.description
        imSession.minCapacity = 6
        imSession.maxCapacity = 7
        Object[] userIdList = User.list()*.id
        imSession.ownerId = (Long) getRandom(userIdList)
        imSession.attendeeIds = User.list(max: Math.random() * 10)*.id
        imSession.sessionStatus = SessionStatus.PROPOSED
        imSession.intelliMeetId = intelliMeetId
        imSession
    }

    static User createUser(String username) {
        new User(username: username, password: 'test')
    }

    static Employee createEmployee(Long userId, String username) {
        new Employee(emailAddress: username, userId: userId)
    }

    static UserRole createUserRole(String username, String authority) {
        User user = User.findByUsername(username) ?: createUser(username).save(flush: true)
        createEmployee(user?.id, user?.username).save(failOnError: true)
        Role role = Role.findByAuthority(authority)
        UserRole userRole = role ? new UserRole(user: user, role: role) : null
        userRole
    }

    static SessionPreference createSessionPreference(Long intelliMeetId, IMSession session = null) {
        SessionPreference sessionPreference = new SessionPreference()
        sessionPreference.intelliMeetId = intelliMeetId
        sessionPreference.sessionId = session?.id ?: (Long) getRandom((1..50)?.toArray())
        sessionPreference.sessionTitle = session?.title ?: getRandom(SAMPLE_TOPICS)
        sessionPreference.sessionOwners = session?.ownersEmail ?: getRandom(SAMPLE_USERNAME_LIST)
        sessionPreference
    }

    static Date stringToDate(String dateString) {
        Date.parse("MM/dd/yyyy",dateString)
    }

}
