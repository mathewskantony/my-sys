<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<div id="create-user" class="content scaffold-create" role="main">
			<g:form action="startAppraisalCycle" method="post">
				<div class="fieldcontain required">
						<label for="year">
							Year
							<span class="required-indicator">*</span>
						</label>
						<input type="number" name="year"/>
					</div>
				<div class="fieldcontain required">
					<label for="cycle">
						Cycle
						<span class="required-indicator">*</span>
					</label>
					<select name="cycle">
					<option value="1">One</option>
					<option value="2">Two</option>
					<option value="3">Three</option>
					<option value="4">Four</option>
				</select>
				</div>
				<fieldset class="buttons">
					<g:submitButton name="start" class="save" value="Init" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
