package com.mycompany.hrsys.security

class User {
    String username
    String passwordHash
	String emailAddress,lastName,firstName
	String department
	String managerId 
    
    static hasMany = [ roles: Role, permissions: String]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
		department(nullable:true)
		managerId(nullable:true)
    }
}
