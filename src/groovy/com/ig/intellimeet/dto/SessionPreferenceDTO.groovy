package com.ig.intellimeet.dto

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class SessionPreferenceDTO {
    Long sessionId
    String sessionTitle
    List<PreferenceDTO> firstPreferenceUserIdList
    List<PreferenceDTO> secondPreferenceUserIdList
    List<PreferenceDTO> thirdPreferenceUserIdList
}
