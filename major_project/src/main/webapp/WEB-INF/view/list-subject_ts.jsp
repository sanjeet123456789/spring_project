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
		<input type="button" value="AddSubject" onclick="window.location.href='showFormForAddSubject'; 
		return false;"
			class="add-button" />
			

			<table>
				<tr>
					<th>subject name</th>
					<th>Class</th>
					<th>Total in week</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempSubject_t" items="${subject_ts}">
					<!-- construct an update lnk with customer id -->
					<c:url var="updateLink" value="/admin/subject_t/showFormForUpdateSubject">
						<c:param name="subject_tId" value="${tempSubject_t.id}" />
					</c:url>
					
					<!-- construct the delete link to delete the customer from the list -->
					<c:url var="deleteLink" value="/admin/subject_t/delete">
						<c:param name="subject_tId" value="${tempSubject_t.id}" />
					</c:url>
					
					<tr>
						<td> ${tempSubject_t.subject_Name} </td>
						<td> ${tempSubject_t.s_Class} </td>
						<td> ${tempSubject_t.total_in_Week} </td>
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









