<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="Appraisal" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-role" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="year" title="Year" />
						<g:sortableColumn property="cycleNumber" title="Cycle" />
						<g:sortableColumn property="status" title="Status" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${appraisalList}" status="i" var="appraisalInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${fieldValue(bean: appraisalInstance, field: "year")}</td>
						<td><g:link action="show" id="${appraisalInstance.id}">${fieldValue(bean: appraisalInstance, field: "cycleNumber")}</g:link></td>
						<td>${fieldValue(bean: appraisalInstance, field: "status")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${appraisalInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
