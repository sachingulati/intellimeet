package com.ig.intellimeet.dto

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class PreferenceDTO {
    Boolean isAllocated=false
    String email
    Long userId
    Long value
}
