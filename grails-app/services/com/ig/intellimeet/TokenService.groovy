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

    Token generateToken(Long userId) {
        Token token = userId?new Token():null
        if (userId) {
            token.effectiveDate = new Date()
            token.expiryDate = new Date() + Token.TOKEN_VALIDITY_IN_DAYS
            token.intelliMeetId = intelliMeetService.currentIntelliMeetId
            token.userId = userId
            token.value = UUID.randomUUID()?.toString()
        }
        token
    }
}
