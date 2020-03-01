<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="resources/js/jquery-1.7.1.min.js" ></script>


<style type="text/css">
select {
	width:500px;

}


</style>


<script type="text/javascript">


$(document).ready(function(){
	$('#comboboxCountry').on('change',function(){
		alert("hello");
		$('#comboboxCity option').remove();
		var id=$('#comboboxCountry option:selected').val();
		$.ajax({
			type:'GET',
			url:'${pageContext.request.contextPath}/demo/loadState/'+id,
			success:function(result){
				alert(id);
				var result=JSON.parse(result);
				var s='';
				for(var i=0;i<result.length;i++){
					s+='<option value="'+result[i].id+'">'+result[i].state_name+'</option>';
				}
				$('#comboboxState').html(s);
			}
			
		})
	});
	
	
	$('#comboboxState').on('change',function(){
		var id=$('#comboboxState option:selected').val();
		$.ajax({
			type:'GET',
			url:'${pageContext.request.contextPath}/demo/loadCity/'+id,
			
			success:function(result){
				alert(id);
				var result=JSON.parse(result);
				var s='';
				for(var i=0;i<result.length;i++){
					s+='<option value="'+result[i].id+'">'+result[i].city_name+'</option>';
				}
				$('#comboboxCity').html(s);
			}
			
		})
	});
	
	
});
</script>



</head>
<body>
<form method="post">
	<table>
		<tr>
			<td>Country</td>
			<select id="comboboxCountry">
				<option value="-1">Select Country</option>
			<c:forEach var="country" items="${countries}">
				
				<option value="${country.id}">${country.country_name}</option>
			</c:forEach>
			</select>
		</tr>
		
		<tr>
			<td>State</td>
			<select id="comboboxState">
			</select>
		</tr>
		<tr>
			<td>City</td>
			<select id="comboboxCity">
			</select>
		</tr>
	</table>

</form>


</body>
</html>