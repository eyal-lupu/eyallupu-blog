<%@ include file="/WEB-INF/includes/jspCommonIncludes.jspf"%>
<html>

	<head>
		<script src="../../static/jquery-1.7.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../../static/commons.css"/>
	</head>
	
	<body>
		<table>
			<tr><th>First</th><th>Last</th></tr>

				<c:forEach items="${customers}" var="currCustomer">
					<tr><td><a href="edit?id=${currCustomer.id}">${currCustomer.firstName}</a></td><td>${currCustomer.lastName}</td></tr>
				</c:forEach>

		</table>
		
		<a href="add" class="linkBtn">Add new...</a>
</body>
</html>
