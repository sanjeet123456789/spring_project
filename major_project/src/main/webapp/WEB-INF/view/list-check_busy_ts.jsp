<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		<!-- putting a new button :Add customer -->
		<input type="button" value="AddCheckBusy" onclick="window.location.href='showFormForAddCheck_busy'; 
		return false;"
			class="add-button" />
			

			<table>
				<tr>
					<th>day</th>
					<th>period</th>
					<th>teachers_id</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCheck_busy_t" items="${check_busy_ts}">
					<!-- construct an update lnk with customer id -->
					<c:url var="updateLink" value="/admin/check_busy_t/showFormForUpdateCheck_busy">
						<c:param name="check_busy_tId" value="${tempCheck_busy_t.id}" />
					</c:url>
					
					<!-- construct the delete link to delete the customer from the list -->
					<c:url var="deleteLink" value="/admin/check_busy_t/delete">
						<c:param name="check_busy_tId" value="${tempCheck_busy_t.id}" />
					</c:url>
					
					<tr>
						<td> ${tempCheck_busy_t.day_Name} </td>
						<td> ${tempCheck_busy_t.period_Name} </td>
						<td> ${tempCheck_busy_t.teachers_Id} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
						
							|
							<a href="${deleteLink}" 
							onclick="if(!(confirm('Are  you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
</body>

</html>









