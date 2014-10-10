package com.ig.intellimeet

class User {

	transient springSecurityService

	String username
	String password
    String cloudinaryImageUrl
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    static hasMany = [oauthIds: OauthId]

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
        cloudinaryImageUrl nullable: true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

    Boolean isAdminOrImOwner() {
        ['ROLE_IM_OWNER', 'ROLE_ADMIN']?.any {authorities*.authority?.contains(it)}
    }

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
