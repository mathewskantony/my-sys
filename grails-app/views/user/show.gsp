
<%@ page import="com.mycompany.hrsys.security.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<ol class="property-list user">
			
				<g:if test="${userInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="user.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.department}">
				<li class="fieldcontain">
					<span id="department-label" class="property-label"><g:message code="user.department.label" default="Department" /></span>
					
						<span class="property-value" aria-labelledby="department-label"><g:fieldValue bean="${userInstance}" field="department"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.managerId}">
				<li class="fieldcontain">
					<span id="managerId-label" class="property-label"><g:message code="user.managerId.label" default="Manager Id" /></span>
					
						<span class="property-value" aria-labelledby="managerId-label"><g:fieldValue bean="${userInstance}" field="managerId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.emailAddress}">
				<li class="fieldcontain">
					<span id="emailAddress-label" class="property-label"><g:message code="user.emailAddress.label" default="Email Address" /></span>
					
						<span class="property-value" aria-labelledby="emailAddress-label"><g:fieldValue bean="${userInstance}" field="emailAddress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="user.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${userInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="user.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${userInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.passwordHash}">
				<li class="fieldcontain">
					<span id="passwordHash-label" class="property-label"><g:message code="user.passwordHash.label" default="Password Hash" /></span>
					
						<span class="property-value" aria-labelledby="passwordHash-label"><g:fieldValue bean="${userInstance}" field="passwordHash"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.permissions}">
				<li class="fieldcontain">
					<span id="permissions-label" class="property-label"><g:message code="user.permissions.label" default="Permissions" /></span>
					
						<span class="property-value" aria-labelledby="permissions-label"><g:fieldValue bean="${userInstance}" field="permissions"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.roles}">
				<li class="fieldcontain">
					<span id="roles-label" class="property-label"><g:message code="user.roles.label" default="Roles" /></span>
					
						<g:each in="${userInstance.roles}" var="r">
						<span class="property-value" aria-labelledby="roles-label"><g:link controller="role" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userInstance?.id}" />
					<g:link class="edit" action="edit" id="${userInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
