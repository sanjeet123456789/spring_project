<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE HTML>
<html>
<head></head>
<body>
	<form:form action="processForm" modelAttribute="student">
	
	First name:<form:input path="firstName" /><br>
	Last name:<form:input path="LastName" /><br>
	Country:<form:select path="country">
	<form:option value="Brazil" label="Brazil" />
	<form:option value="India" label="India" />
	<form:option value="China" label="China" />
	<form:option value="France" label="France" />
	
	</form:select>
	
	
	<input type="submit" value="Submit" />
	
	
	</form:form>





</body>
</html>


