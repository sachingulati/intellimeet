import com.ig.intellimeet.Role
import com.ig.intellimeet.Topic
import com.ig.intellimeet.User
import com.ig.intellimeet.utils.TestUtil
import com.mongodb.DBCollection

class BootStrap {

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
            createTopics()
        }
    }

    void createRoles() { TestUtil.SAMPLE_ROLES?.each { new Role(authority: it).save(failOnError: true) } }

    void createUsers() { TestUtil.SAMPLE_USERNAME_LIST?.each { TestUtil.createUserRole(it, (String) TestUtil.getRandom(TestUtil.SAMPLE_ROLES))?.save(failOnError: true, flush: true) } }

    void createTopics() { TestUtil.SAMPLE_TOPICS?.each { TestUtil.createTopic(it)?.save(failOnError: true) } }
}
