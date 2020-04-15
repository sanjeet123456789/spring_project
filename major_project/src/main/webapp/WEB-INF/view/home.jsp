<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 


<html>

<head>
	<title>Time table generation system</title>
</head>

<body>
	<h2>Time Table</h2>
	<hr>
	
	<p>
	Major Project(create by:sanjeet and pradeep)
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
	<!-- <p><a href="${pageContext.request.contextPath}/admin/customer/list">this is only for admin</a></p>-->
	<p><a href="${pageContext.request.contextPath}/admin/class_t/listClass">Crete class</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/teachers_t/listTeachers">Create Teachers</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/subject_t/listSubject">Create Subejects</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/teacher_subject_t/listTeacher_subject">Connect teacher with subject</a></p>
	  <p><a href="${pageContext.request.contextPath}/admin/check_subject_t/listCheck_subject">CheckSubject</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/check_busy_t/listCheck_busy">Check Busy</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/generate_pdf/online">Generate PDf</a></p>
	
	</security:authorize>
	
	<!-- <p><a href="${pageContext.request.contextPath}/admin/customer/list">this is only for admin</a></p>
	<p><a href="${pageContext.request.contextPath}/admin/class_t/listClass">this is only forclass</a></p>-->
	
	<!--  Add a link for the admin user -->
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>









