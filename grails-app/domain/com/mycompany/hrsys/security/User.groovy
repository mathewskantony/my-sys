package com.mycompany.hrsys.security

class User {
    String username
    String passwordHash
	String emailAddress,lastName,firstName
	String department
	 
    
    static hasMany = [ roles: Role, permissions: String, subordinates : User ]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
		department(nullable:true)
    }
}
