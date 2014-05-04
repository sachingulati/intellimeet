import com.ig.intellimeet.IntelliMeet
import com.ig.intellimeet.Role
import com.ig.intellimeet.Topic
import com.ig.intellimeet.User
import com.ig.intellimeet.enums.IntelliMeetStatus
import com.ig.intellimeet.utils.TestUtil
import com.mongodb.DBCollection

class BootStrap {

    def intelliMeetService

    def init = { servletContext ->

        bootstrapSomeDummyDataForDev()
    }

    def destroy = {
    }

    void bootstrapSomeDummyDataForDev() {
        ((DBCollection) Topic.collection).getDB().dropDatabase()
        createRoles()
        createUsers()
        if(User.count()) {
            new IntelliMeet(title: "IntelliMeet, May-2014", place: 'IntelliGrape', status: IntelliMeetStatus.ACTIVE, dateOfEvent: Date.parse("MM/dd/yyyy", "05/31/2014")).save(failOnError: true,flush: true)
            createTopics()
            createSessions()
        }
    }

    void createRoles() { TestUtil.SAMPLE_ROLES?.each { new Role(authority: it).save(failOnError: true) } }

    void createUsers() { TestUtil.SAMPLE_USERNAME_LIST?.each { TestUtil.createUserRole(it, (String) TestUtil.getRandom(TestUtil.SAMPLE_ROLES))?.save(failOnError: true, flush: true) } }

    void createTopics() { TestUtil.SAMPLE_TOPICS?.each { TestUtil.createTopic(it)?.save(failOnError: true) } }

    void createSessions() {
        Topic.list()?.each {TestUtil.createSession(it, intelliMeetService?.currentIntelliMeetId).save(failOnError: true,flush: true)}
    }
}
