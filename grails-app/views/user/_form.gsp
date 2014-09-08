<%@ page import="com.mycompany.hrsys.security.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${userInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'department', 'error')} ">
	<label for="department">
		<g:message code="user.department.label" default="Department" />
		
	</label>
	<g:textField name="department" value="${userInstance?.department}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'managerId', 'error')} ">
	<label for="managerId">
		<g:message code="user.managerId.label" default="Manager Id" />
		
	</label>
	<g:textField name="managerId" value="${userInstance?.managerId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'emailAddress', 'error')} ">
	<label for="emailAddress">
		<g:message code="user.emailAddress.label" default="Email Address" />
		
	</label>
	<g:textField name="emailAddress" value="${userInstance?.emailAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="user.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${userInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="user.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${userInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordHash', 'error')} ">
	<label for="passwordHash">
		<g:message code="user.passwordHash.label" default="Password Hash" />
		
	</label>
	<g:textField name="passwordHash" value="${userInstance?.passwordHash}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'permissions', 'error')} ">
	<label for="permissions">
		<g:message code="user.permissions.label" default="Permissions" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'roles', 'error')} ">
	<label for="roles">
		<g:message code="user.roles.label" default="Roles" />
		
	</label>
	<g:select name="roles" from="${com.mycompany.hrsys.security.Role.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.roles*.id}" class="many-to-many"/>
</div>

