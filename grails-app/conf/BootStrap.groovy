
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
		def hr = new User(username: "johnd", lastName: "Thomas", firstName: "Dally",
				emailAddress: "test@blahblah8.com",
				passwordHash: new Sha256Hash("admin").toString())
		users += hr

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
		def leadPermission = "team"
		

		def roles = []
		// Creating the Default Roles
		def adminRole = new Role(name: "Administrator")
		adminRole.addToPermissions(fullpermission)
		roles += adminRole
		
		def empRole = new Role(name: "User")
		empRole.addToPermissions(homePermission)
		roles += empRole
		
		def leadRole = new Role(name : "Lead")
		leadRole.addToPermissions(leadPermission)
		roles += leadRole
		
		def hrRole = new Role(name: "HR")
		roles += hrRole
		

		roles.each { role ->
			if(!Role.findByName(role.name)) {
				if(! role.save()) println role.errors
			}
		}

		

		hr.addToRoles(hrRole)
		hr.addToRoles(leadRole)
		hr.addToRoles(empRole)
		
		system.addToRoles(adminRole)
		system.addToRoles(hrRole)

		lead1.addToRoles(empRole)
		lead1.addToRoles(leadRole)
		
		sessionFactory.currentSession.flush()
	}
}
