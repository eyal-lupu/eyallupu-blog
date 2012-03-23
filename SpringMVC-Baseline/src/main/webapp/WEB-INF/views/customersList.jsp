<%@ include file="/WEB-INF/includes/jspCommonIncludes.jspf"%>
<html>

	<head>
		<script src="../../static/jquery-1.7.1.min.js"></script>
	</head>
	
	<body>
		<table>
			<thead><tr><td>First</td><td>Last</td></tr></thead>

			<tbody>
				<c:forEach items="${customers}" var="currCustomer">
					<tr><td><a href="edit?id=${currCustomer.id}">${currCustomer.firstName}</a></td><td>${currCustomer.lastName}</td></tr>
				</c:forEach>
			</tbody>

		</table>
</body>
</html>
