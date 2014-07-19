package com.ig.intellimeet

import com.ig.intellimeet.co.UserPreferenceCO
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * Created by behl on 18/7/14.
 */

@TestFor(UserPreferenceController)
@TestMixin([GrailsUnitTestMixin, DomainClassUnitTestMixin])
class UserPreferenceControllerSpec extends Specification {

    void setupSpec() {
        mockDomain(Token, [new Token(surveyId: 11l)])
        def tokenMock = mockFor(Token)
        tokenMock.demand.isValid(1..1) {
            return true
        }
        tokenMock.createMock()
        mockDomain(Survey, [new Survey(id: 11l, isClosed: false)])
        mockDomain(UserPreference)
        def userPreferenceServiceMock = mockFor(UserPreferenceService, false)
        userPreferenceServiceMock.demand.extractUserPreference(1..1) { UserPreferenceCO userPreferenceCO, Token token ->
            new UserPreference()
        }
        userPreferenceServiceMock.demand.save(1..1) { UserPreference userPreference ->
            return true
        }
        controller.userPreferenceService = userPreferenceServiceMock.createMock()
        def surveyServiceMock = mockFor(SurveyService)
        surveyServiceMock.demand.updateSurveyStatusForEmail(1..1) { Long surveyId, String username ->
            return true
        }
        controller.surveyService = surveyServiceMock.createMock()
        def tokenServiceMock = mockFor(TokenService)
        tokenServiceMock.demand.extractToken(1..1) {String tokenId->
            Token.findBySurveyId(11l)
        }
        tokenServiceMock.demand.save(1..1) { Token token ->
            return true
        }
        controller.tokenService = tokenServiceMock.createMock()
    }

    void "UserPreferenceController: save(UserPreferenceCO userPreferenceCO), constraints validation"() {
        setup:
        UserPreferenceCO userPreferenceCO
        boolean validationResult

        when:
        userPreferenceCO = new UserPreferenceCO(
                tokenId: '123456789',
                firstPreferredSessionId: firstPreferredSessionId,
                secondPreferredSessionId: secondPreferredSessionId,
                thirdPreferredSessionId: thirdPreferredSessionId
        )
        validationResult = userPreferenceCO?.validate()
        controller.save userPreferenceCO

        then:
        userPreferenceCO?.hasErrors() == hasErrors
        userPreferenceCO?.errors?.errorCount == errorCount
        validationResult == expectedValidation
        flash.error == null
        view == expectedViewUri


        where:
        sno | firstPreferredSessionId | secondPreferredSessionId | thirdPreferredSessionId | hasErrors | errorCount | expectedValidation | expectedViewUri
        1   | null                    | null                     | null                    | false     | 0          | true               | '/survey/thankyou'

    }
}
