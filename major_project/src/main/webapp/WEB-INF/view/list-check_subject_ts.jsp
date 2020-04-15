<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Check Subject</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Time Table</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		<!-- putting a new button :Add customer -->
		<input type="button" value="AddCheckSubject" onclick="window.location.href='showFormForAddCheck_subject'; 
		return false;"
			class="add-button" />
			

			<table>
				<tr>
					<th>class_section</th>
					<th>subject_name</th>
					<th>teachers_id</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCheck_subject_t" items="${check_subject_ts}">
					<!-- construct an update lnk with customer id -->
					<c:url var="updateLink" value="/admin/check_subject_t/showFormForUpdateCheck_subject">
						<c:param name="check_subject_tId" value="${tempCheck_subject_t.id}" />
					</c:url>
					
					<!-- construct the delete link to delete the customer from the list -->
					<c:url var="deleteLink" value="/admin/check_subject_t/delete">
						<c:param name="check_subject_tId" value="${tempCheck_subject_t.id}" />
					</c:url>
					
					<tr>
						<td> ${tempCheck_subject_t.class_Section} </td>
						<td> ${tempCheck_subject_t.subject_Name} </td>
						<td> ${tempCheck_subject_t.teachers_Id} </td>
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









