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
				<form:input path="firstName"/><br/>
				<form:input path="lastName"/><br/>
				<div class="actions">
					<input type="submit" name="save" value="Save"/>
					<input type="submit" name="cancel" value="Cancel"/>
				</div>
			</fieldset>
		</form:form>
		
	</body>
</html>
