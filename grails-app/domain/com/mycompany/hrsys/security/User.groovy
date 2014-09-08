package com.mycompany.hrsys.security

import com.mycompany.hrsys.operations.appraisal.Appraisal;

class User {
    String username
    String passwordHash
	String emailAddress,lastName,firstName
	String department
	String managerId 
    
    static hasMany = [ roles: Role, permissions: String, appraisals: Appraisal]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
		department(nullable:true)
		managerId(nullable:true)
    }
	
	def String toString(){
		username
	}
}
