<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.7.1.min.js" />
<script type="text/javascript">

</script>
var pal=${countries};


</head>
<body>
<form method="post">
	<table>
		<tr>
			<td>Country</td>
			<select id="comboboxCountry">
			
			<c:forEach var="country" items="${countries}">
				<option value="${country.id}">${country.country_name}</option>
			</c:forEach>
			</select>
		</tr>
	</table>

</form>


</body>
</html>