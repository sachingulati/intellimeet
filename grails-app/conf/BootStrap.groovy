import com.ig.intellimeet.OauthId
import com.ig.intellimeet.OauthId
import com.ig.intellimeet.Role
import com.ig.intellimeet.User
import com.ig.intellimeet.UserRole

class BootStrap {

    def init = { servletContext ->

        if(!User.count()){
            // User creation and mapping with oauthid for google sign in
            def userbrij = new User(username: "brijkishor",password: "igdefault", email: "brij.kishor@intelligrape.com", enabled: true).save(flush: true, failOnError: true)
            def userbrijKishor = new User(username: "brijkishor1",password: "igdefault", email: "brijkishor.cse@gmail.com", enabled: true).save(flush: true, failOnError: true)
            //Defining Roles for spring security
            def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true);
            UserRole.create(userbrij, userRole)
            UserRole.create(userbrijKishor, userRole)
            def brijIntelliOauthId = new OauthId(accessToken: "brij.kishor@intelligrape.com", user: userbrij, provider: "google" ).save(flush: true, failOnError: true)
            def brijKishorOauthId = new OauthId(accessToken: "brijkishor.cse@gmail.com", user: userbrijKishor, provider: "google" ).save(flush: true, failOnError: true)
        }
    }
    def destroy = {
    }
}
