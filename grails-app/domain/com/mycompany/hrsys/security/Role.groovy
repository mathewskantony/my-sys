package com.mycompany.hrsys.security

class Role {
    String name

    static hasMany = [ users: User, permissions: String ]
    static belongsTo = User

    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
	
	def String toString(){
		name
	}
}
