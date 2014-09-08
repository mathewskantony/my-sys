
import org.apache.shiro.crypto.hash.Sha256Hash

import com.mycompany.hrsys.security.Role
import com.mycompany.hrsys.security.User

class BootStrap {
	def sessionFactory
    def init = { servletContext ->
		ceateTestUsers()
    }
    def destroy = {
    }
	
	def ceateTestUsers = {
		def users = []
		def admin = new User(username: "johnd", lastName: "Thomas", firstName: "Dally",
				emailAddress: "test@blahblah8.com",
				passwordHash: new Sha256Hash("admin").toString())
		users += admin

		def system = new User(username: "lordk", lastName: "Koby", firstName: "Lord",
				emailAddress: "test@blahblah8.com",
				passwordHash: new Sha256Hash("system").toString())
		users += system

		
		def lead1 = new User(username: "timk", lastName: "Kinston", firstName: "Tim",
			emailAddress: "test@blahblah8.com",
			passwordHash: new Sha256Hash("lead").toString())
		
		
		users += lead1
		
		users.each { user ->
			if(!User.findByUsername(user.username)) {
				if(! user.save()) println user.errors
			}
		}

		// Creating the Default Permissions
		def fullpermission =  "*:*"
		def homePermission = "home"
		

		def roles = []
		// Creating the Default Roles
		def adminRole = new Role(name: "Administrator")
		adminRole.addToPermissions(fullpermission)
		
		def empRole = new Role(name: "User")
		empRole.addToPermissions(homePermission)
		
		roles += adminRole

		roles.each { role ->
			if(!Role.findByName(role.name)) {
				if(! role.save()) println role.errors
			}
		}

		

		admin.addToRoles(adminRole)
		system.addToRoles(adminRole)

		lead1.addToRoles(empRole)
		
		sessionFactory.currentSession.flush()
	}
}
