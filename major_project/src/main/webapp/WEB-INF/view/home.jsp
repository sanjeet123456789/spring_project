<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 


<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<p>
	Welcome to the luv2code company home page!
	</p>
	<!--  display username and role -->
	
	<p>
	User:<security:authentication property="principal.username" />
	</p>
	
	<p>
	Roles:<security:authentication property="principal.authorities" />
	</p>
	<!--  Aff a link to point over leader and amnager -->
	
	<security:authorize access="hasRole('MANAGER')">
	<p><a href="${pageContext.request.contextPath}/leaders">this is for leader</a></p>
	
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<p><a href="${pageContext.request.contextPath}/admin/customer/list">this is only for admin</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/class_t/listClass">this is only forclass</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/teachers_t/listTeachers">this is only forclass</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/subject_t/listSubject">this is only forclass</a></p>
	
	</security:authorize>
	<!--  Add a link for the admin user -->
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>









