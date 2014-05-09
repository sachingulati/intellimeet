import com.ig.intellimeet.*
import com.ig.intellimeet.enums.IntelliMeetStatus
import com.ig.intellimeet.utils.TestUtil
import com.mongodb.DBCollection
import grails.util.Environment

class BootStrap {

    def intelliMeetService

    def init = { servletContext ->

        log.info("Current Env: ${Environment?.current?.name}. DB Name: ${IntelliMeet.collection.getDB()}")
        switch (Environment?.current?.name) {
            case 'development':
            case 'qa':
                log.info("Dropping database... ")
                IntelliMeet.collection.getDB().dropDatabase()
                log.info("Bootstraping data... ")
                bootstrapSomeDummyDataForDev()
                break;
            case 'test':
                break
            case 'production':
                break
            default:
                break
        }

        //bootstrapSomeDummyDataForDev()
    }

    def destroy = {
    }

    void bootstrapSomeDummyDataForDev() {
//        ((DBCollection) Topic.collection).getDB().dropDatabase()
        createRoles()
        createUsers()
        if(User.count()) {
            new IntelliMeet(title: "IntelliMeet, May-2014", place: 'IntelliGrape', status: IntelliMeetStatus.ACTIVE, dateOfEvent: Date.parse("MM/dd/yyyy", "05/31/2014")).save(failOnError: true,flush: true)
            createTopics()
            createSessions()
            createUserPreference()
        }
    }

    void createRoles() { TestUtil.SAMPLE_ROLES?.each { new Role(authority: it).save(failOnError: true) } }

    void createUsers() { TestUtil.SAMPLE_USERNAME_LIST?.each { TestUtil.createUserRole(it, (String) TestUtil.getRandom(TestUtil.SAMPLE_ROLES))?.save(failOnError: true, flush: true) } }

    void createTopics() { TestUtil.SAMPLE_TOPICS?.each { TestUtil.createTopic(it)?.save(failOnError: true) } }

    void createUserPreference() {
        List<User> users = User.list();
        List<IMSession> imSessions = IMSession.list()
        Random rand = new Random()
        int max = imSessions.size()

        users.each { User user ->
            UserPreference userPreference = new UserPreference()
            userPreference.userId = user.id
            userPreference.fullName = user.username
            userPreference.emailAddress = user.username
            userPreference.intelliMeetId = 1
            Integer firstRandomIndex =  rand.nextInt(max)
            userPreference.setFirstPreferredSessionId((imSessions[firstRandomIndex]).id)
            Integer secondRandomIndex =  rand.nextInt(max)
            while(secondRandomIndex.equals(firstRandomIndex)) {
                secondRandomIndex = rand.nextInt(max)
            }
            userPreference.setSecondPreferredSessionId((imSessions[secondRandomIndex]).id)
            Integer thirdRandomIndex =  rand.nextInt(max)
            while(thirdRandomIndex.equals(firstRandomIndex) || thirdRandomIndex.equals(secondRandomIndex)) {
                thirdRandomIndex = rand.nextInt(max)
            }
            userPreference.setThirdPreferredSessionId((imSessions[thirdRandomIndex]).id)

            if(userPreference.hasErrors()) {
                println("error in saving user preference")
            } else {
                userPreference.save(flush: true, failOnError: true)
            }
        }

    }


    void createSessions() {
        Topic.list()?.each {TestUtil.createSession(it, intelliMeetService?.currentIntelliMeetId).save(failOnError: true,flush: true)}
    }
}
