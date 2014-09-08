package com.mycompany.hrsys.operations.appraisal

import com.mycompany.hrsys.security.User;

class Appraisal {

	Integer year
	Integer cycleNumber
	String status
	
	static belongsTo = User
	
    static constraints = {
    }
	
	def String toString(){
		"year : ${year}, cycle : ${cycleNumber}" 
	}
}
