package com.ig.intellimeet.co

import com.ig.intellimeet.dto.SessionPreferenceDTO
import grails.validation.Validateable

@Validateable
class AllocationCO {
    List<SessionPreferenceDTO> preferenceDTOList = []
}
