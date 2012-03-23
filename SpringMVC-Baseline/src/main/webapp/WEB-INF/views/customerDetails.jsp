<%@ include file="/WEB-INF/includes/jspCommonIncludes.jspf"%>
<html>

	<head>
		<script src="../../static/jquery-1.7.1.min.js"></script>
	</head>
	
	<body>
		<form:form modelAttribute="customer" action="save">
			<form:input path="firstName"/><br/>
			<form:input path="lastName"/><br/>
		</form:form>
	</body>
</html>
