<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="Shift_JIS">
<title>Regist Form</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script type="text/javascript">
function checkForm() {	
	var form = document.register;
	if(document.getElementById("passwd").value != document.getElementById("passwd2").value) {
		alert('Password check');
		return;
	}
	form.action="regist.do";
	form.method="post";
	form.submit();
	
}
</script>

<script>
$(window).load(function(){
	$("#id").blur(function() {
		var userId = $('#id').val();

		$.ajax({
			url : '${pageContext.request.contextPath}/regist/checkId.do?userId=' + userId,
			type : 'get',
			success : function(data) {					
				
				if (data == 1) {
						$("#id_check").text("Exist ID");
						$("#id_check").css("color", "red");
					} else {
						$('#id_check').text("");	
					}
				}, error : function() {
						console.log("Fail");
				}
			});
		});
});
</script>
</head>
<body>
	<div align="center">
		<form name="register">
			<h3>Sign Up</h3>
			<h6>ID</h6>
			<input type="text" id="id" name="id" required>
			<div class="check_font" id="id_check"></div>
			<h6>Password</h6>
			<input type="password" id="passwd" name="passwd" >
			<h6>Password Verify</h6>
			<input type="password" id="passwd2" name="passwd2" >
			<h6>Name</h6>
			<input type="text" name="name" >
			<p></p>
			<input type="button" value="Submit" onclick="checkForm();">
		</form>
	</div>
</body>

</html>