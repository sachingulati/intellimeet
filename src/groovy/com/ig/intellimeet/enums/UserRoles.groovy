package com.ig.intellimeet.enums

enum UserRoles {

    ROLE_USER("ROLE_USER"),
    ROLE_IM_OWNER("ROLE_IM_OWNER"),
    ROLE_ADMIN("ROLE_ADMIN")

    String displayName

    UserRoles(String displayName){
        this.displayName = displayName
    }
}
