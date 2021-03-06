package com.mycompany.hrsys.admin

import org.apache.shiro.crypto.hash.Sha256Hash
import org.grails.plugins.excelimport.*
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import com.mycompany.hrsys.operations.appraisal.Appraisal
import com.mycompany.hrsys.security.Role
import com.mycompany.hrsys.security.User

class AdminController {
	def excelImportService
	def sessionFactory
	def loadEmployeeData() {}
	def initAppraisal(){}
	def startAppraisalCycle = { servletContext ->
		
		def employeeList = User.findAll()
		employeeList.each {  employee ->
			employee.addToAppraisals(new Appraisal(year : params.year, cycleNumber : params.cycle, status : 'I'))
		}
		sessionFactory.currentSession.flush()
		
		flash.message = "Appraisal cycle intialised for year ${params.year}, cycle ${params.cycle}"
		
		redirect(action: "list", params: params, controller : "team")
	}
	
	
	def upload = { servletContext ->
		
		Map CONFIG_BOOK_COLUMN_MAP = [
			sheet:'Sheet1',
			startRow: 1,
			columnMap:  [
			 //Col, Map-Key
			 'A':'username',
			 'B':'emailId',
			 'C':'dept',
			 'D': 'managerId'
			]
		   ]
	   
	   
		 MultipartHttpServletRequest mpr = (MultipartHttpServletRequest)request;
		 CommonsMultipartFile file = (CommonsMultipartFile) mpr.getFile("file");
		 
		 Workbook workbook = WorkbookFactory.create(file.inputStream)

		 def employeeList = excelImportService.columns(workbook, CONFIG_BOOK_COLUMN_MAP)
		 def newEmpls = []
		 
		 
		 def empRole = Role.findByName("User")
		 
		 employeeList.each { Map employeeParamMap ->
			 def user = User.findByUsername(employeeParamMap['username'])
			 if (!user) {
				user = new User(username: employeeParamMap['username'], lastName: "null", firstName: "null",
					 emailAddress: employeeParamMap['emailId'],department:employeeParamMap['dept'],
					 managerId:employeeParamMap['managerId'],
					 passwordHash: new Sha256Hash("temp").toString())
				user.addToRoles(empRole)
				newEmpls += user
			 } else {
			 	user.setEmailAddress(employeeParamMap['emailId'])
				user.setDepartment(employeeParamMap['dept'])
				user.setManagerId(employeeParamMap['managerId'])
				
				if(! user.save()) println user.errors
			 }
			 
			 
		 }
		 
		 newEmpls.each { user ->
			 if(! user.save()) println user.errors
		 }
		 sessionFactory.currentSession.flush()
		 
		 flash.message = 'Employee data uploaded successfully.'
		 
		 redirect(action: "list", params: params, controller : "team")
	}
}
