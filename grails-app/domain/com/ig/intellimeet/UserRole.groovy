package com.ig.intellimeet

import org.apache.commons.lang.builder.HashCodeBuilder

class UserRole implements Serializable {

	private static final long serialVersionUID = 1

	User user
	Role role

	boolean equals(other) {
		if (!(other instanceof UserRole)) {
			return false
		}

		other.user?.id == user?.id &&
			other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static UserRole get(long userId, long roleId) {
		UserRole.where {
			user == User.load(userId) &&
			role == Role.load(roleId)
		}.get()
	}

	static UserRole create(User user, Role role, boolean flush = false) {
		new UserRole(user: user, role: role).save(flush: flush, insert: true, failOnError: true)
	}

	static boolean remove(User user, Role role, boolean flush = false) {

        UserRole userRole = UserRole.findByUserAndRole(user, role)
        return userRole ? userRole.delete(flush: flush) : false
	}

	static void removeAll(User u) {
		UserRole.where {
			user == User.load(u.id)
		}.deleteAll()
	}

	static void removeAll(Role r) {
		UserRole.where {
			role == Role.load(r.id)
		}.deleteAll()
	}

	static mapping = {
		id composite: ['role', 'user']
		version false
	}
}
