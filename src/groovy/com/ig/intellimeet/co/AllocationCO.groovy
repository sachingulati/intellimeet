package com.ig.intellimeet.co

import com.ig.intellimeet.dto.IMSessionPreference
import grails.validation.Validateable
import org.apache.commons.collections.ListUtils

@Validateable
class AllocationCO {

    List<IMSessionPreference> preferences = ListUtils.lazyList([], {
        new IMSessionPreference()
    } as org.apache.commons.collections.Factory)

}
