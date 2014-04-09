package embedded

import com.ig.intellimeet.User

/**
 * Created by intelligrape on 9/4/14.
 */
class Feedback {

    User filledBy;
    Date fillDate;
    Integer score;
    String comment;
    Answer answer;

    static constraints = {
        score (range: 1..5);
        comment (nullable: true);
    }
}
