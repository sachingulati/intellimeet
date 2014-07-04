package com.ig.intellimeet

import com.ig.intellimeet.co.IMSessionCO
import com.ig.intellimeet.enums.IntelliMeetStatus
import com.ig.intellimeet.enums.SessionStatus
import com.ig.intellimeet.enums.UserRoles

class IntelliMeetService {

    IntelliMeet save(IntelliMeet intelliMeet) {
        if (!intelliMeet?.validate() || !intelliMeet?.save(failOnError: true, flush: true)) {
            log.error(intelliMeet?.errors?.allErrors?.join("\n"))
            intelliMeet = null
        }
        intelliMeet
    }

    IntelliMeet updateStatus(IntelliMeet intelliMeet, IntelliMeetStatus status) {
        intelliMeet.status = status
        save intelliMeet
    }

    void removeLikesFromAllTopics() {
        Topic.list()?.each { Topic topic ->
            topic.interestedUsers = []
            topic.save(failOnError: true, flush: true)
        }
    }

    IntelliMeet getCurrentIntelliMeet() {
        IntelliMeet.findByStatus(IntelliMeetStatus.ACTIVE)
    }

    List<UserRole> revokeRoleFromAllUsers(Role role) {
        List<UserRole> previousUserRoles = UserRole.findAllByRole role
        List<UserRole> userRolesRemoved = []
        previousUserRoles?.each { UserRole userRole ->
            userRole.delete(flush: true)
            userRolesRemoved << userRole
        }
        userRolesRemoved
    }

    List<UserRole> assignOrgranizerRoles(IntelliMeet intelliMeet) {
        List<UserRole> userRoles = []
        User user = null
        Role roleImOwner = Role.findByAuthority(UserRoles.ROLE_IM_OWNER.displayName)
        intelliMeet?.organizers?.each {
            user = User.get(it)
            if (user) {
                userRoles << UserRole.create(user, roleImOwner, true)
            }
        }
        userRoles
    }

    Long getCurrentIntelliMeetId() {
        return currentIntelliMeet?.id
    }

    IMSessionCO getIMSessionList(Long intelliMeetId) {
        if (intelliMeetId == null) {
            intelliMeetId = getCurrentIntelliMeetId()
        }

        IMSessionCO imSessionCO = new IMSessionCO()
        imSessionCO.totalCount = IMSession.countByIntelliMeetIdAndSessionStatus(intelliMeetId, SessionStatus.PROPOSED)
        imSessionCO.sessionList = IMSession.findAllByIntelliMeetIdAndSessionStatus(intelliMeetId, SessionStatus.PROPOSED)
        return imSessionCO
    }

}
