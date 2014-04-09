package embedded

class Feedback {

    Long filledByUserId
    Date fillDate
    Integer score
    List<Answer> answers
    String comment

    static constraints = {
        score range: 1..5
        comment nullable: true
        filledByUserId nullable: true
    }
}
