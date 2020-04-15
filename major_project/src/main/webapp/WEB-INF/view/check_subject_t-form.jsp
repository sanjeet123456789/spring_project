<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Check Subejct</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Time Table</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	
		<form:form action="saveCheck_subject_t" modelAttribute="check_subject_t" method="POST">
		<!-- need to associate this data with customer id -->
		
		<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>CLass section:</label></td>
						<td><form:input path="class_Section" /></td>
					</tr>
				
					<tr>
						<td><label>Subject name:</label></td>
						<td><form:input path="subject_Name" /></td>
					</tr>
					<tr>
						<td><label>Teachers_id:</label></td>
						<td><form:input path="teachers_Id" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/">Back to List</a>
		</p>
	
	</div>

</body>

</html>










