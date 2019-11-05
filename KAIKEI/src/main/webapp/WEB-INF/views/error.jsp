<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>Err</title>
</head>
<script>
	function forawrd() {
		setTimeout(function() {
			location.href="/kaikei/index.jsp";
		}, 2000);
	}
</script>
<body onload="forawrd()">
    <div align="center">
    		<h1>${errorMsg}</h1>
    </div> 
</body>
</html>
 