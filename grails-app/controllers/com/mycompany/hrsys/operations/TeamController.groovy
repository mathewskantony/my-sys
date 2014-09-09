package com.mycompany.hrsys.operations

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.mycompany.hrsys.security.User;

class TeamController {

    def index() { redirect(action: "list", params: params) }
	
	 def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		Subject currentUser = SecurityUtils.getSubject()
		
		def employeeList = []
		if(currentUser.hasRole("HR")){
			employeeList = User.list(params)?:[]
			println employeeList
		} else {
			employeeList = User.findAllWhere(managerId : currentUser.principal)?:[]
			println employeeList
		}
        [userInstanceList: employeeList, userInstanceTotal: employeeList.count]
    }
}
