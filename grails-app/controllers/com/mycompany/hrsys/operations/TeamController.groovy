package com.mycompany.hrsys.operations

import com.mycompany.hrsys.security.User;

class TeamController {

    def index() { redirect(action: "list", params: params) }
	
	 def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }
}
