<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<div id="create-user" class="content scaffold-create" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form action="upload" method="post" enctype="multipart/form-data">
				<br/>
  				<label for="file">File:</label>
  				<input type="file" name="file" id="file" />
  				<br/>
				<fieldset class="buttons">
					<g:submitButton name="upload" class="save" value="Upload" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>


