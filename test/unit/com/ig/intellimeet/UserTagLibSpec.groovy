package com.ig.intellimeet

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Created by behl on 21/7/14.
 */
@TestFor(UserTagLib)
class UserTagLibSpec extends Specification {

    void "UserTagLib: displayUserImage"() {

        expect:
        applyTemplate('<user:displayUserImage email="johndoe@test.com" />') == "<img src='http://res.cloudinary.com/intellimeet/image/upload/dev/johndoe@test.com.png' width='150px' class='center-block img-circle img-responsive'/>"
    }

}
