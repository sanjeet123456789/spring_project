<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Teachers</title>
	
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
		<input type="button" value="AddTeachers" onclick="window.location.href='showFormForAddTeacher_subject'; 
		return false;"
			class="add-button" />
			

			<table>
				<tr>
					<th>teacher_id</th>
					<th>subject_id</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempClass_t" items="${teacher_subject_ts}">
					<!-- construct an update lnk with customer id -->
					<c:url var="updateLink" value="/admin/teacher_subject_t/showFormForUpdateTeacher_subject">
						<c:param name="teacher_subject_tId" value="${tempClass_t.id}" />
					</c:url>
					
					<!-- construct the delete link to delete the customer from the list -->
					<c:url var="deleteLink" value="/admin/teacher_subject_t/delete">
						<c:param name="teacher_subject_tId" value="${tempClass_t.id}" />
					</c:url>
					
					<tr>
						<td> ${tempClass_t.teacher_Id} </td>
						<td> ${tempClass_t.subject_id} </td>
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









