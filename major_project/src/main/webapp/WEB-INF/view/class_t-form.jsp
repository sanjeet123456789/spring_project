<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Class</title>

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
	
		<form:form action="saveClass_t" modelAttribute="class_t" method="POST">
		<!-- need to associate this data with customer id -->
		
		<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>CLass:</label></td>
						<td><form:input path="className" /></td>
					</tr>
				
					<tr>
						<td><label>Section:</label></td>
						<td><form:input path="section" /></td>
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










