<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Subject</title>

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
	
		<form:form action="saveSubject_t" modelAttribute="subject_t" method="POST">
		<!-- need to associate this data with customer id -->
		
		<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="subject_Name" /></td>
					</tr>
				
					<tr>
						<td><label>class:</label></td>
						<td><form:input path="s_Class" /></td>
					</tr>
					
					<tr>
						<td><label>total_in_week:</label></td>
						<td><form:input path="total_in_Week" /></td>
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










