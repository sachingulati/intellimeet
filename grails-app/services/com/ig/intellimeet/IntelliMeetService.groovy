package com.ig.intellimeet

import com.ig.intellimeet.co.IMSessionCO
import com.ig.intellimeet.enums.SessionStatus

class IntelliMeetService {

    IntelliMeet getCurrentIntelliMeet() {

    }

    Long getCurrentIntelliMeetId() {
        return 1L
    }

    /**
     * <p>Returns session list for intellimeet.
     * If null is passed current intellimeet id is used.</p>
     *
     * @param intelliMeetId - IntelliMeet id for which session list need to be fetched
     * @return
     */
    IMSessionCO getIMSessionList(Long intelliMeetId){
        if(intelliMeetId == null) {
            intelliMeetId = getCurrentIntelliMeetId()
        }

        IMSessionCO imSessionCO = new IMSessionCO()
        imSessionCO.totalCount = IMSession.countByIntelliMeetIdAndSessionStatus(intelliMeetId,SessionStatus.PROPOSED)
        imSessionCO.sessionList = IMSession.findAllByIntelliMeetIdAndSessionStatus(intelliMeetId,SessionStatus.PROPOSED)
        return imSessionCO
    }
}
