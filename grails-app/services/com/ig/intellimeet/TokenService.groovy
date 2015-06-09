package com.ig.intellimeet

class TokenService {

    def intelliMeetService

    Token save(Token token) {
        token.save(failOnError: true, flush: true)
    }

    Token extractToken(String tokenId) {
        Long intelliMeetId = intelliMeetService?.currentIntelliMeetId
        Token token = Token.findByValueAndIntelliMeetId tokenId, intelliMeetId
        token
    }

    Token generateToken(String email, Long surveyId=null) {
        if(surveyId && email){
            new Token(effectiveDate: new Date(), expiryDate: new Date() + Token.TOKEN_VALIDITY_IN_DAYS, email: email,
                    intelliMeetId: intelliMeetService?.currentIntelliMeetId, surveyId: surveyId, value: UUID.randomUUID()?.toString())
        }
        else null
    }
}
