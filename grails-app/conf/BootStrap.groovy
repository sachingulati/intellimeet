import com.ig.intellimeet.*
import com.ig.intellimeet.embedded.Option
import com.ig.intellimeet.enums.IntelliMeetStatus
import com.ig.intellimeet.enums.QuestionType
import com.ig.intellimeet.utils.TestUtil
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
            createQuestions()
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

    void createQuestions(){
        new Question(text: "Did the session went as per schedule?", type: QuestionType.OPTION, num: 1,
                options: [new Option(label: "Session went as per schedule", value: "1"),
                          new Option(label: "Session started late as session Owner was late", value: "2"),
                          new Option(label: "Session started late as some attendees were late / absent without notification (Please specify late comers/ absentees)", value: "3"),
                          new Option(label: "Session started late because of inadequate Infrastructure / Others (Please specify unavailable items)", value: "4"),]).save(failOnError: true)
        new Question(text: "How would you rate the content quality of the session?", type: QuestionType.OPTION, num: 2,
                options: [new Option(label: "Content was below average.", value: "1"),
                          new Option(label: "Content was pretty average.", value: "2"),
                          new Option(label: "Content was good and did justice to the topic.", value: "3"),
                          new Option(label: "Content was simply superb. I can refer to it anytime.", value: "4")]).save(failOnError: true)
        new Question(text: "Was the presenter able to interact well and involve the audience in the session?", type: QuestionType.OPTION, num: 3,
                options: [new Option(label: "He/She was more interested in presenting the things rather than involving the audience.", value: "1"),
                          new Option(label: "Presenter tried to involve the audience but it was not just good enough.", value: "2"),
                          new Option(label: "The presenter was able to interact with only some people.", value: "3"),
                          new Option(label: "The presenter was able to interact with almost everyone and kept the interest alive.", value: "4")]).save(failOnError: true)
        new Question(text: "How would you rate the session based on the value addition to your knowledge?", type: QuestionType.OPTION, num: 4,
                options: [new Option(label: "The session was rather confusing than enhancing knowledge.", value: "1"),
                          new Option(label: "There was nothing new to learn.", value: "2"),
                          new Option(label: "There were few new things that I learnt from this session.", value: "3"),
                          new Option(label: "I feel I learnt a lot of new things during the session.", value: "4")]).save(failOnError: true)
        new Question(text: "Was the presenter able to interact well and involve the audience in the session?", type: QuestionType.OPTION, num: 5,
                options: [new Option(label: "He/She was more interested in presenting the things rather than involving the audience.", value: "1"),
                          new Option(label: "Presenter tried to involve the audience but it was not just good enough.", value: "2"),
                          new Option(label: "The presenter was able to interact with only some people.", value: "3"),
                          new Option(label: "The presenter was able to interact with almost everyone and kept the interest alive.", value: "4")]).save(failOnError: true)
        new Question(text: "How do you feel after attending this session?", type: QuestionType.OPTION, num: 6,
                options: [new Option(label: "I think I've wasted my time and deeply regret coming to this session.", value: "1"),
                          new Option(label: "I felt like it was just another day.", value: "2"),
                          new Option(label: "The session was good and I'm happy that I attended it.", value: "3"),
                          new Option(label: "The session was amazing and I feel I would have missed something exciting if I had not attended it.", value: "4")]).save(failOnError: true)
        new Question(text: "What is your overall satisfaction from the session?", type: QuestionType.RANGE, num: 7,
                options: [new Option(label: "1", value: "1"),
                          new Option(label: "10", value: "10")]).save(failOnError: true)
        new Question(text: "How satisfied are you with session allocation (Session agenda was clear to me before making preference. I was allotted session as per my preference / I was consulted while deviating from my preferences)", type: QuestionType.OPTION, num: 8,
                options: [new Option(label: "Below Average", value: "1"),
                          new Option(label: "Average", value: "2"),
                          new Option(label: "Good", value: "3"),
                          new Option(label: "Fully Satisfied", value: "4")]).save(failOnError: true)
        new Question(text: "How satisfied are you with variety of sessions?", type: QuestionType.OPTION, num: 9,
                options: [new Option(label: "Below Average", value: "1"),
                          new Option(label: "Average", value: "2"),
                          new Option(label: "Good", value: "3"),
                          new Option(label: "Fully Satisfied", value: "4")]).save(failOnError: true)
        new Question(text: "What is your overall satisfaction from the session?", type: QuestionType.RANGE, num: 10,
                options: [new Option(label: "1", value: "1"),
                          new Option(label: "10", value: "10")]).save(failOnError: true)
        new Question(text: "What is your satisfaction level from the seating arrangement (Seating space, chair's condition & availability, visibility of slides, white boards, etc.)?", type: QuestionType.OPTION, num: 11,
                options: [new Option(label: "Below Average", value: "1"),
                          new Option(label: "Average", value: "2"),
                          new Option(label: "Good", value: "3"),
                          new Option(label: "Fully Satisfied", value: "4")]).save(failOnError: true)
        new Question(text: "How would you rate the food arrangements for the day (Food/ snacks availability, quality, timings, seating space during lunch/ breaks, etc.)?", type: QuestionType.OPTION, num: 12,
                options: [new Option(label: "Below Average", value: "1"),
                          new Option(label: "Average", value: "2"),
                          new Option(label: "Good", value: "3"),
                          new Option(label: "Fully Satisfied", value: "4")]).save(failOnError: true)
        new Question(text: "How would you rate the cab arrangement for the day (Cab punctuality, Seat availability, etc. )?", type: QuestionType.OPTION, num: 13,
                options: [new Option(label: "Not applicable", value: "1"),
                          new Option(label: "Pathetic", value: "2"),
                          new Option(label: "Bad", value: "3"),
                          new Option(label: "Good", value: "4"),
                          new Option(label: "Excellent", value: "5")]).save(failOnError: true)
        new Question(text: "What is your overall satisfaction from the arrangements?", type: QuestionType.RANGE, num: 14,
                options: [new Option(label: "1", value: "1"),
                          new Option(label: "10", value: "10")]).save(failOnError: true)
        new QuestionTemplate(title: "dummy", questions: Question.list()).save()

    }


    void createSessions() {
        Topic.list()?.each {TestUtil.createSession(it, intelliMeetService?.currentIntelliMeetId).save(failOnError: true,flush: true)}
    }
}
