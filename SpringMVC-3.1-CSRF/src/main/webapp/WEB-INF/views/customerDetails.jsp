<%@ include file="/WEB-INF/includes/jspCommonIncludes.jspf"%>
<html>

	<head>
		<script src="../../static/jquery-1.7.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../../static/commons.css"/>
	</head>
	
	<body>
		<form:form modelAttribute="customer" action="save">
			<fieldset>
				<legend>Customer Details</legend>
				<label for="firstName">First Name</label>:<form:input path="firstName" class="input"/><br/>
				<label for="lastName">Last Name</label>:<form:input path="lastName" class="input"/><br/>
				<div class="actionsBlock">
					<input type="submit" name="save" value="Save" class="button"/>
					<input type="submit" name="cancel" value="Cancel" class="button"/>
				</div>
			</fieldset>
		</form:form>
		
	</body>
</html>
