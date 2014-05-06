package com.ig.intellimeet

class TokenService {

    def intelliMeetService

    Token extractToken(String tokenId) {
        Long intelliMeetId = intelliMeetService?.currentIntelliMeetId
        Token token = Token.findByValueAndIntelliMeetId tokenId, intelliMeetId
        token
    }
}
