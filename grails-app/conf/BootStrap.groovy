
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
		def admin = new User(username: "admin", lastName: "Administrator", firstName: "Admin",
				emailAddress: "test@blahblah8.com",
				passwordHash: new Sha256Hash("admin").toString())
		users += admin

		def system = new User(username: "system", lastName: "System", firstName: "Sys",
				emailAddress: "test@blahblah8.com",
				passwordHash: new Sha256Hash("admin").toString())
		users += system

		//FIXME:Temporary user creation
		
		def emp1 = new User(username: "emp1", lastName: "K", firstName: "Employee",
			emailAddress: "test@blahblah8.com",
			passwordHash: new Sha256Hash("emp1").toString())
		users += emp1
		
		def emp2 = new User(username: "emp2", lastName: "V", firstName: "EmploeeX",
			emailAddress: "test@blahblah8.com",
			passwordHash: new Sha256Hash("emp2").toString())
		users += emp2
		
		def emp3 = new User(username: "emp3", lastName: "S", firstName: "EmployeeY",
			emailAddress: "test@blahblah8.com",
			passwordHash: new Sha256Hash("emp3").toString())
		users += emp3
		
		def emp4 = new User(username: "emp4", lastName: "T", firstName: "EmployeeZ",
			emailAddress: "test@blahblah8.com",
			passwordHash: new Sha256Hash("emp4").toString())
		users += emp4
		
		users.each { user ->
			if(!User.findByUsername(user.username)) {
				if(! user.save()) println user.errors
			}
		}

		// Creating the Default Permissions
		def fullpermission =  "*:*"
		
		

		def roles = []
		// Creating the Default Roles
		def adminRole = new Role(name: "Administrator")
		adminRole.addToPermissions(fullpermission);
		roles += adminRole

		roles.each { role ->
			if(!Role.findByName(role.name)) {
				if(! role.save()) println role.errors
			}
		}

		

		admin.addToRoles(adminRole)
		system.addToRoles(adminRole)
		//FIXME:Temporary user creation
		//emp1.addToRoles(adminRole)
		//emp2.addToRoles(adminRole)
		//emp3.addToRoles(adminRole)
		//emp4.addToRoles(adminRole)
		
		sessionFactory.currentSession.flush()
	}
}
