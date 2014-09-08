package com.mycompany.hrsys.operations

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject

import com.mycompany.hrsys.security.User;

class HomeController {

    def index() { 
		Subject currentUser = SecurityUtils.getSubject()
		def employee = User.findByUsername(currentUser.principal)
		[appraisalList: employee.getAppraisals(), appraisalInstanceTotal: employee.getAppraisals().count]
	}
	
	def list(){
		
	}
}
